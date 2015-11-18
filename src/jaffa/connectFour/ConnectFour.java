package jaffa.connectFour;

public class ConnectFour {

	public static void main(String[] args){
		int option = 0;

		Gui gui = new Gui();

		while (option != -1){ //quit if option = -1
			switch(option){
			case 0:
				gui.updateBoard();
				if (gui.getHasWon()){
					option = 1;			//winner - end game
				}
				else if (gui.getHasTie()){
					option = 2;			//tie - end game
				}
				else if (gui.getNewGame()){
					gui = new Gui();		//reset board
					option = 0;				//start new game
				}
				break;
			case 1: //end game with winner
				gui.showWon();		//display dialogue box with winner
				if (gui.getQuit()){
					option = -1; //end game
				}
				else if (gui.getNewGame()){
					gui = new Gui();  //reset board
					option = 0;			//start new game
				}
				break;
			case 2: //end game with tie
				gui.showTie();		//display dialogue box with tie
				if (gui.getQuit()){
					option = -1; 	//end game
				}
				else if (gui.getNewGame()){
					gui = new Gui();		//reset board
					option = 0;				//start new game
				}
				break;
			}
		}
	}

}
