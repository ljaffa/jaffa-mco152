package jaffa.physics;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class QuadraticEquationGUI extends JFrame {

	private JLabel aLabel;
	private JLabel bLabel;
	private JLabel cLabel;
	private JLabel xLabel;
	private JLabel answerLabel;

	private JTextField aText;
	private JTextField bText;
	private JTextField cText;

	private JButton button;

	public QuadraticEquationGUI() {
		setTitle("Quadratic Equation");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		aLabel = new JLabel("A");
		add(aLabel);
		aText = new JTextField();
		add(aText);

		bLabel = new JLabel("B");
		add(bLabel);
		bText = new JTextField();
		add(bText);

		cLabel = new JLabel("C");
		add(cLabel);
		cText = new JTextField();
		add(cText);
		xLabel = new JLabel();
		add(xLabel);

		button = new JButton("Calculate");
		add(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Double a = Double.parseDouble(aText.getText());
					Double b = Double.parseDouble(bText.getText());
					Double c = Double.parseDouble(cText.getText());

					QuadraticEquation q = new QuadraticEquation(a, b, c);
					Double answer = q.getPositiveX();
					Double answer2 = q.getNegativeX();
					answerLabel = new JLabel();
					add(answerLabel);
					answerLabel.setText("X = " + answer + ", -X = " + answer2);
				} catch (ImaginaryNumberException | DivideByZeroException e) {
					e.printStackTrace();
				}
			}

		});
	}

}
