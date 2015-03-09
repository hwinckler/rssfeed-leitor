package rssfeedleitor.dao.test;

import java.util.Date;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import rssfeedleitor.dao.CategoryDAO;
import rssfeedleitor.model.Category;

public class CategoryDAOTest {

	@Inject
	CategoryDAO categoryDAO;
	
	public CategoryDAOTest() {
		
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		
		categoryDAO = container.instance().select(CategoryDAO.class).get();
	}
	
	@Test
	public void newCategory(){
		
		Category category1 = new Category("Java", new Date());
		Category category2 = new Category("Tecnologias", new Date());
		Category category3 = new Category("Agile e TDD", new Date());
		
		categoryDAO.insert(category1);
		categoryDAO.insert(category2);
		categoryDAO.insert(category3);
		
		System.out.println("id1: " + category1.getId());
		System.out.println("id2: " + category2.getId());
	}
	
//	@Test
//	public void findAll(){
//		
//		List<Category> categories = categoryDAO.findAll();
//		
//		Assert.assertEquals(3, categories.size());
//	}
//	
//	@Test
//	public void findCategoryById(){
//		Integer id = 3;
//		Category category = categoryDAO.findById(id);
//		
//		Assert.assertEquals("Agile e TDD", category.getTitle());
//	}
	
}
