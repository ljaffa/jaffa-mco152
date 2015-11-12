package jaffa.connectFour2;

public class Logic {

	private int cellsLeft = 0;
	private int max;
	private int xSize;
	private int ySize;
	Grid myBoard;

	public Logic(Grid tempGrid){
		max = 4;  //win
		myBoard = tempGrid;
		cellsLeft = myBoard.getCellsLeft();
		xSize = myBoard.getXSize();
		ySize = myBoard.getYSize();
	}

	public boolean setSpaceAndCheck(int x, int y, int player){
		//sets the found coordinate to current player
		myBoard.setSpace(x, y, player);
		cellsLeft--;
		return checkOne(x, y, 0, 1, player)
				|| checkOne(x, y, -1, 1, player)
				|| checkOne(x, y, -1, 0, player)
				|| checkOne(x, y, 1, 1, player);
	}

	public boolean drawGame(){
		return cellsLeft == 0;
	}

	private boolean checkOne(int x, int y, int dx, int dy, int player){
		int count = 0; 
		int tempX = x;
		int tempY = y;

		while (count < max && valid(tempX, tempY)){
			if (!myBoard.spaceEquals(tempX, tempY, player)){
				break;
			}
			tempX += dx;
			tempY += dy;
			count++;
		}
		tempX = x - dx;
		tempY = y - dy;
		while (count < max && valid(tempX, tempY)){
			if (!myBoard.spaceEquals(tempX, tempY, player)){
				break;
			}
			tempX -= dx;
			tempY -= dy;
			count++;
		}
		return count == max;
	}

	private boolean valid(int x, int y){
		return x >= 0 && x < xSize && y >= 0 && y < ySize;
	}

}
