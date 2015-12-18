package jaffa.contacts;

import java.util.Comparator;

public class ContactComparator implements Comparator<Contact> {

	@Override
	public int compare(Contact c1, Contact c2) {
		// TODO Auto-generated method stub
		String name1 = c1.getName();
		String name2 = c2.getName();
		String[] nameArray1 = name1.split(" ");
		String[] nameArray2 = name2.split(" ");
		String last1 = nameArray1[1];
		String last2 = nameArray2[1];
		return last1.compareTo(last2);
	}

}
