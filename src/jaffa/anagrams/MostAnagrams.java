package jaffa.anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostAnagrams {

	public static void main(String args[]) throws FileNotFoundException {
		// make a hashMap of String, ArrayList - if hashMap has sorted word, add
		// to arrayList of sorted word
		// if not, add word to HashMap
		HashMap<String, ArrayList<String>> anagrams = new HashMap<String, ArrayList<String>>();

		Scanner file = new Scanner(new File("US.dic"));

		while (file.hasNext()) {
			String dictionaryWord = file.next();
			char[] dictionaryLetters = dictionaryWord.toCharArray();
			Arrays.sort(dictionaryLetters);
			String anagramWord = new String(dictionaryLetters);

			if (anagrams.containsKey(anagramWord)) {
				ArrayList<String> valueWords = anagrams.get(anagramWord);
				valueWords.add(dictionaryWord);
				anagrams.put(anagramWord, valueWords);
			} else {
				ArrayList<String> valueWords = new ArrayList<String>();
				valueWords.add(dictionaryWord);
				anagrams.put(anagramWord, valueWords);
			}

		}
		file.close();

		int greatestValue = 0;
		String greatestWord = "";
		ArrayList<String> greatestWords = new ArrayList<String>();
		for (Map.Entry<String, ArrayList<String>> entry : anagrams.entrySet()) {
			// System.out.println(entry.getKey() + " \t\t" + entry.getValue());
			if (entry.getValue().size() > greatestValue) {
				greatestValue = entry.getValue().size();
				greatestWord = entry.getKey();
				greatestWords = entry.getValue();
			}
		}
		System.out.println(greatestValue);
		System.out.println(greatestWord);
		System.out.println(greatestWords);
	}
}
