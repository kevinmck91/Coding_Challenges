package equal_stacks;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class EqualStacks_Attempt_2 {

	public static void main(String[] args) {


		int[] stack1 = { 65, 345, 7, 4, 35, 89, 435, 89, 5, 4, 98,3,4 };
		int[] stack2 = { 100, 100, 100, 100, 56, 987, 67, 89, 99, 75, 67 };
		int[] stack3 = { 400, 50, 1, 1, 4, 1, 1, 1, 68, 97, 56 , 3, 4,5,6 };
		
		int num = equalStacks(stack1, stack2, stack3);
		System.out.println(num);

	}

	private static int equalStacks(int[] stack1, int[] stack2, int[] stack3) {

		ArrayList<Integer> ArrayList1 = new ArrayList<>();
		ArrayList<Integer> ArrayList2 = new ArrayList<>();
		ArrayList<Integer> ArrayList3 = new ArrayList<>();
		
		//convert Arrays to Array Lists
		for(int index : stack1)
			ArrayList1.add(index);
		for(int index : stack2)
			ArrayList2.add(index);
		for(int index : stack3)
			ArrayList3.add(index);
		
		System.out.println(ArrayList1);
		System.out.println(ArrayList2);
		System.out.println(ArrayList3);
		
		// Find shortest array 
		
		int shortestArray = shortestOf(ArrayList1, ArrayList2, ArrayList3);
		System.out.println("shortestArray : " + shortestArray);
		
		// Delete remainder of elements from non-shortest
		
		ArrayList<Integer> newArrayList1 = new ArrayList<Integer>();
		ArrayList<Integer> newArrayList2 = new ArrayList<Integer>();
		ArrayList<Integer> newArrayList3 = new ArrayList<Integer>();
		
		if(shortestArray == 1) {
			int length = ArrayList1.size();
			newArrayList1 = ArrayList1;
			newArrayList2 = new ArrayList<Integer>(ArrayList2.subList(0, length));
			newArrayList3 = new ArrayList<Integer>(ArrayList3.subList(0, length));
		}
		if(shortestArray == 2) {
			int length = ArrayList2.size();
			newArrayList1 = new ArrayList<Integer>(ArrayList1.subList(0, length));
			newArrayList2 = ArrayList2;
			newArrayList3 = new ArrayList<Integer>(ArrayList3.subList(0, length));
		}
		if(shortestArray == 3) {
			int length = ArrayList3.size();
			newArrayList1 = new ArrayList<Integer>(ArrayList1.subList(0, length));
			newArrayList2 = new ArrayList<Integer>(ArrayList2.subList(0, length));
			newArrayList3 = ArrayList3;
		}
		
		System.out.println(newArrayList1);
		System.out.println(newArrayList2);
		System.out.println(newArrayList3);
		
		int totalRemoved = 0;
		
		totalRemoved += (ArrayList1.size() - newArrayList1.size());
		totalRemoved += (ArrayList2.size() - newArrayList2.size());
		totalRemoved += (ArrayList3.size() - newArrayList3.size());
		
		System.out.println(totalRemoved);
		
		// Write method to add up all element of each
		
		ArrayList<Integer> myArrayList1 = new ArrayList<Integer>();
		ArrayList<Integer> myArrayList2 = new ArrayList<Integer>();
		ArrayList<Integer> myArrayList3 = new ArrayList<Integer>();
		
		myArrayList1.add(newArrayList1.get(0));
		for(int i = 1; i < newArrayList1.size(); i++) {
			myArrayList1.add((newArrayList1.get(i) + myArrayList1.get(i-1)));
		}
		System.out.println(myArrayList1);
		
		myArrayList2.add(newArrayList2.get(0));
		for(int i = 1; i < newArrayList2.size(); i++) {
			myArrayList2.add((newArrayList2.get(i) + myArrayList2.get(i-1)));
		}
		System.out.println(myArrayList2);
		
		myArrayList3.add(newArrayList3.get(0));
		for(int i = 1; i < newArrayList3.size(); i++) {
			myArrayList3.add((newArrayList3.get(i) + myArrayList3.get(i-1)));
		}
		System.out.println(myArrayList3);
		
		// Count Back from end to check match and add to total
		
		for(int i = myArrayList3.size() -1; i >= 0; i -- ) {
			System.out.println("Checking1 : " + myArrayList1.get(i) + " Checking2 : " + myArrayList2.get(i) + " Checking3 : " + myArrayList3.get(i));
			if(myArrayList1.get(i).equals(myArrayList2.get(i)) && myArrayList2.get(i).equals(myArrayList3.get(i))  ) {
				return totalRemoved;
			} else {
				totalRemoved += 3;
			}
		}
		
		return 0;
	}

	private static int shortestOf(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2,
			ArrayList<Integer> arrayList3) {
		
		int a = arrayList1.size();
		int b = arrayList2.size();
		int c = arrayList3.size();
		
		System.out.println("arrayList1.size() : " + a);
		System.out.println("arrayList2.size() : " + b);
		System.out.println("arrayList3.size() : " + c);
		
		if(a < b && a < c)
			return 1;
		if(b < a && b < c)
			return 2;
		if(c < b && c < a)
			return 3;
		
		return 0;
		
	}

}
