
public class _005_Longest_Palindromic_Substring {
	/*
	 * Given a string S, find the longest palindromic substring in S. You may
	 * assume that the maximum length of S is 1000, and there exists one unique
	 * longest palindromic substring.
	 */
	public static String longestPalindrome(String s) {
		char[] ca = s.toCharArray();
		int rs = 0, re = 0;
		int max = 0;
		int n = ca.length;
		for (int i = 0; i < n; i++) {
			/*
			 * only care about potential match with length > existing max,
			 * since solution is unique
			 */
			if (isPalindrome(ca, i - max - 1, i)) {
				/*
				 * one in the middle match, 12...21
				 */
				rs = i - max - 1;
				re = i;
				max += 2;
			} else if (isPalindrome(ca, i - max, i)) {
				/*
				 * adjacent match, 1221
				 */
				rs = i - max;
				re = i;
				max += 1;
			}
		}
		return s.substring(rs, re + 1);
	}

	private static boolean isPalindrome(char[] ca, int s, int e) {
		/*
		 * i-max-1 could be negative
		 */
		if (s < 0)
			return false;

		while (s < e) {
			if (ca[s++] != ca[e--])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		longestPalindrome("12121");
	}
}
