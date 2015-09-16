package jaffa.morsecode;

public class MorseCode {
	
	private String string;
	private String[] morse;
	private String[] abc;
	
	public MorseCode(){
		this.morse = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", 
		             "....", "..", ".---", "-.-", ".-..", "--", "-.", 
		             "---", ".--.", "--.-", ".-.", "...", "-", "..-",
		             "...-", ".--", "-..-", "-.--", "--.."};
		this.abc = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I",
		                "J", "K", "L", "M", "N", "O", "P", "Q", "R",
		                "S", "T", "U", "V", "W", "X", "Y", "Z"};
	}
	
	public String encode(String message){
		String returnMessage = " ";
		
		String words[] = message.split(" ");
		for (int i = 0; i < words.length; i++){
			char[] letters = words[i].toCharArray();
			
			for (int j = 0; j < letters.length; j++){
				for (int k = 0; k < abc.length; k++){
					if (abc[k].equals(letters[j])){
						returnMessage += morse[k] + " ";
						break;
					}
				}
			}
			
			if (i < words.length - 1){
				returnMessage += "   ";
			}
		}
		return returnMessage;
	}

	
	public String decode(String code){
		String returnMessage = " ";
		
		String[] words = code.split("   ");
		for (int i = 0; i < words.length; i++){
			String[] letters = words[i].split(" ");
			for (int j = 0; j < letters.length; j++){
				for (int k = 0; k < morse.length; k++){
					if (morse[k].equals(letters[j])){
						returnMessage += abc[k];
						break;
					}
				}
			}
			if (i < words.length){
				returnMessage += " ";
			}
		}
		return returnMessage;
		
	}

}
