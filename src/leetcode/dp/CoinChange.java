package leetcode.dp;

import java.util.Arrays;

/**
 * 
 * @author bliu13 Jan 5, 2016
 */
public class CoinChange {

	public int coinChange(int[] coins, int amount) {

		if (coins == null || coins.length == 0 || amount <= 0) {
			return 0;
		}

		Arrays.sort(coins);

		if (amount < coins[0]) {
			return -1;
		}

		int[] sums = new int[amount + 1];

		for (int i = 0; i < coins[0]; i++) {
			sums[i] = -1;
		}

		for (int coin : coins) {
			if (coin > amount) {
				break;
			}
			sums[coin] = 1;
		}

		for (int i = coins[0] + 1; i <= amount; i++) {
			if (sums[i] == 1) {
				continue;
			}
			int min = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (i > coin) {
					if (sums[i - coin] != -1) {
						min = Math.min(min, sums[i - coin] + 1);
						sums[i] = min;
					} 
				} else {
					break;
				}
			}
			
			if (sums[i] == 0) {
				sums[i] = - 1;
			}
		}

		return sums[amount];
	}
	
	public static void main(String[] args) {
		int[] coins = { 186, 419, 83, 408 };
		int amount = 6249;

		CoinChange instance = new CoinChange();
		System.out.println(instance.coinChange(coins, amount));
	}
}
