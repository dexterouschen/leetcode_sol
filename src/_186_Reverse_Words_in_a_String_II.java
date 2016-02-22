
public class _186_Reverse_Words_in_a_String_II {
	/*
	 * Given an input string, reverse the string word by word. A word is defined
	 * as a sequence of non-space characters.
	 * 
	 * The input string does not contain leading or trailing spaces and the
	 * words are always separated by a single space.
	 * 
	 * For example,
	 * Given s = "the sky is blue",
	 * return "blue is sky the".
	 * 
	 * Could you do it in-place without allocating extra space?
	 */

	/*
	 * If one word, it will be reversed twice for nothing, but the time to find
	 * out if it's a single word cost roughly the amount of time to reverse it,
	 * so it's not necessary to do that
	 * 
	 * Plus in other cases there will be multiple reverses regardlessly
	 */
	public void reverseWords(char[] s) {
		if (s.length == 0)
			return;
		/*
		 * reverse the whole array
		 */
		reverse(s, 0, s.length - 1);
		/*
		 * start from beginning
		 */
		int last_start = 0;
		for (int i = 0; i < s.length; i++) {
			/*
			 * if space
			 */
			if (s[i] == ' ') {
				/*
				 * reverse last word
				 */
				reverse(s, last_start, i - 1);
				/*
				 * mark new start
				 */
				last_start = i + 1;
			}
		}
		/*
		 * no space in the end, handle separately
		 */
		reverse(s, last_start, s.length - 1);
	}

	public void reverse(char[] s, int l, int r) {
		while (l < r) {
			char temp = s[l];
			s[l] = s[r];
			s[r] = temp;
			l++;
			r--;
		}
	}
}
