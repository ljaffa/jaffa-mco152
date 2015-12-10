package jaffa.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class WeatherURL {

	// put in URL connection and String builder
	private String zip;

	public WeatherURL(String zip) {
		this.zip = zip;
	}

	public CurrentWeather getWeatherURL() throws IOException {
		CurrentWeather weather;
		StringBuilder builder = new StringBuilder();
		builder.append("Http://api.openweathermap.org/data/2.5/weather?zip=");
		builder.append(zip);
		builder.append(",us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial");

		URL url = new URL(builder.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		weather = gson.fromJson(reader, CurrentWeather.class);

		return weather;
	}

}
