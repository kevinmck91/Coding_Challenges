package exam_20181113;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

	/**
	 * 
	 * Given a list of Hotel Id's and corresponding list of customer reviews associated with each hotel,
	 * Determine which hotel is the best choice depending on search Terms entered 
	 * 
	 * TODO: Optimize using Maps 
	 * 
	 */

public class Question_4_Attempt_2 {

	public static void main(String[] args) {

		String searchTerms = "location breakfast beach citycenter metro view staff price dog";

		// Three possible hotels
		List<Integer> hotel_ids = new ArrayList<>();
		hotel_ids.add(1);
		hotel_ids.add(1);
		hotel_ids.add(2);
		hotel_ids.add(2);
		hotel_ids.add(3);

		// corresponding reviews for each hotel
		List<String> reviews = new ArrayList<>();
		reviews.add("This hotel has a nice view of the citycenter location. The location is perfect.");
		reviews.add("The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.");
		reviews.add("Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.");
		reviews.add("They said I couldn't take my dog and there were other guests with dogs! That is not fair.");
		reviews.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");

		sort_hotels(searchTerms, hotel_ids, reviews);

	}

	private static void sort_hotels(String searchTerms, List<Integer> hotel_ids, List<String> reviews) {

		// Split the search terms into a string array
		String[] arrayofkeywords = searchTerms.split("[\\s\\p{Blank}\\p{Punct}\\W]+");
		
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		
		// for each Search Term
		for (String keyWordToCheck : arrayofkeywords) {
			
			// take each hotel review
			for(int i = 0; i <hotel_ids.size(); i++){
				
				int count = 0;
				
				// split the review into a word array
				String[] reviewSeperated = reviews.get(i).toLowerCase().split("[\\s\\p{Blank}\\p{Punct}\\W]+");
				
				for (String string : reviewSeperated) {
					
					// count the number of occurrences 
					if(string.equals(keyWordToCheck)){
						count++;
					}
				}
				
				// update the hashmap accordingly
				if(hashmap.containsKey(hotel_ids.get(i))){
					int hotelID = hotel_ids.get(i);
					int totalOccurences = hashmap.get(hotelID);
					totalOccurences += count;
					hashmap.put(hotel_ids.get(i), totalOccurences);
				} else {
					hashmap.put(hotel_ids.get(i), count);
				}
			}
			
			// debugging
			// System.out.println("\n Checking review word += " + keyWordToCheck + " : " + hashmap);
			
		}
		System.out.println("{Hotel Id = number of Matching Words}");
		System.out.println(hashmap);
	}
}
