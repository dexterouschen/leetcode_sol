import java.util.HashSet;
import java.util.Set;

public class _127_Word_Ladder {
	/*
	 * Given two words (beginWord and endWord), and a dictionary's word list,
	 * find the length of shortest transformation sequence from beginWord to
	 * endWord, such that:
	 * 
	 * Only one letter can be changed at a time
	 * Each intermediate word must exist in the word list
	 * For example,
	 * 
	 * Given:
	 * beginWord = "hit"
	 * endWord = "cog"
	 * wordList = ["hot","dot","dog","lot","log"]
	 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" ->
	 * "cog",
	 * return its length 5.
	 * 
	 * Note:
	 * Return 0 if there is no such transformation sequence.
	 * All words have the same length.
	 * All words contain only lowercase alphabetic characters.
	 */
	public static int ladderLength(String start, String end, Set<String> dict) {
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();

		set1.add(start);
		set2.add(end);

		return helper(dict, set1, set2, 1);
	}

	/*
	 * two-end BFS, cut off words faster
	 */
	static int helper(Set<String> dict, Set<String> set1, Set<String> set2,
			int level) {
		/*
		 * if certain level can't expand, then empty set, no path possible, 0
		 */
		if (set1.isEmpty())
			return 0;
		/*
		 * expand smaller set first
		 */
		if (set1.size() > set2.size())
			return helper(dict, set2, set1, level);

		// remove words from both ends
		dict.removeAll(set1);
		dict.removeAll(set2);

		// the set for next level
		Set<String> set = new HashSet<String>();

		// for each string in the current level
		for (String str : set1) {
			char[] chars = str.toCharArray();
			int n = chars.length;
			for (int i = 0; i < n; i++) {
				// change letter at every position
				for (char ch = 'a'; ch <= 'z'; ch++) {
					char original = chars[i];
					chars[i] = ch;
					String word = new String(chars);

					// found the word in other end(set)
					if (set2.contains(word)) {
						return level + 1;
					}

					// if not, add to the next level
					if (dict.contains(word)) {
						set.add(word);
					}
					chars[i] = original;
				}
			}
		}
		/*
		 * alternate start set and end set
		 */
		return helper(dict, set2, set, level + 1);
	}

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");

		ladderLength("hit", "cog", set);
	}
}
