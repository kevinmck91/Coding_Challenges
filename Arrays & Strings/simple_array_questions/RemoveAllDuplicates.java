package simple_array_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveAllDuplicates {

	/**
	 * Write a method to remove duplicates for an array
	 * 
	 * TODO: Check if one pass method exists
	 * 
	 */

	public static void main(String[] args) {

		// Run the tests
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("Tests fail.");
		}

	}

	private static boolean doTestsPass() {

		boolean result = false;

		// Test Case 1
		int[] array1 = { 2, 3, 4, 5, 4, 3, 5, 6, 7, 8, 6, 5, 4, 5, 4, 3, 5, 6, 4, 5, 4, 5 };
		int[] resultArray1 = { 2, 3, 4, 5, 6, 7, 8 };

		String a = removeDuplicates(array1);
		String b = Arrays.toString(resultArray1);

		// Test Case 2
		int[] array2 = { 1, 1, 1, 1, 1, 6, 6, 6, 6, 6, 6, 6, 4, 4, 4, 4, 4, 88, 88, 88, 88, 88 };
		int[] resultArray2 = { 1, 6, 4, 88 };

		String c = removeDuplicates(array1);
		String d = Arrays.toString(resultArray1);

		// Check test cases return expected
		if (a.equals(b) && c.equals(d))
			result = true;

		return result;
	}

	private static String removeDuplicates(int[] array1) {

		Set<Integer> linkedhashSet = new LinkedHashSet<>();
		ArrayList<Integer> arrayList = new ArrayList<>();

		for (int i = 0; i < array1.length; i++) {
			linkedhashSet.add(array1[i]);
		}

		for (Integer integer : linkedhashSet) {
			arrayList.add(integer);
		}

		int[] intArray = new int[linkedhashSet.size()];

		for (int i = 0; i < arrayList.size(); i++) {
			intArray[i] = arrayList.get(i);
		}

		return linkedhashSet.toString();
	}
}
