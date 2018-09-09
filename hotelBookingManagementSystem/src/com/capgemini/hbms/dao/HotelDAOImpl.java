/*********************************************************************************************************
 *  -Application : Hotel Booking Management System
 *  -Author name : Vaibhavi V
 *  -Emp Id      : 155316
 *  -Description : Contains method implementations to store details in database, retrieve from database..
 **********************************************************************************************************/


package com.capgemini.hbms.dao;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import com.capgemini.hbms.bean.BookingDetailsBean;
import com.capgemini.hbms.bean.FilterBean;
import com.capgemini.hbms.bean.HotelBean;
import com.capgemini.hbms.bean.RoomDetailsBean;
import com.capgemini.hbms.bean.UsersBean;
import com.capgemini.hbms.exception.HotelBookingException;

;
public class HotelDAOImpl implements IHotelDAO {
	Connection connection = null;
	HotelBean hotelBean = new HotelBean();
	BookingDetailsBean bookingDetailsBean = new BookingDetailsBean();
	RoomDetailsBean roomDetailsBean = new RoomDetailsBean();

	// PreparedStatement preparedStatement=null;

	/*****************************************************************************************************
	 * 
	 * Hotel Methods
	 * 
	 *****************************************************************************************************/
// add hotel details to database
	@Override
	public int addHotel(HotelBean hotelBean) throws HotelBookingException {

		int hotelStatus = 0;
		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.HOTEL_INSERT_QUERY);
			preparedStatement.setString(1, hotelBean.getCity());
			preparedStatement.setString(2, hotelBean.getHotelName());
			preparedStatement.setString(3, hotelBean.getAddress());
			preparedStatement.setString(4, hotelBean.getDescription());
			preparedStatement.setDouble(5, hotelBean.getAvgRatePerNight());
			preparedStatement.setString(6, hotelBean.getPhoneNo1());
			preparedStatement.setString(7, hotelBean.getPhoneNo2());
			preparedStatement.setFloat(8, hotelBean.getRating());
			preparedStatement.setString(9, hotelBean.getEmail());
			preparedStatement.setString(10, hotelBean.getFax());

			hotelStatus = preparedStatement.executeUpdate();

			preparedStatement = connection
					.prepareStatement(IQueryMapper.HOTEL_ID_QUERY_SEQUENCE);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt(1);
				hotelBean.setHotelId(id);
			}

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return hotelStatus;
	}
	@Override
	public int deleteHotelValidate(int id) throws HotelBookingException {
		int idDeleteStatus=0;
		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.HOTEL_DELETE_VALIDATE_QUERY);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				idDeleteStatus=resultSet.getInt(1);

			}

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return idDeleteStatus;
	
	}
	// delete hotel
	@Override
	public int deleteHotel(int id) throws HotelBookingException {
		int hotelDeleteStatus = 0;
		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.HOTEL_DELETE_QUERY);
			preparedStatement.setInt(1, id);

			hotelDeleteStatus = preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return hotelDeleteStatus;
	}

	@Override
	public int modifyHotel(HotelBean hotelBean) throws HotelBookingException {

		int hotelStatus = 0;
		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.HOTEL_UPDATE_QUERY);
			preparedStatement.setString(1, hotelBean.getCity());
			preparedStatement.setString(2, hotelBean.getHotelName());
			preparedStatement.setString(3, hotelBean.getAddress());
			preparedStatement.setString(4, hotelBean.getDescription());
			preparedStatement.setDouble(5, hotelBean.getAvgRatePerNight());
			preparedStatement.setString(6, hotelBean.getPhoneNo1());
			preparedStatement.setString(7, hotelBean.getPhoneNo2());
			preparedStatement.setFloat(8, hotelBean.getRating());
			preparedStatement.setString(9, hotelBean.getEmail());
			preparedStatement.setString(10, hotelBean.getFax());
			preparedStatement.setInt(11, hotelBean.getHotelId());

			hotelStatus = preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return hotelStatus;

	}

	// view specific hotel details for modification
	@Override
	public ArrayList<HotelBean> viewHotel(int hotelId)
			throws HotelBookingException {
		ArrayList<HotelBean> hotelList = new ArrayList<HotelBean>();

		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.VIEW_HOTEL);
			preparedStatement.setInt(1, hotelId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				HotelBean hotelBean = new HotelBean(resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getDouble(6),
						resultSet.getString(7), resultSet.getString(8),
						resultSet.getFloat(9), resultSet.getString(10),
						resultSet.getString(11));

				hotelList.add(hotelBean);

			}

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return hotelList;
	}

	/*******************************************************************************************************************
	 * 
	 * room methods
	 * 
	 ********************************************************************************************************************/
	@Override
	public int addRoom(RoomDetailsBean roomDetailsBean)
			throws HotelBookingException {

		int roomStatus = 0;
		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.ROOM_INSERT_QUERY);
			preparedStatement.setInt(1, roomDetailsBean.getHotelId());
			preparedStatement.setString(2, roomDetailsBean.getRoomNo());
			preparedStatement.setInt(3, roomDetailsBean.getRoomSize());
			preparedStatement.setString(4, roomDetailsBean.getRoomType());
			preparedStatement.setDouble(5, roomDetailsBean.getPerNightRate());
			preparedStatement.setString(6, roomDetailsBean.getAvailability());

			roomStatus = preparedStatement.executeUpdate();

			preparedStatement = connection
					.prepareStatement(IQueryMapper.ROOM_ID_QUERY_SEQUENCE);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt(1);

				roomDetailsBean.setRoomId(id);
			}

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return roomStatus;
	}
	@Override
	public int deleteRoomValidate(int hotelId, int roomId)
			throws HotelBookingException {
		
		int roomIdDeleteStatus=0;
		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.ROOM_DELETE_VALIDATE_QUERY);
			preparedStatement.setInt(1, hotelId);
			preparedStatement.setInt(2, roomId);
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				roomIdDeleteStatus=resultSet.getInt(1);

			}

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return roomIdDeleteStatus;
	
	}
	// delete room
	@Override
	public int deleteRoom(RoomDetailsBean roomDetailsBean)
			throws HotelBookingException {
		int DeleteStatus = 0;
		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.ROOM_DELETE_QUERY);
			preparedStatement.setInt(1, roomDetailsBean.getHotelId());
			preparedStatement.setInt(2, roomDetailsBean.getRoomId());
			DeleteStatus = preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return DeleteStatus;
	}

	@Override
	public int modifyRoom(RoomDetailsBean roomDetailsBean)
			throws HotelBookingException {
		int roomStatus = 0;
		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.ROOM_UPDATE_QUERY);

			preparedStatement.setString(1, roomDetailsBean.getRoomNo());
			preparedStatement.setString(2, roomDetailsBean.getRoomType());
			preparedStatement.setDouble(3, roomDetailsBean.getPerNightRate());
			preparedStatement.setString(4, roomDetailsBean.getAvailability());
			preparedStatement.setInt(5, roomDetailsBean.getRoomSize());
			preparedStatement.setInt(6, roomDetailsBean.getHotelId());
			preparedStatement.setInt(7, roomDetailsBean.getRoomId());
			roomStatus = preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return roomStatus;

	}

	
	@Override
	public int registerUser(UsersBean usersBean) throws HotelBookingException {
		
		int id = 0;
		try {
			connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.USER_INSERT_QUERY);
			preparedStatement.setString(1, usersBean.getPassword());
			preparedStatement.setString(2, usersBean.getRole());
			preparedStatement.setString(3, usersBean.getUserName());
			preparedStatement.setString(4, usersBean.getMobileNo());
			preparedStatement.setString(5, usersBean.getAddress());
			preparedStatement.setString(6, usersBean.getEmail());

			 preparedStatement.executeUpdate();

			preparedStatement = connection
					.prepareStatement(IQueryMapper.USER_ID_QUERY_SEQUENCE);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				id = resultSet.getInt(1);
				usersBean.setUserId(id);
			}

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}
		return id;
	}

	@Override
	public int loginValidation(int id, String password, String role)
			throws HotelBookingException {

		// System.out.println("Inside Login Validation");

		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.PASSWORD_VALIDATE_QUERY);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, role);

			// System.out.println("Prepared Stmt Done");

			ResultSet resultSet = preparedStatement.executeQuery();

			// System.out.println("Query executed");

			while (resultSet.next()) {
				String validPassword = resultSet.getString(1);
				if (validPassword.equals(password)) {
					// System.out.println("Correct Inputs");
					return 1;
				}
			}

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return 0;
	}

	/************************************************************************************************
	 * Search Hotel Methods
	 * 
	 **************************************************************************************************/
	@Override
	// view Destination city to search hotels
	public ArrayList<String> viewHotelCity() throws HotelBookingException {

		ArrayList<String> cityList = new ArrayList<String>();
		try {
			connection = DBUtil.getConnection();

			Statement statement = connection.createStatement();

			ResultSet rs = statement
					.executeQuery(IQueryMapper.VIEW_DESTINATION_CITY);
			while (rs.next()) {

				cityList.add(rs.getString(1));
			}

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return cityList;
	}

	// view room
	@Override
	public RoomDetailsBean viewRoom(int roomId, int hotelId)
			throws HotelBookingException {
		RoomDetailsBean roomDetailsBean = null;
		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.VIEW_ROOM);
			preparedStatement.setInt(1, roomId);
			preparedStatement.setInt(2, hotelId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				roomDetailsBean = new RoomDetailsBean(resultSet.getInt(1),resultSet.getInt(2),
						resultSet.getString(3), resultSet.getString(5),
						resultSet.getDouble(6), resultSet.getString(7),
						resultSet.getInt(4));

			}

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return roomDetailsBean;
	}

	// filter hotels

	@Override
	public ArrayList<FilterBean> filterHotel(String city, int roomSize,
			String checkin, String checkout) throws HotelBookingException {

		ArrayList<FilterBean> filterList = new ArrayList<FilterBean>();
		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.HOTEL_FILTER_QUERY);
			preparedStatement.setString(1, city);
			preparedStatement.setInt(2, roomSize);
			preparedStatement.setString(3, checkin);
			preparedStatement.setString(4, checkout);
			preparedStatement.setString(5, checkin);
			preparedStatement.setString(6, checkout);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				FilterBean filterBean = new FilterBean(resultSet.getInt(1),
						resultSet.getInt(2));

				filterList.add(filterBean);

			}

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return filterList;
	}

	// book hotel
	@Override
	public int bookHotel(BookingDetailsBean bookingDetailsBean)
			throws HotelBookingException {
		int bookStatus = 0;
		String status = "";
		Double amountValidate=0d;
		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.STATUS_CHECK_QUERY);
			preparedStatement.setInt(1, bookingDetailsBean.getRoomId());
			preparedStatement.setInt(2, bookingDetailsBean.getHotelId());

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				status = resultSet.getString(1);
				amountValidate=resultSet.getDouble(2);
			}

			if ("true".equals(status) && bookingDetailsBean.getAmount()==amountValidate) {

				preparedStatement = connection
						.prepareStatement(IQueryMapper.BOOK_INSERT_QUERY);
				preparedStatement.setInt(1, bookingDetailsBean.getRoomId());
				preparedStatement.setInt(2, bookingDetailsBean.getUserId());
				preparedStatement.setString(3,
						bookingDetailsBean.getBookedFrom());
				preparedStatement
						.setString(4, bookingDetailsBean.getBookedTo());
				preparedStatement.setInt(5, bookingDetailsBean.getNoOfAdults());
				preparedStatement.setDouble(6, bookingDetailsBean.getAmount());
				preparedStatement.setInt(7, bookingDetailsBean.getHotelId());

				bookStatus = preparedStatement.executeUpdate();

				preparedStatement = connection
						.prepareStatement(IQueryMapper.BOOK_ID_QUERY_SEQUENCE);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					int id = resultSet.getInt(1);

					bookingDetailsBean.setBookingId(id);

				}

			}

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return bookStatus;
	}

	// view booking status
	@Override
	public ArrayList<BookingDetailsBean> viewBookStatus(int uid)
			throws HotelBookingException {
		ArrayList<BookingDetailsBean> bookStatusList = new ArrayList<BookingDetailsBean>();
		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.VIEW_BOOKING_STATUS_QUERY);
			preparedStatement.setInt(1, uid);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				BookingDetailsBean bookingDetailsBean = new BookingDetailsBean(
						resultSet.getInt(1), resultSet.getInt(2),
						resultSet.getInt(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getInt(6),
						resultSet.getDouble(7), resultSet.getInt(8));

				bookStatusList.add(bookingDetailsBean);

			}

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return bookStatusList;
	}

	

	/*****************************************************************************************************
	 * 
	 * Generate reports
	 * 
	 *****************************************************************************************************/

	// view all hotels
	@Override
	public ArrayList<HotelBean> viewAllHotels() throws HotelBookingException {

		ArrayList<HotelBean> hotelList = new ArrayList<HotelBean>();

		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.VIEW_ALL_HOTELS_QUERY);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				HotelBean hotelBean = new HotelBean(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5),
						resultSet.getDouble(6), resultSet.getString(7),
						resultSet.getString(8), resultSet.getFloat(9),
						resultSet.getString(10), resultSet.getString(11));

				hotelList.add(hotelBean);

			}

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return hotelList;
	}

	@Override
	public ArrayList<BookingDetailsBean> viewSpecificHotelBooking(int hotelId)
			throws HotelBookingException {
		ArrayList<BookingDetailsBean> bookingList = new ArrayList<BookingDetailsBean>();

		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.VIEW_SPECIFIC_HOTEL_BOOKING_QUERY);
			preparedStatement.setInt(1, hotelId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				BookingDetailsBean bookingDetailsBean = new BookingDetailsBean(
						resultSet.getInt(1), resultSet.getInt(2),
						resultSet.getInt(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getInt(6),
						resultSet.getDouble(7), resultSet.getInt(8));

				bookingList.add(bookingDetailsBean);

			}

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return bookingList;

	}
	// view guest list of specific hotel
	@Override
	public ArrayList<UsersBean> viewSpecificHotelGuestList(int hotelId)
			throws HotelBookingException {
		
		ArrayList<UsersBean> guestList = new ArrayList<UsersBean>();

		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.VIEW_SPECIFIC_HOTEL_GUESTLIST_QUERY);
			preparedStatement.setInt(1, hotelId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				UsersBean usersBean=new UsersBean(resultSet.getInt(1), resultSet.getString(2)
						,resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),
						resultSet.getString(6),resultSet.getString(7));

				guestList.add(usersBean);

			}

		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}

		return guestList;
	
	}
	// view specific date booking list
	@Override
	public ArrayList<BookingDetailsBean> viewSpecificDateBooking(String date)
			throws HotelBookingException {
		
		ArrayList<BookingDetailsBean> specificDateBookingList = new ArrayList<BookingDetailsBean>();

		try {
			connection = DBUtil.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IQueryMapper.VIEW_SPECIFIC_DATE_BOOKING);
			preparedStatement.setString(1, date);
			preparedStatement.setString(2, date);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				BookingDetailsBean bookingDetailsBean = new BookingDetailsBean(
						resultSet.getInt(1), resultSet.getInt(2),
						resultSet.getInt(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getInt(6),
						resultSet.getDouble(7), resultSet.getInt(8));

				specificDateBookingList.add(bookingDetailsBean);
			}
		} catch (Exception e) {
			throw new HotelBookingException(e.getMessage());
		}
		return specificDateBookingList;
	}

}
