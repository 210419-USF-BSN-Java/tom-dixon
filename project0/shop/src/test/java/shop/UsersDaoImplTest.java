package shop;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import com.shop.data.daos.UsersDao;
import com.shop.data.daos.UsersDaoImpl;
import com.shop.data.models.User;

public class UsersDaoImplTest {
	
	UsersDao uDao = new UsersDaoImpl();
	
	@Test 
	public void testAddUser() {
		User u = new User();
		assertEquals(1, uDao.add(u));
	}
	
	@Test
	public void testGetAllUsers() {
		assert(uDao.getAll()) != null;
	}
	
	@Test 
	public void testGetUserByName() {
		assert(uDao.get("Fake User")) != null;
	}
}