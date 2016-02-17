import java.util.HashMap;
import java.util.Map;

public class _325_Maximum_Size_Subarray_Sum_Equals_k {
	public static int maxSubArrayLen(int[] nums, int k) {
		if (nums == null)
			return 0;
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		/*
		 * only one, if not, 0
		 */
		if (n == 1) {
			if (nums[0] == k)
				return 1;
			return 0;
		}
		/*
		 * dynamic programming, get each sum up to each index
		 */
		int[] sum = new int[n + 1];
		sum[0] = 0;
		for (int i = 1; i < n + 1; i++) {
			sum[i] = sum[i - 1] + nums[i - 1];
		}
		/*
		 * hash(sum, index)
		 */
		Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
		for (int i = 0; i < n + 1; i++) {
			hashtable.put(sum[i], i);
		}
		/*
		 * sum[j]-sum[i]=k, sum[j] includes sum[i]
		 */
		int max = 0;
		for (int i = 0; i < n + 1; i++) {
			Integer c = hashtable.get(sum[i] + k);
			if (c != null && c.intValue() > i && c.intValue() - i > max)
				max = c.intValue() - i;
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 0, -1, 1 };
		System.out.println(maxSubArrayLen(nums, 0));
	}
}
