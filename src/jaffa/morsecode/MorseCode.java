package jaffa.morsecode;

import java.util.HashMap;
import java.util.Map;

public class MorseCode {
	
	private String[] morse;
	private char[] abc;
	
	private HashMap<Character, String> map;
	
	public MorseCode(){
		this.morse = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", 
		             "....", "..", ".---", "-.-", ".-..", "--", "-.", 
		             "---", ".--.", "--.-", ".-.", "...", "-", "..-",
		             "...-", ".--", "-..-", "-.--", "--.."};
		this.abc = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
		                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
		                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		this.map = new HashMap<Character, String>();
	
		for (int j = 0; j < abc.length; j++){
			map.put(abc[j], morse[j]);
		}
	
	}
	
	public String encode(String message){
		StringBuilder builder = new StringBuilder();
		
		String[] words = message.split(" ");
		for (int i = 0; i < words.length; i++){
			char[] letters = words[i].toCharArray();
			
			for (int j = 0; j < letters.length; j++){
				for (Map.Entry<Character, String> entry : map.entrySet()){
					if (letters[j] == entry.getKey()){
						builder.append(entry.getValue());
						if (j < letters.length - 1){
							builder.append(" ");
						}
					}
				}
			}
			if (i < words.length - 1){
				builder.append("   ");
			}
		}
		return builder.toString();
	}
	
	public String decode(String code){
		StringBuilder builder = new StringBuilder();
		
		String[] words = code.split("   ");
		for (int i = 0; i < words.length; i++){
			String[] letters = words[i].split(" ");
			for (int j = 0; j < letters.length; j++){
				for (Map.Entry<Character, String> entry : map.entrySet()){
					if(letters[j].equals(entry.getValue())){
						builder.append(entry.getKey());
					}
				}
			}
			if (i < words.length - 1){
				builder.append(" ");
			}
		}
		return builder.toString();
	}

}
