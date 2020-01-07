package simple_array_questions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveAllDuplicates {

	public static void main(String[] args) {
		
		// Run the tests
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("Tests fail.");
		}
		
	}

	
	
	private static boolean doTestsPass() {
		
		boolean result = false;
		
		// Test Case 1
		int[] array1 = {2,3,4,5,4,3,5,6,7,8,6,5,4,5,4,3,5,6,4,5,4,5};
		int[] resultArray1 = {2,3,4,5,6,7,8};
		
		String String1 = removeDuplicates(array1);
		String String2 = Arrays.toString(resultArray1);
		
		if(String1.equals(String2))
			result = true;
		
		// Test Case 2
		
		return result;
	}

	
	
	private static String removeDuplicates(int[] array1) {

		Set<Integer> linkedhashSet = new LinkedHashSet<>();
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		for (int i = 0; i < array1.length; i++) {
			linkedhashSet.add(array1[i]);
		}
		
		for (Integer integer : linkedhashSet) {
			arrayList.add(integer);
		}
		
		int[] intArray = new int[linkedhashSet.size()];
		
		for (int i = 0; i < arrayList.size(); i++) {
			intArray[i] = arrayList.get(i);
		}
 
		return linkedhashSet.toString();
	}
}
