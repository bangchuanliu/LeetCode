package leetcode.backtracking;

public class WildcardMatching {
	public boolean isMatch2(String s, String p) {
		if (s == null && p == null || s.length() == 0 && p.length() == 0) {
			return true;
		}

		if ((s != null && s.length() > 0) && (p != null && p.length() > 0)) {
			if (s.equals(p) || p.equals("*") || (s.length() == 1 && p.equals("?"))) {
				return true;
			}

			if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
				return isMatch(s.substring(1), p.substring(1));
			} else if (p.charAt(0) == '*') {
				for (int i = 1; i < s.length(); i++) {
					if (isMatch(s.substring(i), p.substring(1))) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;

		while (i < s.length()) {
			if (j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
				i++;
				j++;
			} else if (j < p.length() && p.charAt(j) == '*') {
				star = j;
				mark = i;
				j++;
			} else if (star != -1) {
				j = star + 1;
				i = ++mark;
			} else {
				return false;
			}
		}

		while (j < p.length() && p.charAt(j) == '*') {
			j++;
		}

		return j == p.length();
	}

	public static void main(String[] args) {
		WildcardMatching instance = new WildcardMatching();
		System.out.println(instance.isMatch("aa", "a"));
		System.out.println(instance.isMatch("aa", "aa"));
		System.out.println(instance.isMatch("aaa", "aa"));
		System.out.println(instance.isMatch("aa", "*"));
		System.out.println(instance.isMatch("aa", "a*"));
		System.out.println(instance.isMatch("ab", "?*"));
		System.out.println(instance.isMatch("aab", "c*a*b"));
		System.out.println(instance.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
	}
}
