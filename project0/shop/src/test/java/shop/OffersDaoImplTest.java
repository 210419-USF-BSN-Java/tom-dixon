package shop;


import org.junit.*;

import com.shop.data.daos.OffersDao;
import com.shop.data.daos.OffersDaoImpl;

public class OffersDaoImplTest {

	OffersDao oDao = new OffersDaoImpl();

	@Test
	public void getAllOffers() {
		assert (oDao.getAll()) != null;
	}

}
