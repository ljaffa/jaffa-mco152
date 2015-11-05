package jaffa.scrabble;

public class ScrabbleDictionarySingleton {

	public static ScrabbleDictionarySingleton getInstance() {
		if (singleton == null) {
			singleton = new ScrabbleDictionarySingleton();
		}
		return singleton;
	}

	private static ScrabbleDictionarySingleton singleton;

	public ScrabbleDictionarySingleton() {
		// TODO read from file

	}

}
