package jaffa.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class SmileJFrame extends JFrame {
	public static void main(String[] args) {

		new SmileJFrame().setVisible(true);
	}

	public SmileJFrame() {
		setTitle("Smile");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();

		container.setLayout(layout);
		container.add(new SmileComponent(), BorderLayout.CENTER);
		// want to put it in center of 5 panels because side panels do not
		// expand
		// and we want it to expand and resize to the size that we need

	}

}
