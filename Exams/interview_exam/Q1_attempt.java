package interview_exam;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Q1_attempt {

	public static void main(String[] args) {

		String[] myStrArray = null;
		String[] myStrArray2 = { "c", "a", "b" };

		System.out.println(sameContents1(myStrArray, myStrArray2));
	}

	// Best Solution

	static boolean sameContents1(String[] a, String[] b) {

		if (a.length == b.length ) {

			ArrayList<String> arrayList1 = new ArrayList<>();
			ArrayList<String> arrayList2 = new ArrayList<>();

			for (String str : a)
				arrayList1.add(str);
			for (String str : b)
				arrayList2.add(str);

			if (arrayList1.containsAll(arrayList2))
				return true;
		}

		return false;
	}
	
	// Alternate Solution
	
	static boolean sameContents2(String[] a, String[] b) {

		Map<String, Integer> treeMap1 = new TreeMap<>();
		Map<String, Integer> treeMap2 = new TreeMap<>();

		for (int i = 0; i < a.length; i++) {
			treeMap1.put(a[i], 0);
		}

		for (int i = 0; i < a.length; i++) {
			treeMap2.put(b[i], 0);
		}

		System.out.println(treeMap1);
		System.out.println(treeMap2);

		if (treeMap1.equals(treeMap2))
			return true;

		return false;
	}
}