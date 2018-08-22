package making_anagrams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author kmk
 * 
 *         Given two strings, a and b, that may or may not be of the same
 *         length, determine the minimum number of character deletions required
 *         to make a and b anagrams. Any characters can be deleted from either
 *         of the strings.
 *
 */

public class Making_Anagrams {

	public static void main(String[] args) {

		String a = "fcrxzwscanmligyxyvym";
		String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

		System.out.println(makeAnagram(a, b));

	}

	private static int makeAnagram(String a, String b) {

		// Add all string 'a' & 'b' to two array that keeps alphabet count
		int[] array1 = new int[26];
		int difference = 0;

		for (int i = 0; i < a.length(); i++) {
			char currentChar = a.charAt(i);
			int currentCharNumeric = (int) currentChar;
			int temp_integer = 96;
			if (currentCharNumeric <= 122 & currentCharNumeric >= 97) {
				array1[currentCharNumeric - temp_integer - 1]++;
			}
		}

		int[] array2 = new int[26];

		for (int i = 0; i < b.length(); i++) {
			char currentChar = b.charAt(i);
			int currentCharNumeric = (int) currentChar;
			int temp_integer = 96;
			if (currentCharNumeric <= 122 & currentCharNumeric >= 97) {
				array2[currentCharNumeric - temp_integer - 1]++;
			}
		}

		// The total difference is the total amount of letters to be removed to have anagrams
		for (int i = 0; i < 26; i++) {
			difference += Math.abs(array1[i] - array2[i]);
		}

		return difference;
	}

	// Method doesn't work
	static int makeAnagramAttempt(String a, String b) {

		/*
		 * Method wont work as it deletes duplicated from the string firstly
		 * Then tries to remove the characters not present in both strings
		 */

		int count = 0;

		ArrayList<Character> ALa = new ArrayList();
		ArrayList<Character> ALb = new ArrayList();

		for (int i = 0; i < a.length(); i++) {
			ALa.add(a.charAt(i));
		}
		for (int i = 0; i < b.length(); i++) {
			ALb.add(b.charAt(i));
		}

		Collections.sort(ALa);
		Collections.sort(ALb);

		/***** Remove duplicates for either array list and increase the count **********/

		TreeSet<Character> hs1 = new TreeSet<Character>();
		hs1.addAll(ALa);
		ALa.clear();
		ALa.addAll(hs1);
		count = count + (a.length() - ALa.size());

		TreeSet<Character> hs2 = new TreeSet<Character>();
		hs2.addAll(ALb);
		ALb.clear();
		ALb.addAll(hs2);
		count = count + (b.length() - ALb.size());

		/***** Remove Non-Matches for either array list **********/

		for (int i = 0; i < ALa.size(); i++) {

			if (ALb.contains(ALa.get(i))) {

			} else {
				count++;
			}
		}

		for (int i = 0; i < ALb.size(); i++) {
			if (ALa.contains(ALb.get(i))) {

			} else {
				count++;
			}
		}

		return count;

	}

}