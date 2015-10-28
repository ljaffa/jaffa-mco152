package jaffa.physics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class GraphicProjectileComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		Projectile p = new Projectile(31, 20, 0);

		double oldX = p.getX();
		double oldY = getHeight() - p.getY();
		double newX;
		double newY;
		for (int i = 0; i < 20; i++) {
			p.setTime(i);
			// get x and get y from this projectile
			newX = p.getX();
			newY = getHeight() - p.getY();
			g2.draw(new Line2D.Double(oldX, oldY, newX, newY));
			// save old x and y so u can use it the next time
			oldX = newX;
			oldY = newY;
		}
	}
}
