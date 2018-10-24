package simple_array_questions;

public class FindMissingNumber {

	/**
	 * How do you find the missing number in a given integer array of 1 to 100?
	 */

	public static void main(String[] args) {

		int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15,
				16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
		
		findMissingNumFromSorted(sortedArray);

	}

	private static void findMissingNumFromSorted(int[] sortedArray) {
		int missingNum = 0;

		for (int i = 1; i <= sortedArray.length - 1; i++) {

			if (i != sortedArray[i] - 1) {
				missingNum = (i + 1);
				break;
			}

		}

		if (missingNum == 0) {
			System.out.println("No Number Missing");
		} else {
			System.out.println("Number " + missingNum + " Is Missing");
		}

	}

}
