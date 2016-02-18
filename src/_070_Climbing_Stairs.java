
public class _070_Climbing_Stairs {
	/*
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 *
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways
	 * can you climb to the top?
	 */
	public static int climbStairs(int n) {
		/*
		 * 1 stair, 1 way, 2 stairs 2 ways
		 */
		if (n < 3)
			return n;

		int[] ans = new int[3];
		ans[0] = 1;
		ans[1] = 1;
		/*
		 * dp[n] = dp[n-1] + dp[n-2], to get to n,
		 * either 1 step from n-1 or 2 steps from n-2
		 */
		for (int i = 2; i <= n; i++) {
			/*
			 * reuse space
			 */
			ans[i % 3] = ans[(i - 1) % 3] + ans[(i - 2) % 3];
		}
		return ans[n % 3];
	}

	public int climbStairs1(int n) {
		if (n < 3)
			return n;
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1; // 1 stair 1 way
		dp[2] = 2; // 2 stairs 2 ways

		for (int i = 3; i < n + 1; i++) {
			/*
			 * normal space use
			 */
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public int climbStairs2(int n) {
		if (n < 4)
			return n;
		int a = 2, b = 3, c = 5;
		for (int i = 5; i <= n; i++) {
			a = c;
			c = b + c;
			b = a;
		}
		return c;
	}

	public static void main(String[] args) {
		climbStairs(10);
	}
}
