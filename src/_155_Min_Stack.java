import java.util.ArrayList;
import java.util.List;

public class _155_Min_Stack {
	/*
	 * Design a stack that supports push, pop, top, and retrieving the minimum
	 * element in constant time.
	 * 
	 * push(x) -- Push element x onto stack.
	 * pop() -- Removes the element on top of the stack.
	 * top() -- Get the top element.
	 * getMin() -- Retrieve the minimum element in the stack.
	 */
	
	/*
	 * separate stack for keeping track of minimum values
	 */
	List<Integer> arr = new ArrayList<Integer>();
	List<Integer> min = new ArrayList<Integer>();

	public void push(int x) {
		arr.add(x);
		if (min.size() == 0) {
			/*
			 * first value is the minimum
			 */
			min.add(x);
		} else {
			/*
			 * if new element is no more than current minimum
			 * add new minimum (equal should be counted too)
			 */
			if (x <= min.get(min.size() - 1).intValue()) {
				min.add(x);
			}
		}
	}

	public void pop() {
		if (arr.size() > 0) {
			/*
			 * get current top and current minimum
			 * if equal, means a minimum is popped out
			 * so pop out current minimum too
			 */
			int num = arr.get(arr.size() - 1);
			int cmin = min.get(min.size() - 1);
			if (num == cmin) {
				min.remove(min.size() - 1);
			}
			/*
			 * pop out current top
			 */
			arr.remove(arr.size() - 1);
		}
	}

	public int top() {
		return arr.get(arr.size() - 1);
	}

	public int getMin() {
		return min.get(min.size() - 1);
	}

	public static void main(String[] args) {
		_155_Min_Stack stack = new _155_Min_Stack();
		stack.push(-1);
		System.out.println(stack.top());
		System.out.println(stack.getMin());
	}
}
