package jaffa.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ScrabbleDictionary {
	
	HashSet<String> dictionary;
	
	public ScrabbleDictionary() throws FileNotFoundException{
		Scanner file = new Scanner(new File("./us.dic"));
		this.dictionary = new HashSet<String>();
		
		while(file.hasNext()){
			dictionary.add(file.next());
		}
		file.close();
	}
	
	/**
	 * @return true if dictionary contains the word, otherwise false
	 * @throws FileNotFoundException 
	 */
	public boolean contains(String word){ 		
		return dictionary.contains(word);
	}

}
