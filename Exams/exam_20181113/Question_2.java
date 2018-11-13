package exam_20181113;

import java.util.ArrayList;

public class Question_2 {

	/**
	 * Output a delta encoding for an array. In a delta encoding, the first element is as-is, the next element is the difference of the two previous.
	 * 
	 * If a value doesn't fit in a signed byte, (-127 < x < 127) output the escape character (-128) before the value  
	 * 
	 */
	
	public static void main(String[] args) {

		int[] array = { 25626, 25757, 24367, 24267, 16, 100, 2, 7277 };

		array = delta_encode(array);
		
		for (int i : array) {
			System.out.print(i + " ");
		}
		
	}

	static int[] delta_encode(int[] array) {

		// Create Delta encoded list
		ArrayList<Integer> myList = new ArrayList<>();

		myList.add(array[0]);

		for (int i = 1; i < array.length; i++) {
			myList.add(array[i] - array[i - 1]);
		}
		
		System.out.println(myList);
		
		// Create new List and add -128 if value is outside range -127 < x < 127
		ArrayList<Integer> myList2 = new ArrayList<>();

		myList2.add(array[0]);
		
		for (int i = 1; i < myList.size(); i ++) {
			
			if(myList.get(i) > 127 || myList.get(i) < -127){
				myList2.add(-128);
				myList2.add(myList.get(i));
			} else {
				myList2.add(myList.get(i));
			}
		}
		
		// Convert ArrayList to array
		
		int[] ret = new int[myList2.size()];
	    for (int i=0; i < ret.length; i++)
	    {
	        ret[i] = myList2.get(i).intValue();
	    }
	    return ret;


	}
}
