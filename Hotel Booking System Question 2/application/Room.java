package application;

public class Room {

	private double 	reference;
	private String 	roomType;
	private double		minGuests;
	private double		maxGuests;
	private	double		price;
	private	double 	pricePU;
	private	double		pricePP;
	private	String	priceModel;
	
	public Room(double reference, String roomType, double minGuests, double maxGuests, double price, String priceModel) {
		this.reference = reference;
		this.roomType = roomType;
		this.minGuests = minGuests;
		this.maxGuests = maxGuests;
		this.price = price;
		this.priceModel = priceModel;
		
		if(priceModel.equals("pu")) {
			this.pricePU = price;
		}
		if(priceModel.equals("pp")) {
			this.pricePP = price;
		}
	}

	public double getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getMinGuests() {
		return minGuests;
	}

	public void setMinGuests(int minGuests) {
		this.minGuests = minGuests;
	}

	public double getMaxGuests() {
		return maxGuests;
	}

	public void setMaxGuests(int maxGuests) {
		this.maxGuests = maxGuests;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getPricePU() {
		return pricePU;
	}

	public void setPricePU(int pricePU) {
		this.pricePU = pricePU;
	}

	public double getPricePP() {
		return pricePP;
	}

	public void setPricePP(int pricePP) {
		this.pricePP = pricePP;
	}

	public String getPriceModel() {
		return priceModel;
	}

	public void setPriceModel(String priceModel) {
		this.priceModel = priceModel;
	}
	
	
	
}
