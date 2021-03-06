package com.shop.presentation;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.xml.stream.StreamFilter;

import com.shop.data.models.Item;
import com.shop.data.models.Offer;
import com.shop.data.models.Payment;
import com.shop.data.models.User;
import com.shop.presentation.components.Ui;
import com.shop.services.ItemsService;
import com.shop.services.OffersService;
import com.shop.services.PaymentsService;
import com.shop.services.UsersService;
import com.shop.util.Calc;

public class View {
	UsersService uService;
	ItemsService iService;
	OffersService oService;
	PaymentsService pService;
	String textFileUrlStub; // looong file path
	String userResponse;
	Ui ui;
	View view;
	User currentUser = null;
	private static final Scanner SC = new Scanner(System.in);

	public View() {
		view = new View();
	}

	public View(UsersService uService, ItemsService iService, OffersService oService, PaymentsService pService) {
		this.uService = uService;
		this.iService = iService;
		this.oService = oService;
		this.pService = pService;
		ui = new Ui();
		textFileUrlStub = "/home/noxid/Revature/java-fullstack/Assignments/tom-dixon/project0/Shop/src/main/resources/menuText/";
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
			ui.hr();
			System.out.print("Selection: ");
			choice = SC.nextLine();
			ui.margin(2);
			if (!validChoices.contains(choice)) {
				ui.invalidChoice();
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

		File menu = currentUserIsCustomer ? new File(textFileUrlStub + "inventoryCustMenu")
				: new File(textFileUrlStub + "inventoryEmpMenu");

		// generate valid choices for customer
		List<Item> inventory = iService.getAvailableInventory();
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
				items = iService.getAvailableInventory();
				ui.itemList(items);
				System.out.println("=======================");
				System.out.print("Enter Item Id or \"n\": ");
			}

			choice = SC.nextLine();
			if (!validMenuChoices.contains(choice)) {
				ui.invalidChoice();
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
					if (i.getId() == Integer.parseInt(choice)) {
						chosenItem = i;
					}
				}
				custOffer(chosenItem);
			}
		}
	}

	private void custOffer(Item i) {

		File header = new File(textFileUrlStub + "custOffer");

		String input;
		double deposit = 0.00;
		double difference = 0.00;
		String plan = "";

		ui.textBlock(header);
		System.out.println(
				i.getName().toUpperCase() + " has some very nice features and is priced to sell at $" + i.getPrice());
		System.out.println("");
		System.out.println("How much would you like to put down on a deposit? ");

		boolean depositValid = false;
		while (!depositValid) {
			System.out.print("Deposit amount: $");
			input = SC.nextLine();

			// validate deposit amount
			try {
				deposit = Double.parseDouble(input);
				if (deposit < i.getPrice()) {
					depositValid = true;
					difference = i.getPrice() - deposit;
				}
			} catch (NumberFormatException e) {
				System.out.println("** VALUE MUST BY NUMERIC **");
			}
		}

		ui.margin(3);
		System.out.println("At " + deposit + " down, you have " + String.format("%.2f", difference)
				+ " left to finance in the form of weekly payments.");
		ui.hr();
		System.out.println("Please choose one of the three options below:");
		ui.hr();
		;
		System.out.println(
				"1) 12 Week Plan: 12 x $" + Calc.paymentAmount(12, difference, 0.05) + " payments at 5% interest");
		System.out.println(
				"2) 24 Week Plan: 24 x $" + Calc.paymentAmount(24, difference, 0.08) + " payments, at 8% interest");
		System.out.println(
				"3) 48 Week Plan: 48 x $" + Calc.paymentAmount(48, difference, 0.15) + " payments, at 12% interest");
		ui.hrBold();

		List<String> validChoices = new ArrayList<>(Arrays.asList("1", "2", "3"));
		while (!validChoices.contains(plan)) {
			System.out.print("Enter 1, 2, or 3 to select a payment plan: ");
			plan = SC.nextLine();
			if (!validChoices.contains(plan)) {
				ui.invalidChoice();
			}
		}

		// set weeks according to payment plan chosen
		int weeks = 0;
		double interest = 0.0;
		if (plan.equals("1")) {
			weeks = 12;
			interest = 0.05;
		} else if (plan.equals("2")) {
			weeks = 24;
			interest = 0.08;
		} else if (plan.equals("3")) {
			weeks = 48;
			interest = 0.15;
		}

		String payment = Calc.paymentAmount(weeks, difference, interest);

		double gross = deposit + (difference * interest) + difference;

		Offer o = new Offer(i.getId(), deposit, weeks, Double.parseDouble(payment), currentUser.getId(), gross);

		ui.hr();
		// add offer service call
		if (oService.addOffer(o) == 1) {
			System.out.println("...Your offer has been successfully added");
			System.out.println("...You are being directed back to the main menu");
			ui.hr();
			customerMain();
		} else {
			System.out.println("There was an error adding your offer. Please try again.");
		}
	}

	private void removeItem() {
		// get all items first
		File header = new File(textFileUrlStub + "inventoryEmpMenu"); // header text
		File prompt = new File(textFileUrlStub + "selectId"); // header text
		List<Item> inventory = iService.getAvailableInventory(); // get items for display and generate valid ids
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
					ui.invalidChoice();
				}
			}

			// remove by id
			if (iService.removeItemById(new Item(Integer.parseInt(choice))) == 1) {
				String removeAnother = "";
				System.out.println("** Item successfully removed **");
				inventory = iService.getAvailableInventory(); // get items for display and generate valid ids
				ui.itemList(inventory);
				System.out.print("Would you like to remove another item (y/n)? ");
				while (!(removeAnother.equals("y") || removeAnother.equals("n"))) {
					removeAnother = SC.nextLine();
					if (!(removeAnother.equals("y") || removeAnother.equals("n"))) {
						ui.invalidChoice();
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
				ui.hrBold();
				System.out.println(" *** New item successfully added ***");
				ui.hr();
				String enterAnotherItem = "";
				System.out.print("Would you like to add another item (y/n):  ");
				while (!(enterAnotherItem.equals("y") || enterAnotherItem.equals("n"))) {
					enterAnotherItem = SC.nextLine();
					if (!(enterAnotherItem.equals("y") || enterAnotherItem.equals("n"))) {
						ui.invalidChoice();
					}
				}

				if (enterAnotherItem.equals("y")) {
					addItem();
				} else {
					ui.margin(2);
					System.out.println("** Redirecting to Employee Main Menu... **");
					employeeMain();
				}

			} catch (NumberFormatException e) {
				ui.margin(10);
				ui.invalidChoice();
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
			ui.margin(2);
			ui.hr();
			System.out.println("** USER NOT FOUND. TRY AGAIN **");
			ui.hr();
			ui.margin(2);
			login();
		}

	}

	private void managerMain() {

	}

	private void customerMain() {
		File greeting = new File(textFileUrlStub + "loginGreeting");
		File menu = new File(textFileUrlStub + "customerMain");
		ui.textBlock(greeting);
		List<String> validChoices = new ArrayList<String>(Arrays.asList("1", "2", "3"));
		String choice = "";
		while (!validChoices.contains(choice)) {
			ui.textBlock(menu);
			System.out.print("Enter selection: ");
			choice = SC.nextLine();
			if (!validChoices.contains(choice)) {
				ui.invalidChoice();
			}
		}
		switch (Integer.parseInt(choice)) {
			case 1:
				inventoryMenu();
				break;
			case 2:
				customerItems();
				break;
			case 3:
				logout();
				break;
			default:
				customerMain();

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
			ui.hr();
			System.out.print("Enter selection: ");
			choice = SC.nextLine();
			if (!validChoices.contains(choice)) {
				ui.invalidChoice();
			}
		}
		switch (Integer.parseInt(choice)) {
			case 1:
				inventoryMenu();
				break;
			case 2:
				employeeOffers();
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
		ui.margin(2);
		ui.hr();
		System.out.println("** Successfully logged out **");
		ui.hr();
		ui.margin(2);
		welcome();
	}

	private void payments() {
		File header = new File(textFileUrlStub + "payments");
		ui.textBlock(header);

		 List<Payment> payments = pService.getPayments();
		 // conver to string list for ui.strinList
		 List<String> items = new ArrayList<>();
		 for(Payment p: payments) {
			items.add(p.toString());
		 }	
		 ui.stringList(items);
		 
		 ui.hrBold();
		 
		 System.out.println("... Rerouting to Employee Main Menu");
		 employeeMain();
	}

	private void customerItems() {
		File greeting = new File(textFileUrlStub + "myItems");
		ui.textBlock(greeting);
		List<Item> myItems = iService.getOwnersItems(currentUser);

		// create item list
		List<String> myItemStrings = new ArrayList<String>();
		for (Item i : myItems) {
			myItemStrings.add(i.toString());
		}
		ui.stringList(myItemStrings);
		ui.hrBold();
		ui.margin(1);

		String choice = "";
		List<String> validMenuChoices = new ArrayList<String>(Arrays.asList("b"));
		// add item ids as valid choices
		for (Item i : myItems) {
			validMenuChoices.add(Integer.toString(i.getId()));
		}

		while (!validMenuChoices.contains(choice)) {
			System.out.print("Enter Purchase Id to make a payment, or 'b' to return to main menu: ");
			choice = SC.nextLine();
			if (!validMenuChoices.contains(choice)) {
				ui.invalidChoice();
			}
		}
		if (!choice.equals("b")) {
			// make a payment then refresh view
			Item chosenItem = null;
			for (Item i : myItems) {
				if (i.getId() == Integer.parseInt(choice)) {
					chosenItem = i;
				}
			}

			// if payment was successful...
			if (pService.processPayment(chosenItem, currentUser) == 2) {
				//
				ui.hr();
				System.out.println("... PAYMENT PROCESSED");
				System.out.println("... Reloading table");
				ui.hr();
			}
			;
			customerItems();
			// if payment was not successful
		} else {
			ui.margin(3);
			ui.hrBold();
			ui.margin(2);
			System.out.println("...Redirecting to main menu...");
			ui.margin(2);
			// redirect to cust main
			customerMain();
		}

	}

	private void employeeOffers() {
		File greeting = new File(textFileUrlStub + "offersEmpHeader");
		ui.textBlock(greeting);
		// offer service call. get all offers
		List<Offer> pendingOffers = oService.getOffers();
		// render pending offers
		ui.offerList(pendingOffers);

		ui.hr();
		ui.hr();
		ui.margin(2);

		// create list of valid user choices
		List<String> validChoices = new ArrayList<String>(Arrays.asList());
		validChoices.add("b"); // "b" routes employee back clearto main menu
		// add pending offer ids to validchoices
		for (Offer o : pendingOffers) {
			validChoices.add(Integer.toString(o.getId()));
		}

		String choice = "";
		while (!validChoices.contains(choice)) {
			System.out.print("Enter Offer Id to approve or reject. Enter 'b' to return to main menu: ");
			choice = SC.nextLine();
			if (!validChoices.contains(choice)) {
				ui.invalidChoice();
			}
		}

		if (choice.equals("b")) {
			employeeMain();
		} else {
			// get selected offer from all offers
			Offer selectedOffer = null;
			for (Offer o : pendingOffers) {
				if (o.getId() == Integer.parseInt(choice)) {
					selectedOffer = o;
				}
			}

			String approveOrReject = "";
			Item item = new Item(selectedOffer.getItemId());

			ui.hr();
			while (!(approveOrReject.equals("a") | approveOrReject.equals("r"))) {
				System.out.println("Enter 'a' to approve or 'r' to reject.");
				System.out.print("Selection: ");
				approveOrReject = SC.nextLine();
				if (!(approveOrReject.equals("a") | approveOrReject.equals("r"))) {
					ui.invalidChoice();
				}
			}

			if (approveOrReject.equals("r")) {
				// implement reject
				if ((oService.rejectOffer(selectedOffer)) > 0) {
					System.out.println("...Offer successfully rejected");
					System.out.println("...Refreshing pending offer table");
					employeeOffers();
				} else {
					System.out.println("*** SOMETHING WENT WRONG. PLEASE TRY AGAIN ***");
					employeeOffers();
				}
			} else {

				// TODO refactor: consolidate into a single offer service call
				int approve = oService.approve(selectedOffer);
				int rejectOffers = oService.rejectOffersByItem(item);
				int assignOwnership = iService.assignOwnership(item, selectedOffer);

				ui.hrBold();
				if (approve > 0 & rejectOffers > 0 & assignOwnership > 0) {
					System.out.println("...Offer successfully approved");
					System.out.println("...Any competing offers rejected");
					System.out.println("...Item removed from available inventory & ownership assigned");
					System.out.println("...Refreshing pending offer table");
					employeeOffers();
				} else {
					System.out.println("*** SOMETHING WENT WRONG. PLEASE TRY AGAIN ***");
					employeeOffers();
				}

			}

		}
	}
}
