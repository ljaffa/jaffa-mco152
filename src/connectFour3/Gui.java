package connectFour3;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Gui extends JFrame{

	private JFrame frame;
	private JButton[] buttons;
	private JComponent[][] board;

	private int rows = 7;
	private int columns = 6;
	private int currentPlayer = 1;

	private boolean hasWinner = false;
	private boolean hasTie = false;
	private boolean newGame = false;
	private boolean quiit = false;

	Board gameBoard = new Board();

	public Gui(){
		frame = new JFrame("Connect Four");

		Container container = getContentPane();
		container.setLayout(new GridLayout(rows, columns + 1));

		buttons = new JButton[rows];
		board = new JComponent[rows][columns];

		for (int row = 0; row < rows; row++){
			for (int column = 0; column < columns; column++){
				board[row][column] = new ConnectFourJComponent();
			}
		}

		frame.setContentPane(container);
		frame.setSize(800,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
