package leetcode.binarysearch;

public class FindMinimumRotatedSortedArray {
	public int findMin2(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		if (num.length == 1) {
			return num[0];
		}
		if (num.length == 2) {
			return Math.min(num[0], num[1]);
		}
		int i = 0;
		int j = num.length - 1;
		while (i < j) {
			int k = (i + j) / 2;
			if (k > 0 && num[k] < num[k - 1]) {
				return num[k];
			} else if (k < num.length - 1 && num[k] > num[k + 1]) {
				return num[k + 1];
			} else {
				if (num[k] > num[j]) {
					i = k + 1;
				} else {
					j = k - 1;
				}
			}
		}
		return num[i];
	}

	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			if (nums[left] <= nums[right]) {
				return nums[left];
			}
			int mid = (left + right) / 2;
			if (nums[left] <= nums[mid]) {
				left = mid + 1;
			} else {
				left++;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		int[] num1 = { 2, 4, 5, 6, 7, 0, 1 };
		int[] num2 = { 0, 1, 2, 3, 4, 5, 6 };
		int[] num3 = { 5, 1, 2, 3, 4 };
		int[] num4 = { 1, 2, 3, 4, 5 };
		int[] num5 = { 6, 1, 2, 3, 4, 5 };
		FindMinimumRotatedSortedArray instance = new FindMinimumRotatedSortedArray();
		System.out.println(instance.findMin(num1));
		System.out.println(instance.findMin(num2));
		System.out.println(instance.findMin(num3));
		System.out.println(instance.findMin(num4));
		// System.out.println(instance.findMin2(num5));
	}
}
