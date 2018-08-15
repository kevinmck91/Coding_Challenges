package array_roatation;

import java.util.ArrayList;

public class ArrayRotation {

	public static void main(String[] args) {

		ArrayList<Integer> array = new ArrayList<Integer>();

		int rotations = 6102;

		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(5);

		for (int i = 0; i < rotations; i++) {
			rotateLeftByOne(array);
		}

		System.out.println(array);

	}

	private static void rotateLeftByOne(ArrayList array) {

		// Separate the left-most number
		int temp = (int) array.get(0);

		// Without moving out of bounds, move all numbers to the left by one
		for (int i = 0; i < array.size(); i++) {

			if ((i) != array.size() - 1) {
				array.set(i, (array.get(i + 1)));
			} else {
				break;
			}
		}

		//Sub the temp back into the end of the array.
		array.set(array.size() - 1, temp);

	}

}
