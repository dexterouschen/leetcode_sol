import java.util.Arrays;
import java.util.Comparator;

import shared.Interval;

public class _252_Meeting_Rooms {
	/*
	 * Given an array of meeting time intervals consisting of start and end
	 * times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend
	 * all meetings.
	 * 
	 * For example,
	 * Given [[0, 30],[5, 10],[15, 20]],
	 * return false.
	 */

	public boolean canAttendMeetings(Interval[] intervals) {
		/*
		 * extract start times and end times, sort respectively
		 * and check in pairs from the earliest for overlap
		 */
		int len = intervals.length;
		if (len == 0) {
			return true;
		}
		int[] begin = new int[len];
		int[] stop = new int[len];
		for (int i = 0; i < len; i++) {
			begin[i] = intervals[i].start;
			stop[i] = intervals[i].end;
		}
		Arrays.sort(begin);
		Arrays.sort(stop);
		for (int i = 1; i < len; i++) {
			if (begin[i] < stop[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public boolean canAttendMeetings1(Interval[] intervals) {
		/*
		 * less efficient, sort by start and check in pairs for overlap
		 */
		if (intervals == null) {
			return true;
		}
		int n = intervals.length;
		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if (o1.start > o2.start) {
					return 1;
				} else if (o1.start < o2.start) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		for (int i = 0; i < n - 1; i++) {
			if (intervals[i].end > intervals[i + 1].start
					&& intervals[i].start < intervals[i + 1].end) {
				return false;
			}
		}
		return true;
	}

}
