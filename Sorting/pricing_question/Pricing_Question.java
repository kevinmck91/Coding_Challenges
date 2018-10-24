package pricing_question;

import java.util.ArrayList;
import java.util.Collections;

public class Pricing_Question {

	/**
	 * A person has only a certain amount to spend, and he wants to maximize the
	 * number of toys he buys with this money. Given a list of prices and an
	 * amount to spend, what is the maximum number of toys Mark can buy?
	 * 
	 * Eg. prices = [1,2,3,4] , k = 7 -> he can buy 3 toys and spend 6 euro
	 * Return the Max number of toys that can be bought.
	 * 
	 */
	public static void main(String[] args) {

		int[] array = { 3,7,6,9,3,6,9,3,7,9,6,3,6,9,0,5,4,8,0 };

		int k = 50;

		System.out.println(maximumToys(array, k));

	}

	static int maximumToys(int[] prices, int k) {

		ArrayList<Integer> arraylist1 = new ArrayList<>();

		for (int i : prices) {
			arraylist1.add(i);
		}

		Collections.sort(arraylist1);

		ArrayList<Integer> arraylist2 = new ArrayList<>();

		arraylist2.add(arraylist1.get(0));

		for (int i = 1; i < arraylist1.size(); i++) {

			int value = (arraylist2.get(i - 1) + arraylist1.get(i));

			if (value > k){
				break;
			}
			
			arraylist2.add(value);

		}
		System.out.println(arraylist2);

		return arraylist2.size();

	}

}
