/*********************************************************************************************************
 *  -Application : Hotel Booking Management System
 *  -Author name : Vaibhavi V
 *  -Emp Id      : 155316
 *  -Description : Contains booking details bean 
 **********************************************************************************************************/

package com.capgemini.hbms.bean;

public class HotelBean {
	
	private int  hotelId;
	private String city;
	private String hotelName;
	private String address;
	private String description;
	private double avgRatePerNight;
	private String phoneNo1;
	private String phoneNo2;
	private float rating;
	private String email;
	private String fax;
	
	public HotelBean() {
		
	}
	
	

	public HotelBean(String city, String hotelName, String address,
			String description, double avgRatePerNight, String phoneNo1,
			String phoneNo2, float rating, String email, String fax) {
		super();
		this.city = city;
		this.hotelName = hotelName;
		this.address = address;
		this.description = description;
		this.avgRatePerNight = avgRatePerNight;
		this.phoneNo1 = phoneNo1;
		this.phoneNo2 = phoneNo2;
		this.rating = rating;
		this.email = email;
		this.fax = fax;
	}



	public HotelBean(int hotelId, String hotelName, String address,
			String description, double avgRatePerNight, String phoneNo1,
			String phoneNo2, float rating, String email, String fax) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.address = address;
		this.description = description;
		this.avgRatePerNight = avgRatePerNight;
		this.phoneNo1 = phoneNo1;
		this.phoneNo2 = phoneNo2;
		this.rating = rating;
		this.email = email;
		this.fax = fax;
	}



	public HotelBean(int hotelId, String city, String hotelName,
			String address, String description, double avgRatePerNight,
			String phoneNo1, String phoneNo2, float rating, String email,
			String fax) {
		super();
		this.hotelId = hotelId;
		this.city = city;
		this.hotelName = hotelName;
		this.address = address;
		this.description = description;
		this.avgRatePerNight = avgRatePerNight;
		this.phoneNo1 = phoneNo1;
		this.phoneNo2 = phoneNo2;
		this.rating = rating;
		this.email = email;
		this.fax = fax;
	}



	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAvgRatePerNight() {
		return avgRatePerNight;
	}

	public void setAvgRatePerNight(double avgRatePerNight) {
		this.avgRatePerNight = avgRatePerNight;
	}

	public String getPhoneNo1() {
		return phoneNo1;
	}

	public void setPhoneNo1(String phoneNo1) {
		this.phoneNo1 = phoneNo1;
	}

	public String getPhoneNo2() {
		return phoneNo2;
	}

	public void setPhoneNo2(String phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	
	
	
	
	

}
