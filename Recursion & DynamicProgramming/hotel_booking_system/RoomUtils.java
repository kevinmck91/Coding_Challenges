package hotel_booking_system;

import java.util.ArrayList;

public class RoomUtils {

	public static double calculateCostPP(Room room, int people) {

		if (room.getPriceModel() == "pp") {
			return room.getPrice();
		}

		if (room.getPriceModel() == "pu") {
			return (room.getPrice() / people);
		}

		return 0;

	}

	// Calculate cheapest room for N people
	public static CheapestRoomDetails cheapestRoomForNpersons(ArrayList<Room> roomArrayList, double n) {

		boolean cheapsetRoomSet = false;
		double cheapestPrice = 0;
		double cheapestRoomReference = 0;
		double minPeople = 0;
		double maxPeople = 0;

		for (int i = 0; i < roomArrayList.size(); i++) {

			// Find the first cheapest room and set the cheapest price
			// N has to be between the Room min and max

			if (roomArrayList.get(i).getMinGuests() <= n && roomArrayList.get(i).getMaxGuests() >= n && cheapsetRoomSet == false) {
				cheapestPrice = roomArrayList.get(i).getPrice();
				cheapestRoomReference = roomArrayList.get(i).getReference();
				maxPeople = roomArrayList.get(i).getMaxGuests();
				minPeople = roomArrayList.get(i).getMinGuests();
				cheapsetRoomSet = true;
				continue;
			}

			// Check if there is a cheaper room and if so, set that to the cheapest price
			if (roomArrayList.get(i).getMinGuests() <= n && roomArrayList.get(i).getMaxGuests() >= n && cheapsetRoomSet == true) {

				if (roomArrayList.get(i).getPrice() < cheapestPrice) {
					cheapestPrice = roomArrayList.get(i).getPrice();
					cheapestRoomReference = roomArrayList.get(i).getReference();
					maxPeople = roomArrayList.get(i).getMaxGuests();
					minPeople = roomArrayList.get(i).getMinGuests();
				}

			}

		}

		//When the cheapest room has been found, return an object with all the details.
		return new CheapestRoomDetails(cheapestRoomReference, n, cheapestPrice, maxPeople, minPeople);

	}

}
