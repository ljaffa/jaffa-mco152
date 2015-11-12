package jaffa.connectFour2;

public class Grid {

	private int xSize;
	private int ySize;
	private int [][] board;
	private int cellsLeft = 0;

	public Grid(){
		xSize = 7;
		ySize = 6;

		board = new int[xSize][ySize];
		for (int i = 0; i < xSize; i++){
			for (int j = 0; j < ySize; j++){
				board[i][j] = 0;
				cellsLeft++;
			}
		}
	}

	public int getCellsLeft(){
		return cellsLeft;
	}

	public int[][] getBoard(){
		return board;
	}

	public boolean spaceEquals(int a, int b, int c){
		return board[a][b] == c;
	}

	public void setSpace(int a, int b, int tempPlayer){
		board[a][b] = tempPlayer;
	}

	public int getXSize(){
		return xSize;
	}

	public int getYSize(){
		return ySize;
	}

	public int findY(int x){
		//checks for room in column and returns free spot
		int column = -1;
		for (int i = 0; i < ySize; i++){
			if (board[x][i] == 0){
				column = i;
			}
		}
		return column;
	}

	public int changePlayer(int player){ //, int max_players){
		if (player == 1){
			player = 2;
		}
		else {
			player = 1;
		}
		return player;
	}

}
