package problem_2;

import java.util.ArrayList;

public class ArrayMultiplication {

	/*
	 * Daily Coding Problem #2
	 * 
	 * Given an array of integers, return a new array such that each element at
	 * index i of the new array is the product of all the numbers in the original
	 * array except the one at i.
	 * 
	 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be
	 * [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would
	 * be [2, 3, 6].
	 * 
	 * TODO: Improve Efficiency
	 * 
	 */

	public static void main(String[] args) {

		int[] intArray = new int[] { 1, 2, 3 };

		ArrayList<Integer> initialArray = new ArrayList<>();
		ArrayList<Integer> newArray = new ArrayList<>();

		for (Integer integer : intArray)
			initialArray.add(integer);

		for (int i = 0; i < initialArray.size(); i++) {

			int tempOriginalNum = initialArray.get(i);

			initialArray.set(i, 1);

			newArray.add(multiplyArray(initialArray));

			initialArray.set(i, tempOriginalNum);

		}

		System.out.println(newArray);

	}

	private static int multiplyArray(ArrayList<Integer> array) {

		int result = 1;

		for (int i = 0; i < array.size(); i++) {

			result = result * array.get(i);
		}

		return result;

	}

}
