/*********************************************************************************************************
 *  -Application : Hotel Booking Management System
 *  -Author name : Vaibhavi V
 *  -Emp Id      : 155316
 *  -Description : Contains user details bean class
 **********************************************************************************************************/

package com.capgemini.hbms.bean;

public class UsersBean {

	private int userId;
	private String password;
	private String role;
	private String userName;
	private String mobileNo;
	private String address;
	private String email;
	
	public UsersBean() {
		
	}

	public UsersBean(int userId, String password, String role, String userName,
			String mobileNo, String address, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.userName = userName;
		this.mobileNo = mobileNo;
		this.address = address;
		this.email = email;
	}

	public UsersBean(String password, String role, String userName,
			String mobileNo,  String address, String email) {
		super();
		this.password = password;
		this.role = role;
		this.userName = userName;
		this.mobileNo = mobileNo;
		this.address = address;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/*public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
*/
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
