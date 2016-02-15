import java.util.HashMap;

public class _001_Two_Sum {

	/*
	 * Given an array of integers, return indices of the two numbers such that
	 * they add up to a specific target.
	 *
	 * You may assume that each input would have exactly one solution.
	 *
	 * Example:
	 * Given nums = [2, 7, 11, 15], target = 9,
	 *
	 * Because nums[0] + nums[1] = 2 + 7 = 9,
	 * return [0, 1].
	 *
	 * UPDATE (2016/2/13):
	 * The return format had been changed to zero-based indices. Please read the
	 * above updated description carefully.
	 */

	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (map.containsKey(nums[i])) {
				/*
				 * 1. index1 < index2, s linear, so i > map.get(nums[i] + 1)
				 * 2. one-based
				 */
				return new int[] { map.get(nums[i]), i };
			} else {
				/*
				 * if not already in the map, then set up association so if
				 * (target - nums[i]) appears
				 * it will know exactly where to match up nums[i] or to target
				 */
				map.put(target - nums[i], i);
			}
		}
		return null;
	}

	public static void main(String[] args) {

	}
}
