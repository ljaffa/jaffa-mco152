package jaffa.weather;

public class CurrentWeather {

	//match up to json file
	private Weather[] weather;
	private Main main;

	public CurrentWeather(){
		weather = new Weather[10];
		main = new Main();
	}

	public Weather[] getWeather() {
		return weather;
	}

	public Main getMain() {
		return main;
	}



}
