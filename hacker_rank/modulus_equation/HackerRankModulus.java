package modulus_equation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author kmk
 * 
 *         Output Format : 
 *         Output the value of A^B Mod X.
 *         If B is negative, it calculates (A^-1 Mod X)^b Mod X
 * 
 *         https://www.hackerrank.com/challenges/littlepandapower
 *
 */

public class HackerRankModulus {

	public static void main(String[] args) {

		System.out.println("test");
		String s1 = "1";

		s1.concat("3");
		System.out.println(s1);

		Scanner myScan = new Scanner(System.in);

		double iterations = 1;

		double A = 0;
		long B = 0;
		double X = 0;

		for (int i = 0; i < iterations; i++) {

			System.out.println("A : ");
			A = myScan.nextDouble();
			System.out.println("B : ");
			B = myScan.nextLong(); // must stay type long to convert to binary
			System.out.println("X : ");
			X = myScan.nextDouble();

			if (B >= 0) {
				double answer = positiveModulus(A, B, X);
				System.out.println((long) answer);
			}

			if (B == -1) {
				double inverse = AInverseModX(A, X);
				System.out.println((long) inverse);
			}

			if (B < -1) {
				double inverse = AInverseModX(A, X);
				double answer = positiveModulus(inverse, B, X);
				System.out.println((long) answer);
			}

			/*
			 //Alternate Method: A^-B mod X <==> (A^(b+1))*(A^-1) mod X
			 
			 if(B < -1){ //For testing purposes :
			 System.out.println("calculating mod of " + A + " to power " +
			 (B-1) + " mod " + X); System.out.println("Answer is: "+
			 positiveModulus(A, Math.abs(B-1), X));
			 System.out.println("calculating inverse of " + A + " mod" + X);
			 System.out.println("Answer is: "+ AInverseModX(A, X)); double mod
			 = positiveModulus(A, Math.abs(B-1), X); double inverse =
			 AInverseModX(A, X); double answer = (mod*inverse) % X;
			 System.out.println((long)answer); }*/
			 
		}
	}

	public static double positiveModulus(double A, long B, double X) {

		// Convert power (B) to binary string and reverse binary string

		StringBuilder sb = new StringBuilder(Long.toBinaryString(B));
		sb = sb.reverse();
		String s = sb.toString();

		// Convert binary string to Array

		int[] binaryArray = new int[s.length()];
		for (int i = 0; i < binaryArray.length; i++) {
			binaryArray[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
		}

		// create an ArrayList with numbers that correspond to 1's in the binary
		// array

		ArrayList<Double> arraylist = new ArrayList<Double>();

		if (binaryArray[0] == 1) {
			arraylist.add(A);
		}

		double temp = A;

		for (int i = 1; i < binaryArray.length; i++) {

			if (binaryArray[i] == 0) {
				temp = (temp * temp) % X;
			}
			if (binaryArray[i] == 1) {
				temp = (temp * temp) % X;
				arraylist.add(temp);
			}

		}

		// multiple all the values of the arraylist and MOD by X

		double multipleSum = 1;

		for (int i = 0; i < arraylist.size(); i++) {
			multipleSum = (multipleSum) * ((double) arraylist.get(i));
		}
		return multipleSum % X;
	}

	public static double AInverseModX(double Aa, double Xx) {

		BigDecimal decimalA = BigDecimal.valueOf(Aa);
		BigDecimal decimalX = BigDecimal.valueOf(Xx);

		BigInteger A, X, inverse;

		A = decimalA.toBigInteger();
		X = decimalX.toBigInteger();

		inverse = A.modInverse(X);

		double inverseDouble = inverse.doubleValue();
		return inverseDouble;
	}

}