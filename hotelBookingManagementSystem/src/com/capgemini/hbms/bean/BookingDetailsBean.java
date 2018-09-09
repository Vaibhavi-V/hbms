/*********************************************************************************************************
 *  -Application : Hotel Booking Management System
 *  -Author name : Vaibhavi V
 *  -Emp Id      : 155316
 *  -Description : Contains booking details bean class
 **********************************************************************************************************/

package com.capgemini.hbms.bean;



public class BookingDetailsBean {
	
	private int bookingId;
	private int roomId;
	private int userId;
	private String bookedFrom;
	private String bookedTo;
	private int noOfAdults;
	private double amount;
	private int hotelId;
	
	public BookingDetailsBean() {
		super();
	}
	

	public BookingDetailsBean(int bookingId, int roomId, int userId,
			String bookedFrom, String bookedTo, int noOfAdults, double amount,
			int hotelId) {
		super();
		this.bookingId = bookingId;
		this.roomId = roomId;
		this.userId = userId;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.noOfAdults = noOfAdults;
		this.amount = amount;
		this.hotelId = hotelId;
	}


	public BookingDetailsBean(int roomId, int userId, String bookedFrom,
			String bookedTo, int noOfAdults, double amount, int hotelId) {
		super();
		this.roomId = roomId;
		this.userId = userId;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.noOfAdults = noOfAdults;
		this.amount = amount;
		this.hotelId = hotelId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBookedFrom() {
		return bookedFrom;
	}

	public void setBookedFrom(String bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	public String getBookedTo() {
		return bookedTo;
	}

	public void setBookedTo(String bookedTo) {
		this.bookedTo = bookedTo;
	}

	public int getNoOfAdults() {
		return noOfAdults;
	}

	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	
	
	

}
