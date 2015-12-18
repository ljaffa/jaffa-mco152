package jaffa.weather16Day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class Weather16DayUrl {
	//make into thread

	private String zip;

	public Weather16DayUrl(String zip){
		this.zip = zip;
	}

	public CurrentWeather getWeatherUrl() throws IOException{
		String urlString = "http://api.openweathermap.org/data/2.5/forecast/daily?zip="
				+ zip
				+ "&cnt=16&appid=2de143494c0b295cca9337e1e96b00e0";

		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		CurrentWeather weather = gson.fromJson(reader, CurrentWeather.class);

		return weather;
	}

}
