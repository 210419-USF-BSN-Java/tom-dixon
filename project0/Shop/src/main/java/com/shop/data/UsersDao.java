package com.shop.data;

import com.shop.models.User;

public interface UsersDao extends GenericDao<Object>{
	// CRUD operations
	Integer add(User u);
	User get(int i); // get by id
	User get(String firstName, String lastName); // get by name
	User update(int id, User u);
	Integer remove(User u);
}
