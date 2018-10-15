package equal_stacks;

import java.util.Stack;

public class EqualStacks_Solution {

	public static void main(String[] args) {

		int[] stack1 = { 3, 2, 1, 1, 1 };
		int[] stack2 = { 4, 3, 2 };
		int[] stack3 = { 1, 1, 4, 1 };

		int number = equalStacks(stack1, stack2, stack3);
		System.out.println(number);

	}

	static int equalStacks(int[] h1, int[] h2, int[] h3) {

		// Convert arrays into stacks (keep track of height)
		// ie. stack1 {1,1,1,2,3} has a height of 8
		
		Stack<Integer> stack1 = new Stack();
		Stack<Integer> stack2 = new Stack();
		Stack<Integer> stack3 = new Stack();
		
		int sum1 = 0, sum2 = 0, sum3 = 0;
		
		for (int i = h1.length - 1; i >= 0; i--) {
			stack1.push(h1[i]);
			sum1 += h1[i];
		}
		
		for (int i = h2.length - 1; i >= 0; i--) {
			stack2.push(h2[i]);
			sum2 += h2[i];
		}
		
		for (int i = h3.length - 1; i >= 0; i--) {
			stack3.push(h3[i]);
			sum3 += h3[i];
		}
		
		
		
		while (!(sum1 == sum2 && sum2 == sum3 && sum3 == sum1)) {
			
			if (sum1 == 0 || sum2 == 0 || sum3 == 0) {
				sum1 = 0;
				break;
			} else if (sum1 >= sum2 && sum1 >= sum3) {
				sum1 -= stack1.peek();
				stack1.pop();
			} else if (sum2 >= sum1 && sum2 >= sum3) {
				sum2 -= stack2.peek();
				stack2.pop();
			} else if (sum3 >= sum1 && sum3 >= sum2) {
				sum3 -= stack3.peek();
				stack3.pop();
			}
		}
		return sum1;
	}

}
