package extra_long_factorials;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class ExtraLongFactorials {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter Number :");
		int n = scanner.nextInt();
		extraLongFactorials(n);

		scanner.close();

	}

	private static void extraLongFactorials(int n) {

		BigInteger mybigIntegerVal = new BigInteger("1");

		// Loop doesn't need to be a big integer
		for (int i = 1; i <= n; i++) {

			// BigIntigers can be overwritten in this way (i + "") ensures its a String
			mybigIntegerVal = mybigIntegerVal.multiply(new BigInteger(i + ""));
		}

		System.out.println(mybigIntegerVal.toString());

	}
}
