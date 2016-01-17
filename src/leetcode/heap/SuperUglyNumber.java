
package leetcode.heap;

import java.util.PriorityQueue;

/**
 * 
 * 
 * @author bliu13 Dec 10, 2015
 */
public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {

		if (n <= 0 || primes == null || primes.length == 0) {
			return 0;
		}

		int[] uglyNumbers = new int[n + 1];
		uglyNumbers[1] = 1;
		PriorityQueue<Integer> heap = new PriorityQueue<>();

		for (int prime : primes) {
			heap.offer(prime);
		}

		for (int i = 2; i <= n; i++) {
			uglyNumbers[i] = heap.poll();
			for (int j = 0; j < primes.length; j++) {
				if (uglyNumbers[i] % primes[j] == 0) {
					heap.offer(uglyNumbers[i] * primes[j]);
					break;
				} else {
					heap.offer(uglyNumbers[i] * primes[j]);
				}
			}
		}

		return uglyNumbers[n];
	}

	public static void main(String[] args) {
		SuperUglyNumber instance = new SuperUglyNumber();
		int[] primes = {2,3,5,13,19,29,31,41,43,53,59,73,83,89,97,103,107,109,127,137,139,149,163,173,179,193,197,199,211,223,227,229,239,241,251,257,263,269,271,281,317,331,337,347,353,359,367,373,379,389,397,409,419,421,433,449,457,461,463,479,487,509,521,523,541,547,563,569,577,593,599,601,613,619,631,641,659,673,683,701,709,719,733,739,743,757,761,769,773,809,811,829,857,859,881,919,947,953,967,971};
		System.out.println(instance.nthSuperUglyNumber(200000, primes));
	}
}
