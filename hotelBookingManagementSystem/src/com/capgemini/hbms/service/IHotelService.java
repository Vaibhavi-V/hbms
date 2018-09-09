/*********************************************************************************************************
 *  -Application : Hotel Booking Management System
 *  -Author name : Vaibhavi V
 *  -Emp Id      : 155316
 *  -Description : Contains unimplemented methods used in user interface
 **********************************************************************************************************/


package com.capgemini.hbms.service;


import java.util.ArrayList;

import com.capgemini.hbms.bean.BookingDetailsBean;
import com.capgemini.hbms.bean.FilterBean;
import com.capgemini.hbms.bean.HotelBean;
import com.capgemini.hbms.bean.RoomDetailsBean;
import com.capgemini.hbms.bean.UsersBean;
import com.capgemini.hbms.exception.HotelBookingException;

public interface IHotelService {
	//unimplemented method to register admin, customer, employee
	public abstract int registerUser(UsersBean usersBean) throws HotelBookingException ;
	//unimplemented login method for all users
	public abstract int loginValidation(int id,String password,String role) throws HotelBookingException ;
	//--------------------------------validation methods---------------------------------------------
	public abstract boolean isValidPassword(String password) throws HotelBookingException;
	public abstract boolean isValidAddress(String address) throws HotelBookingException;
	public abstract boolean isValidName(String name) throws HotelBookingException;
	public abstract boolean isValidMobileNo(String mobile) throws HotelBookingException;
	public abstract boolean isValidEmail(String email) throws HotelBookingException;
	public abstract boolean isValidDescription(String description) throws HotelBookingException;
	public abstract boolean isValidCost(String cost) throws HotelBookingException;
	public abstract boolean isValidRating(String rating) throws HotelBookingException;
	public abstract boolean isValidFax(String fax) throws HotelBookingException;
	public abstract boolean isValidId(String id) throws HotelBookingException;
	public abstract boolean isValidRoomNo(String roomNo) throws HotelBookingException;
	public abstract boolean isValidRoomType(String roomType) throws HotelBookingException;
	public abstract boolean isValidRoomSize(String roomSize) throws HotelBookingException;
	public abstract boolean isValidAvailability(String availability) throws HotelBookingException;
	public abstract boolean isValidCity(String city) throws HotelBookingException;
	public abstract boolean isValidDate(String date) throws HotelBookingException;
	
	//---------------------------------hotel methods---------------------------------------------------
	public abstract int addHotel(HotelBean hotelBean) throws HotelBookingException ;
	public abstract int deleteHotel(int id) throws HotelBookingException ;
	//check if hotel is not booked by customers
	public abstract int deleteHotelValidate(int id) throws HotelBookingException ;
	public abstract int modifyHotel(HotelBean hotelBean) throws HotelBookingException ;
	//view specific hotel details for modification
	public abstract ArrayList<HotelBean> viewHotel(int hotelId) throws HotelBookingException ;
	
	//--------------------------------room methods----------------------------------------------------------
	public abstract int addRoom(RoomDetailsBean roomDetailsBean) throws HotelBookingException ;
	public abstract int deleteRoom(RoomDetailsBean roomDetailsBean) throws HotelBookingException ;
	public abstract int deleteRoomValidate(int hotelId,int roomId) throws HotelBookingException ;
	public abstract int modifyRoom(RoomDetailsBean roomDetailsBean) throws HotelBookingException ;
	
	
	//----------------------------hotel book methods---------------------------------------------
	//view Destination city to search hotels
	public abstract ArrayList<String> viewHotelCity() throws HotelBookingException ;
	//view room
	public abstract RoomDetailsBean viewRoom( int roomId,int hotelId) throws HotelBookingException;
	
	//filter hotels
	public abstract ArrayList<FilterBean> filterHotel(String city,int roomSize,String checkin,String checkout) throws HotelBookingException;
	
	
	
	//book hotel
	public abstract int bookHotel(BookingDetailsBean bookingDetailsBean) throws HotelBookingException;
	
	//view booking status
	public abstract ArrayList<BookingDetailsBean> viewBookStatus(int uid) throws HotelBookingException;
	
	
	//----------------------------generate reports---------------------------------------------------------
	//view all hotels 
	public abstract ArrayList<HotelBean> viewAllHotels() throws HotelBookingException;
	//view all bookings of specific hotel
	public abstract ArrayList<BookingDetailsBean> viewSpecificHotelBooking(int hotelId) throws HotelBookingException;
	// view guest list of specific hotel
	public abstract ArrayList<UsersBean> viewSpecificHotelGuestList(int hotelId) throws HotelBookingException;
	// view specific date booking list
	public abstract ArrayList<BookingDetailsBean> viewSpecificDateBooking(String date) throws HotelBookingException;
	
	
}
