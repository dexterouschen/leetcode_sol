
/*
 * Given a non-negative integer num,
 * repeatedly add all its digits until the result has only one digit.
 *
 * For example:
 *
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. 
 * Since 2 has only one digit, return it.
 *
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */

public class _258_Add_Digits {
	/*
	 * A trivial and naive approach is easy to come up with
	 * continuously extract digits from current number and add them up
	 * to form the new number, until the final number has only one digit.
	 * 
	 * But it's relatively time-consuming, so instead try to identify a pattern.
	 * For number < 9, the result is number & 9
	 * For number > 9, the result is number % 9
	 * For 9, the result is 9
	 * 
	 * So the only exception is the 9, we can make a special case of 9
	 * or simply change the formula a bit, decrease all numbers by 1
	 * thus (number-1) % 9 = original result - 1 for all numbers,
	 * and we simply add 1 to the formula, problem resolved.
	 */
	public int addDigits(int num) {
		if (num == 0) {
			return 0;
		}
		return (num - 1) % 9 + 1;
	}
}
