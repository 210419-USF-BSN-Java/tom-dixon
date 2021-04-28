import com.shop.data.daos.PaymentsDao;
import com.shop.data.daos.PaymentsDaoImpl;
import com.shop.data.daos.UsersDao;
import com.shop.data.daos.UsersDaoImpl;
import com.shop.data.models.User;

public class App {

	public static void main(String[] args) {

		UsersDao uDao = new UsersDaoImpl();
		PaymentsDao pDao = new PaymentsDaoImpl();
		User u = new User("employee", "Tom", "Dixon", "tom", "1234");
		int i = uDao.add(u);
		System.out.println(i);

	}

}
