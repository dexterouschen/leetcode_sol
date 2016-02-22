
public class _167_Two_Sum_II_Input_array_is_sorted {

	/*
	 * Given an array of integers that is already sorted in ascending order,
	 * find two numbers such that they add up to a specific target number.
	 * 
	 * The function twoSum should return indices of the two numbers such that
	 * they add up to the target, where index1 must be less than index2. Please
	 * note that your returned answers (both index1 and index2) are not
	 * zero-based.
	 * 
	 * You may assume that each input would have exactly one solution.
	 * 
	 * Input: numbers={2, 7, 11, 15}, target=9
	 * Output: index1=1, index2=2
	 */

	int indexOf(int[] numbers, int key, int lo) {
		/*
		 * given lower bound, binary search
		 */
		int hi = numbers.length - 1;
		while (lo <= hi) {
			// Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if (key < numbers[mid])
				hi = mid - 1;
			else if (key > numbers[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	public int[] twoSum(int[] numbers, int target) {
		/*
		 * assume exactly one solution
		 */
		int n = numbers.length;
		for (int i = 0; i < n; i++) {
			int cur = numbers[i];
			/*
			 * try to get index of the matched number, but always start from
			 * numbers after current，since possible match can only exist after
			 */
			int index = indexOf(numbers, target - cur, i + 1);
			if (index != -1) {
				/*
				 * if found, return
				 */
				return new int[] { i + 1, index + 1 };
			} else {
				/*
				 * since sorted, skip until next different number
				 */
				while (i + 1 < n && numbers[i + 1] == cur) {
					i++;
				}
			}
		}
		return null;
	}
}
