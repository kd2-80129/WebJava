package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.pojos.Users;

public interface UserInt extends AutoCloseable{
	public int signUp(Users u) throws Exception;
	public int editInfo(Users u) throws Exception;
	public int changePasswd(Users user) throws Exception;
	public Users signin(String email) throws Exception;
	public List<Users> displayAll() throws Exception;
}
