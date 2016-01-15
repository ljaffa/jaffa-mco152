package jaffa.nypl;

public class NYPLMain {

	public static void main(String[] args) {
		NYPLGui gui = new NYPLGui();
		gui.setVisible(true);

		gui.getRootPane().setDefaultButton(gui.getSearch());
	}

}
