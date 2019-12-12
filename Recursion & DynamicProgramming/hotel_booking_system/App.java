package hotel_booking_system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App {  

	public static void main(String[] args) {

		// Read in the excel file and create a list of rooms
		FileUtils fu = new FileUtils();
		ArrayList<Room> roomArrayList = (ArrayList) fu.getRoomsFromExcel();
		
		// Create two arrays that will be used to compute the cheapest room
		ArrayList<Double> s = new ArrayList<>();
		ArrayList<Double> a = new ArrayList<>();
		
		// The array 's' contains the cheapest for N = 1,2,3,4 people etc. 
		int guests = 5;
		for(int i = 0; i <= guests; i++) {
			s.add(RoomUtils.cheapestRoomForNpersons(roomArrayList, i).getPriceForNPeople());
		}
		
		// The array 'a' contains the cheapest alternative solution when comparing with 's'
		// Calculate the cheapest for each index of 's' and 'a' and this is the result for that room
		
		a.add(s.get(0));
		a.add(s.get(1));

		for (int i = 2; i <= guests; i++) {
			a.add(cheapestOfsAnda(a, s, a.size()));
		}
		
		System.out.println("Cheapest for each room : " + a);
			
		}

	private static Double cheapestOfsAnda(ArrayList<Double> a, ArrayList<Double> s, int n) {
		
		ArrayList<Double> setOfResults = new ArrayList<>();
		
		// Create temp arrays with a[0] a[1] a[2] etc
		// Create temp arrays with s[3] a[2] a[1] etc
		
		ArrayList<Double> tempArrayA = new ArrayList<>();
		ArrayList<Double> tempArrayS = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			tempArrayA.add(a.get(i));
		}
		
		for(int i = n; i > 0; i--) {
			tempArrayS.add(s.get(i));
		}
		
		System.out.println("tempArrayA  : " + tempArrayA);
		System.out.println("tempArrayB  : " + tempArrayS);
		
		
		// Add together corresponding entries and add the totals to the setOfResults
		
		for (int i = 0; i < tempArrayA.size(); i++) {
			
			setOfResults.add(tempArrayA.get(i) + tempArrayS.get(i));
			
		}
		
		System.out.println("setOfResults : " + setOfResults);
		Collections.sort(setOfResults);
		System.out.println(" ");
		
		// Return cheapest from setOfResults
		return setOfResults.get(0);
	}

}

/*	SOLUTION: 
	Let s[n] denote the cheapest solution when we put n persons into one room. 

	s[1] = 75
	s[2] = 140
	s[3] = 225
	s[4] = 380

	And let a[n] denote the cheapest solution when we are dealing with a group of n persons. So, a[0] = 0, since that costs nothing.

	We get:

	a[0] = s[0] =  0
	
	a[1] = s[1]  = 75

	a[2] = cheapest of a[1] (75) + s[1] (75) = 150
	                   a[0] (0) + s[2] (140) = 140

	a[3] = cheapest of a[2] (140) + s[1] (75)  = 215
	                   a[1] (75)  + s[2] (140) = 215
	                   a[0] (0)   + s[3] (225) = 225

	a[4] = cheapest of a[3] (215) + s[1] (75)  = 290
	                   a[2] (140) + s[2] (140) = 280
	                   a[1] (75)  + s[3] (225) = 300
	                   a[0] (0)   + s[4] (380) = 380

	et cetera

	And since there is no s[5] and higher, we only have to consider the four steps as in a[4]:

	a[5] = cheapest of a[4] + s[1]
	                   a[3] + s[2]
	                   a[2] + s[3]
	                   a[1] + s[4]
*/