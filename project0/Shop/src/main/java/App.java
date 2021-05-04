
//import com.shop.data.daos.ItemsDao;1
//import com.shop.data.daos.ItemsDaoImpl;
//import com.shop.data.daos.PaymentsDao;
//import com.shop.data.daos.PaymentsDaoImpl;

import com.shop.data.daos.UsersDao;

import java.util.List;

import com.shop.data.daos.ItemsDao;

import com.shop.data.daos.UsersDaoImpl;
import com.shop.data.models.Item;
import com.shop.data.models.Offer;
import com.shop.data.daos.ItemsDaoImpl;
import com.shop.data.daos.OffersDao;
import com.shop.data.daos.OffersDaoImpl;
import com.shop.data.daos.PaymentsDao;
import com.shop.data.daos.PaymentsDaoImpl;
import com.shop.services.UsersService;
import com.shop.services.ItemsService;
import com.shop.services.OffersService;
import com.shop.services.PaymentsService;
import com.shop.presentation.View;

public class App {

	public static void main(String[] args) {

		UsersDao uDao = new UsersDaoImpl();
		ItemsDao iDao = new ItemsDaoImpl();
		OffersDao oDao = new OffersDaoImpl();
		PaymentsDao pDao = new PaymentsDaoImpl();
		UsersService uService = new UsersService(uDao);
		ItemsService iService = new ItemsService(iDao);
		OffersService oService = new OffersService(oDao);
		PaymentsService pService = new PaymentsService(iDao, pDao, oDao);
		View view = new View(uService, iService, oService, pService);

		// List<Offer> offers = oService.getOffers();
		// for (Offer o : offers) {
		// System.out.println(o.getDownPayment() + " " + o.getPaymentPerWeek());
		// }
		// Item item = new Item(2);
		// System.out.println(item.getId());
		// System.out.println(oService.rejectOffersByItem(item));

		// oService.deleteOffersByItem(item);

		// List<Offer> offs = oService.getOffers();
		// for (Offer o : offs) {
		// System.out.println(o.getDownPayment() + " " + o.getPaymentPerWeek());
		// }
		// call these in view.init()
		view.displayShopSign();
		view.welcome();
	}
}