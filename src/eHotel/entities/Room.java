package eHotel.entities;

public class Room {
	
	private String room_no;
	private String room_status;
	private String customer_ssn;
	private String room_city;
	private double price;
	private boolean isextendable;
	private int capacity;
	private String damages;
	private String amenities;

	private int hotel_id;
	
	
	public Room() {
		
	}
	
	public Room(String room_no, String room_status, String room_city,double price,boolean isextendable,int capacity,String damages,String amenities,int hotel_id) {
		this.room_no = room_no;
		this.room_status = room_status;
		this.room_city = room_city;
		this.price= price;
		this.isextendable=isextendable;
		this.capacity=capacity;
		this.damages=damages;
		this.amenities=amenities;

		this.hotel_id=hotel_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isIsextendable() {
		return isextendable;
	}

	public void setIsextendable(boolean isextendable) {
		this.isextendable = isextendable;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getDamages() {
		return damages;
	}

	public void setDamages(String damages) {
		this.damages = damages;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}


	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}

	public String getRoom_status() {
		return room_status;
	}

	public void setRoom_status(String room_status) {
		this.room_status = room_status;
	}

	public String getCustomer_ssn() {
		return customer_ssn;
	}

	public void setCustomer_ssn(String customer_ssn) {
		this.customer_ssn = customer_ssn;
	}
	
	public void setRoom_city(String city) {
		this.room_city = city;
	}
	
	public String getRoom_city() {
		return room_city;
	}
	

}