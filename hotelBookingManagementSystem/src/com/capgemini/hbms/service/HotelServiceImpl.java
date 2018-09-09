/************************************************************************************************************
 *  -Application : Hotel Booking Management System
 *  -Author name : Vaibhavi V
 *  -Emp Id      : 155316
 *  -Description : Contains Hotel service interface implementations to call dao-layer for database operations
 *  				 and validations of user data  
 ************************************************************************************************************/


package com.capgemini.hbms.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.hbms.bean.BookingDetailsBean;
import com.capgemini.hbms.bean.FilterBean;
import com.capgemini.hbms.bean.HotelBean;
import com.capgemini.hbms.bean.RoomDetailsBean;
import com.capgemini.hbms.bean.UsersBean;
import com.capgemini.hbms.dao.HotelDAOImpl;
import com.capgemini.hbms.dao.IHotelDAO;
import com.capgemini.hbms.exception.HotelBookingException;

public class HotelServiceImpl implements IHotelService {

	UsersBean UsersBean = new UsersBean();
	IHotelDAO hotelDAO = null;
	
	
	/*****************************************************************************************************
	 * 
	 * Hotel Methods
	 * 
	 *****************************************************************************************************/
	
	// add hotel
	@Override
	public int addHotel(HotelBean hotelBean) throws HotelBookingException {
		
		hotelDAO = new HotelDAOImpl();
		
		
		return hotelDAO.addHotel(hotelBean);
	}
//delete hotel
	@Override
	public int deleteHotel(int id) throws HotelBookingException {
		hotelDAO = new HotelDAOImpl();
		return hotelDAO.deleteHotel(id);
	}
	//view specific hotel details for modification
	@Override
	public ArrayList<HotelBean> viewHotel(int hotelId) throws HotelBookingException {
		hotelDAO = new HotelDAOImpl();
		return hotelDAO.viewHotel(hotelId);
	}
	//update hotel
	@Override
	public int modifyHotel(HotelBean hotelBean) throws HotelBookingException {
		hotelDAO = new HotelDAOImpl();
		return hotelDAO.modifyHotel(hotelBean);
	}
/*******************************************************************************************************************
 * 
 * room methods
 * 
 ********************************************************************************************************************/
	@Override
	public int addRoom(RoomDetailsBean roomDetailsBean)
			throws HotelBookingException {
		
		hotelDAO = new HotelDAOImpl();
		
		return hotelDAO.addRoom(roomDetailsBean);
	}
//delete room
	@Override
	public int deleteRoom(RoomDetailsBean roomDetailsBean)
			throws HotelBookingException {
		hotelDAO = new HotelDAOImpl();
		return hotelDAO.deleteRoom(roomDetailsBean);
	}
	@Override
	public int deleteRoomValidate(int hotelId,int roomId) throws HotelBookingException {
		hotelDAO = new HotelDAOImpl();
		return hotelDAO.deleteRoomValidate(hotelId,roomId);
	}
	@Override
	public int modifyRoom(RoomDetailsBean roomDetailsBean)
			throws HotelBookingException {
		hotelDAO = new HotelDAOImpl();
		return hotelDAO.modifyRoom(roomDetailsBean);
	}
	//view room
	@Override
	public RoomDetailsBean viewRoom(int roomId,int hotelId) throws HotelBookingException {
		hotelDAO = new HotelDAOImpl();
		return hotelDAO.viewRoom(roomId,hotelId);
	}

	/******************************************************************************************
	 * 
	 * validation methods
	 *********************************************************************************************/
	@Override
	public boolean isValidName(String name) {
		Pattern pattern = Pattern.compile("[A-Za-z ]{2,}");
		Matcher matcher = pattern.matcher(name);

		return matcher.matches();

	}
	@Override
	public boolean isValidAddress(String address) throws HotelBookingException {
		Pattern pattern = Pattern.compile("[A-Za-z0-9#, ]{5,100}");
		Matcher matcher = pattern.matcher(address);

		return matcher.matches();
	}

	@Override
	public boolean isValidMobileNo(String mobile) {
		Pattern pattern = Pattern.compile("^[7-9]{1}[0-9]{9}");
		Matcher matcher = pattern.matcher(mobile);

		return matcher.matches();

	}
	@Override
	public boolean isValidEmail(String email) {
		Pattern pattern = Pattern
				.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$");
		Matcher matcher = pattern.matcher(email);

		return matcher.matches();

	}
	@Override
	public boolean isValidPassword(String password) {
		Pattern pattern = Pattern.compile("[A-Za-z0-9.?!@#$%^&*-_]{8,15}");
		Matcher matcher = pattern.matcher(password);

		return matcher.matches();

	}
	@Override
	public boolean isValidDescription(String description)
			throws HotelBookingException {
		Pattern pattern = Pattern.compile("[0-9A-Za-z, ]{2,50}");
		Matcher matcher = pattern.matcher(description);
		return matcher.matches();
		
	}
	@Override
	public boolean isValidCost(String cost) throws HotelBookingException {
		
		Pattern pattern = Pattern.compile("[0-9]{0,6}");
		Matcher matcher = pattern.matcher(cost);
		return matcher.matches();
	
	}
	@Override
	public boolean isValidRating(String rating) throws HotelBookingException {
	
		Pattern pattern = Pattern.compile("[0-5]{1}|[0-5]{1}.[0-9]{1}");
		Matcher matcher = pattern.matcher(rating);

		return matcher.matches();
	}
	@Override
	public boolean isValidFax(String fax) throws HotelBookingException {
		Pattern pattern = Pattern.compile("[0-9]{1,3}-[0-9]{3}\\-[0-9]{7}");
		Matcher matcher = pattern.matcher(fax);

		return matcher.matches();
	}
	@Override
	public boolean isValidId(String id) throws HotelBookingException {
		Pattern pattern = Pattern.compile("[0-9]{1,4}");
		Matcher matcher = pattern.matcher(id);

		return matcher.matches();
	}
	@Override
	public boolean isValidRoomNo(String roomNo) throws HotelBookingException {
		Pattern pattern = Pattern.compile("[A-Za-z0-9]{1,4}");
		Matcher matcher = pattern.matcher(roomNo);

		return matcher.matches();
	}
	@Override
	public boolean isValidRoomType(String roomType) throws HotelBookingException {
		Pattern pattern = Pattern.compile("[A-Za-z ]{2,20}");
		Matcher matcher = pattern.matcher(roomType);
		return matcher.matches();
	}
	@Override
	public boolean isValidRoomSize(String roomSize) throws HotelBookingException {
		Pattern pattern = Pattern.compile("[0-9]{1}");
		Matcher matcher = pattern.matcher(roomSize);
		return matcher.matches();
	}
	@Override
	public boolean isValidAvailability(String availability)
			throws HotelBookingException {
		Pattern pattern = Pattern.compile("true|false");
		Matcher matcher = pattern.matcher(availability);
		return matcher.matches();
	}
	@Override
	public boolean isValidCity(String city) throws HotelBookingException {
		Pattern pattern = Pattern.compile("[A-Za-z]{2,10}");
		Matcher matcher = pattern.matcher(city);
		return matcher.matches();
	}

	@Override
	public boolean isValidDate(String date) throws HotelBookingException {
		Pattern pattern = Pattern.compile("[0-9]{2}[-][JAN|Jan|jan|FEB|Feb|feb|MAR|Mar|mar|APR|Apr|apr|MAY|May|may|JUN|Jun|jun|JUL|Jul|jul|AUG|Aug|aug|SEP|Sep|sep|OCT|Oct|oct|NOV|Nov|nov|DEC|Dec|dec]{3}[-][0-9]{4}");
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}

/*
 * Registration method
 * 
 */
	@Override
	public int registerUser(UsersBean usersBean)
			throws HotelBookingException {
		hotelDAO = new HotelDAOImpl();
		
		return hotelDAO.registerUser(usersBean);
	}
/*
 * 
 * Login Method
 * 
 */
	@Override
	public int loginValidation(int id, String password,String role)
			throws HotelBookingException {
		
		hotelDAO = new HotelDAOImpl();
		
		return hotelDAO.loginValidation(id,password,role);
	}
/************************************************************************************************
 * Search Hotel Methods
 * 
 **************************************************************************************************/
	@Override
	//view Destination city to search hotels
	public ArrayList<String> viewHotelCity() throws HotelBookingException {
		hotelDAO = new HotelDAOImpl();
		return hotelDAO.viewHotelCity();
	}

//filter hotels
@Override
public ArrayList<FilterBean> filterHotel(String city,int roomSize,String checkin,String checkout)
		throws HotelBookingException {
	hotelDAO = new HotelDAOImpl();
	return hotelDAO.filterHotel(city,roomSize,checkin,checkout);
}

//book hotels
@Override
public int bookHotel(BookingDetailsBean bookingDetailsBean) throws HotelBookingException {
	hotelDAO = new HotelDAOImpl();
	return hotelDAO.bookHotel(bookingDetailsBean);
}
//view booking status

@Override
public ArrayList<BookingDetailsBean> viewBookStatus(int uid) throws HotelBookingException {
	hotelDAO = new HotelDAOImpl();
	return hotelDAO.viewBookStatus(uid);
}

//check if hotel is not booked by customers

@Override
public int deleteHotelValidate(int id) throws HotelBookingException {
	hotelDAO = new HotelDAOImpl();
	return hotelDAO.deleteHotelValidate(id);
}


/************************************************************************************************
 * Generate reports
 * 
 **************************************************************************************************/
//view all hotels 
@Override
public ArrayList<HotelBean> viewAllHotels() throws HotelBookingException {
	hotelDAO = new HotelDAOImpl();
	return hotelDAO.viewAllHotels();
}

@Override
public ArrayList<BookingDetailsBean> viewSpecificHotelBooking(int hotelId)
		throws HotelBookingException {
	hotelDAO = new HotelDAOImpl();
	return hotelDAO.viewSpecificHotelBooking(hotelId);
}
//view guest list of specific hotel
@Override
public ArrayList<UsersBean> viewSpecificHotelGuestList(int hotelId)
		throws HotelBookingException {
	hotelDAO = new HotelDAOImpl();
	return hotelDAO.viewSpecificHotelGuestList(hotelId);
}

//view specific date booking list	
@Override
public ArrayList<BookingDetailsBean> viewSpecificDateBooking(String date)
		throws HotelBookingException {
	hotelDAO = new HotelDAOImpl();
	return hotelDAO.viewSpecificDateBooking(date);
}


}

