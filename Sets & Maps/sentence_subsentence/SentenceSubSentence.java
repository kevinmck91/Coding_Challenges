package sentence_subsentence;

import java.util.Map;
import java.util.TreeMap;

public class SentenceSubSentence {

	/**
	 * Check that one array of strings is a subarray of another set of strings  
	 */
	
	public static void main(String[] args) {

		String[] magazine = { "apgo", "clm", "w", "lxkvg", "mwz", "elo", "bg",
				"elo", "lxkvg", "elo", "apgo", "apgo", "w", "elo", "bg" };
		String[] note = { "elo", "lxkvg", "bg", "mwz", "clm", "w" };

		System.out.println(checkMagazine(magazine, note));
	}

	static String checkMagazine(String[] magazine, String[] note) {

		// Add String count to TreeMap to count occurrences
		Map<String, Integer> magazineMap = new TreeMap<String, Integer>();
		
		for (String string : magazine) {

			if (magazineMap.containsKey(string)) {
				int value = magazineMap.get(string);
				value++;
				magazineMap.put(string, value);
			} else {
				magazineMap.put(string, 1);
			}

		}

		// Check if every String in 'note' is in magazine altering the count if it is.
		for (String string : note) {

			if (!magazineMap.containsKey(string)) {
				return "no";
			} else {
				int value = magazineMap.get(string);
				value--;
				magazineMap.put(string, value);
			}

			if (magazineMap.get(string) < 0) {
				return "no";
			}
		}

		return "yes";
	}

}
