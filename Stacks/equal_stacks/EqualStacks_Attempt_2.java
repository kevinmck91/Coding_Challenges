package equal_stacks;

import java.util.ArrayList;
import java.util.Collections;

public class EqualStacks_Attempt_2 {

	
	public static void main(String[] args) {

		int[] stack1 = { 1 };
		int[] stack2 = { 1 };
		int[] stack3 = { 1 };
		
		int num = equalStacks(stack1, stack2, stack3);
		System.out.println(num);

	}

	private static int equalStacks(int[] stack1, int[] stack2, int[] stack3) {

		ArrayList<Integer> arrayList1 = new ArrayList<>();
		ArrayList<Integer> arrayList2 = new ArrayList<>();
		ArrayList<Integer> arrayList3 = new ArrayList<>();
		
		//convert Arrays to Array Lists
		for(int index : stack1)
			arrayList1.add(index);
		for(int index : stack2)
			arrayList2.add(index);
		for(int index : stack3)
			arrayList3.add(index);
		
		// Reverse arrayList - Uncomment for HackerRank submission.
				
				Collections.reverse(arrayList1); 
				Collections.reverse(arrayList2);
				Collections.reverse(arrayList3);
		
				System.out.println(arrayList1);
				System.out.println(arrayList2);
				System.out.println(arrayList3);
				 
		// Write method to add up all element of each
		
		ArrayList<Integer> myArrayList1 = new ArrayList<Integer>();
		ArrayList<Integer> myArrayList2 = new ArrayList<Integer>();
		ArrayList<Integer> myArrayList3 = new ArrayList<Integer>();
		
		myArrayList1.add(arrayList1.get(0));
		for(int i = 1; i < arrayList1.size(); i++) {
			myArrayList1.add((arrayList1.get(i) + myArrayList1.get(i-1)));
		}
		System.out.println(myArrayList1);
		
		myArrayList2.add(arrayList2.get(0));
		for(int i = 1; i < arrayList2.size(); i++) {
			myArrayList2.add((arrayList2.get(i) + myArrayList2.get(i-1)));
		}
		System.out.println(myArrayList2);
		
		myArrayList3.add(arrayList3.get(0));
		for(int i = 1; i < arrayList3.size(); i++) {
			myArrayList3.add((arrayList3.get(i) + myArrayList3.get(i-1)));
		}
		System.out.println(myArrayList3);
		
		ArrayList<Integer> longestArrayList = new ArrayList<>();
		
		int longestArray = longestOf(myArrayList1, myArrayList2, myArrayList3);
		if(longestArray == 1)
			longestArrayList = myArrayList1;
		if(longestArray == 2)
			longestArrayList = myArrayList2;
		if(longestArray == 3)
			longestArrayList = myArrayList3;
		
		// Count Back from end to check match and add to total
		
		int stackHeight = 0;
		
		for(int i = longestArrayList.size() -1; i >= 0; i -- ) {
			
			int current = longestArrayList.get(i);
			
			if(myArrayList1.contains(current) && myArrayList2.contains(current) && myArrayList3.contains(current)){
				stackHeight = current;
				break;
			}
		}
		
		return stackHeight;
		
	}

	private static int longestOf(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2,
			ArrayList<Integer> arrayList3) {
		
		int a = arrayList1.size();
		int b = arrayList2.size();
		int c = arrayList3.size();
		
		System.out.println("arrayList1.size() : " + a);
		System.out.println("arrayList2.size() : " + b);
		System.out.println("arrayList3.size() : " + c);
		
		if(a > b && a > c)
			return 1;
		if(b > a && b > c)
			return 2;
		if(c > b && c > a)
			return 3;
		if(a == b && a > c)
			return 1;
		if(a == c && b > c)
			return 2;
		if(b == c && b > a)
			return 3;
		
		System.out.println("All Equal");
		return 0;
		
	}

}