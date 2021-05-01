package com.shop.presentation;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.shop.data.models.Item;
import com.shop.data.models.User;
import com.shop.presentation.components.Ui;
import com.shop.services.ItemsService;
import com.shop.services.UsersService;

public class View {
	UsersService uService;
	ItemsService iService;
	String textFileUrlStub; // looong file path
	String userResponse;
	Ui ui;
	View view;
	User currentUser;
	private static final Scanner SC = new Scanner(System.in);

	public View() {
		view = new View();
	}

	public View(UsersService uService, ItemsService iService) {
		this.uService = uService;
		this.iService = iService;
		textFileUrlStub = "/home/noxid/Revature/Java Fullstack/Assignments/tom-dixon/project0/Shop/src/main/resources/menuText/";
	}

	public void displayShopSign() {
		File f = new File(textFileUrlStub + "shop_sign");
		Ui header = new Ui();
		header.textBlock(f);
	}

	public void welcome() {
		String choice = "";
		File f = new File(textFileUrlStub + "welcome");
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

	private void inventoryEmpMenu() {
		File empMenu = new File(textFileUrlStub + "inventoryEmpMenu");
		Ui ui = new Ui();
		ui.textBlock(empMenu);

		List<String> validChoices = new ArrayList<String>(Arrays.asList("1", "2"));
		String choice = "";
		while (!validChoices.contains(choice)) {
			ui.textBlock(empMenu);
			choice = SC.nextLine();
			if (!validChoices.contains(choice)) {
				System.out.println("** INVALID CHOICE **");
			}
		}

		switch (Integer.parseInt(choice)) {
			case 1:
				addItem();
				break;
			case 2:
				removeItem();
				break;
			case 3:
				employeeMain();
		}

	}

	private void removeItem() {
	}

	private void addItem() {
		String name = "";
		String priceStr = "";
		Double price = 0.00;

		// validate price entry
		boolean validEntry = false;

		File addItem = new File(textFileUrlStub + "addItem");
		Ui ui = new Ui();
		ui.textBlock(addItem);

		// item name
		while (name.length() < 3) {
			System.out.print("Item name: ");
			name = SC.nextLine();
		}
		// item price
		while (!validEntry) {
			System.out.print("Item price (##.## format): $");
			priceStr = SC.nextLine();

			try {
				price = Double.parseDouble((priceStr));
				// service call add item
				iService.addNewItem(new Item(name, price));
				validEntry = true;

				System.out.println("New item successfully added");

				//
				String enterAnotherItem = "";
				System.out.print("Would you like to add another item (y/n)? ");
				while (!(enterAnotherItem.equals("y") || enterAnotherItem.equals("n"))) {
					enterAnotherItem = SC.nextLine();
					if (!(enterAnotherItem.equals("y") || enterAnotherItem.equals("n"))) {
						System.out.println("** INVALID ENTRY **");
					}
				}

				if (enterAnotherItem.equals("y")) {
					addItem();
				} else {
					System.out.println("** Redirecting to Employee Main Menu... **");
					employeeMain();
				}

			} catch (NumberFormatException e) {
				ui.margin(10);
				System.out.println("** INVALID ENTRY **");
				System.out.println("Please try again.");
				addItem();
			} catch (Exception e) {
				System.out.println("Something went wrong adding the item. Please try again.");
				addItem();
			}
		}

	}

	private void signup() {
		File f = new File(textFileUrlStub + "signup");
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

		// signup service

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
					// log-in
					currentUser = u;
					// logged in. Route by usertype
					switch (userType) {
						case "customer":
							customerMenu00();
							break;
						case "employee":
							employeeMain();
							break;
						default:
							managerMain();
					}
				}
			} else {
				// incorrect login information. rerouting to main menu
				System.out.println("*** ERROR LOGGIN IN. REROUTING TO MAIN MENU");
				view.welcome();
			}
		}

	}

	private void managerMain() {

	}

	private void customerMenu00() {

	}

	public void employeeMain() {
		Ui ui = new Ui();
		File greeting = new File(textFileUrlStub + "loginGreeting");
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
				inventoryEmpMenu();
				break;
			case 2:
				offers();
				break;
			default:
				payments();
				break;

		}
	}

	private void payments() {
		System.out.println("payments");
	}

	private void offers() {
		System.out.println("offers");
	}

}
