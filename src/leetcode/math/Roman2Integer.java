package leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Oct 29, 2014
 */
public class Roman2Integer {

	public int romanToInt(String s) {
		if(s == null || s.trim().length() == 0){
			return 0;
		}
		char[] symbol = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
		int[] val = { 1, 5, 10, 50, 100, 500, 1000 };
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < symbol.length; i++)
			map.put(symbol[i], val[i]);

		int len = s.length();
		int res = 0;

		res += map.get(s.charAt(0));
		for (int i = 1; i < len; i++) {
			int cur = map.get(s.charAt(i));
			int pre = map.get(s.charAt(i - 1));
			if (cur <= pre) {
				res += cur;
			} else {
				res = res + cur - 2 * pre;
			}

		}
		return res;
	}
}
