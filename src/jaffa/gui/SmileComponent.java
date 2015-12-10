package jaffa.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mouseX;
	private int mouseY;

	// can only draw on the screen with this method
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// g.drawOval(100, y, getWidth() - 200, getHeight() - 200);
		// y++;

		// if (y == 201) {
		// y = 0;
		// }

		// super.repaint();

		// g.drawLine(0, 300, 600, 50);

		g.setColor(Color.YELLOW);
		g.fillOval(100, 50, getWidth() - 200, getHeight() - 100);
		g.setColor(Color.blue);

		g.fillOval(250, 168, getWidth() - 700, getHeight() - 450);
		// height++;

		// if (height == 50) {
		// height = 0;
		// }
		// try {
		// Thread.sleep(16);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// super.repaint();

		g.fillOval(450, 168, getWidth() - 700, getHeight() - 450);

		final Point mousePos = this.getMousePosition();
		if (mousePos != null) {
			mouseX = mousePos.x;
			mouseY = mousePos.y;
		}

		g.setColor(Color.BLACK);
		if (mouseX >= 260 && mouseY >= 178) {
			g.fillOval(290, 218, 40, 40);
			g.fillOval(490, 218, 40, 40);
		}
		if (mouseX < 260 && mouseY < 178) {
			g.fillOval(260, 178, 40, 40);
			g.fillOval(460, 178, 40, 40);
		}
		if (mouseX >= 260 && mouseY < 178) {
			g.fillOval(280, 178, 40, 40);
			g.fillOval(480, 178, 40, 40);
		}
		if (mouseX < 260 && mouseY >= 178) {
			g.fillOval(255, 218, 40, 40);
			g.fillOval(455, 218, 40, 40);
		}
		super.repaint();
		g.setColor(Color.red);
		g.fillArc(200, 250, getWidth() - 400, getHeight() - 350, 180, 180);
		// x++;
		// width--;

		// if (x == 250 && width == 100) {
		// x = 150;
		// width = 200;
		// }
		// try {
		// Thread.sleep(16);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// super.repaint();
	}

}
