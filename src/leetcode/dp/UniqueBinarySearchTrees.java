package leetcode.dp;

public class UniqueBinarySearchTrees {

	public int numTrees(int n) {

		if (n <= 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		int[] result = new int[n + 1];
		result[0] = 1;
		result[1] = 1;
		result[2] = 2;

		for (int i = 3; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				result[i] += result[j - 1] * result[i - j];
			}
		}
		return result[n];
	}

	public static void main(String[] args) {
		UniqueBinarySearchTrees instance = new UniqueBinarySearchTrees();
		System.out.println(instance.numTrees(1));
		System.out.println(instance.numTrees(2));
		System.out.println(instance.numTrees(3));
		System.out.println(instance.numTrees(4));
		System.out.println(instance.numTrees(5));
		System.out.println(instance.numTrees(6));
	}
}
