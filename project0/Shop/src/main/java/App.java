
//import com.shop.data.daos.ItemsDao;1
//import com.shop.data.daos.ItemsDaoImpl;
//import com.shop.data.daos.PaymentsDao;
//import com.shop.data.daos.PaymentsDaoImpl;

import com.shop.data.daos.UsersDao;
import com.shop.data.daos.ItemsDao;

import com.shop.data.daos.UsersDaoImpl;
import com.shop.data.daos.ItemsDaoImpl;
import com.shop.services.UsersService;
import com.shop.services.ItemsService;

import com.shop.presentation.View;

public class App {

	public static void main(String[] args) {

		UsersDao uDao = new UsersDaoImpl();
		ItemsDao iDao = new ItemsDaoImpl();
		UsersService uService = new UsersService(uDao);
		ItemsService iService = new ItemsService(iDao);
		View view = new View(uService, iService);

		// call these in view.init()
		view.displayShopSign();
		view.welcome();
	}
}