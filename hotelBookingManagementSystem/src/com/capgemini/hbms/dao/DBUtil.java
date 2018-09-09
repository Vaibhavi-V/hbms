/*********************************************************************************************************
 *  -Application : Hotel Booking Management System
 *  -Author name : Vaibhavi V
 *  -Emp Id      : 155316
 *  -Description : Contains Connection method to connect to oracle database
 **********************************************************************************************************/


package com.capgemini.hbms.dao;

import java.sql.*;

public class DBUtil {
	

	public static Connection getConnection() throws Exception {

		Connection conn = null;

		// Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@10.219.34.3:1521:orcl","trg223","training223");

		return conn;
	}

}
