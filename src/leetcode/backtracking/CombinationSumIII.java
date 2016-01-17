package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author bliu13 Jan 14, 2016
 */
public class CombinationSumIII {
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		
		if (k <= 0 || n <= 0) {
			return result;
		}
		
		List<Integer> temp = new ArrayList<>();
		
		combinationSum(result, temp, k,n, 1, 0);
		
		return result;
	}
	
	public void combinationSum(List<List<Integer>> result, List<Integer> temp, int k, int n, int cur, int sum) {
		if (sum > n || temp.size() > k) {
			return;
		}
		
		if (sum == n && temp.size() == k) {
			result.add(new ArrayList<>(temp));
		}
		
		for (int i = cur; i <= 9; i++) {
				temp.add(i);
				combinationSum(result, temp, k, n, i+1, sum + i);
				temp.remove(temp.size() - 1);	
			}
		}
}
