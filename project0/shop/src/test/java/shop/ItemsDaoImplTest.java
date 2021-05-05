package shop;

import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import com.shop.data.daos.ItemsDao;
import com.shop.data.daos.ItemsDaoImpl;
import com.shop.data.models.Item;

public class ItemsDaoImplTest {
	static ItemsDao iDao = new ItemsDaoImpl();
	static Item addTest;
	static Item updateTest;
	static Item removeTest;
	
		@Test 
		public void addTest() {
			Item item = new Item();
			assertEquals(1, iDao.add(item));
		}
		
		@Test
		public void getAllTest() {
			assert(iDao.getAll()) != null;
		}

		@Test
		public void removeItem() {
			List<Item> items = iDao.getAll();
			Item[] itemArr = new Item[items.size()];
			itemArr = items.toArray(itemArr);			
			assertEquals(1, iDao.remove(itemArr[0]));
		}
}

