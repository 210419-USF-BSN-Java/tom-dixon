package com.shop.data.daos;

import com.shop.data.models.User;

public interface UsersDao extends GenericDao<User>{
	// CRUD operations
	User add(User u);
	User get(int i); // get by id
	User get(String firstName, String lastName); // get by name
	User update(int id, User u);
	Integer remove(User u);
}
