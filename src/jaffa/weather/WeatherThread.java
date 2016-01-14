package jaffa.weather;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class WeatherThread extends Thread{

	private JLabel tempLabel;
	private JLabel descLabel;
	private JLabel iconLabel;
	private CurrentWeather weather;
	private String textString;

	public WeatherThread(String text, JLabel temp, JLabel desc, JLabel icon){
		this.textString = text;
		this.tempLabel = temp;
		this.descLabel = desc;
		this.iconLabel = icon;
	}

	@Override
	public void run() {
		WeatherURL weatherURL = new WeatherURL(textString);
		weather = null;
		try {
			weather = weatherURL.getWeatherURL();
			tempLabel.setText(String.valueOf(weather.getMain().getTemp()));
			descLabel.setText(weather.getWeather()[0].getDescription());

			String url = "http://openweathermap.org/img/w/" + weather.getWeather()[0].getIcon() + ".png";

			URL picURL = new URL(url);

			BufferedImage image = ImageIO.read(picURL);
			ImageIcon icon = new ImageIcon(image);

			iconLabel.setIcon(icon);
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

}