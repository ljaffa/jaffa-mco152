package jaffa.anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostAnagrams {
	
	public static void main(String args[]) throws FileNotFoundException{
		HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
		ArrayList<String> words = new ArrayList<String>();
		
		Scanner file = new Scanner(new File("US.dic"));
		
		while(file.hasNext()){
			String word = file.next();
			words.add(word);
			char[] letters = word.toCharArray();
			Arrays.sort(letters);
			String keyWord = new String (letters);
			
			Integer count = dictionary.get(keyWord);
			if (count == null){
				dictionary.put(keyWord, 1);
			}
			else {
				dictionary.put(keyWord, count + 1);
			}
			
		}
		file.close();
		int greatestValue = 0;
		String greatestWord = "";
		for (Map.Entry<String, Integer> entry : dictionary.entrySet()){
			//System.out.println(entry.getKey() + " \t\t" + entry.getValue());
			if (entry.getValue() > greatestValue){
				greatestValue = entry.getValue();
				greatestWord = entry.getKey();
			}
		}
		System.out.println();
		System.out.println(greatestValue);
		System.out.println(greatestWord);
				
		ArrayList<String> anagrams = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : dictionary.entrySet()){
			if (entry.getValue() == greatestValue){
			
				for (String s : words){
					char[] sLetters = s.toCharArray();
					Arrays.sort(sLetters);
					String sSorted = new String (sLetters);
			
					if (sSorted.equals(entry.getKey())){
						anagrams.add(s);
					}
			}
			}
		}
		System.out.println(anagrams);
	}
}
