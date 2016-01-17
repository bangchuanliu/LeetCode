package leetcode.arraystring;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Feb 3, 2015
 */
public class CountAndSay {
	public static String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}
		if (n == 1) {
			return "1";
		}
		String preSeq = countAndSay(n - 1);
		String[] preSeqs = preSeq.split(",");
		String lastStr = preSeqs[preSeqs.length - 1];
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < lastStr.length()) {
			int j = i + 1;
			while (j < lastStr.length() && lastStr.charAt(j) == lastStr.charAt(i)) {
				j++;
			}
			sb.append(j - i).append(lastStr.charAt(i));
			i = j;
		}
		return sb.toString();
	}
	
	public static String countAndSay3(int n) {
		if (n <= 0) {
            return null;
        }
        
        String str = "1";
        
        while (n > 1) {
            StringBuffer sb = new StringBuffer();
            char pre = str.charAt(0);
            int counter = 1;
            
            for (int i = 1; i < str.length(); i++) {
                char cur = str.charAt(i);
                if (cur == pre) {
                    counter++;
                } else {
                    sb.append(counter).append(pre);
                    pre = cur;
                    counter=1;
                }
            }
            sb.append(counter).append(pre);
            str = sb.toString();
            n--;
        }
        return str;
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(0));
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
		System.out.println(countAndSay(5));
		System.out.println(countAndSay(25));
	}
}
