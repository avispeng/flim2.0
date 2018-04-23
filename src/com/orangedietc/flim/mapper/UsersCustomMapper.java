package com.orangedietc.flim.mapper;

import com.orangedietc.flim.po.UsersCustom;

public interface UsersCustomMapper {
	
	public UsersCustom findUserByName(String username) throws Exception;

}
