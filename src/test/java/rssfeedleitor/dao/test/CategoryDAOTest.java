package rssfeedleitor.dao.test;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import rssfeedleitor.dao.CategoryDAO;
import rssfeedleitor.model.Category;
import dbunit.dataset.load.DBUnitLoad;

public class CategoryDAOTest extends DBUnitLoad {

	@Inject
	static CategoryDAO categoryDAO;
		
	final static String dataSet = "/CategoriaDataset.xml";
	
	@BeforeClass
	public static void init() throws Exception {
		setUp(dataSet);
		
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		
		categoryDAO = container.instance().select(CategoryDAO.class).get();
	}
	
	@Test
	public void addCategory(){
		
		Category category1 = new Category("Outros", new Date());
		categoryDAO.insert(category1);
	}
	
	@Test
	public void findAll(){
		
		List<Category> categories = categoryDAO.findAll();
		
		Assert.assertEquals(4, categories.size());
	}
	
	@Test
	public void findById(){
		Integer id = 4;
		Category category = categoryDAO.findById(id);
		
		Assert.assertEquals("Outros", category.getTitle());
		
		Assert.assertEquals(0, category.getChannels().size());
	}
	
	@AfterClass
	public static void end() throws Exception {
		tearDown();
	}
	
}
