package exam_20181113;

/**
 * Given 3 inputs, Check if the triangle is valid
 * 
 */

public class Question_1 {

	public static void main(String[] args) {

		int a = 100;
		int b = 90;
		int c = 200;

		System.out.println(triangle(a, b, c));

	}

	private static int triangle(int a, int b, int c) {

		if (a <= 0 || b <= 0 || c <= 0) {
			return 0;
		}

		if (a == b && b == c) {
			return 1;
		}

		if (a + b > c && a + c > b && c + b > a) {
			return 2;
		} else {
			return 0;
		}
	}
}
