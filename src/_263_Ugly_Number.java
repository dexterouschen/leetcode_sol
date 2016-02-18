
public class _263_Ugly_Number {
	/*
	 * Write a program to check whether a given number is an ugly number.
	 *
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3,
	 * 5. For example, 6, 8 are ugly while 14 is not ugly since it includes
	 * another prime factor 7.
	 *
	 * Note that 1 is typically treated as an ugly number.
	 */
	public boolean isUgly(int num) {
		/*
		 * a number can be written as a product of prime numbers
		 * if a number's prime factors only include 2,3,5
		 * then by dividing 2,3,5 repeatedly, 1 will be reached
		 */
		for (int i = 2; i < 6 && num > 0; i++)
			while (num % i == 0)
				num /= i;
		return num == 1;
	}
}
