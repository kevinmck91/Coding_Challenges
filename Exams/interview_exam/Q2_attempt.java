package interview_exam;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Q2_attempt {

	public static void main(String[] args) {

		String[] testArray2 = { "lamp", "palm", "finger", "deal", "elbow",
				"fringe", "silent", "teaching", "below", "bowel", };
	
		matchingWords(testArray2);

	}

	private static String[] matchingWords(String[] input) {

		// Loop through to find anagrams
		// Add all anagrams to a LinkedHashSet (to remove duplicates and sort)
		// Convert LinkedHashSet to array of Strings
		// Traverse to print out sets of anagrams

		LinkedHashSet<String> set1 = new LinkedHashSet<>();
		
		for (int i = 0; i < input.length; i++) {
			
			

			for (int j = i + 1; j < input.length; j++) {

				//System.out.println("i : " + input[i] + " j : " + input[j]);

				boolean isMatch = isAnagram(input[i], input[j]);

				if (isMatch == true) {
					set1.add(input[i]);
					set1.add(input[j]);
				}
			}
			
		}
		
		System.out.println("LinkedHashSet : " + set1);
		
		String[] stringArray = Arrays.copyOf(set1.toArray(), set1.toArray().length, String[].class);
	
		Iterator<String> itr = set1.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

		
		return input;

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

}
