package jaffa.math;

import java.util.HashSet;

public class ShowDuplicates {
	
	public static void main(String args[]){
		
		String array[] = new String[]{
				"A", "B", "B", "C"
		};
		
		HashSet set = new HashSet<String>();
		for (String s : array){
			if (!set.contains(s)){
				System.out.println(s);
			}
			set.add(s);
		}
		
		System.out.println(set);
		
	}

}
