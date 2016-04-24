package leetcode.arraystring;

import java.util.List;

public class ShortestWordDistance {
	
	public int shortWordDistance(List<String> words, String word1, String word2) {
		int index1 = -1;
		int index2 = -1;
		int dis = Integer.MAX_VALUE;
		
		for (int i = 0 ; i < words.size(); i++) {
			if (words.get(i).equals(word1)) {
				index1 = i;
			} else if (words.get(i).equals(word2)) {
				index2 = i;
			} else if (index1 != -1 && index2 != -1) {
				dis = Math.min(dis, Math.abs(index1 - index2) + 1);
			}
		}
		
		return dis;
	}
}
