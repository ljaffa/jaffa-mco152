package jaffa.weather16Day;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Weather16DayThread extends Thread{

	private WeatherComponent[] days;

	private String text;
	private JLabel temp;
	private JLabel desc;
	private JLabel icon;

	private JLabel dateLabel;
	private CurrentWeather weather;

	public Weather16DayThread(WeatherComponent[] days, String text,  JLabel temp, JLabel dtLabel, JLabel desc, JLabel icon){
		this.days = days;
		this.text = text;
		this.temp = temp;
		this.desc = desc;
		this.icon = icon;
		this.dateLabel = dtLabel;
	}

	@Override
	public void run(){
		Weather16DayUrl weatherUrl = new Weather16DayUrl(text);
		//JPanel panel = new JPanel();
		//JPanel[] days = new JPanel[16];
		try {
			weather = weatherUrl.getWeatherUrl();
			for (int i = 0; i < 16; i++){
				temp.setText(String.valueOf(weather.getList()[i].getTemp()));
				desc.setText(weather.getList()[i].getWeather().getDescription());

				SimpleDateFormat formatter = new SimpleDateFormat("MM/dd");
				String newDate = formatter.format(weather.getList()[i].getDt());
				dateLabel.setText(String.valueOf(newDate));

				String picString = "http://openweathermap.org/img/w/" + 
						weather.getList()[i].getWeather().getIcon() + ".png";
				URL picUrl = new URL(picString);

				BufferedImage image = ImageIO.read(picUrl);
				ImageIcon imageIcon = new ImageIcon(image);
				icon.setIcon(imageIcon);


				//days[i].setDate(dateLabel);
				//days[i].setTemp(temp);
				//days[i].setDesc(desc);
				//days[i].setIcon(icon);
				/*panel = new JPanel();
				panel.add(temp);
				panel.add(desc);
				panel.add(icon);
				days[i] = panel;*/
				/*days[i] = new WeatherComponent();
				days[i].setDate(dateLabel);

				days[i].setBorder(new LineBorder(Color.BLACK));
				panel.add(days[i]);*/
			}



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
