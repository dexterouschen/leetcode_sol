
public class _202_Happy_Number {
	/*
	 * Write an algorithm to determine if a number is "happy".
	 *
	 * A happy number is a number defined by the following process: Starting
	 * with any positive integer, replace the number by the sum of the squares
	 * of its digits, and repeat the process until the number equals 1 (where it
	 * will stay), or it loops endlessly in a cycle which does not include 1.
	 * Those numbers for which this process ends in 1 are happy numbers.
	 *
	 * Example: 19 is a happy number
	 * 
	 */
	int digitSquareSum(int n) {
		/*
		 * Helper
		 * extract digits and calculate sum of squares
		 */
		int sum = 0, tmp;
		while (n > 0) {
			tmp = n % 10;
			sum += tmp * tmp;
			n /= 10;
		}
		return sum;
	}

	public boolean isHappy(int n) {
		/*
		 * slow/fast pointers, cycle detection
		 */
		int slow = n, fast = n;
		do {
			/*
			 * fast move twice as fast
			 */
			slow = digitSquareSum(slow);
			fast = digitSquareSum(fast);
			fast = digitSquareSum(fast);
			/*
			 * reached, true
			 */
			if (fast == 1)
				return true;
		} while (slow != fast);
		/*
		 * if slow meets fast, cycle
		 */
		return false;
	}
}
