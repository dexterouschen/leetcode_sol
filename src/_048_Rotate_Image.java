
public class _048_Rotate_Image {
	public static void rotate(int[][] matrix) {
		/*
		 * rotate every 4 elements on each edge
		 */
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = temp;
			}
		}
	}

	/*
	 * use an extra 2d array to hold the rotated matrix and copy back
	 */
	public void rotate1(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;

		int m = matrix.length;

		int[][] result = new int[m][m];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				result[j][m - 1 - i] = matrix[i][j];
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = result[i][j];
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };
		rotate(matrix);
	}
}
