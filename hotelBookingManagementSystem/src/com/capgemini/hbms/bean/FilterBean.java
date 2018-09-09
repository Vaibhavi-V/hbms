/*********************************************************************************************************
 *  -Application : Hotel Booking Management System
 *  -Author name : Vaibhavi V
 *  -Emp Id      : 155316
 *  -Description : Contains filter bean class - to store available hotels and rooms id according to 
 *  				requirements of search
 **********************************************************************************************************/

package com.capgemini.hbms.bean;

public class FilterBean {
	
	private int hotelId;
	private int roomId;
	public FilterBean() {
		super();
	}
	public FilterBean(int hotelId, int roomId) {
		super();
		this.hotelId = hotelId;
		this.roomId = roomId;
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
	
	
	

}
