package jaffa.rascalTriangle;

import java.util.Scanner;

public class RascalTriangle {

	public static int rascal(int first, int second) {
		int answer = 0;
		if (second == 0) {
			return 1;
		}
		if (first == 1 || second == 1) {
			return answer = (first * second + 1) / 1;
		}
		// while (first != 1 && second != 1) {
		answer = (rascal(first - 1, second - 1) * rascal(first - 1, second) + 1)
				/ rascal(first - 2, second - 1);
		// }
		return answer;
	}

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter first number");
		int first = keyboard.nextInt();
		System.out.println("Enter second number");
		int second = keyboard.nextInt();
		System.out.println("Answer: " + rascal(first, second));
	}

}
