package connectFour3;

public class Board {

	private int rows;
	private int columns;
	private int[][] board;
	private int spacesLeft = 0;

	public Board(){
		this.rows = 7;
		this.columns = 6;
		this.board = new int[rows][columns];
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++){
				board[i][j] = 0;
				spacesLeft++;
			}
		}
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public int[][] getBoard() {
		return board;
	}

	public int getSpacesLeft() {
		return spacesLeft;
	}

}
