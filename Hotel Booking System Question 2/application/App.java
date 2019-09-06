package application;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

		int people = 7;
		
		// Tests for Room Creation
		Room doubleRoom_60861869 = new Room(60861869, "DOUBLE", 2, 2, 123, "pp");
		Room familyRoom_60861869 = new Room(60961873, "FAMILY", 2, 4, 400, "pu");

		// Tests for cost calculations
		System.out.println(RoomUtils.calculateCostPP(doubleRoom_60861869, people));
		System.out.println(RoomUtils.calculateCostPP(familyRoom_60861869, people));
		
		// Read in the excel file and create a list of rooms
		FileUtils fu = new FileUtils();
		List roomList = fu.getRoomsFromExcel();
		
		// Traverse the list for 1 guest to find the cheapest room
		
	}

}
