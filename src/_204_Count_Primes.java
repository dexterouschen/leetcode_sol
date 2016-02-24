
public class _204_Count_Primes {

	/*
	 * Count the number of prime numbers less than a non-negative number, n.
	 */

	public static int countPrimes(int n) {
		if (n < 3)
			return 0;

		boolean[] non_prime = new boolean[n];
		// only count odd numbers
		int count = n / 2;
		for (int i = 3; i * i < n; i += 2) { // i += 2 counts only odd numbers
			if (non_prime[i])
				continue;

			for (int j = i * i; j < n; j += 2 * i) {
				/*
				 * i,j both odd, sum to even, so j+2i is odd
				 */
				if (!non_prime[j]) {
					/*
					 * once find a not marked non-prime number
					 * subtract count by 1
					 */
					--count;
					non_prime[j] = true;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(20));
	}
}
