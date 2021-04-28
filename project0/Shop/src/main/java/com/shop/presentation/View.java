package com.shop.presentation;

import java.util.List;

import com.shop.data.models.User;
import com.shop.services.UsersService;

public class View {

	UsersService uService;

	public View(UsersService uService) {
		this.uService = uService;
	}

	public void welcome() {
		System.out.println("Welcome to the Pwnt Store");
		displayUsers();

	}

	public void displayUsers() {
		List<User> users = uService.getAllUsers();
		for (User user : users) {
			System.out.println(
					"Name: " + user.getFirstName() + " " + user.getLastName() + "Username: " + user.getUsername());
		}

	}

}
