package connectFour3;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class ConnectFourJComponent extends JComponent{

	private Color color = Color.WHITE;

	public void setColor(Color color){
		this.color = color;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(color);
		g.fillOval(20, 20, 50, 50);
	}



}
