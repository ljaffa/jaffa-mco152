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
		HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
		ArrayList<String> words = new ArrayList<String>();

		Scanner file = new Scanner(new File("US.dic"));

		while (file.hasNext()) {
			String dictionaryWord = file.next();
			char[] dictionaryLetters = dictionaryWord.toCharArray();
			Arrays.sort(dictionaryLetters);
			String anagramWord = new String(dictionaryLetters);

			if (anagrams.containsKey(anagramWord)) {
				anagrams.get(anagramWord).add(dictionaryWord);
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
		System.out.println();
		System.out.println(greatestValue);
		System.out.println(greatestWord);
		System.out.println(greatestWords);

		file = new Scanner(new File("US.dic"));

		while (file.hasNext()) {
			String word = file.next();
			words.add(word);
			char[] letters = word.toCharArray();
			Arrays.sort(letters);
			String keyWord = new String(letters);

			Integer count = dictionary.get(keyWord);
			if (count == null) {
				dictionary.put(keyWord, 1);
			} else {
				dictionary.put(keyWord, count + 1);
			}

		}
		file.close();
		int greatestValue2 = 0;
		String greatestWord2 = "";
		for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
			// System.out.println(entry.getKey() + " \t\t" + entry.getValue());
			if (entry.getValue() > greatestValue) {
				greatestValue2 = entry.getValue();
				greatestWord2 = entry.getKey();
			}
		}
		System.out.println();
		System.out.println(greatestValue2);
		System.out.println(greatestWord2);

		ArrayList<String> anagramWords = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
			if (entry.getValue() == greatestValue2) {

				for (String s : words) {
					char[] sLetters = s.toCharArray();
					Arrays.sort(sLetters);
					String sSorted = new String(sLetters);

					if (sSorted.equals(entry.getKey())) {
						anagramWords.add(s);
					}
				}
			}
		}
		System.out.println(anagrams);
	}
}
