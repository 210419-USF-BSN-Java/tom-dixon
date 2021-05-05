package com.shop.services;

import java.util.List;

import com.shop.data.daos.UsersDao;
import com.shop.data.models.User;

public class UsersService {
	private UsersDao uDao;

	public UsersService(UsersDao uDao) {
		this.uDao = uDao;
	}

	public int addNewUser(User u) {
		return uDao.add(u);
	}

	public List<User> getAllUsers() {
		return uDao.getAll();
	}

	public User getUserByUsername(String username) {
		User user = null;
		user = uDao.get(username);
		return user;
	}

}
