package jaffa.weather16Day;



public class List {

	private Long dt;
	private Temp temp;
	private Weather[] weather;

	public Long getDt(){
		//SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/YYYY");
		Long newDt = dt * 1000;
		//Date date = new Date(newDt);
		//return formatter.format(date);
		return newDt;
	}

	public Temp getTemp(){
		return temp;
	}

	public Weather getWeather(){
		return weather[0];
	}

}
