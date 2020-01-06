package exam_20191220;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Question_2 {

	/**
	 * Given a number N in the range [-8000, 8000]
	 * 
	 * Find the maximum number when the digit 5 is inserted in N
	 * 
	 * EG: given 670 should return 6750
	 * 
	 * TODO: Create test Cases and jUnit
	 * 
	 * 	 */
	public static void main(String[] args) {
		
		System.out.println(solution(-999));

	}

	public static int solution(int N) {
		
		Boolean isNegitive = false;
		
		if(N < 0) {
			N = N*-1;
			isNegitive = true;
		}

		// Add number to linked list

		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		int length = String.valueOf(N).length();
		String NString = String.valueOf(N);

		for (int i = 0; i < length; i++) {

			int num = Integer.parseInt(String.valueOf(NString.charAt(i)));

			linkedList.add(num);

		}

		// Add 5 to each position of linked list
		// Convert to Linklist to String then to int,
		// Add all possible ints to ArrayList. Return Largest

		List<Integer> arrayList = new ArrayList<Integer>();

		for (int i = 0; i < length + 1; i++) {

			// Add 5 to each position of LL
			linkedList.add(i, 5);

			String str = "";

			for (Integer integer : linkedList) {
				str += integer;
			}

			arrayList.add(Integer.parseInt(str));

			linkedList.remove(i);

		}

		Collections.sort(arrayList);
		// System.out.println(arrayList.get(arrayList.size() - 1));

		if (isNegitive == true) {
			return (arrayList.get(0)*-1);
		} else {
			return (arrayList.get(arrayList.size() - 1));
		}

	}

}
