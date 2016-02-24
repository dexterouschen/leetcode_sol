import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _049_Group_Anagrams {
	/*
	 * Given an array of strings, group anagrams together.
	 * 
	 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
	 * 
	 * Return:
	 * 
	 * [
	 * ["ate", "eat","tea"],
	 * ["nat","tan"],
	 * ["bat"]
	 * ]
	 * 
	 * Note:
	 * 
	 * For the return value, each inner list's elements must follow the
	 * lexicographic order.
	 * 
	 * All inputs will be in lower-case.
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> results = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<>();

		for (String s : strs) {
			char[] keyArr = new char[26];
			/*
			 * use counts to form key instead of sorting each word to match
			 * 
			 * 2 words are anagrams if they have same count of each letter
			 */
			int n = s.length();
			for (int i = 0; i < n; i++)
				keyArr[s.charAt(i) - 'a']++;
			String key = new String(keyArr);
			if (map.containsKey(key))
				map.get(key).add(s);
			else {
				List<String> val = new ArrayList<>();
				val.add(s);
				map.put(key, val);
			}
		}

		for (List<String> list : map.values()) {
			Collections.sort(list);
			results.add(list);
		}
		return results;
	}
}
