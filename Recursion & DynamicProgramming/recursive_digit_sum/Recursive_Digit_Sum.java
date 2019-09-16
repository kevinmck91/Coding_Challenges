package recursive_digit_sum;

public class Recursive_Digit_Sum {

	public static void main(String[] args) {

		String n = "9999998";
		int k = 1;

		System.out.println(superDigit(n, k));

	}

	static int superDigit(String n, int k) {

		int x = 0;

		if (k == 0) {
			return 0;
		}

		if (n.length() > 1 || k > 1) {

			StringBuilder s = new StringBuilder(n);

			// Create the combined String
			for (int i = 1; i < k; i++) {
				s.append(n);
			}

			// Add up the Digits and store as int (BigInteger for completeness)
			for (int i = 0; i < s.length(); i++) {
				x += s.charAt(i) - '0';
			}

			// Base Case
			if (Integer.toString(x).length() == 1) {
				return x;
			}

			int str = superDigit(Integer.toString(x), 1);

			return str;

		}

		return Integer.valueOf(n);

	}

}
