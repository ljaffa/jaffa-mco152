package jaffa.pi;

public class PiCalculator {

	public double calculate(long iterations){
		double pi = 0;

		double numerator = 4;
		double denominator = 1;

		boolean positive = true;
		for (long i = 0; i < iterations; i++){
			if (positive){
				pi += numerator/ denominator;
				//positive = false;
			}
			else {
				pi -= numerator / denominator;
				//positive = true;
			}
			denominator += 2;
			//positive = positive ? negative : positive;
			positive = !positive;
		}

		return pi;
	}

}
