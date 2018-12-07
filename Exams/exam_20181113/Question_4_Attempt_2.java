package exam_20181113;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

	/**
	 * Not finished
	 */

public class Question_4_Attempt_2 {

	public static void main(String[] args) {

		String keywords = "location breakfast beach citycenter metro view staff price dog";

		List<Integer> hotel_ids = new ArrayList<>();
		hotel_ids.add(1);
		hotel_ids.add(2);
		hotel_ids.add(1);
		hotel_ids.add(3);
		hotel_ids.add(2);

		List<String> reviews = new ArrayList<>();
		reviews.add("This hotel has a nice view of the citycenter. The location is perfect.");
		reviews.add("The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.");
		reviews.add("Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.");
		reviews.add("They said I couldn't take my dog and there were other guests with dogs! That is not fair.");
		reviews.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");

		sort_hotels(keywords, hotel_ids, reviews);

	}

	private static void sort_hotels(String keywords, List<Integer> hotel_ids,	List<String> reviews) {

		String[] arrayofkeywords = keywords.split("[\\s\\p{Blank}\\p{Punct}\\W]+");
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		
		for (String keyWordToCheck : arrayofkeywords) {
			
			for(int i = 0; i <hotel_ids.size(); i++){
				
				int count = 0;
				
				String[] reviewSeperated = reviews.get(i).toLowerCase().split("[\\s\\p{Blank}\\p{Punct}\\W]+");
				
				for (String string : reviewSeperated) {
					
					if(string.equals(keyWordToCheck)){
						count++;
					}
					
				}
				
				if(hashmap.containsKey(hotel_ids.get(i))){
					int number = hotel_ids.get(i);
					number += count;
					hashmap.put(hotel_ids.get(i), number);
				} else {
					hashmap.put(hotel_ids.get(i), count);
				}
				
				
				
			}
			
		}
		System.out.println(hashmap);
	}


}
