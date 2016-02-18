
public class _326_Power_of_Three {
	/*
	 * Given an integer, write a function to determine if it is a power of
	 * three.
	 *
	 * Follow up:
	 * Could you do it without using any loop / recursion?
	 * 
	 */
	public boolean isPowerOfThree(int n) {
		/*
		 * hard-code max of power of three within Integer range
		 */
		return n > 0 && (1162261467 % n == 0);
	}
}
