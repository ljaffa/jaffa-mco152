package jaffa.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameDemo extends JFrame {

	private JTextField textField;
	private JLabel label1;
	private JLabel label2;
	private JButton button1;

	public JFrameDemo() {
		setTitle("JFrameDemo"); // title of window
		setSize(800, 600); // size of the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes the window and
		// exits the program

		Container container = getContentPane();

		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		// textField = new JTextField();
		// textField.setSize(new Dimension(200, 300));
		// textField.setText("Here is some text");
		// add(textField);

		label1 = new JLabel("All this text gets shown all the time");
		add(label1);
		label2 = new JLabel("more Labels");
		add(label2);
		textField = new JTextField();
		add(textField);
		button1 = new JButton("Button1");
		add(button1);

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(new Date());
			}

		});

	}

}
