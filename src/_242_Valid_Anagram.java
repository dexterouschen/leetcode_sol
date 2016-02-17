import java.util.Arrays;

public class _242_Valid_Anagram {
	/*
	 * Given two strings s and t, write a function to determine if t is an
	 * anagram of s.
	 *
	 * For example,
	 * s = "anagram", t = "nagaram", return true.
	 * s = "rat", t = "car", return false.
	 *
	 * Note:
	 * You may assume the string contains only lowercase alphabets.
	 *
	 * Follow up:
	 * What if the inputs contain unicode characters? How would you adapt your
	 * solution to such case?
	 */
	public static boolean isAnagram(String s, String t) {
		/*
		 * both null, true
		 */
		if (s == null && t == null) {
			return true;
		}
		/*
		 * only one null, false
		 */
		if (s == null && t != null || s != null && t == null) {
			return false;
		}
		/*
		 * convert to char array for easy manipulation
		 */
		char[] charsS = s.toCharArray(), charsT = t.toCharArray();
		int ns = s.length(), nt = t.length();
		/*
		 * different length, false
		 */
		if (ns != nt) {
			return false;
		}
		/*
		 * sort both
		 */
		Arrays.sort(charsS);
		Arrays.sort(charsT);
		/*
		 * any inconsistency, false
		 */
		for (int i = 0; i < ns; i++) {
			if (charsS[i] != charsT[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "gramana"));
	}
}
