
public class _246_Strobogrammatic_Number {
	/*
	 * A strobogrammatic number is a number that looks the same when rotated 180
	 * degrees (looked at upside down).
	 * 
	 * Write a function to determine if a number is strobogrammatic. The number
	 * is represented as a string.
	 * 
	 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
	 */
	
	public boolean isStrobogrammatic(String num) {
		if (num == null) {
			return true;
		}
		int n = num.length();
		if (n == 0) {
			return true;
		}
		/*
		 * to char array for easy manipulation
		 */
		char[] numArr = num.toCharArray();

		for (int i = 0, j = n - 1; i <= j; i++, j--) {
			/*
			 * if any non strobogrammatic number, false
			 */
			if (numArr[i] > '1' && numArr[i] < '6' || numArr[i] == '7'
					|| numArr[j] > '1' && numArr[j] < '6' || numArr[j] == '7')
				return false;
			/*
			 * 69 96 pairs are valid
			 */
			if (numArr[i] == '6' && numArr[j] == '9'
					|| numArr[i] == '9' && numArr[j] == '6') {
				continue;
			}
			/*
			 * but single 6/9 is not valid
			 */
			if (numArr[i] != numArr[j] || (numArr[i] == numArr[j]
					&& (numArr[i] == '6' || numArr[i] == '9'))) {
				return false;
			}
		}
		return true;
	}

	public boolean isStrobogrammatic1(String num) {
		/*
		 * check inwards, pairs, string comparison, not very efficient
		 */
		for (int i = 0, j = num.length() - 1; i <= j; i++, j--)
			if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)))
				return false;
		return true;
	}
}
