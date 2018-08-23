package valid_strings;

/**
 * @author kmk
 * 
 *         Consider a string to be valid if all characters of the string appear
 *         the same number of times. It is also valid if one can remove just 1
 *         character at any index in the string, and the remaining characters
 *         will occur the same number of times.
 * 
 *         Given a string , determine if it is valid.
 */

public class ValidStrings {

	public static void main(String[] args) {

		// NO
		// String s = "aabbcd";
		// String s = "aabbccddeefghi";

		// YES
		String s = "abcdefghhgfedecba";

		System.out.println(isValid(s));
	}

	static String isValid(String s) {

		
		// Add Characters to Letter-Frequency array 
		int[] alphabetArray = new int[26];

		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			int currentCharNumeric = (int) currentChar;
			int temp_integer = 96;
			if (currentCharNumeric <= 122 & currentCharNumeric >= 97) {
				alphabetArray[currentCharNumeric - temp_integer - 1]++;
			}
		}

		// If all values are equal : YES
		// If all values are equal bar one : YES
		// If all values are equal bar two : NO

		int benchMark = alphabetArray[0];
		int numberOfDifferences = 0;

		for (int i = 0; i < alphabetArray.length; i++) {
			if (alphabetArray[i] == benchMark) {
				// do nothing
			} else if (alphabetArray[i] == 0) {
				// do nothing
			} else {
				numberOfDifferences++;
			}

		}

		if (numberOfDifferences >= 2) {
			return "NO";
		}

		return "YES";

	}

}
