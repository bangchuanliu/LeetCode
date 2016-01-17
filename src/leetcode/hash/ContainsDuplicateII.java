package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * difference between i and j is at most k.
 * 
 * @author bliu13 Jan 13, 2016
 */
public class ContainsDuplicateII {
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		
		if (nums == null || nums.length == 0) {
			return false;
		}
		
		Map<Integer,Integer> maps = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			if (maps.containsKey(nums[i])) {
				int j = maps.get(nums[i]);
				if (i - j <= k) {
					return true;
				}
			} 
			
			maps.put(nums[i], i);
		}
		
		return false;
	}
}
