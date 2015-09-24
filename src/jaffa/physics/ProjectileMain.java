package jaffa.physics;

public class ProjectileMain {

	public static void main(String args[]) {

		double velocity = 20;
		double angle = 31;
		double time = 2.7;

		Projectile projectile = new Projectile(angle, velocity, time);

		for (double t = 0; t <= 10; t++) {
			projectile.setTime(t);

			System.out.println("At " + t + " seconds, x = " + projectile.getX());
			System.out.println("At " + t + " seconds, y =  " + projectile.getY());
		}

	}
}