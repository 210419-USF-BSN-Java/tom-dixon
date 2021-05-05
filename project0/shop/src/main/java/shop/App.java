package shop;


import com.shop.data.daos.ItemsDao;
import com.shop.data.daos.ItemsDaoImpl;
import com.shop.data.daos.OffersDao;
import com.shop.data.daos.OffersDaoImpl;
import com.shop.data.daos.PaymentsDao;
import com.shop.data.daos.PaymentsDaoImpl;
import com.shop.data.daos.UsersDao;
import com.shop.data.daos.UsersDaoImpl;
import com.shop.data.models.Item;
import com.shop.presentation.View;
import com.shop.services.ItemsService;
import com.shop.services.OffersService;
import com.shop.services.PaymentsService;
import com.shop.services.UsersService;
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
	
		
		view.displayShopSign();
		view.welcome();
	}

}
