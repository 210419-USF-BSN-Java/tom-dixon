package com.shop.services;

import com.shop.data.daos.UsersDao;
import com.shop.data.models.User;

public class UserService {
	private UsersDao uDao;
	
	UserService(UsersDao uDao){
		this.uDao = uDao;
	}
	
	public int addNewUser(User u) {
		return uDao.add(u);
	}

}
