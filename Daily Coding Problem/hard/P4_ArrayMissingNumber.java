package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class P4_ArrayMissingNumber {

	public static void main(String[] args) {
		
		
		/*
		 * Given an array of integers, find the first missing positive integer
		 * in linear time and constant space. In other words, find the lowest
		 * positive integer that does not exist in the array. The array can
		 * contain duplicates and negative numbers as well.
		 * 
		 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2,
		 * 0] should give 3.
		 * 
		 * TODO: Look at solution here : https://dev.to/awwsmm/java-daily-coding-problem-004-2ogb
		 * 
		 */
		
		int[] array = new int[]{3, 4, -1, 1};
		
		printMissingNum(array);

	}

	private static void printMissingNum(int[] array) {

		ArrayList<Integer> arrayList = new ArrayList<>();
		
		Collections.sort(arrayList);		// Fail linear time as order is n.Log(n)
		
		for(int i = 0; i < arrayList.size(); i++){
			
			if(arrayList.get(i) < 0)
				continue;
			
			
			
		}
		
	}

}
