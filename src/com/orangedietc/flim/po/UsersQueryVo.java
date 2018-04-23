package com.orangedietc.flim.po;

import java.util.List;

public class UsersQueryVo {
	
	private List<UsersCustom> usersList;
	
	private UsersCustom usersCustom;
	
	private Users users;

	public List<UsersCustom> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<UsersCustom> usersList) {
		this.usersList = usersList;
	}

	public UsersCustom getUsersCustom() {
		return usersCustom;
	}

	public void setUsersCustom(UsersCustom usersCustom) {
		this.usersCustom = usersCustom;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
