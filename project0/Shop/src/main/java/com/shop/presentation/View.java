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
	User currentUser = null;
	private static final Scanner SC = new Scanner(System.in);

	public View() {
		view = new View();
	}

	public View(UsersService uService, ItemsService iService) {
		this.uService = uService;
		this.iService = iService;

		ui = new Ui();

		textFileUrlStub = "/home/noxid/Revature/Java Fullstack/Assignments/tom-dixon/project0/Shop/src/main/resources/menuText/";
	}

	public void displayShopSign() {
		File f = new File(textFileUrlStub + "shop_sign");
		ui.textBlock(f);
	}

	public void welcome() {
		String choice = "";
		File f = new File(textFileUrlStub + "welcome");
		// TODO create util that generates validChoices using varargs...
		List<String> validChoices = new ArrayList<String>(Arrays.asList("1", "2"));
		while (!validChoices.contains(choice)) {
			ui.textBlock(f);
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

	private void inventoryMenu() {
		List<String> validMenuChoices;
		Item chosenItem = null;
		List<Item> items = null;
		boolean currentUserIsCustomer = currentUser.getUserType().equals("customer");

		System.out.println("current user is cust" + currentUserIsCustomer);
		File menu = currentUserIsCustomer ? new File(textFileUrlStub + "inventoryCustMenu")
				: new File(textFileUrlStub + "inventoryEmpMenu");

		// generate valid choices for customer
		List<Item> inventory = iService.getAllItems();
		List<String> validCustomerChoices = new ArrayList<>();

		for (Item i : inventory) {
			validCustomerChoices.add(Integer.toString(i.getId()));
		}

		// add "n" as valid customer choice
		validCustomerChoices.add("n");

		// Valid choices for employee inventory menu are
		List<String> validEmployeeChoices = new ArrayList<String>(Arrays.asList("1", "2", "3"));

		validMenuChoices = currentUserIsCustomer ? validCustomerChoices : validEmployeeChoices;

		String choice = "";
		while (!validMenuChoices.contains(choice)) {
			ui.textBlock(menu);
			// if customer, display inventory
			if (currentUserIsCustomer) {
				// display inventory
				items = iService.getAllItems();
				ui.itemList(items);
				System.out.println("=======================");
				System.out.println("Enter Item Id or \"n\": ");
			}

			choice = SC.nextLine();
			if (!validMenuChoices.contains(choice)) {
				System.out.println("** INVALID CHOICE **");
			}
		}

		if (!currentUserIsCustomer) {
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
		} else {
			if (choice.equals("n")) {
				customerMain();
			} else {
				for (Item i : items) {
					System.out.println("Choice: " + choice);
					if (i.getId() == Integer.parseInt(choice)) {
						chosenItem = i;
					}
				}
				custOffer(chosenItem);
			}
		}
	}

	private void custOffer(Item i) {
		// get item to make an offer on from choice (conver to into, then call item
		System.out.println(i);
		// service getItem(id)
		// if item not found, return to

	}

	private void removeItem() {
		// get all items first
		File header = new File(textFileUrlStub + "inventory"); // header text
		File prompt = new File(textFileUrlStub + "selectId"); // header text
		List<Item> inventory = iService.getAllItems(); // get items for display and generate valid ids
		List<String> validIds = new ArrayList<>(); // holds valid ids to select from
		String choice = "";

		if (inventory.size() == 0) {
			System.out.println("** INVENTORY IS EMPTY. Redirecting to employee main menu...");
			employeeMain();
		} else {

			// display inventory
			ui.textBlock(header);
			ui.itemList(inventory);
			// populate valid id list
			for (Item i : inventory) {
				validIds.add(String.valueOf(i.getId()));
			}

			// get input
			while (!validIds.contains(choice)) {
				ui.textBlock(prompt);
				choice = SC.nextLine();
				if (!validIds.contains(choice)) {
					System.out.println("** INVALID CHOICE **");
				}
			}

			// remove by id
			if (iService.removeItemById(new Item(Integer.parseInt(choice))) == 1) {
				String removeAnother = "";
				System.out.println("** Item successfully removed **");
				inventory = iService.getAllItems(); // get items for display and generate valid ids
				ui.itemList(inventory);
				System.out.print("Would you like to remove another item (y/n)? ");
				while (!(removeAnother.equals("y") || removeAnother.equals("n"))) {
					removeAnother = SC.nextLine();
					if (!(removeAnother.equals("y") || removeAnother.equals("n"))) {
						System.out.println("** INVALID ENTRY **. Try again...");
					}
				}

				if (removeAnother == "y") {
					removeItem();
				} else {
					System.out.println("** Redirecting to Employee Main Menu... **");
					employeeMain();
				}
			} else {
				System.out.println("** ITEM NOT REMOVED SUCCESSFULLY **");
				System.out.println("Please try again");
			}
		}
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
		User u = new User("customer", firstName, lastName, un, pw);
		if (uService.addNewUser(u) == 1) {
			System.out.println("** Registration successful ** ");
			System.out.println("** Redirecting to login... ** ");
			login();
		} else {
			System.out.println("** Something went wrong **");
			System.out.println("** Redirecting to main menu... **");
		}

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

		// get user by username
		User u = uService.getUserByUsername(un);

		// extract user properties
		String username = u.getUsername(); // to check
		String password = u.getPassword();
		String userType = u.getUserType();
		if (username != null) {
			if (password.equals(pw)) {
				currentUser = u;
				if (userType != null) {
					// logged in. Route by usertype
					switch (userType) {
						case "customer":
							customerMain();
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
				System.out.println("** ERROR LOGGIN IN **");
				System.out.println("**  REROUTING TO MAIN MENU **");
				view.welcome();
			}
		} else {
			System.out.println("** USER NOT FOUND. TRY AGAIN **");
			login();
		}

	}

	private void managerMain() {

	}

	private void customerMain() {
		File greeting = new File(textFileUrlStub + "loginGreeting");
		File menu = new File(textFileUrlStub + "customerMain");

		ui.textBlock(greeting);

		List<String> validChoices = new ArrayList<String>(Arrays.asList("1", "2", "3", "4"));
		String choice = "";
		while (!validChoices.contains(choice)) {
			ui.textBlock(menu);
			System.out.print("Enter selection: ");
			choice = SC.nextLine();
			if (!validChoices.contains(choice)) {
				System.out.println("** INVALID CHOICE **");
			}
		}
		switch (Integer.parseInt(choice)) {
			case 1:
				inventoryMenu();
				break;
			case 2:
				offers();
				break;
			case 3:
				payments();
				break;
			case 4:
				logout();
		}
	}

	public void employeeMain() {
		File greeting = new File(textFileUrlStub + "loginGreeting");
		File menu = new File(textFileUrlStub + "empMenu01");
		ui.textBlock(greeting);

		List<String> validChoices = new ArrayList<String>(Arrays.asList("1", "2", "3", "4"));
		String choice = "";
		while (!validChoices.contains(choice)) {
			ui.textBlock(menu);
			System.out.print("Enter selection: ");
			choice = SC.nextLine();
			if (!validChoices.contains(choice)) {
				System.out.println("** INVALID CHOICE **");
			}
		}
		switch (Integer.parseInt(choice)) {
			case 1:
				inventoryMenu();
				break;
			case 2:
				offers();
				break;
			case 3:
				payments();
				break;
			case 4:
				logout();
		}
	}

	private void logout() {
		currentUser = null;
		System.out.println("** Successfully logged out **");
		welcome();
	}

	private void payments() {
		System.out.println("payments");

	}

	private void offers() {
		System.out.println("offers");
	}

}
