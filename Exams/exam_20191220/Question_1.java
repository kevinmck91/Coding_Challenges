package exam_20191220;

import java.util.ArrayList;
import java.util.List;

public class Question_1 {

	public static void main(String[] args) {
		
		String[] A = {"co", "dil", "ity"};
		
		solution(A);
	}

	public static int solution(String[] A) {

		// Get all possible combinations for string
		List<String> al = new ArrayList<String>();
		List<String> al2 = new ArrayList<String>();
		
		String str = "";
		
		for(int i = 0; i < A.length - 1; i++) {
			
			for(int j = i; j < A.length; j++) {
				str += A[j];
				al.add(str);
			}
			
			al2.add(str);
		}
		
		System.out.println(al);
		System.out.println(al2);
		
		return 0;
	}

}
