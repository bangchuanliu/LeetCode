package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author bangliu
 * 
 */
public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> parentheses = new ArrayList<>();
		if (n <= 0) {
			return parentheses;
		}

		dfs(parentheses, n, n, "");
		return parentheses;
	}

	public void dfs(List<String> parentheses, int left, int right, String s) {
		if (left > right) {
			return;
		}

		if (left == 0 && right == 0) {
			parentheses.add(s);
		}

		if (left > 0) {
			dfs(parentheses, left - 1, right, s + "(");
		}

		if (right > 0) {
			dfs(parentheses, left, right - 1, s + ")");
		}
	}

	public static void main(String[] args) {
		
	}
}
