package leetcode.arraystring;


/**
 * 
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 * 
 * @author admin
 *
 */
public class String2Integer {

	
	/**
	 * handle follow cases
	 * 
	 *  1. null or empty string
		2. white spaces
		3. +/- sign
		4. calculate real value
		5. handle min & max
	 */
	
	public int atoi(String str) {
		
		// null or empty string
		if(str == null || str.trim().length() <= 0){
			return 0;
		}
		
		// white space in front and behind
		str = str.trim();
		
		// + - sign, only one sign and must in front of string
		char flag = '+';
		int i=0;
		if(str.charAt(0) == '-'){
			flag = '-';
			i++;
		}else if(str.charAt(0) == '+'){
			i++;
		}
		double result = 0;
		
		while(i<str.length() && Character.isDigit(str.charAt(i))){
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
		if(flag == '-'){
			result = -result;
		}
		
		//handle min, max
		if(result > Integer.MAX_VALUE){
			result = Integer.MAX_VALUE;
		}else if(result < Integer.MIN_VALUE){
			result = Integer.MIN_VALUE;
		}
		return (int)result;
	}
	
	public static void main(String[] args){
		String2Integer instance = new String2Integer();
		System.out.println(instance.atoi("+1")); // 1
		System.out.println(instance.atoi("+-2")); //0
	}
}
