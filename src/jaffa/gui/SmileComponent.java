package jaffa.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	// can only draw on the screen with this method
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// g.drawLine(0, 300, 600, 50);
		g.setColor(Color.YELLOW);
		g.fillOval(100, 100, 300, 300);
		g.setColor(Color.black);
		g.fillOval(165, 168, 50, 50);
		g.fillOval(285, 168, 50, 50);
		g.setColor(Color.red);
		g.fillArc(150, 170, 200, 200, 180, 180);
	}

}
