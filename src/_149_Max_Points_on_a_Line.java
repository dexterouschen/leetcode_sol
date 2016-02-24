import shared.Point;

public class _149_Max_Points_on_a_Line {
	/*
	 * Given n points on a 2D plane, find the maximum number of points that lie
	 * on the same straight line.
	 */
	public int maxPoints(Point[] points) {
		int n = points.length;
		/*
		 * two points form a line
		 */
		if (n < 2)
			return n;
		int currentL = 0, maxL = 2, x = 0, y = 0, dx = 0, dy = 0, overlap = 0,
				upperB = n;
		for (int i = 0; i < upperB; i++) {
			for (int j = i + 1; j < n; j++) {
				currentL = 1;
				/*
				 * Given two points: (a,b) and (c,d), the corresponding normal
				 * vector is (b-d,c-a)
				 * If another point (s,t) is in the same line uniquely defined
				 * by (a,b) and (c,d),
				 * then (s-a,t-b) dot (b-d,c-a) = 0
				 */
				x = points[i].y - points[j].y;
				y = points[j].x - points[i].x;

				/*
				 * If two points are the same, there is no need to check
				 * further,
				 * since a line has to be defined by exactly two distinct
				 * points.
				 */
				if (x == 0 && y == 0)
					overlap++;

				/*
				 * Well, it might be the case that duplicates are not
				 * consecutive,
				 * but as long as we can have a non-trivial normal vector, it
				 * won't matter.
				 */
				else {
					currentL++;

					/*
					 * Explaining (currentL+n-k>maxL):
					 * no further checking is necessary when there isn't enough
					 * left to make it surpass maxL.
					 */
					for (int k = j + 1; k < n && currentL + n - k > maxL; k++) {
						dx = points[k].x - points[i].x;
						dy = points[k].y - points[i].y;
						if (x * dx + y * dy == 0)
							currentL++;
					}
				}
				maxL = Math.max(currentL + overlap, maxL);
			}

			/*
			 * Explaining (upperB=n-maxL):
			 * it would be crystal clear as soon as you draw a table for
			 * combinations of case n>3.
			 */
			upperB = n - maxL;
			overlap = 0;
		}
		return maxL;
	}
}
