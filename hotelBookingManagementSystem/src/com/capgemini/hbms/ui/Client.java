/*********************************************************************************************************
 *  -Application : Hotel Booking Management System
 *  -Author name : Vaibhavi V
 *  -Emp Id      : 155316
 *  -Description : Contains Main method 
 *  				- User interface options for Customer to search and reserve hotels.
 *  				- User interface options for Admin to add, delete, update, view hotel and rooms 
 *  				- User interface options for Employee to book hotels for walk in customers,
 *  				   view bookings and hotels 
 * 
 **********************************************************************************************************/


package com.capgemini.hbms.ui;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hbms.bean.BookingDetailsBean;
import com.capgemini.hbms.bean.FilterBean;
import com.capgemini.hbms.bean.HotelBean;
import com.capgemini.hbms.bean.RoomDetailsBean;
import com.capgemini.hbms.bean.UsersBean;
import com.capgemini.hbms.exception.HotelBookingException;
import com.capgemini.hbms.service.*;

public class Client {
	static Logger logger = Logger.getRootLogger();
	UsersBean usersBean = null;
	RoomDetailsBean roomDetailsBean = null;
	IHotelService service = new HotelServiceImpl();

	public static void main(String[] args) {
		char ch;
		Scanner scanner = new Scanner(System.in);

		System.out
				.println("---------Hotel Booking Management System------------- ");
		System.out.println();
		System.out.println("Access Categories:");
		System.out.println("1.Customer\n2.Hotel-Employee\n3.Admin");
		System.out.println();
		System.out.println("Choose option");
		System.out.println();

		UsersBean usersBean = null;

		int option = scanner.nextInt();
		IHotelService service = new HotelServiceImpl();
		switch (option) {
		/********************************************************************
		 * Customer Functions
		 *******************************************************************/
		case 1:
			do {
				System.out
						.println("1.Register\n2.Search for Hotel Rooms\n3.View Booking Status");
				System.out.println();
				System.out.println("Choose option");
				int option1 = scanner.nextInt();
				switch (option1) {
				/*******************************************************************
				 * Customer Registration
				 ********************************************************************/
				case 1:
					String role = "customer";
					int registerStatus;
					try {
						registerStatus = new Client().register(role);

						if (registerStatus > 0) {
							logger.info("Customer Registered successfully. User Id : "+ registerStatus);
							System.out.println("Your registration is Successful.\nUse below User Id during login\n"+ registerStatus);
							System.out.println();
							role = "customer";
							new Client().search(role);

						} else {
							System.err.println("Customer Registration failed");
							logger.error("Insertion failed");
						}
					} catch (HotelBookingException e) {
						System.err.println(e.getMessage());
					}
					break;

				/******************************************************************************************
				 * Search for Hotel Rooms
				 ******************************************************************************************/
				case 2:
					role = "customer";
					try {
						new Client().search(role);
					} catch (HotelBookingException e) {
						System.err.println(e.getMessage());
					}

					break;

				/******************************************************************************************
				 * view booking status
				 ******************************************************************************************/
				case 3:
					try {
						new Client().viewBookStatus();
					} catch (HotelBookingException e) {
						System.err.println(e.getMessage());
					}

					break;

				default:
					System.err.println("Select a valid option");
					break;
				}
				System.out
						.println("Do you want to exit from application? Yes or No");
				ch = scanner.next().charAt(0);
			} while (ch == 'n' || ch == 'N');
			System.exit(0);
			break;
		/**************************************************************************************
		 * Hotel Employee functions
		 ***************************************************************************************/
		case 2:
			do {
				System.out.println("1.Register\n2.Login");
				System.out.println();
				System.out.println("choose option");

				scanner = new Scanner(System.in);
				option = scanner.nextInt();
				switch (option) {
				/**************************************************************************************
				 * employee registration
				 ***************************************************************************************/
				case 1:
					String role = "employee";
					int registerStatus;
					try {
						registerStatus = new Client().register(role);

						if (registerStatus > 0) {
							logger.info("Employee Registered successfully. Emp Id : "+ registerStatus);
							System.out
									.println("Regitered Successfully.\nUse below Emp Id during login\n"
											+ registerStatus);
							System.out.println();
						} else {
							logger.error("Registration failed");
							System.err.println("Registration failed");
						}
					} catch (HotelBookingException e) {
						System.err.println(e.getMessage());
					}

					break;
				/**************************************************************************************
				 * Employee login
				 ***************************************************************************************/
				case 2:
					role = "employee";
					int loginStatus;
					int validEmp = 1;
					try {
						do {
							validEmp = 1;
							loginStatus = new Client().login(role);

							if (loginStatus > 0) {
								do {
									logger.info("Employee login successful. User Id : "+ loginStatus);
									System.out.println("Welcome " +loginStatus);
									System.out
											.println("1. Search hotels to book for customers\n2. View List of all Hotels\n3. View Bookings of specific hotel\n4. View guest list of specific hotel\n5. View bookings for specified date ");
									System.out.println();
									System.out.println("Enter option");
									scanner = new Scanner(System.in);
									option = scanner.nextInt();
									switch (option) {
									/*************************************************************************************
									 * Search hotels to book for customers
									 *************************************************************************************/
									case 1:
										new Client().employeeHotelSearch();
										break;

									/*************************************************************************************
									 * view list of all hotels
									 *************************************************************************************/
									case 2:
										new Client().allHotelsList();
										break;
									/*************************************************************************************
									 * view bookings of specific hotel
									 *************************************************************************************/
									case 3:
										new Client().viewSpecificHotelBooking();
										break;
									/*************************************************************************************
									 * view guest list of specific hotel
									 *************************************************************************************/
									case 4:
										new Client()
												.viewSpecificHotelGuestList();
										break;

									/*************************************************************************************
									 * view bookings for specified date
									 *************************************************************************************/
									case 5:
										new Client().viewSpecificDateBooking();
										break;

									default:
										System.out
												.println("Select a valid option");
										break;
									}
									System.out
											.println("Do you want to continue? Yes or No");
									ch = scanner.next().charAt(0);
								} while (ch == 'y' || ch == 'Y');

							} else {
								System.out.println("Not a valid employee");
								logger.error("Employee Login failed");
								System.err.println("Check your credentials and login again");
								validEmp = 0;

							}
						} while (validEmp == 0);
					} catch (HotelBookingException e) {
						System.err.println(e.getMessage());
					}

					break;

				default:
					System.err.println("Select a valid option");
					break;
				}
				System.out
						.println("Do you want to exit from application? Yes or No");
				ch = scanner.next().charAt(0);
			} while (ch == 'n' || ch == 'N');
			System.exit(0);
			break;
		case 3:
			/*********************************************************************************
			 * Admin Functions
			 *********************************************************************************/
			do {
				service = new HotelServiceImpl();
				System.out.println("1.Register\n2.Login");
				System.out.println();
				System.out.println("choose option");

				scanner = new Scanner(System.in);
				option = scanner.nextInt();
				switch (option) {
				case 1:

					/********************************************************************************
					 * Admin Registration
					 *********************************************************************************/
					String role = "admin";
					int adminRegisterStatus;
					try {
						adminRegisterStatus = new Client().register(role);

						if (adminRegisterStatus > 0) {
							logger.info("Admin Registered successfully. Admin Id : "+ adminRegisterStatus);
							System.out.println("Regitered Successfully.\nUse below Admin Id during login\n"+ adminRegisterStatus);
							System.out.println();
						} else {
							System.err.println("Registration failed");
							logger.error("Registration failed");
						}
					} catch (HotelBookingException e) {
						System.err.println(e.getMessage());
					}
					break;

				case 2:

					/**************************************************************************************
					 * Admin Login
					 **************************************************************************************/
					role = "admin";
					int loginStatus;
					int validAdmin = 1;

					try {
						do {
							validAdmin = 1;
							loginStatus = new Client().login(role);

							if (loginStatus > 0) {
								do{
								logger.info("Admin login successful. Admin Id : "+ loginStatus);
								System.out.println("Welcome "+loginStatus);

								/**************************************************************************************
								 * Admin operations
								 ****************************************************************************************/

								System.out
										.println("1.Perform Hotel Management\n2.Perform Room Management\n3.Generate various Reports");
								System.out.println();
								System.out.println("choose option");
								scanner = new Scanner(System.in);
								int option1 = scanner.nextInt();
								switch (option1) {
								case 1:

									/************************************************************************************
									 * Hotel Management
									 *************************************************************************************/
									System.out
											.println("1.Add Hotel\n2.Update Hotel\n3.Delete Hotel");
									System.out.println();
									System.out.println("choose option");
									scanner = new Scanner(System.in);
									int option2 = scanner.nextInt();

									switch (option2) {

									/************************************************************************************
									 * Add Hotel
									 *************************************************************************************/
									case 1:
										new Client().addHotel();

										break;
									/***********************************************************************************
									 * Update hotel
									 ***********************************************************************************/

									case 2:
										new Client().updateHotel();
										break;
									/***********************************************************************************
									 * Delete hotel
									 *************************************************************************************/
									case 3:
										new Client().deleteHotel();
										break;

									default:
										System.err
												.println("Enter valid option");
										break;
									}

									break;
								/*****************************************************************************
								 * Room Management
								 ******************************************************************************/
								case 2:
									System.out
											.println("1.Add Room\n2.Update Room\n3.Delete Room");
									System.out.println();
									System.out.println("choose option");
									scanner = new Scanner(System.in);
									option2 = scanner.nextInt();

									switch (option2) {
									/**************************************************************************
									 * Add room
									 ***************************************************************************/
									case 1:
										new Client().addRoom();
										break;

									/*********************************************************************************
									 * update room
									 *********************************************************************************/
									case 2:
										new Client().updateRoom();
										break;

									/********************************************************************************
									 * Delete room
									 ********************************************************************************/
									case 3:
										new Client().deleteRoom();
										break;

									default:
										System.out
												.println("Enter valid option");
										break;
									}

									break;

								/*************************************************************************************
								 * Generate Reports
								 *************************************************************************************/
								case 3:
									System.out
											.println("1. View List of Hotels\n2. View Bookings of specific hotel\n3. View guest list of specific hotel\n4. View bookings for specified date");
									System.out.println();
									System.out.println("choose option");
									scanner = new Scanner(System.in);
									int generateOption = scanner.nextInt();
									switch (generateOption) {
									/*************************************************************************************
									 * view list of all hotels
									 *************************************************************************************/
									case 1:

										new Client().allHotelsList();

										break;
									/*************************************************************************************
									 * view bookings of specific hotel
									 *************************************************************************************/
									case 2:
										new Client().viewSpecificHotelBooking();
										break;

									/*************************************************************************************
									 * view guest list of specific hotel
									 *************************************************************************************/
									case 3:
										new Client()
												.viewSpecificHotelGuestList();
										break;
									/*************************************************************************************
									 * view bookings for specified date
									 *************************************************************************************/
									case 4:
										new Client().viewSpecificDateBooking();
										break;

									default:
										break;
									}
									break;
								default:
									System.err.println("Enter valid option");
									break;
								}
								System.out
								.println("Do you want to continue? Yes or No");
						ch = scanner.next().charAt(0);
					} while (ch == 'y' || ch == 'Y');
							} else {
								logger.error("Admin Login failed");
								System.out.println("Not a Valid Admin");
								System.out.println("Check your credentials and login again");
								System.out.println();
								validAdmin = 0;
							}
						} while (validAdmin == 0);

					} catch (HotelBookingException e) {
						System.err.println(e.getMessage());
					}
					break;
				default:
					System.err.println("Enter valid option");
					break;
				}
				System.out
						.println("Do you want to exit from application? Yes or No");
				ch = scanner.next().charAt(0);
			} while (ch == 'n' || ch == 'N');
			System.exit(0);
			break;
		default:
			System.err.println("Enter valid option");
			break;
		}
	}

	public int register(String role) throws HotelBookingException {
		int registerId = 0;
		Scanner scanner1 = new Scanner(System.in);
		usersBean = new UsersBean();

		System.out.println("Enter Name:");
		String name = scanner1.nextLine();
		// Name Validation
		while (!service.isValidName(name)) {
			System.err.println(IMsgMapper.NAME_ERROR);
			name = scanner1.nextLine();
		}

		System.out.println("Enter Address:");
		String address = scanner1.nextLine();
		while (!service.isValidAddress(address)) {
			System.err.println(IMsgMapper.ADDRESS_ERROR);
			address = scanner1.nextLine();
		}
		System.out.println("Enter Mobile Number:");
		String mobile = scanner1.nextLine();
		// Mobile number Validation
		while (!service.isValidMobileNo(mobile)) {
			System.err.println(IMsgMapper.MOBILE_NO_ERROR);
			mobile = scanner1.nextLine();
		}
		System.out.println("Enter Email:");
		String email = scanner1.nextLine();
		// Email Validation
		while (!service.isValidEmail(email)) {

			System.err.println(IMsgMapper.EMAIL_ERROR);
			email = scanner1.nextLine();
		}
		System.out
				.println("Set Password:(min 8 characters and maximum 15 characters)");
		String password = scanner1.nextLine();
		// Password Validation
		while (!service.isValidPassword(password)) {
			System.err.println(IMsgMapper.PASSWORD_ERROR);
			password = scanner1.nextLine();
		}

		usersBean = new UsersBean(password, role, name, mobile, address, email);
		// Registration Method
		registerId = service.registerUser(usersBean);

		return registerId;
	}

	public int login(String role) throws HotelBookingException {
		service = new HotelServiceImpl();
		int loginStatus = 0;
		Scanner scanner2 = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Id:");
		int uid = scanner.nextInt();
		System.out.println("Enter Password:");
		String upassword = scanner2.nextLine();
		// Login Validation Method
		loginStatus = service.loginValidation(uid, upassword, role);
		if(loginStatus==1)
		{
			return uid;
		}
		return loginStatus;
	}

	public void search(String role) throws HotelBookingException {
		int validUser = 1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Where are you travelling to ?");
		ArrayList<String> cityArrayList = new ArrayList<String>();
		cityArrayList = service.viewHotelCity();

		for (int i = 0; i < cityArrayList.size(); i++) {
			System.out.println((i + 1) + " : " + cityArrayList.get(i));
		}
		System.out.println();
		System.out.println("Enter city name : ");
		Scanner scanner4 = new Scanner(System.in);
		String cityOption = scanner4.nextLine();
		while (!service.isValidCity(cityOption)) {
			System.err.println(IMsgMapper.CITY_ERROR);
			cityOption = scanner4.nextLine();
		}
		System.out.println("Enter Check in date (dd-mon-yyyy) : ");
		String checkin = scanner.next();
		while (!service.isValidDate(checkin)) {
			System.err.println(IMsgMapper.DATE_ERROR);
			checkin = scanner.next();
		}
		System.out.println("Enter check out date (dd-mon-yyyy) : ");
		String checkout = scanner.next();
		while (!service.isValidDate(checkout)) {
			System.err.println(IMsgMapper.DATE_ERROR);
			checkout = scanner.next();
		}
		System.out.println("Enter No of adults : ");
		String roomSizestr = scanner4.nextLine();
		while (!service.isValidRoomSize(roomSizestr)) {

			System.err.println(IMsgMapper.ROOM_SIZE_ERROR);
			roomSizestr = scanner4.nextLine();
		}
		int roomSize=Integer.parseInt(roomSizestr);
		
		logger.info("Customer searched hotels in " +cityOption+" Check in : "+checkin+" check out : "+checkout+" room size : "+roomSize);
		ArrayList<FilterBean> hotelFilterList = new ArrayList<FilterBean>();
		hotelFilterList = service.filterHotel(cityOption, roomSize, checkin,
				checkout);
		ArrayList<HotelBean> hotelList = new ArrayList<HotelBean>();

		int temp = 0;
		if (hotelFilterList.isEmpty()) {
			logger.error("No hotels found for above search");
			System.err.println("No hotels found");
			return;
		}

		for (FilterBean filterBean : hotelFilterList) {
			if (temp != filterBean.getHotelId()) {
				System.out.println();
				System.out.println("-----------------------------------------------------------------------------------------");
				System.out.println();
				System.out.println("---------------Hotel Id "
						+ filterBean.getHotelId() + "-----------------");
				hotelList = service.viewHotel(filterBean.getHotelId());

				for (HotelBean hotelBean1 : hotelList) {
					System.out.println("hotel id : " + filterBean.getHotelId());
					System.out.println("Hotel Name : "
							+ hotelBean1.getHotelName());
					System.out.println("Address : " + hotelBean1.getAddress());
					System.out.println("Contact Number 1 : "
							+ hotelBean1.getPhoneNo1());
					System.out.println("Contact Number 2 : "
							+ hotelBean1.getPhoneNo2());
					System.out.println("Email : " + hotelBean1.getEmail());
					System.out.println("Fax : " + hotelBean1.getFax());
					System.out.println("Average Cost per Night : "
							+ hotelBean1.getAvgRatePerNight());
					System.out.println("Hotel Rating : "
							+ hotelBean1.getRating());
					System.out.println();
					System.out.println();
					// i++;
					temp = filterBean.getHotelId();
				}
			}
			RoomDetailsBean roomDetailsBean = service.viewRoom(
					filterBean.getRoomId(), filterBean.getHotelId());
			System.out.println("------------Room Id " + filterBean.getRoomId()
					+ "----------------");
			System.out.println("Room id : " + filterBean.getRoomId());
			System.out.println("Room type : " + roomDetailsBean.getRoomType());
			System.out.println("Room Cost : "
					+ roomDetailsBean.getPerNightRate());
			System.out.println("Room size : " + roomDetailsBean.getRoomSize());
			System.out.println();
			System.out.println();

		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Login to book hotel : ");
		do {
			validUser = 1;
			System.out.println("Enter User Id:");
			int uid = scanner.nextInt();
			System.out.println("Enter Password:");
			String upassword = scanner4.nextLine();

			int loginStatus = service.loginValidation(uid, upassword, role);
			if (loginStatus == 1) {
				logger.info("Customer login successful. User Id : "+ uid);
				System.out.println("Enter hotel id to book : ");
				int hotelId = scanner.nextInt();
				System.out.println("Enter room id to book : ");
				int roomId = scanner.nextInt();
				System.out.println("Enter amount : ");
				double amount = scanner.nextDouble();
				int userId = uid;
				BookingDetailsBean bookingDetailsBean = new BookingDetailsBean(
						roomId, userId, checkin, checkout, roomSize, amount,
						hotelId);
				int bookStatus = service.bookHotel(bookingDetailsBean);
				if (bookStatus == 1) {
					logger.info("Customer booking is successful. booking ID is :"+ bookingDetailsBean.getBookingId());
					System.out
							.println("Your booking is successful\nYour booking ID is :"
									+ bookingDetailsBean.getBookingId());
					System.out.println();
				} else {
					System.err.println("Your booking is failed");
					logger.error("customer "+loginStatus+" booking failed");
				}

			}

			else {
				System.out.println("Not a valid user");
				System.err.println("Check your credentials and try again");
				validUser = 0;
			}
		} while (validUser == 0);
	}

	public void viewBookStatus() throws HotelBookingException {
		ArrayList<BookingDetailsBean> bookingStatusList = new ArrayList<BookingDetailsBean>();
		int validUser = 1;
		service = new HotelServiceImpl();
		System.out.println("Login first to view status");
		Scanner scanner5 = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		do {
			validUser = 1;
			scanner5 = new Scanner(System.in);
			scanner = new Scanner(System.in);
			System.out.println("Enter User Id:");
			int uid = scanner.nextInt();
			System.out.println("Enter Password:");
			String upassword = scanner5.nextLine();
			String role = "customer";

			int loginStatus = service.loginValidation(uid, upassword, role);
			if (loginStatus == 1) {
				System.out.println("Welcome " + uid);
				logger.info("Customer login successful. User Id : "+ uid);

				bookingStatusList = service.viewBookStatus(uid);
				if (bookingStatusList.isEmpty()) {
					logger.error("No booking found");
					System.err.println("No booking found");
					return;
				}
				int s = 1;
				for (BookingDetailsBean bookingDetailsBean : bookingStatusList) {
					System.out.println("----------booking " + s
							+ "-----------------");
					System.out.println("Booking Id : "
							+ bookingDetailsBean.getBookingId());
					System.out.println("Hotel Id : "
							+ bookingDetailsBean.getHotelId());
					System.out.println("Room Id : "
							+ bookingDetailsBean.getHotelId());
					System.out.println("Check In : "
							+ bookingDetailsBean.getBookedFrom().substring(0,
									10));
					System.out
							.println("Check Out : "
									+ bookingDetailsBean.getBookedTo()
											.substring(0, 10));
					System.out.println("Amount : "
							+ bookingDetailsBean.getAmount());

					System.out.println();
					System.out.println();
					s++;
				}

			} else {
				logger.error("Customer login failed ");
				System.out.println("Not a Valid User");
				System.err.println("Check your credentials and try again");
				validUser = 0;
			}
		} while (validUser == 0);
	}

	public void addHotel() throws HotelBookingException {
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Hotel Name");

		String hotelName = scanner1.nextLine();
		while (!service.isValidName(hotelName)) {
			System.err.println(IMsgMapper.NAME_ERROR);
			hotelName = scanner1.nextLine();
		}
		System.out.println("Enter Hotel Address : ");
		String hotelAddress = scanner1.nextLine();
		while (!service.isValidAddress(hotelAddress)) {
			System.err.println(IMsgMapper.ADDRESS_ERROR);
			hotelAddress = scanner1.nextLine();
		}
		System.out.println("Enter City : ");
		String city = scanner1.nextLine();
		while (!service.isValidCity(city)) {
			System.err.println(IMsgMapper.CITY_ERROR);
			city = scanner1.nextLine();
		}
		System.out.println("Enter Phone No1 : ");
		String phoneNo1 = scanner1.nextLine();
		while (!service.isValidMobileNo(phoneNo1)) {
			System.err.println(IMsgMapper.MOBILE_NO_ERROR);
			phoneNo1 = scanner1.nextLine();
		}
		System.out.println("Enter Phone No2 : ");
		String phoneNo2 = scanner1.nextLine();
		while (!service.isValidMobileNo(phoneNo2)) {
			System.err.println(IMsgMapper.MOBILE_NO_ERROR);
			phoneNo2 = scanner1.nextLine();
		}
		System.out.println("Enter Email : ");
		String hotelEmail = scanner1.nextLine();
		while (!service.isValidEmail(hotelEmail)) {

			System.err.println(IMsgMapper.EMAIL_ERROR);
			hotelEmail = scanner1.nextLine();
		}
		System.out.println("Enter fax : ");
		String fax = scanner1.nextLine();
		while (!service.isValidFax(fax)) {
			System.err.println(IMsgMapper.FAX_ERROR);
			fax = scanner1.nextLine();
		}
		System.out.println("Enter Description : ");
		String description = scanner1.nextLine();
		while (!service.isValidDescription(description)) {

			System.err.println(IMsgMapper.DESCRIPTION_ERROR);
			description = scanner1.nextLine();
		}
		System.out.println("Enter average cost per night : ");
		String avgRatePerNightStr = scanner.next();
		while (!service.isValidCost(avgRatePerNightStr)) {

			System.err.println(IMsgMapper.COST_ERROR);
			avgRatePerNightStr = scanner.next();
		}
		Double avgRatePerNight=Double.parseDouble(avgRatePerNightStr);
		System.out.println("Enter Hotel rating (0-5) : ");
		String ratingstr = scanner1.next();
		while (!service.isValidRating(ratingstr)) {

			System.err.println(IMsgMapper.RATING_ERROR);
			ratingstr = scanner.next();
		}
		
		Float rating=Float.parseFloat(ratingstr);
		HotelBean hotelBean = new HotelBean(city, hotelName, hotelAddress,
				description, avgRatePerNight, phoneNo1, phoneNo2, rating,
				hotelEmail, fax);
		// Add hotel method
		int hotelAddStatus = service.addHotel(hotelBean);
		if (hotelAddStatus == 1) {
			logger.info("Hotel Id "+hotelBean.getHotelId()+" added successfully");
			System.out.println("Hotel Id "+hotelBean.getHotelId()+" added successfully");
		} else {
			logger.error("Hotel is not added");
			System.err.println("Hotel is not added");
		}

	}

	public void updateHotel() throws HotelBookingException {
		ArrayList<HotelBean> hotelList = new ArrayList<HotelBean>();
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Enter hotel id to update");
		int hotelId = scanner.nextInt();

		hotelList = service.viewHotel(hotelId);
		if (hotelList.isEmpty()) {
			logger.error("No records found to update");
			System.err.println("No records found to update");
			return;
		}

		for (HotelBean hotelBean1 : hotelList) {
			System.out.println("Below Details stored in the database");
			System.out.println();
			System.out.println("1) Hotel Name : " + hotelBean1.getHotelName());
			System.out.println("2) Address : " + hotelBean1.getAddress());
			System.out.println("3) Contact Number 1 : "
					+ hotelBean1.getPhoneNo1());
			System.out.println("4) Contact Number 2 : "
					+ hotelBean1.getPhoneNo2());
			System.out.println("5) Email : " + hotelBean1.getEmail());
			System.out.println("6) Fax : " + hotelBean1.getFax());
			System.out.println("7) Average Cost per Night : "
					+ hotelBean1.getAvgRatePerNight());
			System.out.println("8) Hotel Rating : " + hotelBean1.getRating());
			System.out.println();
			System.out.println();
		}
		System.out.println("Update Hotel Name : ");
		String hotelName = scanner1.nextLine();
		System.out.println("Update Hotel Address");
		String hotelAddress = scanner1.nextLine();
		System.out.println("Update City");
		String city = scanner1.nextLine();
		System.out.println("Update Phone No1");
		String phoneNo1 = scanner1.nextLine();
		System.out.println("Update Phone No2");
		String phoneNo2 = scanner1.nextLine();
		System.out.println("Update Email");
		String hotelEmail = scanner1.nextLine();
		System.out.println("Update fax");
		String fax = scanner1.nextLine();
		System.out.println("Update Description");
		String description = scanner1.nextLine();
		System.out.println("Update average cost per night");
		double avgRatePerNight = scanner.nextDouble();
		System.out.println("Update Hotel rating");
		float rating = scanner1.nextFloat();
		HotelBean hotelBean = new HotelBean(hotelId, city, hotelName,
				hotelAddress, description, avgRatePerNight, phoneNo1, phoneNo2,
				rating, hotelEmail, fax);
		int hotelUpdateStatus = service.modifyHotel(hotelBean);
		if (hotelUpdateStatus == 1) {
			logger.info("Hotel Id " + hotelBean.getHotelId()
					+ " updated successfully");
			System.out.println("Hotel Id " + hotelBean.getHotelId()
					+ " updated successfully");
		} else {
			logger.error("Hotel Id " + hotelBean.getHotelId()
					+ " is not updated");
			System.err.println("Hotel Id " + hotelBean.getHotelId()
					+ " is not updated");
		}

	}

	public void deleteHotel() throws HotelBookingException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter hotel id to delete");
		int deleteHotelId = scanner.nextInt();

		int validDelete = service.deleteHotelValidate(deleteHotelId);
		if (validDelete == 0) {
			int deleteStatus = service.deleteHotel(deleteHotelId);

			if (deleteStatus == 1) {
				logger.info("Hotel " + deleteHotelId
						+ " deleted Successfully");
				System.out.println("Hotel " + deleteHotelId
						+ " deleted Successfully");

			} else {
				logger.error("Delete failed");
				System.err.println("Delete failed");
			}
		} else {
			logger.error("Hotel is already booked");
			System.err.println("Hotel is already booked");
		}
	}

	public void addRoom() throws HotelBookingException {
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Hotel Id : ");
		String hotelIdstr = scanner1.nextLine();
		while (!service.isValidId(hotelIdstr)) {

			System.err.println(IMsgMapper.ID_ERROR);
			hotelIdstr = scanner1.nextLine();
		}
		int hotelId=Integer.parseInt(hotelIdstr);
		System.out.println("Enter Room No : ");
		String roomNo = scanner1.nextLine();
		while (!service.isValidRoomNo(roomNo)) {

			System.err.println(IMsgMapper.ROOM_NO_ERROR);
			roomNo = scanner1.nextLine();
		}
		System.out.println("Enter Room Type : ");
		String roomType = scanner1.nextLine();
		while (!service.isValidRoomType(roomType)) {

			System.err.println(IMsgMapper.ROOM_TYPE_ERROR);
			roomType = scanner1.nextLine();
		}
		System.out.println("Enter Room Size");
		String roomSizestr = scanner1.nextLine();
		while (!service.isValidRoomSize(roomSizestr)) {

			System.err.println(IMsgMapper.ROOM_SIZE_ERROR);
			roomSizestr = scanner1.nextLine();
		}
		int roomSize=Integer.parseInt(roomSizestr);
		
		System.out.println("Enter cost per night : ");
		String perNightRatestr = scanner1.nextLine();
		while (!service.isValidCost(perNightRatestr)) {

			System.err.println(IMsgMapper.COST_ERROR);
			perNightRatestr = scanner1.nextLine();
		}
		Double perNightRate=Double.parseDouble(perNightRatestr);
		System.out.println("Enter availability (true or false) : ");
		String availability = scanner1.nextLine();
		while (!service.isValidAvailability(availability)) {

			System.err.println(IMsgMapper.AVAILABILITY_ERROR);
			availability = scanner1.nextLine();
		}
		RoomDetailsBean roomDetailsBean = new RoomDetailsBean(hotelId, roomNo,
				roomType, perNightRate, availability, roomSize);
		// Add room method
		int roomAddStatus = service.addRoom(roomDetailsBean);
		if (roomAddStatus == 1) {
			logger.info("Room Id "+roomDetailsBean.getRoomId()+" added successfully");
			System.out.println("Room Id "+roomDetailsBean.getRoomId()+" added successfully");
		} else {
			logger.error("Room not added");
			System.err.println("Room not added");
		}
	}

	public void updateRoom() throws HotelBookingException {
		roomDetailsBean = new RoomDetailsBean();
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Enter hotel id to update");
		int hotelId = scanner.nextInt();
		System.out.println("Enter room id to update");
		int roomId = scanner.nextInt();

		roomDetailsBean = service.viewRoom(roomId, hotelId);
		if (roomDetailsBean.getRoomId()==0) {
			logger.error("No records found to update");
			System.err.println("No records found to update");
			return;
		}
		System.out.println("Below Details stored in the database");
		System.out.println();
		System.out.println("Room Number : " + roomDetailsBean.getRoomNo());
		System.out.println("Room type : " + roomDetailsBean.getRoomType());
		System.out.println("Room Cost : " + roomDetailsBean.getPerNightRate());
		System.out.println("Room size : " + roomDetailsBean.getRoomSize());
		System.out.println("Availability Status : "
				+ roomDetailsBean.getAvailability());
		System.out.println();
		System.out.println();
		System.out.println("Update Room No");
		String roomNo = scanner1.nextLine();
		System.out.println("Update Room Type");
		String roomType = scanner1.nextLine();
		System.out.println("Update Room Size");
		int roomSize = scanner.nextInt();
		System.out.println("Update cost per night");
		double perNightRate = scanner.nextDouble();
		System.out.println("Update availability");
		String availability = scanner1.nextLine();

		RoomDetailsBean roomDetailsBean = new RoomDetailsBean(hotelId, roomId,
				roomNo, roomType, perNightRate, availability, roomSize);

		// update room method
		int roomUpdateStatus = service.modifyRoom(roomDetailsBean);
		if (roomUpdateStatus == 1) {
			logger.info("Room " + roomId + " updated Successfuly");
			System.out.println("Room " + roomId + " updated Successfuly");
		} else {
			logger.error("Room " + roomId + " not updated");
			System.err.println("Room " + roomId + " not updated");
		}

	}

	public void deleteRoom() throws HotelBookingException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter hotel id ");
		int hotelId = scanner.nextInt();
		System.out.println("Enter room id to delete");
		int roomId = scanner.nextInt();

		RoomDetailsBean roomDetailsBean = new RoomDetailsBean();

		roomDetailsBean.setHotelId(hotelId);
		roomDetailsBean.setRoomId(roomId);
		int validDelete = service.deleteRoomValidate(hotelId, roomId);
		if (validDelete == 0) {
			int deleteStatus = service.deleteRoom(roomDetailsBean);

			if (deleteStatus == 1) {
				logger.info("Room " + roomId+ " deleted Successfully in Hotel " + hotelId);
				System.out.println("Room " + roomId+ " deleted Successfully in Hotel " + hotelId);

			} else {
				logger.error("Delete failed");
				System.out.println("Delete failed");
			}
		} else {
			logger.error("Room is already booked");
			System.out.println("Room is already booked");
			System.out.println();
		}
	}

	public void allHotelsList() throws HotelBookingException {
		ArrayList<HotelBean> hotelList = new ArrayList<HotelBean>();
		hotelList = service.viewAllHotels();
		if (hotelList.isEmpty()) {
			logger.error("No hotels found");
			System.err.println("No hotels found");
			return;
		}

		for (HotelBean hotelBean1 : hotelList) {
			System.out.println("---------------------------Hotel Id  "
					+ hotelBean1.getHotelId() + "-------------------------");
			System.out.println();
			System.out.println("Hotel Name : " + hotelBean1.getHotelName());
			System.out.println("Address : " + hotelBean1.getAddress());
			System.out.println("City : " + hotelBean1.getCity());
			System.out
					.println("Contact Number 1 : " + hotelBean1.getPhoneNo1());
			System.out
					.println("Contact Number 2 : " + hotelBean1.getPhoneNo2());
			System.out.println("Email : " + hotelBean1.getEmail());
			System.out.println("Fax : " + hotelBean1.getFax());
			System.out.println("Average Cost per Night : "
					+ hotelBean1.getAvgRatePerNight());
			System.out.println("Hotel Rating : " + hotelBean1.getRating());
			System.out.println();
			System.out.println();
			System.out.println();
		}

	}

	void viewSpecificHotelBooking() throws HotelBookingException {

		ArrayList<BookingDetailsBean> hotelBookingList = new ArrayList<BookingDetailsBean>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter hotel id ");
		int hotelId = scanner.nextInt();
		hotelBookingList = service.viewSpecificHotelBooking(hotelId);
		if (hotelBookingList.isEmpty()) {
			logger.error("No booking found");
			System.err.println("No booking found");

			return;
		}

		for (BookingDetailsBean bookingDetailsBean : hotelBookingList) {
			System.out.println("--------------Booking Id "
					+ bookingDetailsBean.getBookingId()
					+ " ----------------------");
			System.out.println();
			System.out.println("User Id : " + bookingDetailsBean.getUserId());
			System.out.println("Room Id : " + bookingDetailsBean.getRoomId());
			System.out.println("Check-in date (yyyy-mm-dd) : "
					+ bookingDetailsBean.getBookedFrom().substring(0, 10));
			System.out.println("check-out date (yyyy-mm-dd) : "
					+ bookingDetailsBean.getBookedTo().substring(0, 10));
			System.out.println("Number of adults : "
					+ bookingDetailsBean.getNoOfAdults());
			System.out.println("Amount Paid : "
					+ bookingDetailsBean.getAmount());
			System.out.println();
			System.out.println();
		}

	}

	public void viewSpecificHotelGuestList() throws HotelBookingException {

		ArrayList<UsersBean> hotelGuestList = new ArrayList<UsersBean>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter hotel id ");
		int hotelId = scanner.nextInt();
		hotelGuestList = service.viewSpecificHotelGuestList(hotelId);
		if (hotelGuestList.isEmpty()) {
			logger.error("No guest list found");
			System.out.println("No guest list found");
			System.out.println();
			return;
		}

		for (UsersBean usersBean : hotelGuestList) {
			System.out.println("--------------User Id " + usersBean.getUserId()
					+ " ----------------------");
			System.out.println();
			System.out.println("Name : " + usersBean.getUserName());
			System.out.println("Mobile number : " + usersBean.getMobileNo());
			System.out.println("Address : " + usersBean.getAddress());
			System.out.println("Email : " + usersBean.getEmail());
			System.out.println();
			System.out.println();
		}

	}

	public void viewSpecificDateBooking() throws HotelBookingException {
		ArrayList<BookingDetailsBean> specificDateBookingList = new ArrayList<BookingDetailsBean>();
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Enter date : ");
		String date = scanner1.nextLine();
		specificDateBookingList = service.viewSpecificDateBooking(date);
		if (specificDateBookingList.isEmpty()) {
			logger.error("No booking found");
			System.err.println("No booking found");
			return;
		}
		for (BookingDetailsBean bookingDetailsBean : specificDateBookingList) {
			System.out.println("--------------Booking Id "
					+ bookingDetailsBean.getBookingId()
					+ " ----------------------");
			System.out.println();
			System.out.println("User Id : " + bookingDetailsBean.getUserId());
			System.out.println("Hotel Id : " + bookingDetailsBean.getHotelId());
			System.out.println("Room Id : " + bookingDetailsBean.getRoomId());
			System.out.println("Check-in date (yyyy-mm-dd) : "
					+ bookingDetailsBean.getBookedFrom().substring(0, 10));
			System.out.println("check-out date (yyyy-mm-dd) : "
					+ bookingDetailsBean.getBookedTo().substring(0, 10));
			System.out.println("Number of adults : "
					+ bookingDetailsBean.getNoOfAdults());
			System.out.println("Amount Paid : "
					+ bookingDetailsBean.getAmount());
			System.out.println();
			System.out.println();
		}

	}

	public void employeeHotelSearch() throws HotelBookingException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Where the customer travelling to ?");
		ArrayList<String> cityArrayList = new ArrayList<String>();
		cityArrayList = service.viewHotelCity();
		for (int i = 0; i < cityArrayList.size(); i++) {
			System.out.println((i + 1) + " : " + cityArrayList.get(i));
		}
		System.out.println();
		System.out.println("Enter city name : ");
		Scanner scanner4 = new Scanner(System.in);
		String cityOption = scanner4.nextLine();
		
		System.out.println("Enter Check in date (dd-mon-yyyy) : ");
		String checkin = scanner4.nextLine();
		System.out.println("Enter check out date (dd-mon-yyyy) : ");
		String checkout = scanner4.nextLine();

		System.out.println("Enter No of adults : ");
		int roomSize = scanner.nextInt();

		ArrayList<FilterBean> hotelFilterList = new ArrayList<FilterBean>();
		hotelFilterList = service.filterHotel(cityOption, roomSize, checkin,
				checkout);
		ArrayList<HotelBean> hotelList = new ArrayList<HotelBean>();

		int temp = 0;

		for (FilterBean filterBean : hotelFilterList) {
			if (temp != filterBean.getHotelId()) {
				System.out.println("---------------Hotel Id "
						+ filterBean.getHotelId() + "-----------------");
				hotelList = service.viewHotel(filterBean.getHotelId());

				for (HotelBean hotelBean1 : hotelList) {
					System.out.println("hotel id : " + filterBean.getHotelId());
					System.out.println("Hotel Name : "
							+ hotelBean1.getHotelName());
					System.out.println("Address : " + hotelBean1.getAddress());
					System.out.println("Contact Number 1 : "
							+ hotelBean1.getPhoneNo1());
					System.out.println("Contact Number 2 : "
							+ hotelBean1.getPhoneNo2());
					System.out.println("Email : " + hotelBean1.getEmail());
					System.out.println("Fax : " + hotelBean1.getFax());
					System.out.println("Average Cost per Night : "
							+ hotelBean1.getAvgRatePerNight());
					System.out.println("Hotel Rating : "
							+ hotelBean1.getRating());
					System.out.println();
					System.out.println();
					// i++;
					temp = filterBean.getHotelId();
				}
			}

			RoomDetailsBean roomDetailsBean = service.viewRoom(
					filterBean.getRoomId(), filterBean.getHotelId());
			System.out.println("------------Room Id " + filterBean.getRoomId()
					+ "----------------");
			System.out.println("Room id : " + filterBean.getRoomId());
			System.out.println("Room type : " + roomDetailsBean.getRoomType());
			System.out.println("Room Cost : "
					+ roomDetailsBean.getPerNightRate());
			System.out.println("Room size : " + roomDetailsBean.getRoomSize());
			System.out.println();
			System.out.println();
		}
		if (hotelFilterList.isEmpty()) {
			logger.error("No hotels found");
			System.err.println("No hotels found ");
			System.out.println();
			return;
		}
		System.out.println("Register customer details in behalf of Customer..");
		System.out.println();
		String role = "customer";
		int registerStatus = new Client().register(role);
		if (registerStatus > 0) {
			logger.info("Customer Registered successfully "+registerStatus);
			System.out.println("Customer Registered successfully");
			System.out.println("Use below id for hotel booking : "
					+ registerStatus);
			System.out.println();

			System.out.println("Enter hotel id to book : ");
			int hotelId = scanner.nextInt();
			System.out.println("Enter room id to book : ");
			int roomId = scanner.nextInt();
			System.out.println("Enter amount : ");
			double amount = scanner.nextDouble();
			int userId = registerStatus;
			BookingDetailsBean bookingDetailsBean = new BookingDetailsBean(
					roomId, userId, checkin, checkout, roomSize, amount,
					hotelId);
			int bookStatus = service.bookHotel(bookingDetailsBean);
			if (bookStatus == 1) {
				logger.info("Customer's booking is successful. Booking ID is :"
								+ bookingDetailsBean.getBookingId());
				System.out
						.println("Customer's booking is successful\nBooking ID is :"
								+ bookingDetailsBean.getBookingId());
			} else {
				logger.error("Customer's booking failed");
				System.err.println("Customer's booking failed");
			}
		} else {
			logger.error("Customer not registered");
			System.err.println("Customer not registered");
		}
	}
}
