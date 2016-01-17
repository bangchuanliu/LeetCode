package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subsets {

	public List<List<Integer>> generateSubsets(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return result;
		}

		Map<Integer, Boolean> numMap = new HashMap<>();
		List<Integer> temp = new ArrayList<>();
		Arrays.sort(nums);
//		generateSubsets(result, 0, nums, numMap);
		
		generateSubsets2(result, 0, nums, temp);

		return result;
	}

	public void generateSubsets(List<List<Integer>> result, int index, int[] nums, Map<Integer, Boolean> numMap) {

		if (index == nums.length) {
			List<Integer> list = new ArrayList<>();
			for (int num : nums) {
				if (numMap.get(num)) {
					list.add(num);
				}
			}
			result.add(list);
			return;
		}

		numMap.put(nums[index], true);
		generateSubsets(result, index + 1, nums, numMap);

		numMap.put(nums[index], false);
		generateSubsets(result, index + 1, nums, numMap);
	}

	
	public void generateSubsets2(List<List<Integer>> result, int index, int[] nums, List<Integer> temp) {

		if (index == nums.length) {
			result.add(new ArrayList<>(temp));
			return;
		}
		
		generateSubsets2(result, index + 1, nums, temp);
		
		temp.add(nums[index]);
		generateSubsets2(result, index + 1, nums, temp);
		temp.remove(temp.size() - 1);
	}
	
	public static void main(String[] args) {
		int[] nums = { 4, 1, 0 };
		Subsets instance = new Subsets();
		List<List<Integer>> result = instance.generateSubsets(nums);
		System.out.println(Arrays.toString(result.toArray()));
	}
}
