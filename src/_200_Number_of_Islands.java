
public class _200_Number_of_Islands {
	/*
	 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
	 * islands. An island is surrounded by water and is formed by connecting
	 * adjacent lands horizontally or vertically. You may assume all four edges
	 * of the grid are all surrounded by water.
	 * 
	 * Example 1:
	 * 
	 * 11110
	 * 11010
	 * 11000
	 * 00000
	 * 
	 * Answer: 1
	 * 
	 * Example 2:
	 * 
	 * 11000
	 * 11000
	 * 00100
	 * 00011
	 * 
	 * Answer: 3
	 */
	public static void DFS(char[][] grid, int i, int j, int m, int n) {
		/*
		 * if goes overboard, return
		 */
		if (i < 0 || i >= m || j < 0 || j >= n)
			return;
		/*
		 * recursively mark all adjacent 1's
		 */
		if (grid[i][j] == '1') {
			grid[i][j] = '2';
			DFS(grid, i + 1, j, m, n);
			DFS(grid, i - 1, j, m, n);
			DFS(grid, i, j + 1, m, n);
			DFS(grid, i, j - 1, m, n);
		}
	}

	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int row = grid.length, column = grid[0].length, count = 0;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++) {
				/*
				 * 1 encountered, start DFS
				 */
				if (grid[i][j] == '1') {
					count++;
					DFS(grid, i, j, row, column);
				}
			}
		return count;
	}
}
