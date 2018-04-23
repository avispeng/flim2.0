package com.orangedietc.flim.service;

import com.orangedietc.flim.po.UsersCustom;

public interface UsersService {
	
	public UsersCustom findUserById(Integer userid) throws Exception;
	
	public void InsertUser(UsersCustom usersCustom) throws Exception;
	
	public UsersCustom findUserByName(String username) throws Exception;

}
