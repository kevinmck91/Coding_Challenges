package simple_array_questions;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;


public class FindDuplicateNumber {

	/**
	 *  Find the duplicate number on a given integer array
	 */
	
	public static void main(String[] args) {

		int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 5, 14, 15,
				16, 17, 18, 25, 19, 20, 21, 22, 23, 6, 24, 25 };

		findDuplicate(sortedArray);
		
	}

	private static void findDuplicate(int[] sortedArray) {

		// Use a hashmap to find duplicate count
		
		Map<Integer, Integer> hashmap = new HashMap<>();
		Set<Integer> hashset = new HashSet<>();
		
		for (int i = 0; i < sortedArray.length; i++) {
			
			if(hashmap.containsKey(sortedArray[i])){
				int value = hashmap.get(sortedArray[i]);
				value ++; 
				hashmap.put(sortedArray[i], value);
			} else {
				hashmap.put(sortedArray[i], 1);
			}
			
		}
		
		// Use a hashset to print out duplicates
		
		for (int i : sortedArray) {
			if(hashmap.get(i) > 1){
				hashset.add(i);
			}
		}
		
		System.out.println(hashset.toString());
		
	}

}
