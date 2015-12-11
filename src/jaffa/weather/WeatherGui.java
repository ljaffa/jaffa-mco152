package jaffa.weather;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherGui extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel zipLabel;
	private JLabel tempLabel;
	private JLabel descLabel;
	private JLabel iconLabel;
	private JTextField text;
	private JButton button;

	public WeatherGui(){
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
			//do in separate thread
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				WeatherThread thread = new WeatherThread(text.getText(), tempLabel, descLabel, iconLabel);
				thread.start();
			}

		});
	}
}

