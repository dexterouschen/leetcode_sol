import java.util.HashSet;
import java.util.Set;

public class _217_Contains_Duplicate {
	/*
	 * Given an array of integers, find if the array contains any duplicates.
	 * Your function should return true if any value appears at least twice in
	 * the array, and it should return false if every element is distinct.
	 * 
	 */

	public boolean containsDuplicate(int[] nums) {
		if (nums == null) {
			return false;
		}
		int[] hashTable = new int[nums.length];
		// Separate boolean flags to in case that
		// Integer.MIN_VALUE appears in the input array.twice
		boolean[] occupied = new boolean[nums.length];

		for (int i = 0; i < nums.length; i++) {
			/*
			 * % to make sure absolute value within range
			 */
			int h = nums[i] % nums.length;
			/*
			 * change negative to positive
			 */
			h = h >= 0 ? h : h + nums.length;
			/*
			 * check if occupied
			 */
			while (occupied[h]) {
				/*
				 * each time to check if same
				 */
				if (nums[i] == hashTable[h]) {
					/*
					 * same, true
					 */
					return true;
				} else {
					/*
					 * custom hash function
					 * occupied but not same, find next available slot
					 */
					h = (h + 1) % nums.length;
				}
			}
			hashTable[h] = nums[i];
			occupied[h] = true;
		}
		return false;
	}

	public boolean containsDuplicate1(int[] nums) {
		/*
		 * scan whole array to get min/max
		 */
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int b : nums) {
			if (b < min) {
				min = b;
			}
			if (b > max) {
				max = b;
			}
		}
		/*
		 * build boolean flags of enough length
		 */
		boolean a[] = new boolean[max - min + 1];
		/*
		 * use offset of min to flag each encounter
		 */
		for (int b : nums) {
			if (a[b - min]) {
				return true;
			} else {
				a[b - min] = true;
			}
		}
		return false;
	}

	public boolean containsDuplicate2(int[] nums) {
		Set<Integer> set = new HashSet<>();
		if (nums == null) {
			return false;
		}
		int n = nums.length;
		if (n < 2) {
			return false;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!set.add(nums[i])) {
				return true;
			}
		}
		return false;
	}
}
