import java.util.ArrayList;
import java.util.List;

public class _20_Valid_Parentheses {
	/*
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * The brackets must close in the correct order, "()" and "()[]{}" are all
	 * valid but "(]" and "([)]" are not.
	 */
	public boolean isValid(String s) {
		List<Character> stack = new ArrayList<>();
		/*
		 * to char array for easy manipulation
		 */
		char[] chars = s.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			char cur = chars[i];
			/*
			 * if not match or right appears but left hasn't yet, false
			 */
			switch (cur) {
			case '}':
				if (stack.isEmpty() || stack.remove(stack.size() - 1) != '{')
					return false;
				break;
			case ']':
				if (stack.isEmpty() || stack.remove(stack.size() - 1) != '[')
					return false;
				break;
			case ')':
				if (stack.isEmpty() || stack.remove(stack.size() - 1) != '(')
					return false;
				break;
			default:
				stack.add(cur);
				break;
			}
		}
		/*
		 * if any haven't matched, false
		 */
		return stack.isEmpty();
	}
}
