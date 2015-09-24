package jaffa.scrabble;

import java.io.BufferedReader;
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.HashSet;

//import java.util.Scanner;

public class ScrabbleDictionary {

	HashSet<String> dictionary;

	public ScrabbleDictionary() throws IOException {
		/*
		 * Scanner file = new Scanner(new File("./us.dic")); this.dictionary =
		 * new HashSet<String>();
		 * 
		 * while(file.hasNext()){ dictionary.add(file.next()); } file.close();
		 */

		// use BufferedReader instead of Scanner
		BufferedReader in = new BufferedReader(new FileReader("US.dic"));
		// ArrayList<String> dictionary = new ArrayList<String>();
		this.dictionary = new HashSet<String>();
		String line;
		while ((line = in.readLine()) != null) {
			dictionary.add(line);
		}
		in.close();

	}

	/**
	 * @return true if dictionary contains the word, otherwise false
	 * @throws FileNotFoundException
	 */
	public boolean contains(String word) {
		return dictionary.contains(word);
	}

}
