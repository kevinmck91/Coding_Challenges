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
		reviews.add("The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.");
		reviews.add("Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.");
		reviews.add("They said I couldn't take my dog and there were other guests with dogs! That is not fair.");
		reviews.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");

		sort_hotels(keywords, hotel_ids, reviews);

	}

	static List<Integer> sort_hotels(String keywords, List<Integer> hotel_ids,
			List<String> reviews) {

		// Split the String into word array
		String[] keyWordArray = keywords.split("\\s+");

		// Keep an ArrayList of all individual hotels
		List<Integer> individual_hotel_ids = new ArrayList<>();
		for (Integer integer : hotel_ids) {
			if (individual_hotel_ids.contains(integer)) {
				// do nothing
			} else {
				individual_hotel_ids.add(integer);
			}
		}
		System.out.println(individual_hotel_ids);

		// Create hashMap of the concat of each String
		Map<Integer, String> hotel_and_reviews = new LinkedHashMap<>();

		for (int i = 0; i < hotel_ids.size(); i++) {

			int hotelID = hotel_ids.get(i);

			if (hotel_and_reviews.containsKey(hotelID)) {
				String str = hotel_and_reviews.get(hotelID);
				String concat = reviews.get(i);
				str = str.concat(" " + concat);
				hotel_and_reviews.put(hotelID, str);
			} else {
				hotel_and_reviews.put(hotelID, reviews.get(i));
			}
		}

		System.out.println(hotel_and_reviews);

		// Do a word count of every word in each
		Map<Integer, Map<String, Integer>> specific_word_count = new LinkedHashMap<>();

		for (int i = 0; i < individual_hotel_ids.size(); i++) {

			String str = hotel_and_reviews.get(individual_hotel_ids.get(i));

			Map<String, Integer> hashMapTemp = new LinkedHashMap<>();
			hashMapTemp = createwordMap(str);

			specific_word_count.put(individual_hotel_ids.get(i), hashMapTemp);

		}
		System.out.println(" ");
		System.out.println(specific_word_count);
		System.out.println(" ");

		// Create hashMap for hotel Id and Total Count
		Map<Integer, Integer> hotelID_totalCount = new LinkedHashMap<>();

		// for every word in the KeyWordslist, for each hotel ID, find the
		// wordcount and add it to count.

		for (Integer hotelId : individual_hotel_ids) {

			int wordMatches = 0;
			
			for (String keyword : keyWordArray) {
				
				if(specific_word_count.get(hotelId).containsKey(keyword)){
				
					wordMatches += specific_word_count.get(hotelId).get(keyword);
					System.out.println(keyword + " " + wordMatches);
					
				}
				
				
				
			}
			hotelID_totalCount.put(hotelId, wordMatches);
		}
System.out.println(hotelID_totalCount);
		return hotel_ids;

	}

	private static Map<String, Integer> createwordMap(String str) {

		Map<String, Integer> hashMapTemp = new TreeMap<>();
		String[] word = str.split("[\\s\\p{Blank}\\p{Punct}\\W]+");

		int wordCount = word.length;

		for (String w : word) {
			w = w.toLowerCase();
			if (!hashMapTemp.containsKey(w)) {
				hashMapTemp.put(w, 1);
			} else {
				int value = hashMapTemp.get(w);
				value++;
				hashMapTemp.put(w, value);
			}
		}

		return hashMapTemp;
	}

}
