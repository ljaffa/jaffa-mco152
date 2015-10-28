package jaffa.physics;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class GraphicProjectile extends JFrame {

	public static void main(String[] args) {
		new GraphicProjectile().setVisible(true);
	}

	public GraphicProjectile() {
		setTitle("Projectile");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();

		container.setLayout(layout);
		container.add(new GraphicProjectileComponent(), BorderLayout.CENTER);
	}

}
