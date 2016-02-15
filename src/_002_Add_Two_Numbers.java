import shared.ListNode;

public class _002_Add_Two_Numbers {
	/*
	 * You are given two linked lists representing two non-negative numbers. The
	 * digits are stored in reverse order and each of their nodes contain a
	 * single digit. Add the two numbers and return it as a linked list.
	 *
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * Output: 7 -> 0 -> 8
	 */

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null, prev = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			// get current digit from l1
			int v1 = l1 != null ? l1.val : 0;
			// get current digit from l2
			int v2 = l2 != null ? l2.val : 0;
			// sum up total for current digit
			int tmp = v1 + v2 + carry;
			// calculate carry
			carry = tmp / 10;
			// leave out current digit
			int val = tmp % 10;
			// make a node out of current digit
			ListNode cur = new ListNode(val);

			// if no head (means first)
			if (head == null) {
				// then assign this cur
				head = cur;
			}
			// if already prev node
			if (prev != null) {
				// then link this cur to prev
				prev.next = cur;
			}
			// point prev to tail(cur)
			prev = cur;
			// move forward pointers if exists
			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}

		// if still carry after process
		if (carry > 0) {
			// then make a node out of carry
			ListNode l = new ListNode(carry);
			// append
			prev.next = l;
		}
		// return head
		return head;
	}

	public static void main(String[] args) {

	}
}
