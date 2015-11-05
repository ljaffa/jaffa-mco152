package jaffa.connectFour;

import java.awt.Graphics;

import javax.swing.JComponent;

public class ConnectFourComponent extends JComponent {

	private int height = getHeight();
	private int width = getWidth();

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawRect(0, 0, 50, 50);
		g.drawRect(0, 50, 50, 50);
		g.drawRect(0, 100, 50, 50);
		g.drawRect(0, 150, 50, 50);
		g.drawRect(0, 200, 50, 50);
		g.drawRect(0, 2s
				-50, 50, 50);

		//g.drawRect(0, 0, width, height);
		//g.drawRect(20, 20, width, height);

		int i = 0;
		int j = 0;

		while (i < height) {
			g.drawRect(i, j, 50, 50);
			i += 50;
			j += 50;
		}

	}

}
