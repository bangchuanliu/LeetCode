package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * …≤ ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 2,3,6,7 and target 7, A solution set is: [7]
 * [2,2, 3]
 * 
 * 
 * @author BangChuan Liu
 * @date 2015
 * @Contact liubangchuan1100@gmail.com
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0 || target <= 0) {
			return result;
		}
		List<Integer> temp = new ArrayList<Integer>();
		Arrays.sort(candidates);
		combinationSum(candidates, 0, target, temp, result);
		return result;
	}

	public void combinationSum(int[] candidates, int start, int target, List<Integer> temp,
			List<List<Integer>> result) {
		if (0 == target) {
			result.add(new ArrayList<>(temp));
		}

		if (target > 0) {
			for (int i = start; i < candidates.length; i++) {
				temp.add(candidates[i]);
				combinationSum(candidates, i, target - candidates[i], temp, result);
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		CombinationSum instance = new CombinationSum();
		int[] candidates = { 2, 3, 6, 7 };
		List<List<Integer>> result = instance.combinationSum(candidates, 7);
		System.out.println(Arrays.deepToString(result.toArray()));
	}
}
