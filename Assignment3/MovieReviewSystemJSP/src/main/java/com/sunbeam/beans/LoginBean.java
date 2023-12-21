package com.sunbeam.beans;

import com.sunbeam.daos.UsersDao;
import com.sunbeam.pojos.Users;

public class LoginBean {
	//data fields - must have same name as params in jsp:useBean tag
	private String email;
	private String passwd;
	private boolean status;

	public LoginBean() {    
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
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void authentication() {
		try(UsersDao udao = new UsersDao()){
			Users user = udao.signin(email);
			
			if(user != null && user.getPasswd().equals(passwd)) {
				status = true;
			} 			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
