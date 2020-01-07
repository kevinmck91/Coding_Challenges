package array_roatation;

import java.util.ArrayList;

/**
 * @author kmk 
 * 		
 *		A left rotation operation on an array shifts each of the array's
 *      elements 1 unit to the left. For example, if 2 left rotations are
 *      performed on array [1,2,3,4,5,], then the array would become
 *      [3,4,5,1,2]. 
 *         
 *      Given an array a of n integers and a number, d perform d
 *      left rotations on the array. Return the updated array to be printed
 *      as a single line of space-separated integers.
 */

public class ArrayRotation {

	public static void main(String[] args) {

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		arrayList.add(6);
		arrayList.add(7);
		arrayList.add(8);
		arrayList.add(9);

		int rotations = 4;

		// Method one - (Inefficient)
		// rotateLeftByMany(arrayList, rotations);

		// Method two
		modularRotate(arrayList, rotations);

	}
	
	private static void modularRotate(ArrayList array, int rotations) {

		// Create a new array
		int[] newArray = new int[array.size()];

		// Populate new array with rotations
		for (int i = 0; i < array.size(); i++) {
			int indexToMoveTo = (i + (array.size() - rotations)) % array.size();
			newArray[indexToMoveTo] = (int) array.get(i);
		}

		// Convert new array back into ArrayList
		ArrayList<Integer> arrayListRotated = new ArrayList<Integer>();

		for (int x : newArray)
			arrayListRotated.add(x);

		System.out.println(arrayListRotated);

	}

	private static void rotateLeftByMany(ArrayList<Integer> arrayList,
			int rotations) {

		for (int i = 0; i < rotations; i++) {

			// Separate the left-most number
			int temp = (int) arrayList.get(0);

			// Without moving out of bounds, move all numbers to the left by one
			for (int j = 0; j < arrayList.size(); j++) {

				if ((j) != arrayList.size() - 1) {
					arrayList.set(j, (arrayList.get(j + 1)));
				} else {
					break;
				}
			}

			// Sub the temp back into the end of the array.
			arrayList.set(arrayList.size() - 1, temp);
		}

		System.out.println(arrayList);

	}
}
