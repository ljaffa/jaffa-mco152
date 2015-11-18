package jaffa.connectFour;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Gui{

	private JFrame frame;
	private JLabel[][] board;
	private JButton[] buttons;

	private int rows = 7;
	private int columns = 6;
	private int currentPlayer = 1;

	private boolean hasWon = false;
	private boolean hasTie = false;
	private boolean quit = false;
	private boolean newGame = false;

	private ImageIcon redIcon;
	private ImageIcon blueIcon;
	private ImageIcon whiteIcon;

	private Board myBoard;



	public Gui() {
		myBoard = new Board();

		frame = new JFrame("Connect Four");

		redIcon = new ImageIcon("redCircle.jpe");
		Image redImage = redIcon.getImage();
		Image resizeRed = redImage.getScaledInstance(80, 70, Image.SCALE_SMOOTH);
		redIcon = new ImageIcon(resizeRed);

		blueIcon = new ImageIcon("blueCircle.png");
		Image blueImage = blueIcon.getImage();
		Image resizeBlue = blueImage.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		blueIcon = new ImageIcon(resizeBlue);

		whiteIcon = new ImageIcon("whiteCircle.jpe");
		Image whiteImage = whiteIcon.getImage();
		Image resizeWhite = whiteImage.getScaledInstance(90, 80, Image.SCALE_SMOOTH);
		whiteIcon = new ImageIcon(resizeWhite);

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
							int x = Integer.parseInt(e.getActionCommand());
							int y = myBoard.findFirstSpace(x); //check for space in column
							if (y == -1) {
								JOptionPane.showMessageDialog(null, "Choose another one", "Full Column", JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								//set place to currentPlayer
								if (myBoard.setSpaceAndCheck(x, y, currentPlayer)){
									hasWon = true;
								}
								else if (myBoard.tieGame()){
									hasTie = true;
								}
								else {
									//change player
									currentPlayer = myBoard.changePlayer(currentPlayer);
									frame.setTitle("ConnectFour - Player " + currentPlayer + "'s turn ");
								}
							}

						}				
					});
			panel.add(buttons[i]);
		}
		for (int column = 0; column < columns; column++){
			for (int row = 0; row < rows; row++){
				board[row][column] = new JLabel(whiteIcon);
				//board[row][column].setHorizontalAlignment(SwingConstants.CENTER);
				board[row][column].setBorder(new LineBorder(Color.BLACK));

				panel.add(board[row][column]);
			}
		}

		//JFrame stuff
		frame.setContentPane(panel);
		frame.setSize(800, 700);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
	}

	public void updateBoard(){
		//keeps gui in sync with logic and grid
		//update every time you make a move
		for (int row = 0; row < rows; row++){
			for (int column = 0; column < columns; column++){
				if (myBoard.spaceEquals(row, column, 1)){
					board[row][column].setIcon(redIcon);
				}
				else if (myBoard.spaceEquals(row, column, 2)){
					board[row][column].setIcon(blueIcon);
				}
			}
		}
	}

	public void showWon(){
		String winner = "Player " + currentPlayer + " wins!";
		int n = JOptionPane.showConfirmDialog(frame, "Would you like to play another game?", winner, JOptionPane.YES_NO_OPTION);
		if (n < 1){
			frame.dispose();
			newGame = true;
		}
		else {
			frame.dispose();
			quit = true;
		}
	}

	public void showTie(){
		int n = JOptionPane.showConfirmDialog(frame,  "Would you like to play another game?", "Tie Game", JOptionPane.YES_NO_OPTION);
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

	public boolean getHasTie(){
		return hasTie;
	}

	public boolean getQuit(){
		return quit;
	}

	public boolean getNewGame(){
		return newGame;
	}
}