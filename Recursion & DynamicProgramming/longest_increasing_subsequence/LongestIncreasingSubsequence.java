package longest_increasing_subsequence;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {

	/**
	 * Given an ArrayList, Determine the longest increasing subsequence
	 * Recursion is not needed. Will use Bottom Up Tabulation (Dynamic Programming)
	 * 
	 */

	public static void main(String[] args) {

		ArrayList<Integer> array = new ArrayList<>();
		array.add(10);
		array.add(22);
		array.add(9);
		array.add(33);
		array.add(21);
		array.add(50);
		array.add(41);

		System.out.println(tabulation(array, array.size()));

		// System.out.println(memoization(array, n));

	}

	private static int tabulation(ArrayList<Integer> array, int n) {

		ArrayList<Integer> lis = new ArrayList<>();
		int i, j, max = 0;

		// Create a new array for the MAX values as they are calculated. Fill with 1 to
		// default.
		for (int k = 0; k < n; k++) {
			lis.add(1);
		}

		for (i = 1; i < n; i++) {
			System.out.println("\n array " + array);
			System.out.println("iteration " + lis);
			for (j = 0; j < i; j++) {

				System.out.println("compare if  array.get(i) > array.get(j) -  Ie. is " + array.get(i) + " > "
						+ array.get(j) + " - " + (array.get(i) > array.get(j)));
				System.out.println("compare if  lis.get(i) < lis.get(j) + 1 -  Ie. is " + lis.get(i) + " < "
						+ lis.get(j) + " + 1" + " - " + (lis.get(i) < lis.get(j) + 1));

				if (array.get(i) > array.get(j) && lis.get(i) < lis.get(j) + 1) {
					System.out.println("set index i (" + i + ") to lis.get(j) + 1 : " + lis.get(j) + 1);
					lis.set(i, lis.get(j) + 1);
					System.out.println("subIteration " + lis);
				}

			}

		}
		System.out.println(lis);
		return 0;

	}

}
