/*********************************************************************************************************
 *  -Application : Hotel Booking Management System
 *  -Author name : Vaibhavi V
 *  -Emp Id      : 155316
 *  -Description : Contains error messages for validations of user data
 **********************************************************************************************************/




package com.capgemini.hbms.service;

public interface IMsgMapper {
	
	
	public static final String NAME_ERROR= "Name must contain only Alphabets";
	public static final String ADDRESS_ERROR= "Enter address within 100 characters";
	public static final String MOBILE_NO_ERROR= "Enter valid 10 digit Mobile number";
	public static final String PASSWORD_ERROR= "Password should contain minimum 8 characters and maximum 15 characters";
	public static final String EMAIL_ERROR= "Enter valid Email";
	public static final String DESCRIPTION_ERROR= "Enter description within 50 characters";
	public static final String COST_ERROR= "Enter Cost less than 1000000";
	public static final String RATING_ERROR= "Enter rating between 0-5";
	public static final String FAX_ERROR= "Enter valid fax no";
	public static final String ID_ERROR= "Enter valid ID (numbers 0-4)";
	public static final String ROOM_NO_ERROR= "Enter valid Room no between 4 characters";
	public static final String ROOM_TYPE_ERROR= "Enter valid Room type between 4-20 characters";
	public static final String ROOM_SIZE_ERROR= "Enter valid Room size (1 digit)";
	public static final String AVAILABILITY_ERROR= "Enter true or false";
	public static final String CITY_ERROR= "Enter valid city name (10 characters)";
	public static final String DATE_ERROR= "Enter Check in date in this format (dd-mon-yyyy)";
}
