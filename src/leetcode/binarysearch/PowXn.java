package leetcode.binarysearch;

/**
 * 
 * @author bliu13 Jan 11, 2016
 */
public class PowXn {
	public double myPow2(double x, int n) {
		if (x == 0) {
			return 1;
		}

		int m = Math.abs(n);
		double prod = x;
		for (int i = 2; i <= m; i++) {
			prod *= x;
		}

		return n < 0 ? 1.0 / prod : prod;
	}
	
	/**
	 * Binary search
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {
		if (n < 0) {
			return 1 / pow(x,-n);
		} else {
			return pow(x,n);
		}
	}
	
	public double pow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		
		double pow = myPow(x, n / 2);
		
		if (n % 2 == 0) {
			return pow * pow;
		} else {
			return pow*pow*x;
		}
	}
	
	public static void main(String[] args) {
		PowXn instance = new PowXn();
		System.out.println(instance.myPow(0.00001,2147483647));
	}
}
