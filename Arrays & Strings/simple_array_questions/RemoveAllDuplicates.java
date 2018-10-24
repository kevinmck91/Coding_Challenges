package simple_array_questions;


import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveAllDuplicates {

	public static void main(String[] args) {

		int[] array = {2,3,4,5,4,3,5,6,7,8,6,5,4,5,4,3,5,6,4,5,4,5};
		
		Set<Integer> linkedhashmap = new LinkedHashSet<>();

		for (int i : array) {
			linkedhashmap.add(array[i]);
		}
		
		System.out.println(linkedhashmap.toString());
	}
}
