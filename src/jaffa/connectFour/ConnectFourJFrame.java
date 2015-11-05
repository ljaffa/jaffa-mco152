package jaffa.connectFour;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class ConnectFourJFrame extends JFrame {

	public static void main(String[] args) {
		new ConnectFourJFrame().setVisible(true);
	}

	public ConnectFourJFrame() {
		setTitle("Connect Four");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout layout = new GridLayout(8,8);
		Container container = getContentPane();

		container.setLayout(layout);
		container.add(new ConnectFourComponent(), GridLayout.class);
	}
}
