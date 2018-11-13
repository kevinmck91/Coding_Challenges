package exam_20181113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Question_4 {

	public static void main(String[] args) {

		String keywords = "breakfast beach citycenter location metro view staff price";

		List<Integer> hotel_ids = new ArrayList<>();
		hotel_ids.add(1);
		hotel_ids.add(2);
		hotel_ids.add(1);
		hotel_ids.add(1);
		hotel_ids.add(2);

		List<String> reviews = new ArrayList<>();
		reviews.add("This hotel has a nice view of the citycenter. The location is perfect.");
		reviews.add("Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.");
		reviews.add("They said I couldn't take my dog and there were other guests with dogs! That is not fair.");
		reviews.add("The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.");
		reviews.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");

		sort_hotels(keywords, hotel_ids, reviews);

	}

	static List<Integer> sort_hotels(String keywords, List<Integer> hotel_ids,	List<String> reviews) {
		
		// Split the String into word array
		String[] keyWordArray = keywords.split("\\s+");
		
		ArrayList<Integer> hotelIds_AL = new ArrayList<Integer>();
		ArrayList<String>  hotelReviews_AL = new ArrayList<String>();
		
		
		
		return hotel_ids;

	}

}
