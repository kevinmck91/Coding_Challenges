package exam_20191213;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class Question1 {

	public static void main(String[] args) {

		/** 
		 *  Sort a list of dates in ascending order. Each Date is in the string format "dd mmm yyyy"
		 *  
		 */

		String[] stringArray3 = new String[]{
				"02 SEP 1875", 
				"12 JAN 1875",
				"22 MAR 1875",
				"31 JAN 1991",
				"01 MAR 1919",
				"11 JAN 1916",
				"21 JUN 1840",
				"30 JAN 2007",
				"05 AUG 2049",
				"19 JAN 2000"
				};
		
		// Convert dates into sortable strings and add to ArrayList
		
		SimpleDateFormat inputFormatter = 	new SimpleDateFormat("dd MMM yyyy");
		SimpleDateFormat outputFormatter = 	new SimpleDateFormat("yyyyMMdd");
		
		ArrayList<String> arrayList = new ArrayList();
		
		for (String string : stringArray3) {
			
			Date myDate = new Date();
			
			try {
				myDate = inputFormatter.parse(string);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			arrayList.add(outputFormatter.format(myDate));
				
		}
		
		Collections.sort(arrayList);
		
		// Convert Sorted strings back into dates
		inputFormatter = 	new SimpleDateFormat("yyyyMMdd");
		outputFormatter = 	new SimpleDateFormat("dd MMM yyyy");
		
		for (String string : arrayList) {
			
			Date myDate2 = new Date();
			
			try {
				myDate2 = inputFormatter.parse(string);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			System.out.println(outputFormatter.format(myDate2));
			
		}
		
		

	}

}
