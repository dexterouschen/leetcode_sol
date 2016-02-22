import shared.ListNode;

public class _023_Merge_k_Sorted_Lists {
	ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		/*
		 * recursively
		 */
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		if (l1.val < l2.val) {
			/*
			 * let l1 head be the "current", connect recursive result and return
			 */
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			/*
			 * let l2 head be the "current", connect recursive result and return
			 */
			l2.next = mergeTwoLists(l2.next, l1);
			return l2;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		return mergeKLists(lists, 0, lists.length - 1);
	}

	private ListNode mergeKLists(ListNode[] lists, int start, int end) {
		if (start == end) {
			return lists[start];
		} else if (start < end) {
			int mid = (end - start) / 2 + start;
			ListNode left = mergeKLists(lists, start, mid);
			ListNode right = mergeKLists(lists, mid + 1, end);
			return mergeTwoLists(left, right);
		} else {
			return null;
		}
	}

}
