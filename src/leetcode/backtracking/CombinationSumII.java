package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
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

		int lastNumber = Integer.MAX_VALUE;

		if (target > 0) {
			for (int i = start; i < candidates.length; i++) {
				if (lastNumber != candidates[i]) {
					lastNumber = candidates[i];
					temp.add(candidates[i]);
					combinationSum(candidates, i + 1, target - candidates[i], temp, result);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		CombinationSumII instance = new CombinationSumII();
		int[] candidates = { 1, 1, 7 };
		List<List<Integer>> result = instance.combinationSum(candidates, 1);
		System.out.println(Arrays.deepToString(result.toArray()));
	}
}
