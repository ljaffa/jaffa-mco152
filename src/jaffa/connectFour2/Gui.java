package jaffa.connectFour2;

//import jaffa.connectFour.ConnectFourJFrame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import connectFour3.ConnectFourJComponent;

public class Gui{

	private JFrame frame;
	//private JLabel[][] board;
	private JComponent[][] board;
	private JButton[] buttons;

	private int rows = 7;
	private int columns = 6;
	private int currentPlayer = 1;

	private boolean hasWon = false;
	private boolean hasDraw = false;
	private boolean quit = false;
	private boolean newGame = false;

	Grid myBoard = new Grid();
	Logic boardLogic = new Logic(myBoard); //create game logic 



	public Gui() {
		frame = new JFrame("Connect Four");

		//setTitle("Connect Four");
		//setSize(800, 600);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//GridLayout layout = new GridLayout(xSize, ySize + 1);
		//Container container = getContentPane();
		//container.setLayout(layout);
		//container.add(new Board());

		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(new GridLayout(rows, columns + 1));

		board = new JLabel[rows][columns];
		buttons = new JButton[rows];

		for (int i = 0; i < rows; i++){
			buttons[i] = new JButton("" + (i+1));
			buttons[i].setActionCommand("" + i);
			buttons[i].addActionListener(
					new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							int a = Integer.parseInt(e.getActionCommand());
							int y = myBoard.findY(a); //check for space in column
							if (y != -1){
								//set place to currentPlayer
								if (boardLogic.setSpaceAndCheck(a, y, currentPlayer)){
									hasWon = true;
								}
								else if (boardLogic.drawGame()){
									hasDraw = true;
								}
								else {
									//change player
									currentPlayer = myBoard.changePlayer(currentPlayer);
									frame.setTitle("ConnectFour - Player " + currentPlayer + "'s turn ");
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Choose another one", "column is filled", JOptionPane.INFORMATION_MESSAGE);
							}
						}				
					});
			panel.add(buttons[i]);
		}
		for (int column = 0; column < columns; column++){
			for (int row = 0; row < rows; row++){
				//board[row][column] = new JLabel();
				//board[row][column] = new ConnectFourJComponent();
				//board[row][column].setHorizontalAlignment(SwingConstants.CENTER);
				//board[row][column].setBorder(new LineBorder(Color.BLACK));
				//panel.add(board[row][column]);
				panel.add(new ConnectFourJComponent());
			}
		}

		//JFrame stuff
		frame.setContentPane(panel);
		frame.setSize(700, 600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
	}

	public void updateBoard(){
		//keeps gui in sync with logic and grid
		for (int row = 0; row < rows; row++){
			for (int column = 0; column < columns; column++){
				if (myBoard.spaceEquals(row, column, 1)){
					board[row][column].setOpaque(true);
					//board[row][column].setBackground(Color.red);
					board[row][column].setBackground(Color.red);
					//board[row][column].repaint();
				}
				if (myBoard.spaceEquals(row, column, 2)){
					board[row][column].setOpaque(true);
					//board[row][column].setBackground(Color.blue);
					board[row][column].setBackground(Color.blue);
					//board[row][column].repaint();
				}
			}
		}
	}

	public void showWon(){
		String winner = "player" + currentPlayer + " wins";
		int n = JOptionPane.showConfirmDialog(frame, "new game?", winner, JOptionPane.YES_NO_OPTION);
		if (n < 1){
			frame.dispose();
			newGame = true;
		}
		else {
			frame.dispose();
			quit = true;
		}
	}

	public void showDraw(){
		String winner = "draw game";
		int n = JOptionPane.showConfirmDialog(frame,  "new game?", winner, JOptionPane.YES_NO_OPTION);
		if (n < 1){
			frame.dispose();
			newGame = true;
		}
		else{
			frame.dispose();
			quit = true;
		}
	}

	public boolean getHasWon(){
		return hasWon;
	}

	public boolean getHasDraw(){
		return hasDraw;
	}

	public boolean getQuit(){
		return quit;
	}

	public boolean getNewGame(){
		return newGame;
	}

	public static void main(String[] args) {
		Gui gui = new Gui();
	}
}