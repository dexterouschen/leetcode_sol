import java.util.LinkedList;
import java.util.List;

public class _089_Gray_Code {
	/*
	 * The gray code is a binary numeral system where two successive values
	 * differ in only one bit.
	 * 
	 * Given a non-negative integer n representing the total number of bits in
	 * the code, print the sequence of gray code. A gray code sequence must
	 * begin with 0.
	 * 
	 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	 * 
	 * 00 - 0
	 * 01 - 1
	 * 11 - 3
	 * 10 - 2
	 * 
	 * Note:
	 * For a given n, a gray code sequence is not uniquely defined.
	 * 
	 * For example, [0,2,3,1] is also a valid gray code sequence according to
	 * the above definition.
	 */

	public static List<Integer> grayCode(int n) {
		List<Integer> result = new LinkedList<>();
		/*
		 * 1 << n, 100...00 (number of 0's : n)
		 */
		for (int i = 0; i < 1 << n; i++)
			/*
			 * normally there are various way to construct gray code sequence
			 * however binary-reflected gray code is easy to construct,
			 * normally each bit in gray code should be calculated based on
			 * current and previous bit in binary, but use a copy of shifted
			 * original binary can achieve the same, since for the most
			 * significant bit, XOR will keep its value regardlessly
			 * 
			 * 0(B1) XOR 0(shifted) = 0
			 * 1(B1) XOR 0(shifted) = 1
			 * 
			 * G1 = B1
			 * G2 = B1 XOR B2
			 * G3 = B2 XOR B3
			 * ...
			 */
			result.add(i ^ i >> 1); // i ^ (i >> 1)
		return result;
	}

	public static void main(String[] args) {

		for (int i = 0; i < 30; i++) {
			System.out.println((1 << i) == Math.pow(2, i));
		}

		grayCode(5);
	}
}
