package exam_company1;
import java.util.*;

public class accenture {

	public static void main(String[] args) {

		try {
			
			String string = "100";
			 
			 double k = Double.parseDouble(string);
			 
            double result = Math.floor(Math.sqrt(k));
			 
			System.out.println((int)result);
			
		} catch (Exception e) {
		}
	}

}