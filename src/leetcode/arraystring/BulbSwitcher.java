package leetcode.arraystring;


/**
 * 
 * @author bliu13 Jan 17, 2016
 */
public class BulbSwitcher {
	public int bulbSwitch(int n) {
		if (n <= 0) {
			return 0;
		}

		boolean[] bulbOn = new boolean[n + 1];
		int round = 1;

		while (round <= n) {
			for (int i = round; i <= n; i += round) {
				bulbOn[i] = !bulbOn[i];
			}
			round++;
		}

		int count = 0;
		for (boolean isOn : bulbOn) {
			if (isOn) {
				count++;
			}
		}
		return count;
	}
}
