package interview_exam;

public class Q1_submission {

	public static void main(String[] args) {

		String[] myStrArray = { "a" };

		String[] myStrArray2 = { "a" };

		System.out.println(sameContents(myStrArray, myStrArray2));
	}

	static boolean sameContents(String[] a, String[] b) {

		if (a.length != b.length) {

			return false;

		} else {

			for (int i = 0; i < a.length; i++) {
				if (!(a[i].equals(b[i]))) {
					return false;
				}

			}

			return true;
		}
	}
}