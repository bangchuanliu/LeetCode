package leetcode.bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {

	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<>();

		if (s == null) {
			return result;
		}

		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);

		int hash = 0;
		Set<Integer> nums = new HashSet<>();
		Set<Integer> added = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			if (i < 9) {
				hash = (hash << 2) + map.get(s.charAt(i));
			} else {
				hash = (hash << 2) + map.get(s.charAt(i));
				hash = hash & (1 << 20) - 1;
				if (nums.contains(hash) && !added.contains(hash)) {
					result.add(s.substring(i - 9, i + 1));
					added.add(hash);
				} else {
					nums.add(hash);
				}
			}
		}

		return result;
	}
	
	public static void main(String[] args) {
		RepeatedDNASequences instance = new RepeatedDNASequences();
		instance.findRepeatedDnaSequences("CAAAAAAAAAC");
	}
}
