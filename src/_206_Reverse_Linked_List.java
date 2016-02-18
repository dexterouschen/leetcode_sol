import shared.ListNode;

public class _206_Reverse_Linked_List {
	/*
	 * Reverse a singly linked list.
	 */
	public ListNode reverseList(ListNode head) {
		/*
		 * one node, no need
		 */
		if (head == null || head.next == null)
			return head;
		/*
		 * two pointers, one node away
		 */
		ListNode p1 = head;
		ListNode p2 = head.next;
		/*
		 * detach current head
		 */
		head.next = null;
		while (p1 != null && p2 != null) {
			/*
			 * third pointer to hold the rest
			 */
			ListNode t = p2.next;
			/*
			 * point back
			 */
			p2.next = p1;
			/*
			 * move forward first pointer
			 */
			p1 = p2;
			if (t != null) {
				/*
				 * if possible, second pointer take over the rest
				 */
				p2 = t;
			} else {
				/*
				 * 
				 */
				break;
			}
		}

		return p2;
	}
}
