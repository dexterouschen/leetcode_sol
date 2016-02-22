import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _078_Subsets {

	/*
	 * Given a set of distinct integers, nums, return all possible subsets.
	 * 
	 * Note:
	 * Elements in a subset must be in non-descending order.
	 * The solution set must not contain duplicate subsets.
	 * For example,
	 * If nums = [1,2,3], a solution is:
	 * 
	 * [
	 * [3],
	 * [1],
	 * [2],
	 * [1,2,3],
	 * [1,3],
	 * [2,3],
	 * [1,2],
	 * []
	 * ]
	 */
	public static List<List<Integer>> subsets(int[] S) {
		/*
		 * non-descending
		 */
		Arrays.sort(S);
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		subsets.add(new ArrayList<Integer>());
		for (int i = 0; i < S.length; i++) {
			int size = subsets.size();
			for (int j = 0; j < size; j++) {
				/*
				 * make a new set using existing values
				 */
				ArrayList<Integer> subset = new ArrayList<Integer>(
						subsets.get(j));
				subset.add(S[i]);
				subsets.add(subset);
			}
		}
		return subsets;
	}

	public static void main(String[] args) {

		subsets(new int[] { 1, 2, 3 });
	}
}
