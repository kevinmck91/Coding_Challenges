package simple_array_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindLargestAndSmallest {

	/**
	 * How do you find the largest and smallest number in an unsorted integer array?
	 */
	public static void main(String[] args) {
		
		int[] array = { 816, 58, 33, 66, 85, 36, 7, 5, 9, 1, 11, 12, 14, 15, 176, 157, 518, 25, 159, 70, 251, 322, 2735, 67, 44, 255 };

		printLargestAndSmallest(array);
		
	}

	private static void printLargestAndSmallest(int[] array) {
		
		ArrayList<Integer> arraylist = new ArrayList<>();
		
		for (int integer : array) {
			arraylist.add(integer);
		}
		
		Collections.sort(arraylist);		// uses Quicksort. order(n.logn)
		
		System.out.println("Lowest : " + arraylist.get(0) + ". Highest : " + arraylist.get(arraylist.size()-1));
		
	}

}
