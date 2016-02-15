
public class _266_Palindrome_Permutation {
	/*
	 * Given a string, determine if a permutation of the string could form a
	 * palindrome.
	 *
	 * For example,
	 * "code" -> False, "aab" -> True, "carerac" -> True.
	 */
	public static boolean canPermutePalindrome(String s) {
		/*
		 * As long as there are multiple distinct character
		 * the sequence can never be rearranged into "palindrome"
		 * and as long as the appearances are even, exact times doesn't matter 
		 * so instead of keeping track of numbers, boolean is used
		 * array of flags, true for odd and false for even
		 * track count of odd appearances too
		 * and return false if more than 1 otherwise true
		 */
		if (s == null)
			return true;
		int len = s.length();
		if (len <= 1)
			return true;
		boolean[] odd_flag = new boolean[256];
		int odd_count = 0;
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (odd_flag[c]) {
				odd_flag[c] = false;
				odd_count--;
			} else {
				odd_flag[c] = true;
				odd_count++;
			}
		}
		if (odd_count > 1)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		System.out.println(canPermutePalindrome("asa"));
	}
}
