package jaffa.physics;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProjectileGUI extends JFrame {

	private JLabel angleLabel;
	private JLabel velocityLabel;
	private JLabel timeLabel;
	private JLabel answerLabel;

	private JTextField angleText;
	private JTextField velocityText;
	private JTextField timeText;

	private JButton button;

	public ProjectileGUI() {
		setTitle("Projectile");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		angleLabel = new JLabel("Angle");
		add(angleLabel);
		angleText = new JTextField();
		add(angleText);
		velocityLabel = new JLabel("Velocity");
		add(velocityLabel);
		velocityText = new JTextField();
		add(velocityText);
		timeLabel = new JLabel("Time");
		add(timeLabel);
		timeText = new JTextField();
		add(timeText);

		button = new JButton("Calculate");
		add(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				double angle = Double.parseDouble(angleText.getText());
				double velocity = Double.parseDouble(velocityText.getText());
				double time = Double.parseDouble(timeText.getText());

				Projectile p = new Projectile(angle, velocity, time);
				double x = p.getX();
				double y = p.getY();

				answerLabel = new JLabel();
				add(answerLabel);
				answerLabel.setText("X = " + x + ", Y = " + y);
			}

		});

	}

}
