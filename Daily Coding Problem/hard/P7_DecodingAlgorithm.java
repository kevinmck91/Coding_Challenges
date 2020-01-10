package hard;

import java.util.HashMap;
import java.util.TreeMap;

public class P7_DecodingAlgorithm {

	public static void main(String[] args) {

		/*
		 * Given the mapping a = 1, b = 2, … z = 26, and an encoded message,
		 * count the number of ways it can be decoded. For example, the message
		 * ‘111’ would give 3, since it could be decoded as ‘aaa’, ‘ka’, and
		 * ‘ak’.
		 * 
		 */
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		TreeMap<Integer, Character> alphabetHash = new TreeMap<>();
		
		for (int i = 1; i <= alphabet.length(); i++) 
			alphabetHash.put(i, alphabet.charAt(i-1));
		
		String encoding = "111";
		
		// compute all substrings
		
		
		
		
	}

}
