
public class _243_Shortest_Word_Distance {
	/*
	 * Given a list of words and two words word1 and word2, return the shortest
	 * distance between these two words in the list.
	 * 
	 * For example,
	 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
	 *
	 * Given word1 = “coding”, word2 = “practice”, return 3.
	 * Given word1 = "makes", word2 = "coding", return 1.
	 *
	 * Note:
	 * You may assume that word1 does not equal to word2, and word1 and word2
	 * are both in the list.
	 */

	public int shortestDistance(String[] words, String word1, String word2) {
		/*
		 * locate one, then find both ways
		 */
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				int count = 0;
				for (int j = i - 1, k = i + 1; j >= 0
						|| k < words.length; j--, k++) {
					count++;
					if ((j >= 0 && words[j].equals(word2))
							|| (k < words.length && words[k].equals(word2))) {
						if (min > count)
							min = count;
						break;
					}
				}
			}
		}
		return min;
	}

	public int shortestDistance1(String[] words, String word1, String word2) {
		/*
		 * locate each, then calculate distance
		 */
		int pos1 = -1, pos2 = -1, n = words.length;

		int min_dist = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (words[i].equals(word1)) {
				pos1 = i;
			} else if (words[i].equals(word2)) {
				pos2 = i;
			}
			if (pos1 != -1 && pos2 != -1) {
				int new_dist = Math.abs(pos1 - pos2);
				min_dist = min_dist > new_dist ? new_dist : min_dist;
			}
		}
		return min_dist;
	}
}
