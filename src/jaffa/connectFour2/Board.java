package jaffa.connectFour2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Board extends JComponent{

	int rows = 7;
	int columns = 8;
	int size = 100;
	int[][] board = new int[rows][columns];

	public void setup(){
		//setSize(800, 600);
		board[0][0] = 1;
		board[1][1] = 2;
	}

	//public void draw(){
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++){
				//g.fillRect(x, y, width, height);fill(255);
				g.drawRect(j*size, i*size, size, size);
				if (board[i][j] == 1){
					g.setColor(Color.RED);
					g.fillRect(j*size, i*size, size, size);
				}
				else if (board[i][j] == 2){
					g.setColor(Color.GREEN);
					g.fillRect(j*size, i*size, size, size);
				}
			}
		}
	}

	public void mousePressed(){
		int mouseX = ;
		int x = mouseX  / size;
	}
}
