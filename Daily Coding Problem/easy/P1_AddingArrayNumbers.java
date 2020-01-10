package easy;

import java.util.HashSet;

public class P1_AddingArrayNumbers {

	/**
	 * Daily Coding Problem #1
	 * 
	 * Given a list of numbers and a number k, return whether any two numbers
	 * from the list add up to k.
	 * 
	 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7
	 * is 17.
	 * 
	 * Bonus: Can you do this in one pass?
	 */

	public static void main(String[] args) {

		int[] array = new int[] { 1,2,3,10,16,1,5,3,7,6,4,11,22,21,23,25,26,76,24,26,24,21,21,12,15,16,17 };
		int result = 20;

		// Order O(n^2) - Nested for loops
		method1(array, result);
		
		// Order O(n) - Only one loop
		method2(array, result);

	}


	private static void method1(int[] array, int result) {

		boolean flag = false;
		int firstNumber = 0;
		int secondNumber = 0;

		for (int i = 0; i < array.length - 1; i++) {

			if (flag)
				break;

			for (int j = i + 1; j < array.length; j++) {

				if (flag)
					break;

				if (array[i] + array[j] == result) {
					firstNumber = array[i];
					secondNumber = array[j];
					flag = true;
				}
			}
		}

		if (flag)
			System.out.println(firstNumber + " and " + secondNumber + " add up to " + result);

		if (!flag)
			System.out.println("No answer");
	}
	
	
	private static void method2(int[] array, int result) {

		HashSet<Integer> hashSet = new HashSet<>();
		boolean flag = false;
		
		// For each array element, subtract it from the result
		// If this number isnt in the hashmap add the array integer entry
		// If this number is in the hash map, it can be added to the integer to make the result 
		
		for (Integer arrayInteger : array) {
			
			int temp = result - arrayInteger;
			
			if(!hashSet.contains(temp) && temp > 0){
				hashSet.add(arrayInteger);
			} else {
				System.out.println(arrayInteger + " and " + temp + " add up to " + result);
				flag = true;
				break;
			}
			
		}
		
		if(!flag)
			System.out.println("No answer");
		
	}

}
