//import com.shop.data.daos.ItemsDao;
//import com.shop.data.daos.ItemsDaoImpl;
//import com.shop.data.daos.PaymentsDao;
//import com.shop.data.daos.PaymentsDaoImpl;
import com.shop.data.daos.UsersDao;
import com.shop.data.daos.UsersDaoImpl;
import com.shop.presentation.View;
//import com.shop.data.models.User;
import com.shop.services.UsersService;

public class App {

	public static void main(String[] args) {

		UsersDao uDao = new UsersDaoImpl();
		UsersService uService = new UsersService(uDao);
//		ItemsDao iDao = new ItemsDaoImpl();
//		PaymentsDao pDao = new PaymentsDaoImpl();
		
		View view = new View(uService);
		view.welcome();
	}

}
