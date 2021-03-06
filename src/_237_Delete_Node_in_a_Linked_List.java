import shared.ListNode;

public class _237_Delete_Node_in_a_Linked_List {

	/*
	 * Write a function to delete a node (except the tail) in a singly linked
	 * list, given only access to that node.
	 * 
	 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third
	 * node with value 3, the linked list should become 1 -> 2 -> 4 after
	 * calling your function.
	 */

	public void deleteNode(ListNode node) {
		/*
		 * Not necessary to traverse the list
		 * simply take what's next and connect the further elements to it
		 * 
		 * a -> b -> c, delete a, then a1 -> a2 -> c, then a1 -> c
		 * a -> b -> c, delete b, then a -> c1 -> c2, then a -> c1
		 * situation when c to be deleted is not considered according to description
		 */
		node.val = node.next.val;
	    node.next = node.next.next;
	}
}
