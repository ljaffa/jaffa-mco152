package jaffa.anagrams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostAnagrams {

	public static void main(String args[]) throws IOException {
		// make a hashMap of String, ArrayList - if hashMap has sorted word, add
		// to arrayList of sorted word
		// if not, add word to HashMap
		HashMap<String, ArrayList<String>> anagrams = new HashMap<String, ArrayList<String>>();

		BufferedReader file = new BufferedReader(new FileReader("US.dic"));

		String dictionaryWord;
		while ((dictionaryWord = file.readLine()) != null) {
			//String dictionaryWord = file.readLine();
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
		String greatestWord2 = "";
		ArrayList<String> greatestWords2 = new ArrayList<String>();

		for (Map.Entry<String, ArrayList<String>> entry : anagrams.entrySet()) {
			// System.out.println(entry.getKey() + " \t\t" + entry.getValue());
			if (entry.getValue().size() > greatestValue) {
				greatestValue = entry.getValue().size();
				greatestWord = entry.getKey();
				greatestWords = entry.getValue();
			}
			else if (entry.getValue().size() == greatestValue){
				greatestWord2 = entry.getKey();
				greatestWords2 = entry.getValue();
			}
		}
		System.out.println(greatestValue);
		System.out.println(greatestWord);
		System.out.println(greatestWords);
		System.out.println(greatestWord2);
		System.out.println(greatestWords2);
	}
}
