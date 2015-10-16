package jaffa.physics;

public class QuadraticEquation {

	private double a;
	private double b;
	private double c;

	public QuadraticEquation(double a, double b, double c)
			throws ImaginaryNumberException, DivideByZeroException {
		if (a == 0) {
			throw new ImaginaryNumberException();
		}
		if (b == 0) {
			throw new DivideByZeroException();
		}
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getPositiveX() {
		double x = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		return x;
	}

	public double getNegativeX() {
		double x = ((-b) - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		return x;
	}

}
