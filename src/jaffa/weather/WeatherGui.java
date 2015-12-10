package jaffa.weather;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherGui extends JFrame{

	public static void main(String[] args){
		new WeatherGui().setVisible(true);
	}

	private JLabel zipLabel;
	private JLabel tempLabel;
	private JLabel descLabel;
	private JLabel iconLabel;
	private JTextField text;
	private JButton button;
	private CurrentWeather currentWeather;

	public WeatherGui(){
		//currentWeather = new CurrentWeather();
		setTitle("Weather");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();

		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		zipLabel = new JLabel("Enter a Zip Code");
		add(zipLabel);
		text = new JTextField();
		add(text);
		button = new JButton("Recalculate");
		add(button);
		tempLabel = new JLabel("Temperature");
		add(tempLabel);
		descLabel = new JLabel("Description");
		add(descLabel);
		iconLabel = new JLabel("Icon");
		add(iconLabel);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				WeatherURL weatherURL = new WeatherURL(text.getText());
				CurrentWeather weather = null;
				try {
					weather = weatherURL.getWeatherURL();
					tempLabel.setText(String.valueOf(weather.getMain().getTemp()));
					descLabel.setText(weather.getWeather()[0].getDescription());
					//icon is a string. have to inspect element 
					//corresponds to a url like zip have to change the icon number
					//build a stringbuilder and append first half and then getIcon() and then second half.
					//create a new URL. google hw to create  a url
					//create a bufferedImage - imageIO.read(Url)
					//create a new Image Icon based on the image
					//label.setIcon(image icon based on bufferedImage);
					StringBuilder builder = new StringBuilder();
					builder.append(
							"http://openweathermap.org/img/w/");
					builder.append(weather.getWeather()[0].getIcon());
					builder.append(".png");
					URL picURL = null;
					picURL = new URL(builder.toString());
					BufferedImage image = null;
					image = ImageIO.read(picURL);
					ImageIcon icon = new ImageIcon(image);
					iconLabel.setIcon(icon);
				}
				catch (IOException e){
					e.printStackTrace();
				}
			}

		});
	}
}

