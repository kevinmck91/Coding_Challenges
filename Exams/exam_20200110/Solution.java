package exam_20200110;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public static void main(String args[]) throws Exception {

		/*
		 * A matching word is when all letters in A are contained in B, and all
		 * letters in B are contained in A Given a word and a list of words.
		 * Determine the number of matching words
		 * 
		 * EG :
		 * 
		 * love 
		 * velo low vole lovee volvell lowly lower lover levo loved love
		 * lovee lowe lowes lovey lowan lowa evolve loves volvelle lowed love
		 * 
		 * Answer : 8
		 * 
		 */

		String myString1 = "love";
		ArrayList<String> arrayList1 = new ArrayList();
		String[] array = new String[] { "velo", "low", "vole", "lovee", "volvell", "lowly", "lower", "lover", "levo", "loved", "love",
				"lovee", "lowe", "lowes", "lovey", "lowan", "lowa", "evolve", "loves", "volvelle", "lowed", "love" };

		for (String string : array) {
			arrayList1.add(string);
		}

		System.out.println(arrayList1 + "\n");

		// Add initial word letters to TreeSet_1
		TreeSet<Character> TreeSet1 = new TreeSet<>();

		for (int i = 0; i < myString1.length(); i++) {
			TreeSet1.add(myString1.charAt(i));
		}

		System.out.println("Initial word : " + TreeSet1);

		int count = 0;

		// Loop through list of words
		for (int i = 0; i < arrayList1.size(); i++) {

			System.out.println("Testing Array word : " + arrayList1.get(i));
			TreeSet<Character> treeSet2 = new TreeSet<>();

			// Add each words letters to set_2
			for (int j = 0; j < arrayList1.get(i).length(); j++) {
				treeSet2.add(arrayList1.get(i).charAt(j));
			}

			System.out.println("Added to Treelist : " + treeSet2);

			// if Set_1.equals(Set_2), increase count
			if (TreeSet1.equals(treeSet2)) {
				count++;
				System.out.println("Set1 : " + TreeSet1 + ". Set2 : " + treeSet2);
				System.out.println("count : " + count + "\n");
			} else {
				System.out.println("\n");
			}
		}

		System.out.println(count);

	}

}

/*
 * love velo low vole lovee volvell lowly lower lover levo loved love lovee lowe
 * lowes lovey lowan lowa evolve loves volvelle lowed love
 */