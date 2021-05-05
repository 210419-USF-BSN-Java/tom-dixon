package com.shop.data.daos;

import com.shop.data.models.User;

public interface UsersDao extends GenericDao<User> {
	// CRUD operations
	int add(User u);

	User get(int i); // get by id

	User get(String firstName, String lastName); // get by name

	User get(String username); // get by username

	int update(int id, User u);

	int remove(User u);
}
