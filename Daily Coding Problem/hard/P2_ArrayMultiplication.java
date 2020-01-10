package hard;

import java.util.ArrayList;

public class P2_ArrayMultiplication {

	/**
	 * Daily Coding Problem #2
	 * 
	 * Given an array of integers, return a new array such that each element at
	 * index i of the new array is the product of all the numbers in the
	 * original array except the one at i.
	 * 
	 * For example, if our input was [1, 2, 3, 4, 5], the expected output would
	 * be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output
	 * would be [2, 3, 6].
	 * 
	 * Follow up question - Compute without using division
	 */

	public static void main(String[] args) {

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };

		// O(n)
		method1(intArray);
		
		// Follow up - O(n^2)
		method2(intArray);

	}

	
	private static void method1(int[] intArray) {

		int total = 1;
		
		for (int i : intArray) {
			total = total*i;
		}

		int[] resultArray = new int[intArray.length];
		
		for (int i = 0; i < intArray.length; i++) {
			resultArray[i] = total/intArray[i];
		}
		
		for (int i : resultArray) {
			System.out.print(i + " ");
		}
		
		System.out.print("\n");
	}


	private static void method2(int[] intArray) {

		ArrayList<Integer> initialArray = new ArrayList<>();
		ArrayList<Integer> newArray = new ArrayList<>();

		for (Integer integer : intArray)	// Runs N times (but not nested so it is constant)
			initialArray.add(integer);

		for (int i = 0; i < initialArray.size(); i++) { // Runs N Times

			int tempOriginalNum = initialArray.get(i);

			initialArray.set(i, 1);

			newArray.add(multiplyArray(initialArray));

			initialArray.set(i, tempOriginalNum);

		}

		System.out.println(newArray);

	}

	private static int multiplyArray(ArrayList<Integer> array) {

		int result = 1;

		for (int i = 0; i < array.size(); i++) { // Runs N Times

			result = result * array.get(i);
		}

		return result;

	}

}
