package exam_20200106;

/* Problem Name is &&& Best Average Grade &&& PLEASE DO NOT REMOVE THIS LINE. */

import java.io.*;
import java.util.*;

/*
 **  Instructions:
 **
 **  Given a list of student test scores, find the best average grade.
 **  Each student may have more than one test score in the list.
 **
 **  Complete the bestAverageGrade function in the editor below.
 **  It has one parameter, scores, which is an array of student test scores.
 **  Each element in the array is a two-element array of the form [student name, test score]
 **  e.g. [ "Bobby", "87" ].
 **  Test scores may be positive or negative integers.
 **
 **  If you end up with an average grade that is not an integer, you should
 **  use a floor function to return the largest integer less than or equal to the average.
 **  Return 0 for an empty input.
 **
 **  Example:
 **
 **  Input:
 **  [ [ "Bobby", "87" ],
 **    [ "Charles", "100" ],
 **    [ "Eric", "64" ],
 **    [ "Charles", "22" ] ].
 **
 **  Expected output: 87
 **  Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
 **  respectively. 87 is the highest.
 */

class Solution {
	
	/*
	 ** Execution entry point.
	 */


	public static void main(String[] args) {
		// Run the tests
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("Tests fail.");
		}
	}
	
	
	
	/*
	 ** Returns true if the tests pass. Otherwise, returns false;
	 */


	public static boolean doTestsPass() {

		String[][] tc1 = { { "Bobby", "100" }, { "Charles", "100" }, { "Eric", "150" }, { "Charles", "22" }, { "Bobby", "87" },
				{ "Charles", "100" }, { "Eric", "64" }, { "Charles", "22" } };

		String[][] tc2 = { { "Bobby", "123" }, { "Bobby", "321" }, { "Charles", "125" }, { "Charles", "352" }, { "Eric", "132" },
				{ "Eric", "312" }, { "Tommy", "231" }, { "Tommy", "333" } };

		boolean result = false;

		System.out.println(bestAverageGrade(tc1));

		if (bestAverageGrade(tc1) == 282 && bestAverageGrade(tc2) == 282)
			result = true;

		return result;
	}

	
	
	/*
	 ** Find the best average grade.
	 */
	
	public static Integer bestAverageGrade(String[][] scores) {

		HashMap<String, String> myHashMap = new HashMap<>();

		// Create a HashMap with Keys but Empty Values
		for (int i = 0; i < scores.length; i++)
			myHashMap.put(scores[i][0], "");

		// Fill the hash Map value
		for (int i = 0; i < scores.length; i++) {

			if (myHashMap.get(scores[i][0]) == "") {
				myHashMap.put(scores[i][0], scores[i][1]);
			}

			// If a value exists, replace it with the calculated average value
			else {

				int number = Integer.parseInt(myHashMap.get(scores[i][0]));

				number += Integer.parseInt(scores[i][1]);

				number = number / 2;

				myHashMap.put(scores[i][0], String.valueOf(number));

			}

		}

		System.out.println(myHashMap);

		int count = 0;

		for (String name : myHashMap.keySet()) {

			String key = name.toString();
			String value = myHashMap.get(name).toString();

			if (Integer.parseInt(value) > count)
				count = Integer.parseInt(value);
		}

		// System.out.println(count);
		return count;
	}


}
