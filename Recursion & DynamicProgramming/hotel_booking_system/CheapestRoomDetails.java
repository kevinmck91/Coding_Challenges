package hotel_booking_system;

public class CheapestRoomDetails {

	private double RoomReference;
	private double numberOfPeople;
	private double pricePerPerson;
	private double priceForNPeople;
	private double maxPeopleAllowed;
	private double minPeopleAllowed;

	//Constructor to set all the needed fields
	public CheapestRoomDetails(double roomReference, double numberOfPeople, double price, double maxPeopleAllowed,
			double minPeopleAllowed) {

		this.RoomReference = roomReference;
		this.numberOfPeople = numberOfPeople;
		this.pricePerPerson = price;
		this.priceForNPeople = price * numberOfPeople;
		this.maxPeopleAllowed = maxPeopleAllowed;
		this.minPeopleAllowed = minPeopleAllowed;
	}

	//toString
	public String toString() {
		return "CheapestRoomDetails [RoomReference=" + RoomReference + ", numberOfPeople=" + numberOfPeople
				+ ", pricePerPerson=" + pricePerPerson + ", priceForNPeople=" + priceForNPeople + ", maxPeopleAllowed="
				+ maxPeopleAllowed + ", minPeopleAllowed=" + minPeopleAllowed + "]";
	}

	public double getRoomReference() {
		return RoomReference;
	}

	public void setRoomReference(double roomReference) {
		RoomReference = roomReference;
	}

	public double getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(double numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public double getPriceForNPeople() {
		return priceForNPeople;
	}

	public void setPriceForNPeople(double priceForNPeople) {
		this.priceForNPeople = priceForNPeople;
	}

	public double getMaxPeopleAllowed() {
		return maxPeopleAllowed;
	}

	public void setMaxPeopleAllowed(double maxPeopleAllowed) {
		this.maxPeopleAllowed = maxPeopleAllowed;
	}

	public double getMinPeopleAllowed() {
		return minPeopleAllowed;
	}

	public void setMinPeopleAllowed(double minPeopleAllowed) {
		this.minPeopleAllowed = minPeopleAllowed;
	}

	public double getPricePerPerson() {
		return pricePerPerson;
	}

	public void setPricePerPerson(double pricePerPerson) {
		this.pricePerPerson = pricePerPerson;
	}

}
