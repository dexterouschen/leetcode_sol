
public class _231_Power_of_Two {
	public boolean isPowerOfTwo(int n) {
		/*
		 * Power of 2 means only one bit of n is '1', so use the trick
		 * n & (n-1) == 0 to judge whether that is the case
		 * 
		 * 10...00 & 00...01 == 0
		 */
		return (n > 0 && ((n & (n - 1)) == 0));
	}
}
