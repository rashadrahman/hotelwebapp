package eHotel.entities;

public class employee {
	
//	employee here has employeeid and password attributes
	
	private String Essn;
	private String employee_pass;
	private String mngrSsn;
	private String name;
	private String role;
	private String zip;
	private String city;
	private String street;
	private String country;
	private int hotel_id;
	
	public String getMngrSsn() {
		return mngrSsn;
	}

	public void setMngrSsn(String mngrSsn) {
		this.mngrSsn = mngrSsn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public void setEssn(String essn) {
		Essn = essn;
	}

	public employee() {
		
	}

	public String getEssn() {
		return Essn;
	}

	public void setEmployee_id(String employee_id) {
		this.Essn = employee_id;
	}

	public String getEmployee_pass() {
		return employee_pass;
	}

	public void setEmployee_pass(String employee_pass) {
		this.employee_pass = employee_pass;
	}
	
	

}
