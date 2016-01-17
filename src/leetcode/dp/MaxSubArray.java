package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 * 
 * @author admin
 *
 */
public class MaxSubArray {

	public int maxSubArray(List<Integer> nums) {
		if (nums == null || nums.size() == 0) {
			return 0;
		}
		int size = nums.size();
		int mStart = nums.get(size - 1);
		int mAll = nums.get(size - 1);
		for (int i = size - 2; i >= 0; i--) {
			mStart = Math.max(nums.get(i), nums.get(i) + mStart);
			mAll = Math.max(mStart, mAll);
		}
		return mAll;
	}

	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int sum = nums[0];
		int max = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(nums[i], sum + nums[i]);
			max = Math.max(sum, max);
		}

		return max;
	}

	public static void main(String[] args) {
		MaxSubArray instance = new MaxSubArray();
		Integer[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		List<Integer> nums = new ArrayList<Integer>(Arrays.asList(arr));
		System.out.println(instance.maxSubArray(nums));
	}
}
