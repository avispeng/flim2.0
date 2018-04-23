package com.orangedietc.flim.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.orangedietc.flim.mapper.UsersMapper;
import com.orangedietc.flim.exception.CustomException;
import com.orangedietc.flim.mapper.UsersCustomMapper;
import com.orangedietc.flim.po.Users;
import com.orangedietc.flim.po.UsersCustom;
import com.orangedietc.flim.service.UsersService;

public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper usersMapper;

	@Autowired
	private UsersCustomMapper usersCustomMapper;

	@Override
	public UsersCustom findUserById(Integer userid) throws Exception {
		Users users = usersMapper.selectByPrimaryKey(userid);

		// exception process
		if (users == null) {
			throw new CustomException("This user doesn't exist!");
		}

		UsersCustom usersCustom = new UsersCustom();
		BeanUtils.copyProperties(users, usersCustom);

		return usersCustom;
	}

	@Override
	public void InsertUser(UsersCustom usersCustom) throws Exception {

		usersMapper.insert(usersCustom);

	}

	@Override
	public UsersCustom findUserByName(String username) throws Exception {
		
		return usersCustomMapper.findUserByName(username);
	}

}
