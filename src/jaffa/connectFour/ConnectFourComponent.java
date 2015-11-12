package jaffa.connectFour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class ConnectFourComponent extends JComponent {

	private int height = getHeight() / 7;
	private int width = getWidth() / 8;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		/*g.drawRect(0, 0, 50, 50);
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
		}*/
		for (int i = 0; i < 7; i++){
			for (int j = 0; j < 8; j++){
				/*int x = 100* (8-1);
				int y = 100 * (7 - 1);
				g.drawRect(x, y, width, height);*/

				int x1 = 100*(8 - 1);
				int y1 = 100*(7 - 1);
				g.fillOval(x1, y1, 100, 100);

				int xCenter = getWidth() / 2;
				int yCenter = getHeight() / 2;
				int radius = (int)(Math.min(getWidth(), getHeight())*0.4);

				int x2 = xCenter - radius;
				int y2 = yCenter - radius;

				g.fillArc(x2, y2, 2*radius, 2*radius, 0, 360);
				setBackground(Color.BLACK);

				/*if (theSeed == 1) {
                    int x3 = 100*(currentCol - 1);
                    int y3 = 100*(currentRow - 1);
                    g.fillOval(x3, y3, 100, 100);
                    g.setColor(Color.RED);
                }
                if (theSeed == 2) { 
                    int x3 = 100*(currentCol - 1);
                    int y3 = 100*(currentRow - 1);
                    g.fillOval(x3, y3, 100, 100);
                    g.setColor(Color.BLUE);
                }
                else {
                    int x3 = 100*(currentCol - 1);
                    int y3 = 100*(currentRow - 1);
                    g.fillOval(x3, y3, 100, 100);
                    g.setColor(Color.WHITE);
                }
            }*/
			}
		}
	}


}


