package rssfeedleitor.bo.test;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import rssfeedleitor.bo.CategoryBO;
import rssfeedleitor.bo.UserBO;
import rssfeedleitor.exception.CategoryException;
import rssfeedleitor.exception.InvalidUserException;
import rssfeedleitor.exception.UserAlreadExistsException;
import rssfeedleitor.guice.AppModule;
import rssfeedleitor.model.Category;
import rssfeedleitor.model.User;

import com.google.inject.Guice;
import com.google.inject.Injector;

import dbunit.dataset.load.DBUnitLoad;

public class UserBOTest extends DBUnitLoad {

	@Inject
	static UserBO userBO;

	@Inject
	static CategoryBO categoryBO;
	
	final static String dataSet = "/UserDataset.xml";
	
	@BeforeClass
	public static void init() throws Exception {
		setUp(dataSet);
		
		Injector injector = Guice.createInjector(new AppModule());
		userBO = injector.getInstance(UserBO.class);
		categoryBO = injector.getInstance(CategoryBO.class);
		
	}
	
	@Test
	public void addUser() throws Exception{

		User user1 = new User("user1@user.com");
		user1.setDate(new Date());

		User user2 = new User("user2@user.com");
		user2.setDate(new Date());
		
		userBO.insert(user1);
		userBO.insert(user2);
	}

	@Test(expected=UserAlreadExistsException.class)
	public void addDuplicate() throws Exception{

		User user1 = new User("user1@user.com");
		user1.setDate(new Date());
		
		userBO.insert(user1);
	}
	
	@Test
	public void createsNotExist() throws InvalidUserException, CategoryException{
		User user = userBO.createsNotExist(new User("user3@user.com"));
		
		Assert.assertEquals(3, user.getId().intValue());
		Assert.assertEquals("user3@user.com", user.getEmail());
	}
	
	@Test
	public void find(){
		User user = userBO.findByEmail("user1@user.com");
		
		Assert.assertEquals(1, user.getId().intValue());
		Assert.assertEquals("user1@user.com", user.getEmail());
	}
	
	@Test
	public void findAll(){
		
		List<User> users = userBO.findAll();
		
		Assert.assertEquals(2, users.size());
	}
	
	@Test
	public void userDefault(){
		
		User user = userBO.findByEmail("user3@user.com");
		
		Category category = categoryBO.findDefaultCategory(user);
		
		Assert.assertEquals(Category.DEFAULT, category.getTitle());
		Assert.assertEquals(1, category.getId().intValue());
	}

	@Test
	public void deleteWithCategory(){

		userBO.delete("user3@user.com");
		
		User user = userBO.findByEmail("user3@user.com");
		
		Assert.assertNull(user);
	}
	
	@AfterClass
	public static void end() throws Exception {
		tearDown();
	}
	
}
