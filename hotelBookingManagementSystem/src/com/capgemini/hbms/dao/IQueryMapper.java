/*********************************************************************************************************
 *  -Application : Hotel Booking Management System
 *  -Author name : Vaibhavi V
 *  -Emp Id      : 155316
 *  -Description : Contains sql queries for database 
 **********************************************************************************************************/

package com.capgemini.hbms.dao;

/********************************************************************************************************
 * 
 * SQL queries
 * 
 **********************************************************************************************************/
public interface IQueryMapper {
	//Hotel methods Query
	public static final String HOTEL_INSERT_QUERY="INSERT INTO HOTEL VALUES(HOTEL_ID_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
	public static final String HOTEL_ID_QUERY_SEQUENCE="SELECT HOTEL_ID_SEQ.CURRVAL FROM DUAL";
	public static final String HOTEL_DELETE_QUERY="DELETE HOTEL WHERE HOTEL_ID=?";
	public static final String HOTEL_DELETE_VALIDATE_QUERY="select count(*) from BOOKINGDETAILS where hotel_id=?";
	public static final String VIEW_HOTEL="SELECT * FROM HOTEL WHERE HOTEL_ID=?";
	public static final String HOTEL_UPDATE_QUERY="UPDATE HOTEL SET CITY=?,HOTEL_NAME=?,ADDRESS=?,DESCRIPTION=?,AVG_RATE_PER_NIGHT=?,PHONE_NO1=?,PHONE_NO2=?,RATING=?,EMAIL=?,FAX=? WHERE HOTEL_ID=?";
	//Registration Query
	public static final String USER_INSERT_QUERY="INSERT INTO USERS VALUES(USER_ID_SEQ.NEXTVAL,?,?,?,?,?,?)";
	public static final String USER_ID_QUERY_SEQUENCE="SELECT USER_ID_SEQ.CURRVAL FROM DUAL";
	
	//Login Query
	public static final String PASSWORD_VALIDATE_QUERY="SELECT PASSWORD FROM USERS WHERE USER_ID=? AND ROLE=?";
	//Room methods Query
	
	public static final String ROOM_INSERT_QUERY="INSERT INTO ROOMDETAILS VALUES(?,ROOM_ID_SEQ.NEXTVAL,?,?,?,?,?)";
	public static final String ROOM_ID_QUERY_SEQUENCE="SELECT ROOM_ID_SEQ.CURRVAL FROM DUAL";
	public static final String ROOM_DELETE_QUERY="DELETE ROOMDETAILS WHERE HOTEL_ID=? AND ROOM_ID=?";
	public static final String ROOM_DELETE_VALIDATE_QUERY="select count(*) from BOOKINGDETAILS where hotel_id=? and room_id=?";
	public static final String ROOM_UPDATE_QUERY="UPDATE ROOMDETAILS SET ROOM_NO=?,ROOM_TYPE=?,PER_NIGHT_RATE=?,AVAILABILITY=?,ROOM_SIZE=? WHERE HOTEL_ID=? AND ROOM_ID=?";
	
	//view Destination city Query to search hotels
	public static final String VIEW_DESTINATION_CITY="SELECT DISTINCT CITY FROM HOTEL";
	
	//view room query
	public static final String VIEW_ROOM="SELECT * FROM ROOMDETAILS WHERE ROOM_ID=? and hotel_id=?";
	//filter hotel
	public static final String HOTEL_FILTER_QUERY="SELECT r.hotel_id,r.room_id FROM roomdetails r ,hotel h WHERE (r.hotel_id= h.hotel_id) and (h.city=?) and (r.room_size=?) and (r.hotel_id,r.room_id) not in (select hotel_id,room_id from bookingdetails where(booked_from between ? and ?) or (booked_to-1 between ? and ?)) order by 1";
	//book hotel
	public static final String STATUS_CHECK_QUERY="SELECT AVAILABILITY,PER_NIGHT_RATE FROM ROOMDETAILS WHERE ROOM_ID=? AND HOTEL_ID=?";
	public static final String BOOK_INSERT_QUERY="INSERT INTO BOOKINGDETAILS VALUES(BOOK_ID_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
	public static final String BOOK_ID_QUERY_SEQUENCE="SELECT BOOK_ID_SEQ.CURRVAL FROM DUAL";
	
	
	//view booking status query
	public static final String VIEW_BOOKING_STATUS_QUERY="SELECT * FROM BOOKINGDETAILS WHERE USER_ID=?";
	
		
	//view available hotels in particular city
	public static final String VIEW_ALL_HOTELS_QUERY="SELECT * FROM HOTEL";
	//view booking of specific hotel
	
	public static final String VIEW_SPECIFIC_HOTEL_BOOKING_QUERY="select * from BOOKINGDETAILS where hotel_id=?";
	//view guest list for specific hotel
	public static final String VIEW_SPECIFIC_HOTEL_GUESTLIST_QUERY="select * from users where user_id in(select user_id from bookingdetails where hotel_id=?)";
	// view specific date booking list
	public static final String VIEW_SPECIFIC_DATE_BOOKING="select * from BOOKINGDETAILS where booked_from <= ? and booked_to>=?";
	
	
	
	
	
}
