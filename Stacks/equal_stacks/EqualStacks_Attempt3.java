package equal_stacks;

import java.util.Stack;

public class EqualStacks_Attempt3 {

	public static void main(String[] args) {
		
		int[] stack1 = { 1, 1, 1, 1, 2 };
		int[] stack2 = { 3, 7 };
		int[] stack3 = {1,3,1 };
	
		int number = equalStacks(stack1, stack2, stack3);
		System.out.println(number);
		
	}

	private static int equalStacks(int[] h1, int[] h2, int[] h3) {

		// Convert arrays into stack of additive heights
		// ie. stack1 becomes : {1,2,3,5,8}
		
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		Stack<Integer> stack3 = new Stack<>();
		
		stack1.push(h1[h1.length - 1]);
		for(int i = h1.length - 1; i > 0; i --){
			stack1.push(stack1.peek() + h1[i-1]);
		}
		
		stack2.push(h2[h2.length - 1]);
		for(int i = h2.length - 1; i > 0; i --){
			stack2.push(stack2.peek() + h2[i-1]);
		}
		
		stack3.push(h3[h3.length - 1]);
		for(int i = h3.length - 1; i > 0; i --){
			stack3.push(stack3.peek() + h3[i-1]);
		}
		
		// Pop the longest stack until we find the longest common height
		
		
		while(!(stack1.peek() == stack2.peek() && stack2.peek() == stack3.peek())){
		
			// ***** If all stacks are different sizes :
			 if (stack1.peek() > stack2.peek() && stack1.peek() > stack3.peek()) {
				stack1.pop(); 
			}
			else if (stack2.peek() > stack1.peek() && stack2.peek() > stack3.peek()) {
				stack2.pop(); 
			}
			else if (stack3.peek() > stack1.peek() && stack3.peek() > stack2.peek()) {
				stack3.pop(); 
			}
			// ***** If two of the stacks are joint longest :
			else if (stack1.peek() == stack2.peek() && stack1.peek() > stack3.peek()) {
				stack1.pop();
			}
			else if (stack2.peek() == stack3.peek() && stack2.peek() > stack1.peek()) {
				stack2.pop();
			}
			else if (stack1.peek() == stack3.peek() && stack3.peek() > stack2.peek()) {
				stack3.pop();
			}
		}
		
		if(stack1.peek() == stack2.peek() && stack2.peek() == stack3.peek()){
			return stack1.peek();
		}
		return 0;
	}

}
