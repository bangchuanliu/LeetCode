package leetcode.bit;

public class SingleNumber {

	public int singleNumber(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int ret = A[0];
		for (int i = 1; i < A.length; i++) {
			ret ^= A[i];
		}
		return ret;
	}

	public int singleNumber2(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int[] B = new int[32];
		for (int i = 0; i < A.length; i++) {
			String s = Integer.toBinaryString(A[i]);
			for (int j = s.length() - 1; j >= 0; j--) {
				if (s.charAt(j) == '1') {
					B[B.length - s.length() + j] += 1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < B.length; i++) {
			B[i] = B[i] % 3;
			sb.append(B[i]);
		}
		return (int) Long.parseLong(sb.toString(), 2);
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 2 };
		System.out.println(new SingleNumber().singleNumber2(A));
	}
}
