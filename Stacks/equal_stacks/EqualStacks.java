package equal_stacks;

import java.util.Stack;

public class EqualStacks {

	public static void main(String[] args) {
		
		int[] stack1 = {1,1,1,2,3};
		int[] stack2 = {2,3,4};
		int[] stack3 = {1,4,1,1};
		
		equalStacks(stack1, stack2, stack3);

	}
	
	static int equalStacks(int[] h1, int[] h2, int[] h3) {
		
		// Add all arrays to Stacks
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Integer> stack3 = new Stack<Integer>();
		
		for(int i = 0; i < h1.length; i++){
			stack1.push(h1[i]);
		}
		for(int i = 0; i < h2.length; i++){
			stack2.push(h2[i]);
		}
		for(int i = 0; i < h3.length; i++){
			stack3.push(h3[i]);
		}
		
		System.out.println(stack1);
		System.out.println(stack2);
		System.out.println(stack3);
		
		System.out.println("");
		
		System.out.println(stack1.size());
		System.out.println(stack2.size());
		System.out.println(stack3.size());
		
		System.out.println("");
		
		System.out.println(calculateHeight(stack1));
		System.out.println(calculateHeight(stack2));
		System.out.println(calculateHeight(stack3));
		
		System.out.println(stack1);
		System.out.println(stack2);
		System.out.println(stack3);
		
		
		return 0;
        
    }

	static int calculateHeight(Stack stack) {
		
		int totalHeight = 0;
		int loopCounter = stack.size();
		
		for(int i = 0; i < loopCounter; i++){
			int myInt = (int) stack.peek();
			stack.pop();
			totalHeight += myInt;
		}
		
		return totalHeight;
		
		
		
	}

}
