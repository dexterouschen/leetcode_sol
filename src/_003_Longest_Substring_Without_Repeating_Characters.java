import java.util.HashMap;

public class _003_Longest_Substring_Without_Repeating_Characters {

	/*
	 * Given a string, find the length of the longest substring without
	 * repeating characters. For example, the longest substring without
	 * repeating letters for "abcabcbb" is "abc", which the length is 3. For
	 * "bbbbb" the longest substring is "b", with the length of 1.
	 */

	public int lengthOfLongestSubstring(String s) {
		int lastIndices[] = new int[256];
		for (int i = 0; i < 256; i++) {
			lastIndices[i] = -1;
		}

		int maxLen = 0;
		int curLen = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (lastIndices[cur] < start) {
				/*
				 * 1. -1, haven't encountered
				 * 2. encountered this value / other value => start >>
				 * and last index of this value is within [0, start-1]
				 */
				lastIndices[cur] = i;
				curLen++;
			} else {

				int lastIndex = lastIndices[cur];
				start = lastIndex + 1;
				curLen = i - start + 1;
				lastIndices[cur] = i;
			}

			if (curLen > maxLen) {
				maxLen = curLen;
			}
		}

		return maxLen;
	}

	/**
	 * HashMap approach is less efficient than array approach
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring_2(String s) {
		HashMap<Character, Integer> dict = new HashMap<>();
		int n = s.length();
		int start = -1, maxLength = 0;
		for (int i = 0; i < n; i++) {
			char cur = s.charAt(i);
			Integer curIndex = dict.get(s.charAt(i));
			if (curIndex != null && curIndex > start) {
				start = curIndex;
			}
			dict.put(cur, i);
			maxLength = maxLength > i - start ? maxLength : i - start;
		}
		return maxLength;
	}

	public static void main(String[] args) {
		for (char c = 65530; c < 70000; c += 1) {
			System.out.println(c);
		}
	}
}
