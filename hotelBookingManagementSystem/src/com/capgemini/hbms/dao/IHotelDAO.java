/*********************************************************************************************************
 *  -Application : Hotel Booking Management System
 *  -Author name : Vaibhavi V
 *  -Emp Id      : 155316
 *  -Description : Contains unimplemented methods related to database
 **********************************************************************************************************/

package com.capgemini.hbms.dao;

import java.util.ArrayList;

import com.capgemini.hbms.bean.BookingDetailsBean;
import com.capgemini.hbms.bean.FilterBean;
import com.capgemini.hbms.bean.HotelBean;
import com.capgemini.hbms.bean.RoomDetailsBean;
import com.capgemini.hbms.bean.UsersBean;
import com.capgemini.hbms.exception.HotelBookingException;

public interface IHotelDAO {

	public abstract int registerUser(UsersBean usersBean)
			throws HotelBookingException;

	public abstract int loginValidation(int id, String password, String role)
			throws HotelBookingException;

	public abstract int addHotel(HotelBean hotelBean)
			throws HotelBookingException;

	public abstract int deleteHotel(int id) throws HotelBookingException;

	// check if hotel is not booked by customers
	public abstract int deleteHotelValidate(int id)
			throws HotelBookingException;

	public abstract int modifyHotel(HotelBean hotelBean)
			throws HotelBookingException;

	// view specific hotel details for modification
	public abstract ArrayList<HotelBean> viewHotel(int hotelId)
			throws HotelBookingException;

	public abstract int addRoom(RoomDetailsBean roomDetailsBean)
			throws HotelBookingException;

	public abstract int deleteRoom(RoomDetailsBean roomDetailsBean)
			throws HotelBookingException;
	public abstract int deleteRoomValidate(int hotelId,int roomId) throws HotelBookingException ;
	public abstract int modifyRoom(RoomDetailsBean roomDetailsBean)
			throws HotelBookingException;


	// view Destination city to search hotels
	public abstract ArrayList<String> viewHotelCity()
			throws HotelBookingException;

	// view room
	public abstract RoomDetailsBean viewRoom(int roomId, int hotelId)
			throws HotelBookingException;

	// view all hotels
	public abstract ArrayList<HotelBean> viewAllHotels()
			throws HotelBookingException;

	// filter hotels
	public abstract ArrayList<FilterBean> filterHotel(String city,
			int roomSize, String checkin, String checkout)
			throws HotelBookingException;

	// book hotel
	public abstract int bookHotel(BookingDetailsBean bookingDetailsBean)
			throws HotelBookingException;

	// view booking status
	public abstract ArrayList<BookingDetailsBean> viewBookStatus(int uid)
			throws HotelBookingException;

	// generate reports
	// view all bookings of specific hotel
	public abstract ArrayList<BookingDetailsBean> viewSpecificHotelBooking(
			int hotelId) throws HotelBookingException;

	// view guest list of specific hotel
	public abstract ArrayList<UsersBean> viewSpecificHotelGuestList(
			int hotelId) throws HotelBookingException;
	
	// view specific date booking list
		public abstract ArrayList<BookingDetailsBean> viewSpecificDateBooking(String date) throws HotelBookingException;
		

}
