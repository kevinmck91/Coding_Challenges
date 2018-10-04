package interview_exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Q2_attempt2 {

	public static void main(String[] args) {
		
		String[] testArray = { "lamp", "palm", "finger", "deal", "elbow",
				"fringe", "silent", "teaching", "below", "bowel", };
		
		String[] testArray2 = { "qwerty", "trewqt", "ytrewq", "asdf", "fdsa",
				"asdf", "ffff", "teadddching", "sfda", "bowel", };
	
		matchingWords(testArray2);

	}

	private static void matchingWords(String[] testArray) {
		
		LinkedHashMap<String, TreeSet> linkedHashMap1 = new LinkedHashMap<>();
		
	// Convert String Array to ArrayList and sort
		
		ArrayList<String> arrayList = new ArrayList<>();
		for(int i = 0; i < testArray.length; i++){
			arrayList.add(testArray[i]);
		}
		
		Collections.sort(arrayList);
		
	// Create TreeSet of Normalized strings to remove duplicates
		
		TreeSet<String> treeSet1 = new TreeSet<>();
		for(int i = 0; i < arrayList.size(); i++){	
			String result = normalizeString(arrayList.get(i));
			treeSet1.add(result);
		}
		
		System.out.println("Sort Each String  : " + arrayList);
		System.out.println("Remove Duplicates : " +treeSet1);
		
	/* 	Take a Normalized String.
	   	Check it against all original Strings for matching anagrams.
	 	Add all anagrams (originals format) to a new TreeSet
	*/
		
		ArrayList<TreeSet> arrayList2 = new ArrayList<>();

		for (String normalizedString : treeSet1) {

			TreeSet<String> treeSet2 = new TreeSet<>();

			for (String originalString : arrayList) {

				if (isAnagram(normalizedString, originalString)) {
					treeSet2.add(originalString);
				}
			}
			arrayList2.add(treeSet2);
		}
		
		
	System.out.println("Sets of anagrams  : " + arrayList2);
	
	/*	Two array lists now correspond
	 * 	arrayList1<String> : [aceghint, adel, almp, below, efginr, eilnst]
	 *  arrayList<TreeSet> : [[teaching], [deal], [lamp, palm], [below, bowel, elbow], [finger, fringe], [silent]]
	 *  
	 *  Now print out the contents
	 *  
	 */
	
		for (TreeSet output : arrayList2) {
			if (output.size() > 1) {
				System.out.println(output);
			}
		}
	
		
	}
	
	
	private static boolean isAnagram(String string, String string2) {

		if (string.length() != string2.length()) {
			return false;
		}

		int[] array1 = new int[26];

		for (int i = 0; i < string.length(); i++) {
			char currentChar = string.charAt(i);
			int currentCharNumeric = (int) currentChar;
			int temp_integer = 96;
			if (currentCharNumeric <= 122 & currentCharNumeric >= 97) {
				array1[currentCharNumeric - temp_integer - 1]++;
			}
		}

		int[] array2 = new int[26];

		for (int i = 0; i < string2.length(); i++) {
			char currentChar = string2.charAt(i);
			int currentCharNumeric = (int) currentChar;
			int temp_integer = 96;
			if (currentCharNumeric <= 122 & currentCharNumeric >= 97) {
				array2[currentCharNumeric - temp_integer - 1]++;
			}
		}

		if (Arrays.equals(array1, array2)) {
			return true;
		} else {
			return false;
		}

	}

	private static String normalizeString(String string) {

		// Convert to Char array list
		// Sort
		
		ArrayList<Character> characterArrayList = new ArrayList<>();
		
		for(int i = 0; i < string.length(); i++){
			characterArrayList.add(string.charAt(i));
		}
		
		Collections.sort(characterArrayList);
		
		String output = "";
		
		for(int i = 0; i < characterArrayList.size(); i++){
			output += characterArrayList.get(i);
		}
		
		return output;
	}

}
