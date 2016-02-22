import java.util.HashMap;

public class _146_LRU_Cache {

	class DoubleLinkedNode {
		/*
		 * store key is necessary since the double linked list should
		 * synchronize with the hash map, and to remove a node from both in
		 * O(1), a double linked node should know its key
		 */
		public int key;
		public int value;
		public DoubleLinkedNode pre;
		public DoubleLinkedNode next;

		public DoubleLinkedNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	class LRUCache {
		int capacity;
		/*
		 * hash map for get in O(1)
		 */
		HashMap<Integer, DoubleLinkedNode> map = new HashMap<Integer, DoubleLinkedNode>();
		/*
		 * double linked list for set in O(1)
		 */
		DoubleLinkedNode head = null;
		DoubleLinkedNode end = null;

		public LRUCache(int capacity) {
			this.capacity = capacity;
		}

		public int get(int key) {
			/*
			 * test if exists
			 */
			if (map.containsKey(key)) {
				/*
				 * get if exists
				 */
				DoubleLinkedNode n = map.get(key);
				/*
				 * get counted as used, move to head
				 */
				remove(n);
				setHead(n);

				return n.value;
			}

			return -1;
		}

		public void remove(DoubleLinkedNode n) {
			/*
			 * if head to be removed, move down head pointer
			 * otherwise let its previous's next pointer skip itself
			 */
			if (n.pre != null) {
				n.pre.next = n.next;
			} else {
				head = n.next;
			}

			/*
			 * if tail to be removed, move up end pointer
			 * otherwise let its next' previous pointer skip itself
			 */
			if (n.next != null) {
				n.next.pre = n.pre;
			} else {
				end = n.pre;
			}

		}

		public void setHead(DoubleLinkedNode n) {
			/*
			 * attach the new node to the list
			 */
			n.next = head;
			n.pre = null;

			/*
			 * old head's previous pointer to the new node
			 */
			if (head != null)
				head.pre = n;

			/*
			 * make the new node as the new head
			 */
			head = n;

			/*
			 * new nodes to be appended to the head
			 * end should be the very first head of any list
			 */
			if (end == null)
				end = head;
		}

		public void set(int key, int value) {
			if (map.containsKey(key)) {
				/*
				 * if exists, move up to head
				 */
				DoubleLinkedNode old = map.get(key);
				old.value = value;
				remove(old);
				setHead(old);
			} else {
				/*
				 * make one if not exists
				 */
				DoubleLinkedNode created = new DoubleLinkedNode(key, value);
				if (map.size() >= capacity) {
					/*
					 * end should be least used, remove from list and remove
					 * entry from map
					 */
					map.remove(end.key);
					remove(end);
				}
				/*
				 * make the new node as the new head
				 */
				setHead(created);
				/*
				 * add new entry to the map
				 */
				map.put(key, created);
			}
		}
	}
}
