package equal_stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * You have three stacks of cylinders where each cylinder has the same
 * diameter, but they may vary in height. You can change the height of a
 * stack by removing and discarding its topmost cylinder any number of
 * times.
 * 
 * Find the maximum possible height of the stacks such that all of the
 * stacks are exactly the same height. This means you must remove zero
 * or more cylinders from the top of zero or more of the three stacks
 * until they're all the same height, then print the height. The
 * removals must be performed in such a way as to maximize the height.
 * 
 * Note: An empty stack is still a stack.
 */

public class EqualStacks {

	public static void main(String[] args) {

		int[] stack1 = { 65, 345, 7, 4, 35, 89, 435, 89, 5, 4, 98 };
		int[] stack2 = { 100, 100, 100, 100, 56, 987, 67, 89, 99, 75, 67 };
		int[] stack3 = { 400, 50, 1, 1, 1, 1, 1, 1, 68, 97, 56 };

		int maxHeight = equalStacks(stack1, stack2, stack3);

		System.out.println("maxHeight : " + maxHeight);
	}

	static int equalStacks(int[] h1, int[] h2, int[] h3) {

		// Add all arrays to ArrayLists
		ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
		for (int element : h1)
			arrayList1.add(element);
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
		for (int element : h2)
			arrayList2.add(element);
		ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
		for (int element : h3)
			arrayList3.add(element);

		// Reverse arrayList - Uncomment for HackerRank submission.
		/*
		 * Collections.reverse(arrayList1); 
		 * Collections.reverse(arrayList2);
		 * Collections.reverse(arrayList3);
		 */

		// While the arrayList heights are unequal.
		// Find the largest stack and remove end element

		int elementsRemoved = 0;

		while (checkEquality(arrayList1, arrayList2, arrayList3) != true) {

			int largestStack = findLargestStack(arrayList1, arrayList2,
					arrayList3);

			elementsRemoved++;

			if (largestStack == 1)
				removeLastElement(arrayList1);
			if (largestStack == 2)
				removeLastElement(arrayList2);
			if (largestStack == 3)
				removeLastElement(arrayList3);
			if (largestStack == 0) {
				return 0;

			}

		}

		System.out.println("Elements removed : " + elementsRemoved);

		System.out.println((arrayList1) + " - Height : "
				+ calculateHeight(arrayList1));
		System.out.println((arrayList2) + " - Height : "
				+ calculateHeight(arrayList2));
		System.out.println((arrayList3) + " - Height : "
				+ calculateHeight(arrayList3));

		return calculateHeight(arrayList1);

	}

	private static void removeLastElement(ArrayList<Integer> arrayList) {

		int lastIndex = arrayList.size() - 1;
		arrayList.remove(lastIndex);

	}

	private static int findLargestStack(ArrayList<Integer> arrayList1,
			ArrayList<Integer> arrayList2, ArrayList<Integer> arrayList3) {

		int h1 = calculateHeight(arrayList1);
		int h2 = calculateHeight(arrayList2);
		int h3 = calculateHeight(arrayList3);

		if (h1 > h2 && h1 > h3)
			return 1;

		if (h2 > h1 && h2 > h3)
			return 2;

		if (h3 > h2 && h3 > h1)
			return 3;

		System.out.println("no largest number");
		return 0;

	}

	private static boolean checkEquality(ArrayList<Integer> arrayList1,
			ArrayList<Integer> arrayList2, ArrayList<Integer> arrayList3) {

		if (calculateHeight(arrayList1) == calculateHeight(arrayList2)
				&& calculateHeight(arrayList1) == calculateHeight(arrayList3)
				&& calculateHeight(arrayList2) == calculateHeight(arrayList3)) {
			System.out.println("Stacks are equal");
			return true;
		}

		return false;
	}

	static int calculateHeight(ArrayList<Integer> stack) {

		int totalHeight = 0;

		for (int height : stack)
			totalHeight += height;

		return totalHeight;

	}

}
