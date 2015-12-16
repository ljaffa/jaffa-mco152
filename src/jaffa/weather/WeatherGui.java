package jaffa.weather;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
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

		add(Box.createVerticalStrut(20));
		zipLabel = new JLabel("Enter a Zip Code");
		add(zipLabel);
		add(Box.createVerticalStrut(20));
		text = new JTextField();
		text.setMaximumSize( 
				new Dimension(Integer.MAX_VALUE, text.getPreferredSize().height) );
		//text.setMaximumSize(text.getPreferredSize());
		add(text);
		add(Box.createVerticalStrut(50));

		button = new JButton("Get weather");
		add(button);
		add(Box.createVerticalStrut(20));
		tempLabel = new JLabel("Temperature");
		add(tempLabel);
		add(Box.createVerticalStrut(20));
		descLabel = new JLabel("Description");
		add(descLabel);
		add(Box.createVerticalStrut(20));
		iconLabel = new JLabel("Icon");
		add(iconLabel);
		add(Box.createVerticalStrut(20));

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

