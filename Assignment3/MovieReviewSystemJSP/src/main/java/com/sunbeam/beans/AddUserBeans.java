package com.sunbeam.beans;

import com.sunbeam.daos.UsersDao;
import com.sunbeam.pojos.Users;
import com.sunbeam.utils.DateUtil;

public class AddUserBeans {
	private String fname;
	private String lname;
	private String email;
	private String passwd;
	private String mobile;
	private String dob;
	private boolean status;
	
	public AddUserBeans() {
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void saveUser() {
		int cnt = 0;
		
		java.util.Date jdate = DateUtil.parse(dob);		
		Users u = new Users(1, fname, lname, email, passwd, mobile, jdate);
		try(UsersDao udao = new UsersDao()){
			cnt = udao.signUp(u);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		status = (cnt == 1);
	}
	
}
