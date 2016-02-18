
public class _191_Number_of_1_Bits {

	/*
	 * Write a function that takes an unsigned integer and returns the number of
	 * ’1' bits it has (also known as the Hamming weight).
	 *
	 * For example, the 32-bit integer ’11' has binary representation
	 * 00000000000000000000000000001011, so the function should return 3.
	 */

	// you need to treat n as an unsigned value
	public static int hammingWeight(int n) {
		int count = 0;
		if (n < 0) {
			/*
			 * if negative, then - is counted as 1
			 */
			count = 1;
			/*
			 * if negative, AND to get corresponding positive
			 */
			n &= Integer.MAX_VALUE;
		}

		while (n > 0) {
			/*
			 * if last bit 1, then must be odd
			 */
			if (n % 2 != 0) {
				++count;
			}
			/*
			 * keep shift right by 1 until 0
			 */
			n >>= 1;
		}

		return count;
	}

	public static int hammingWeight1(int n) {
		return Integer.bitCount(n);
	}

	public static void main(String[] args) {
		hammingWeight(-10);
	}
}
