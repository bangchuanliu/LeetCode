package leetcode.stackqueue;

import java.util.LinkedList;

public class EvaluateReversePolishNotation {
	private LinkedList<String> stack = new LinkedList<String>();

	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}
		for (String s : tokens) {
			if (s.equals("+") || s.equals("-") || s.equals("*")
					|| s.equals("/")) {
				int b = Integer.parseInt(stack.pop());
				int a = Integer.parseInt(stack.pop());
				int c = 0;
				if (s.equals("+")) {
					c = a + b;
				} else if (s.equals("-")) {
					c = a - b;
				} else if (s.equals("*")) {
					c = a * b;
				} else {
					c = a / b;
				}
				stack.push(String.valueOf(c));
			} else {
				stack.push(s);
			}
		}
		return Integer.parseInt(stack.pop());
	}
}
