/*********************************************************************************************************
 *  -Application : Hotel Booking Management System
 *  -Author name : Vaibhavi V
 *  -Emp Id      : 155316
 *  -Description : Contains test cases for bean and dao methods
 **********************************************************************************************************/


package com.capgemini.hbms.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.hbms.bean.HotelBean;
import com.capgemini.hbms.dao.HotelDAOImpl;
import com.capgemini.hbms.dao.IHotelDAO;


public class HotelDAOImplTest {
	IHotelDAO hotelDAO = null;
	
	/*
	patientDAO= new PatientDAO();
	PatientBean patientBean= new PatientBean("test",20,"7894563211","suffering from cold");
	patientDAO.addPatientDetails(patientBean);
	assertEquals(2, patientBean.getPatientId());
	assertEquals("test", patientBean.getPatientName());
	assertEquals(20, patientBean.getAge());
	assertEquals("7894563211", patientBean.getPhone());
	assertEquals("suffering from cold", patientBean.getDescription());
*/
	@Test
	public void testAddHotel() {
		hotelDAO = new HotelDAOImpl();
		HotelBean hotelBean=new HotelBean(25,"shirdi","sai bansi","temple area","spacious rooms",800,"9874563211","7894561231",4.1,"bansi@gmail.com","12-145-1456327");
		assertEquals(25,hotelBean.getHotelId());
		assertEquals("sai bansi",hotelBean.getHotelName());
		assertEquals("shirdi",hotelBean.getCity());
		assertEquals("temple area",hotelBean.getAddress());
		assertEquals("spacious rooms",hotelBean.getDescription());
		assertEquals(800,hotelBean.getAvgRatePerNight());
		assertEquals("9874563211",hotelBean.getPhoneNo1());
		assertEquals("7894561231",hotelBean.getPhoneNo2());
		assertEquals(4.1,hotelBean.getRating());
		assertEquals("bansi@gmail.com",hotelBean.getEmail());
		assertEquals("12-145-1456327",hotelBean.getFax());
		
		
	}

	@Test
	public void testDeleteHotelValidate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteHotel() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyHotel() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewHotel() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddRoom() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteRoomValidate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteRoom() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyRoom() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegisterUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoginValidation() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewHotelCity() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewRoom() {
		fail("Not yet implemented");
	}

	@Test
	public void testFilterHotel() {
		fail("Not yet implemented");
	}

	@Test
	public void testBookHotel() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewBookStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewAllHotels() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewSpecificHotelBooking() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewSpecificHotelGuestList() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewSpecificDateBooking() {
		fail("Not yet implemented");
	}

}
