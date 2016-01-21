package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Given two words (beginWord and endWord), and a wordListionary, find all
 * shortest transformation sequence(s) from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the wordListionary For example,
 * 
 * Given: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log"] Return [ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"] ] Note: All words have the same length. All
 * words contain only lowercase alphabetic characters.
 * 
 * @author BangChuan Liu
 * @date 2015
 * @Contact liubangchuan1100@gmail.com
 */
public class WordLadderII {

	static int dis = Integer.MAX_VALUE;

	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

		List<List<String>> result = new ArrayList<List<String>>();

		if (beginWord == null || endWord == null || wordList == null) {
			return result;
		}

		wordList.add(endWord);
		List<String> temp = new ArrayList<>();
		LinkedList<String> queue = new LinkedList<>();
		queue.add(beginWord);

		findLadders(queue, endWord, wordList, result, temp);

		result.removeIf(list -> list.size() > dis);

		return result;
	}

	public void findLadders(LinkedList<String> queue, String endWord, Set<String> wordList, List<List<String>> result,
			List<String> temp) {

		if (queue.isEmpty()) {
			return;
		}

		while (!queue.isEmpty()) {
			String word = queue.poll();

			if (word.equals(endWord)) {
				dis = Math.min(temp.size(), dis);
				result.add(new ArrayList<String>(temp));
				continue;
			}

			for (int i = 0; i < endWord.length(); i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					char[] words = word.toCharArray();

					if (words[i] == c) {
						continue;
					}

					words[i] = c;
					String newWord = new String(words);

					if (wordList.contains(newWord)) {
						queue.add(newWord);
						temp.add(newWord);
						wordList.remove(newWord);
						if (temp.size() <= dis) {
							findLadders(queue, endWord, wordList, result, temp);
						}
						wordList.add(newWord);
						temp.remove(temp.size() - 1);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		WordLadderII instance = new WordLadderII();
		String[] wordLists = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
		Set<String> wordList = new HashSet<String>(Arrays.asList(wordLists));
		List<List<String>> result = instance.findLadders("qa", "sq", wordList);
		System.out.println(Arrays.deepToString(result.toArray()));
	}
}
