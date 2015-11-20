package jaffa.pi;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PiFrame extends JFrame{

	public PiFrame(){
		setTitle("");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("Pi calculation in progress");

		Container container = getContentPane();
		container.add(label);

		PiCalculationThread thread = new PiCalculationThread(label);

		thread.start();	//tells the operating system to call the run method
	}

	public static void main(String[] args){
		new PiFrame().setVisible(true);
	}

}
