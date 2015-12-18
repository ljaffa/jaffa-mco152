package jaffa.weather16Day;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Weather16DayGui extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args){
		Weather16DayGui gui = new Weather16DayGui();
		gui.setVisible(true);
	}

	private JPanel panel;
	private WeatherComponent[] days;
	private JLabel temp;
	private JLabel desc;
	private JLabel icon;
	private JTextField text;
	private JButton button;
	private JLabel date;

	public Weather16DayGui(){
		setTitle("16 Day Forecast");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BorderLayout());

		days = new WeatherComponent[16];
		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 8));
		temp = new JLabel("Temperature");
		desc = new JLabel("Description");
		icon = new JLabel("Icon");
		text = new JTextField();
		button = new JButton("Get Weather");
		date = new JLabel("Date");
		panel.add(temp);
		panel.add(desc);
		panel.add(icon);
		panel.add(date);

		//panel.add(temp);
		//panel.add(desc);
		//panel.add(icon);
		for (int i = 0; i < days.length; i++){
			days[i] = new WeatherComponent();

			days[i].setBorder(new LineBorder(Color.BLACK));
			days[i].setDate(date);
			days[i].setTemp(temp);
			days[i].setDesc(desc);
			days[i].setIcon(icon);
			panel.add(days[i]);
		}

		container.add(panel, BorderLayout.CENTER);
		container.add(text, BorderLayout.NORTH);
		container.add(button, BorderLayout.SOUTH);


		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Weather16DayThread thread = new Weather16DayThread(days,  text.getText(), temp, date, desc, icon);
				thread.start();

			}

		});
	}

}
