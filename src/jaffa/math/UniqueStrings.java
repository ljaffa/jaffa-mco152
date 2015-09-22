package jaffa.math;

import java.util.HashSet;

public class UniqueStrings {
	
	public static void main(String args[]){
		
		String array[] = new String[] {
				"A", "B", "B","C"
		};
		
		for (int i = 0; i < array.length; i++){
			boolean found = false;
			for (int j = 0; j < i; j++){
				if (array[i].equals(array[j])){
					found = true;
				}
			}
			if (!found){
				System.out.println(array[i]);
			}
		}
		
		HashSet set = new HashSet<String>();
		for (String s : array){
			if (!set.contains(s)){
				System.out.println(s);
			}
			set.add(s);
		}
		
	}

}
