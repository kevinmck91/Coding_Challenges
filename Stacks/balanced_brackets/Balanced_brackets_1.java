package balanced_brackets;

import java.util.Stack;

public class Balanced_brackets_1 {

	public static void main(String[] args) {

		String s = "}{";
		System.out.println(isBalanced(s));

	}

	static String isBalanced(String s) {

		// Default Cases
		
		if (s.length() == 0) 
			return "YES";
		if (s.length() % 2 != 0) 
			return "NO";
		

		Stack stack1 = new Stack<>();

		stack1.push(s.charAt(0));

		for (int i = 1; i < s.length(); i++) {
			
			if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') 
			{
				if (s.charAt(i) == '{') {
					stack1.push('{');
				} else if (s.charAt(i) == '(') {
					stack1.push('(');
				} else if (s.charAt(i) == '[') {
					stack1.push('[');
				} 
			}

			if (s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']') 
			{
				if (stack1.isEmpty()) {
					return "NO";
				} else if (s.charAt(i) == '}' && (char) stack1.peek() == '{') {
					stack1.pop();
				} else if (s.charAt(i) == ')' && (char) stack1.peek() == '(') {
					stack1.pop();
				} else if (s.charAt(i) == ']' && (char) stack1.peek() == '[') {
					stack1.pop();
				} else {
					return "NO";
				}
			}
		}

		if (stack1.isEmpty())
			return "YES";

		return "NO";

	}

}
