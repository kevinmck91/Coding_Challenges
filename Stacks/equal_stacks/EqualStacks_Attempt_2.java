package equal_stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class EqualStacks_Attempt_2 {

	
	public static void main(String[] args) {

		int[] stack1 = { 3,2,1,1,1 };
		int[] stack2 = { 4,3,2 };
		int[] stack3 = { 1,1,4,1 };
		
		int num = equalStacks(stack1, stack2, stack3);
		System.out.println(num);

	}

	private static int equalStacks(int[] stack1, int[] stack2, int[] stack3) {
		
		//Reverse 3 stacks
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
		
		stack1 = arrayList1.toArray(arrayList1);
		
		// Convert 3 arrays into 3 additive HashMaps
		
		Map<Integer, Integer> hashMap1 = new HashMap<>();
		Map<Integer, Integer> hashMap2 = new HashMap<>();
		Map<Integer, Integer> hashMap3 = new HashMap<>();
		
		hashMap1.put(0, stack1[0]);
		for(int i = 1; i < stack1.length; i++) {
			int current = stack1[i] + hashMap1.get(i-1);
			hashMap1.put(i, current);
		}
		
		hashMap2.put(0, stack2[0]);
		for(int i = 1; i < stack2.length; i++) {
			int current = stack2[i] + hashMap2.get(i-1);
			hashMap2.put(i, current);
		}
		
		hashMap3.put(0, stack3[0]);
		for(int i = 1; i < stack3.length; i++) {
			int current = stack3[i] + hashMap3.get(i-1);
			hashMap3.put(i, current);
		}
		
		
		System.out.println(hashMap1);
		System.out.println(hashMap2);
		System.out.println(hashMap3);
		System.out.println();
		
		// Find the longestHashMap
		
		Map<Integer, Integer> longestHashMap = new HashMap<>();
		
		int longestHashMapNo = longestOf(hashMap1, hashMap2, hashMap3);
		
		if(longestHashMapNo == 1)
			longestHashMap = hashMap1;
		if(longestHashMapNo == 2)
			longestHashMap = hashMap2;
		if(longestHashMapNo == 3)
			longestHashMap = hashMap3;
		
		// Count Back from end to check match and add to total
		
		int stackHeight = 0;
		
		for(int i = longestArrayList.size() -1; i >= 0; i -- ) {
			
			int current = longestArrayList.get(i);
			
			if(myArrayList1.contains(current) && myArrayList2.contains(current) && myArrayList3.contains(current)){
				stackHeight = current;
				break;
			}
		}
		
		return stackHeight;*/
		
	}

	private static int longestOf(Map<Integer, Integer> hashMap1, Map<Integer, Integer> hashMap2,
			Map<Integer, Integer> hashMap3) {
		
		int a = hashMap1.size();
		int b = hashMap2.size();
		int c = hashMap3.size();
		
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
