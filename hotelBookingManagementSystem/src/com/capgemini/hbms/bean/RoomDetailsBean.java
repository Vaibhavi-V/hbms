/*********************************************************************************************************
 *  -Application : Hotel Booking Management System
 *  -Author name : Vaibhavi V
 *  -Emp Id      : 155316
 *  -Description : Contains room details bean class
 **********************************************************************************************************/

package com.capgemini.hbms.bean;

public class RoomDetailsBean {
	private int hotelId;
	private int roomId;
	private String roomNo;
	private String roomType;
	private double perNightRate;
	private String availability;
	private int roomSize;
	//private String photo;
	
	public RoomDetailsBean() {
		
	}

	

	public RoomDetailsBean(int hotelId, int roomId, String roomNo,
			String roomType, double perNightRate, String availability,
			int roomSize) {
		super();
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.perNightRate = perNightRate;
		this.availability = availability;
		this.roomSize = roomSize;
	}



	public RoomDetailsBean(int hotelId, String roomNo, String roomType,
			double perNightRate, String availability, int roomSize) {
		super();
		this.hotelId = hotelId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.perNightRate = perNightRate;
		this.availability = availability;
		this.roomSize = roomSize;
	}



	public int getHotelId() {
		return hotelId;
	}



	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}



	public int getRoomId() {
		return roomId;
	}



	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}



	public String getRoomNo() {
		return roomNo;
	}



	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}



	public String getRoomType() {
		return roomType;
	}



	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}



	public double getPerNightRate() {
		return perNightRate;
	}



	public void setPerNightRate(double perNightRate) {
		this.perNightRate = perNightRate;
	}



	public String getAvailability() {
		return availability;
	}



	public void setAvailability(String availability) {
		this.availability = availability;
	}



	public int getRoomSize() {
		return roomSize;
	}



	public void setRoomSize(int roomSize) {
		this.roomSize = roomSize;
	}




}
