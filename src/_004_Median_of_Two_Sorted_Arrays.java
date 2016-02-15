
public class _004_Median_of_Two_Sorted_Arrays {

	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length, n = B.length;
		return findMedianSortedArrays(A, m, B, n);
	}

	private double findMedianSortedArrays(int A[], int m, int B[], int n) {
		int[] C = new int[m + n];
		int im = 0;
		int in = 0;
		while (im < m && in < n) {
			if (A[im] <= B[in]) {
				im++;
				C[im + in - 1] = A[im - 1];
			} else {
				in++;
				C[im + in - 1] = B[in - 1];
			}
		}
		if (im < m) {
			for (; im < m; im++) {
				C[im + in] = A[im];
			}
		} else if (in < n) {
			for (; in < n; in++) {
				C[im + in] = B[in];
			}
		}
		if ((m + n) % 2 == 0)
			return ((float) C[(m + n) / 2] + C[(m + n - 1) / 2]) / 2;
		else
			return C[(m + n) / 2];
	}

	public double findMedianSortedArrays1(int[] A, int[] B) {
		int m = A.length, n = B.length;
		int l = (m + n + 1) / 2;
		int r = (m + n + 2) / 2;
		return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
	}

	public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
		if (aStart > A.length - 1)
			return B[bStart + k - 1];
		if (bStart > B.length - 1)
			return A[aStart + k - 1];
		if (k == 1)
			return Math.min(A[aStart], B[bStart]);

		int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
		if (aStart + k / 2 - 1 < A.length)
			aMid = A[aStart + k / 2 - 1];
		if (bStart + k / 2 - 1 < B.length)
			bMid = B[bStart + k / 2 - 1];

		if (aMid < bMid)
			// Check: aRight + bLeft
			return getkth(A, aStart + k / 2, B, bStart, k - k / 2);

		else
			// Check: bRight + aLeft
			return getkth(A, aStart, B, bStart + k / 2, k - k / 2);

	}
}
