package jaffa.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrabbleDictionary {
	
	private ArrayList words;
	
	public ScrabbleDictionary(){
		this.words = new ArrayList();
	}
	
	/**
	 * @return true if dictionary contains the word, otherwise false
	 * @throws FileNotFoundException 
	 */
	public boolean contains(String word) throws FileNotFoundException{
		
		Scanner file = new Scanner(new File("./us.dic"));
		
		while(file.hasNext()){
			words.add(file.next());
		}
		if (words.contains(word)){
			return true;
		}
		return false;
	}

}
