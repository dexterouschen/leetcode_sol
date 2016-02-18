import shared.ListNode;

public class _21_Merge_Two_Sorted_Lists {

	/*
	 * Merge two sorted linked lists and return it as a new list. The new list
	 * should be made by splicing together the nodes of the first two lists.
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		/*
		 * make use of extra pointers to construct
		 */
		ListNode l = new ListNode(-1);
		ListNode p = l;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if (l1 != null) {
			p.next = l1;
		}
		if (l2 != null) {
			p.next = l2;
		}
		return l.next;
	}

}
