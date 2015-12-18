package jaffa.weather16Day;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class WeatherComponent extends JComponent{

	//all things to display
	private JLabel date;
	private JLabel temp;
	private JLabel desc;
	private JLabel icon;

	public WeatherComponent(){
		this.date = new JLabel();
		this.temp = new JLabel();
		this.desc = new JLabel();
		this.icon = new JLabel();
	}

	public JLabel getDate() {
		return date;
	}

	public void setDate(JLabel date) {
		this.date = date;
	}

	public JLabel getTemp() {
		return temp;
	}

	public void setTemp(JLabel temp) {
		this.temp = temp;
	}

	public JLabel getDesc() {
		return desc;
	}

	public void setDesc(JLabel desc) {
		this.desc = desc;
	}

	public JLabel getIcon() {
		return icon;
	}

	public void setIcon(JLabel icon) {
		this.icon = icon;
	}


}
