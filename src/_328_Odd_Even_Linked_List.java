import shared.ListNode;

public class _328_Odd_Even_Linked_List {
	public static ListNode oddEvenList(ListNode head) {
		if (head != null) {
			/*
			 * pointers for odd/even nodes respectively
			 * extra pointer for head of even sublist
			 */
			ListNode odd = head, even = head.next, evenHead = even;

			while (even != null && even.next != null) {
				/*
				 * take turns to move forward pointers
				 * based on the other side
				 */
				odd.next = odd.next.next;
				even.next = even.next.next;
				odd = odd.next;
				even = even.next;
			}
			/*
			 * connect even sublist
			 */
			odd.next = evenHead;
		}
		/*
		 * since in place, head
		 */
		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);

		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		oddEvenList(l1);
	}
}
