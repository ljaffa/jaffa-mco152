package jaffa.connectFour;

public class Board {

	private int xSize;
	private int ySize;
	private int [][] board;
	private int cellsLeft;
	private int max;

	public Board(){
		xSize = 7;
		ySize = 6;
		cellsLeft = 0;
		max = 4;	//4 in a row
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

	/*public void setSpace(int a, int b, int tempPlayer){
		board[a][b] = tempPlayer;
	}*/

	public int getXSize(){
		return xSize;
	}

	public int getYSize(){
		return ySize;
	}

	public int findFirstSpace(int x){
		//checks for room in column and returns free spot
		int column = -1;
		for (int i = 0; i < ySize; i++){
			if (board[x][i] == 0){		//if space is not set to a player
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

	public boolean setSpaceAndCheck(int x, int y, int player){
		//sets the found coordinate to current player
		//setSpace(x, y, player);
		board[x][y] = player;
		cellsLeft--;
		//returns true if there is a winner
		return checkforWinner(x, y, 0, 1, player)
				|| checkforWinner(x, y, -1, 1, player)
				|| checkforWinner(x, y, -1, 0, player)
				|| checkforWinner(x, y, 1, 1, player);
	}

	public boolean tieGame(){
		//returns true if board is full and there is no winner
		return cellsLeft == 0;
	}

	private boolean checkforWinner(int x, int y, int xChange, int yChange, int player){
		int count = 0; 	//keep track of how many spaces in a row match
		//keep moving space to check each spaces
		int tempX = x;	
		int tempY = y;

		while (count < max && validSpace(tempX, tempY)){
			if (!spaceEquals(tempX, tempY, player)){
				break;
			}
			tempX += xChange;
			tempY += yChange;
			count++;
		}
		//got to end of board, have to now check the other way
		tempX = x - xChange;
		tempY = y - yChange;
		while (count < max && validSpace(tempX, tempY)){
			if (!spaceEquals(tempX, tempY, player)){
				break;
			}
			tempX -= xChange;
			tempY -= yChange;
			count++;
		}
		//returns true if there is a winner
		return count == max;
	}

	private boolean validSpace(int x, int y){
		return x >= 0 && x < xSize && y >= 0 && y < ySize;
	}

}
