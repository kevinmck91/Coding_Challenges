package matching_substrings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author kmk
 * 
 *         Given two strings, determine if they share a common substring. A
 *         substring may be as small as one character.
 * 
 */

public class MatchingSubstrings {

	public static void main(String[] args) {

		String s1 = "678912fdsfdfdsfsd";
		String s2 = "12345";

		System.out.println(quickMethod(s1, s2));
		// System.out.println(slowMethod(s1, s2));

	}

	private static boolean quickMethod(String s1, String s2) {

		// No need to check Strings - only check characters

		// Set the shortest string as s1 (less checks)
		if (s2.length() < s1.length()) {
			String temp = "";
			temp = s1;
			s1 = s2;
			s2 = temp;
		}

		// Add all characters in s1 to the Treemap
		Map<Character, Integer> treeMap = new TreeMap<>();

		for (int i = 0; i < s1.length(); i++) {
			treeMap.put(s1.charAt(i), 0);
		}

		// Check if Characters in s2 are in s1
		for (int i = 0; i < s2.length(); i++) {
			char letterToCheck = s2.charAt(i);
			if (treeMap.containsKey(letterToCheck)) {
				return true;
			}
		}

		return false;

	}

	// Initial Attempt - Innefficient
	private static boolean slowMethod(String s1, String s2) {

		boolean containsDuplicate = false;

		// Set the shortest string as s1 (less checks)
		if (s2.length() < s1.length()) {
			String temp = "";
			temp = s1;
			s1 = s2;
			s2 = temp;
		}

		// Add all combinations in s1 to the Treemap
		Map<String, Integer> treeMap = new TreeMap<>();

		for (int i = 0; i < s1.length(); i++) {

			for (int j = i + 1; j <= s1.length(); j++) {
				treeMap.put(s1.substring(i, j), 0);
			}
		}

		System.out.println(treeMap);

		// Check all combinations of s2 against s1 TreeMap
		for (int i = 0; i < s2.length(); i++) {

			for (int j = i + 1; j <= s2.length(); j++) {

				String subString = s2.substring(i, j);

				// No point in checking if '12345...' is a substring of '123'
				if (subString.length() > s1.length()) {
					break;
				}

				// Increase value of Map by 1 when duplicate string is found
				if (treeMap.containsKey(subString)) {
					int value = treeMap.get(subString);
					value++;
					treeMap.put(subString, value);
					containsDuplicate = true;
				}
			}
		}
		System.out.println(treeMap);
		return containsDuplicate;
	}
}
