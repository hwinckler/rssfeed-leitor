package rssfeedleitor.bo.test;

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
import rssfeedleitor.guice.AppModule;
import rssfeedleitor.model.Category;
import rssfeedleitor.model.User;

import com.google.inject.Guice;
import com.google.inject.Injector;

import dbunit.dataset.load.DBUnitLoad;

public class CategoryBOTest extends DBUnitLoad {

	@Inject
	static CategoryBO categoryBO;
	
	@Inject
	static UserBO userBO;
	
	static User user;
	
	final static String dataSet = "/CategoryDataset.xml";
	
	@BeforeClass
	public static void init() throws Exception {
		setUp(dataSet);
		
		Injector injector = Guice.createInjector(new AppModule());
		categoryBO = injector.getInstance(CategoryBO.class);
		userBO = injector.getInstance(UserBO.class);
	}
	

	@Test
	public void addCategory() throws CategoryException, InvalidUserException{

		user = userBO.createsNotExist(new User("user1@user.com"));
		
		Category category1 = new Category(user, "Outros");
		categoryBO.insert(category1);
	}
	
	@Test
	public void findAll(){
		
		List<Category> categories = categoryBO.findAll(user);
		
		Assert.assertEquals(2, categories.size());
	}
	
	@Test
	public void findById(){
		
		Category category = categoryBO.find(new Category(user, "Outros"));
		
		Assert.assertEquals("Outros", category.getTitle());
		Assert.assertEquals(2, category.getId().intValue());
		
		Assert.assertEquals(0, category.getChannels().size());
	}
	
	@Test
	public void defaultCategory(){
		
		Category category = categoryBO.findDefaultCategory(user);
		
		Assert.assertEquals(Category.DEFAULT, category.getTitle());
		Assert.assertEquals(1, category.getId().intValue());
	}	

	@Test
	public void updateCategory(){
		
		Category category = categoryBO.findById(2, user);
		category.setTitle("Outros updated");

		categoryBO.update(category);
		
		Category categoryUpdated = categoryBO.findById(2, user);
		
		Assert.assertEquals("Outros updated", categoryUpdated.getTitle());
		Assert.assertEquals(2, categoryUpdated.getId().intValue());		
		
	}
	
	@AfterClass
	public static void end() throws Exception {
		tearDown();
	}
	
}
