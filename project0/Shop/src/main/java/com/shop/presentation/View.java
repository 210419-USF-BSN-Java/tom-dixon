package com.shop.presentation;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.shop.data.models.User;
import com.shop.presentation.components.Ui;
import com.shop.services.UsersService;

public class View {
	UsersService uService;
	String textFileUrlStub; // looong file path
	String userResponse;
	Ui ui;
	View view;
	private static final Scanner SC = new Scanner(System.in);

	public View() {
		view = new View();
	}

	public View(UsersService uService) {
		this.uService = uService;
		textFileUrlStub = "/home/noxid/java/RevatureCertProgram/Course Repo/Curriculum-Resources/Shop/src/main/resources/menuText/";
	}

	public void displayShopSign() {
		File f = new File(textFileUrlStub + "shop_sign");
		Ui header = new Ui();
		header.textBlock(f);
	}

	public void welcome() {
		String choice = "";
		File f = new File(textFileUrlStub + "/welcome");
		Ui header = new Ui();
		// TODO create util that generates validChoices using varargs...
		List<String> validChoices = new ArrayList<String>(Arrays.asList("1", "2"));
		while (!validChoices.contains(choice)) {
			header.textBlock(f);
			choice = SC.nextLine();

			if (!validChoices.contains(choice)) {
				System.out.println("*** INVALID CHOICE. TRY AGAIN ***");
			}
		}
		switch (Integer.parseInt(choice)) {
			case 1:
				login();
				break;
			case 2:
				signup();
				break;
		}
	}

	private void inventory(User u) {
		File f = new File(textFileUrlStub + "/inventory");
		Ui header = new Ui();
		header.textBlock(f);

		// inventory service call

	}

	private void signup() {
		File f = new File(textFileUrlStub + "/signup");
		String firstName = "";
		String lastName = "";
		String un = "";
		String pw = "";

		Ui header = new Ui();
		header.textBlock(f);

		try {
			while (firstName.length() < 3) {
				System.out.print("First name: ");
				firstName = SC.nextLine();
			}

			while (lastName.length() < 3) {
				System.out.print("Last name: ");
				lastName = SC.nextLine();
			}

			while (un.length() < 3) {
				System.out.print("Username: ");
				un = SC.nextLine();
			}

			while (pw.length() < 3) {
				System.out.print("Password: ");
				pw = SC.nextLine();
			}
		} catch (Exception e) {
			System.out.println("Signup ui error ");
			e.printStackTrace();
		}

		// login service

	}

	public void login() {
		String un = "";
		String pw = "";
		File f = new File(textFileUrlStub + "login");
		Ui header = new Ui();
		header.textBlock(f);

		try {
			// get user input
			while (un.length() < 3) {
				System.out.print("Username: ");
				un = SC.nextLine();
			}

			while (pw.length() < 3) {
				System.out.print("Password: ");
				pw = SC.nextLine();
			}
		} catch (Exception e) {
			System.out.println("login input error");
			e.printStackTrace();
		}

		// service
		User u = uService.getUserByUsername(un);

		// extract user properties
		String username = u.getUsername();
		String password = u.getPassword();
		String userType = u.getUserType();
		if (username != null) {
			if (password.equals(pw)) {
				if (userType != null) {
					// logged in. Route by usertype
					switch (userType) {
						case "customer":
							customerMenu00(u);
							break;
						case "employee":
							employeeMenu00(u);
							break;
						default:
							managerMenu00(u);
					}
				}
			} else {
				// incorrect login information. rerouting to main menu
				System.out.println("*** ERROR LOGGIN IN. REROUTING TO MAIN MENU");
				view.welcome();
			}
		}

	}

	private void managerMenu00(User u) {

	}

	private void customerMenu00(User u) {

	}

	public void employeeMenu00(User u) {
		Ui ui = new Ui();
		File greeting = new File(textFileUrlStub + "empMenu00");
		File menu = new File(textFileUrlStub + "empMenu01");
		ui.textBlock(greeting);

		List<String> validChoices = new ArrayList<String>(Arrays.asList("1", "2", "3"));
		String choice = "";
		while (!validChoices.contains(choice)) {
			ui.textBlock(menu);
			choice = SC.nextLine();
			if (!validChoices.contains(choice)) {
				System.out.println("** INVALID CHOICE **");
			}
		}

		switch (Integer.parseInt(choice)) {
			case 1:
				inventory(u);
				break;
			case 2:
				offers(u);
				break;
			default:
				payments(u);
				break;

		}

	}

	private void payments(User u) {
		System.out.println("payments");
	}

	private void offers(User u) {
		System.out.println("offers");
	}

}
