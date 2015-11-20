package jaffa.pi;

import javax.swing.JLabel;

public class PiCalculationThread extends Thread{

	private JLabel label;

	public PiCalculationThread(JLabel label){
		this.label = label;
	}

	@Override
	public void run(){
		//this is the code that will execute on a different thread than the main thread.
		PiCalculator calc = new PiCalculator();
		double pi = calc.calculate(1000000000L);
		label.setText(String.valueOf(pi));
	}

}
