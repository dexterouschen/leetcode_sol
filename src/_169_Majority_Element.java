import java.util.Hashtable;

public class _169_Majority_Element {
	/*
	 * Given an array of size n, find the majority element. The majority element
	 * is the element that appears more than ⌊ n/2 ⌋ times.
	 * 
	 * You may assume that the array is non-empty and the majority element
	 * always exist in the array.
	 */

	public int majorityElement1(int[] nums) {
		/*
		 * order doesn't matter, if consider major element as a positive count
		 * and negative otherwise, then keep track of possible major element and
		 * its count until it reach 0 then switch to new element, finally we can
		 * get the actual major element
		 */
		int res = nums[0];
		int count = 1;

		for (int num : nums) {
			if (res == num)
				++count;
			else
				--count;

			if (count == 0) {
				res = num;
				count = 1;
			}
		}

		return res;
	}

	public int majorityElement(int[] nums) {

		int result = 0, count = 0, n = nums.length;

		for (int i = 0; i < n; i++) {
			if (count == 0) {
				result = nums[i];
				count = 1;
			} else if (result == nums[i]) {
				count++;
			} else {
				count--;
			}
		}

		return result;
	}
}
