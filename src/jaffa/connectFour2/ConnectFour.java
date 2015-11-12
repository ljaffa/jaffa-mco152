package jaffa.connectFour2;

public class ConnectFour {

	public static void main(String[] args){
		int state = 0;
		boolean useGui = true ;

		if (useGui){
			Gui gui = new Gui();

			while (state != -1){
				switch(state){
				case 0:
					gui.updateBoard();
					if (gui.getHasWon()){
						state = 1;
					}
					else if (gui.getHasDraw()){
						state = 2;
					}
					else if (gui.getNewGame()){
						gui = new Gui();
						state = 0;
					}
					break;
				case 1: //end game with winner
					gui.showWon();
					if (gui.getQuit()){
						state = -1;
					}
					else if (gui.getNewGame()){
						gui = new Gui();
						state = 0;
					}
					break;
				case 2: //end game with draw
					gui.showDraw();
					if (gui.getQuit()){
						state = -1;
					}
					else if (gui.getNewGame()){
						gui = new Gui();
						state = 0;
					}
					break;
				}
			}
		}
	}

}
