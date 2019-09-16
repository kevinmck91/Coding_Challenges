package hotel_booking_system;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

		// Read in the excel file and create a list of rooms
		FileUtils fu = new FileUtils();
		ArrayList<Room> roomArrayList = (ArrayList) fu.getRoomsFromExcel();
		
		
		//	System.out.println(RoomUtils.cheapestRoomForNpersons(roomArrayList, 0).toString());
		//	System.out.println(RoomUtils.cheapestRoomForNpersons(roomArrayList, 4).getPriceForNPeople());

		
		// Traverse the list for N guests (between 1 and 4) to find the cheapest room for each
		int guests = 4;
		
		double[] s = new double[guests + 1];
		double[] a = new double[guests + 1];
		
		
		for(int i = 0; i <= guests; i++) {
			s[i] = RoomUtils.cheapestRoomForNpersons(roomArrayList, i).getPriceForNPeople();
		}
		
		a[0] = s[0];
		a[1] = s[1];
		 //To Be finished
		
			
		}
		
		
/*		SOLUTION: 
 		Let s[n] denote the cheapest solution when we put n persons into one room. 

			s[1] = 75
			s[2] = 140
			s[3] = 225
			s[4] = 380

			And let a[n] denote the cheapest solution when we are dealing with a group of n persons. So, a[0] = 0, since that costs nothing.

			We get:

			a[0] = s[0] =  0
			
			a[1] = s[1]  = 75

			a[2] = cheapest of a[1] + s[1] = 215
			                   a[0] + s[2] = 140

			a[3] = cheapest of a[2] + s[1] = 215
			                   a[1] + s[2] = 215
			                   a[0] + s[3] = 225

			a[4] = cheapest of a[3] + s[1] = 290
			                   a[2] + s[2] = 280
			                   a[1] + s[3] = 290
			                   a[0] + s[4] = 380

			et cetera

			And since there is no s[5] and higher, we only have to consider the four steps as in a[4]:

			a[5] = cheapest of a[4] + s[1]
			                   a[3] + s[2]
			                   a[2] + s[3]
			                   a[1] + s[4]
*/
		
		

}
