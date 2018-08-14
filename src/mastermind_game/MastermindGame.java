package mastermind_game;

import java.util.ArrayList;
import java.util.Scanner;

public class MastermindGame {

	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);
		int randomNum = 100 + (int) (Math.random() * 999);
		//System.out.println(randomNum);

		for (int i = 1; i > 0; i++) {
			System.out.println("Enter Guess between 100 and 999: ");
			int guess = myScanner.nextInt();

			if (checkRange(guess)) {
				
				int difference = checkDigits(guess, randomNum);

				if (difference == 0) {
					System.out.println("Correct. It took you " + i + "guesses");
					break;
				}

				if (difference != 0) {
					System.out.println("incorrect by " + difference + " digits");
				}
			}else {System.out.println("number not it range");}
		}

	}

	private static int checkDigits(int guess, int randomNum) {
		int guessTemp = guess;
		ArrayList<Integer> guessArray = new ArrayList<Integer>();
		do {
			guessArray.add(guessTemp % 10);
			guessTemp /= 10;
		} while (guessTemp > 0);

		int randomTemp = randomNum;
		ArrayList<Integer> randomNumArray = new ArrayList<Integer>();
		do {
			randomNumArray.add(randomTemp % 10);
			randomTemp /= 10;
		} while (randomTemp > 0);

		int count = 0;

		if (guessArray == randomNumArray) {
			return count;
		} else {
			for (int i = 0; i < guessArray.size(); i++) {
				if (guessArray.get(i) != randomNumArray.get(i)) {
					count++;
				}
			}
			return count;
		}

	}

	private static boolean checkRange(int guess) {

		if (guess >= 100 && guess < 1000) {

			return true;
		}
		return false;

	}

}
