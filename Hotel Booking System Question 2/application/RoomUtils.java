package application;

public class RoomUtils {
	
	public static double calculateCostPP(Room room, int people){
		
		if(room.getPriceModel() == "pp") {
			return room.getPrice();
		}
		
		if(room.getPriceModel() == "pu") {
			return (room.getPrice() / people);
		}
		
		return 0;
		
	}
	
	

}
