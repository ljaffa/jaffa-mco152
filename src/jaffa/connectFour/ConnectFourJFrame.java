package jaffa.connectFour;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JFrame;

public class ConnectFourJFrame extends JFrame {

	public static int player1 = 1;
	static int player2 = 2;
	static int currentPlayer = 1;
	static int[][] board = new int[7][8];

	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		new ConnectFourJFrame().setVisible(true);
	}

	public ConnectFourJFrame() {
		setTitle("Connect Four");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout layout = new GridLayout(7,8);
		Container container = getContentPane();

		container.setLayout(layout);
		for (int i = 0; i < 7*8; i++){
			container.add(new ConnectFourComponent());
		}
		//add(container, BorderLayout.CENTER);
	}

	public static void playGame(){
		int row;
		System.out.println("Enter a column (1 -8)");
		int column = keyboard.nextInt() - 1;
		for (int i = board.length; i >= 0; i--){
			if (board[i][column] == 0){
				row = i;
			}
		}
		new ConnectFourComponent(row, column, currentPlayer);
		if (currentPlayer == 1){
			currentPlayer = 2;
		}
		else {
			currentPlayer = 1;
		}
	}
}
