
//import com.shop.data.daos.ItemsDao;1
//import com.shop.data.daos.ItemsDaoImpl;
//import com.shop.data.daos.PaymentsDao;
//import com.shop.data.daos.PaymentsDaoImpl;

import com.shop.data.daos.UsersDao;

import java.util.List;

import com.shop.data.daos.ItemsDao;

import com.shop.data.daos.UsersDaoImpl;
import com.shop.data.models.Offer;
import com.shop.data.daos.ItemsDaoImpl;
import com.shop.data.daos.OffersDao;
import com.shop.data.daos.OffersDaoImpl;
import com.shop.services.UsersService;
import com.shop.services.ItemsService;
import com.shop.services.OffersService;
import com.shop.presentation.View;

public class App {

	public static void main(String[] args) {

		UsersDao uDao = new UsersDaoImpl();
		ItemsDao iDao = new ItemsDaoImpl();
		OffersDao oDao = new OffersDaoImpl();
		UsersService uService = new UsersService(uDao);
		ItemsService iService = new ItemsService(iDao);
		OffersService oService = new OffersService(oDao);
		View view = new View(uService, iService, oService);

		List<Offer> offers = oService.getOffers();

		for (Offer o : offers) {
			System.out.println(o.getDownPayment() + " " + o.getPaymentPerWeek());
		}
		// call these in view.init()
		// view.displayShopSign();
		// view.welcome();
	}
}