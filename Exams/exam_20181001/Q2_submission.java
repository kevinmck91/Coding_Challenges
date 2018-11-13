package exam_20181001;

import java.util.ArrayList;
import java.util.Arrays;

public class Q2_submission {

	public static void main(String[] args) {

		String[] myStrArray = { "mark", "kram", "markdfd", "eoj", "kramtrt",
				"joe", "oje" };

		friendlyWords(myStrArray);

	}

	static String[] friendlyWords(String[] input) {

		/*
		 * Create two charactor maps Add lettets to charactor maps
		 */

		ArrayList<String> arrayListFriendlyWords = new ArrayList<String>();

		for (int i = 0; i < input.length; i++)

			for (int j = i + 1; j < input.length; j++) {

				// System.out.println("i : " + input[i] + " j : " + input[j]);

				boolean IsFriendly = checkIsFriendly(input[i], input[j]);

				if (IsFriendly == true) {
					arrayListFriendlyWords.add(input[i]);
					arrayListFriendlyWords.add(input[j]);
				}
			}

		// String[] output = (String[]) arrayListFriendlyWords.toArray();

		System.out.println(arrayListFriendlyWords);

		return input;
	}

	private static boolean checkIsFriendly(String string, String string2) {

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
