import java.util.ArrayList;
import java.util.List;

public class _293_Flip_Game {
	/*
	 * You are playing the following Flip Game with your friend: Given a string
	 * that contains only these two characters: + and -, you and your friend
	 * take turns to flip two consecutive "++" into "--". The game ends when a
	 * person can no longer make a move and therefore the other person will be
	 * the winner.
	 * 
	 * Write a function to compute all possible states of the string after one
	 * valid move.
	 * 
	 * For example, given s = "++++", after one move, it may become one of the
	 * following states:
	 * 
	 * [
	 * "--++",
	 * "+--+",
	 * "++--"
	 * ]
	 * If there is no valid move, return an empty list [].
	 */

	public static List<String> generatePossibleNextMoves(String s) {
		/*
		 * Simply manipulate the converted char array
		 * temporarily flip each possible pair and generate a new result
		 * then flip them back
		 */
		char[] c = s.toCharArray();
		int n = c.length;
		List<String> res = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			if (c[i] == '+' && c[i - 1] == '+') {
				c[i] = '-';
				c[i - 1] = '-';
				res.add(new String(c));
				c[i] = '+';
				c[i - 1] = '+';
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(generatePossibleNextMoves("++--++"));
	}
}
