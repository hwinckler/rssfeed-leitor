package rssfeedleitor.bo;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.dao.CategoryDAO;
import rssfeedleitor.model.Category;

public class CategoryBOImp implements CategoryBO {

	private static final Logger logger = LoggerFactory.getLogger(CategoryBOImp.class);
	
	@Inject
	private CategoryDAO categoryDAO;
	
	public void insert(String title) throws Exception {
		logger.debug("insert()...");
		
		if(title == null || title.isEmpty()){
			throw new Exception("Title is empty");
		}
		
		title = title.trim();
		
		if(categoryDAO.findByTitle(title) != null){
			throw new Exception("Title already exists");
		}
		
		categoryDAO.insert(new Category(title, new Date()));
	}

	@Override
	public List<Category> findAll() {
		logger.debug("findAll()...");
		return categoryDAO.findAll();
	}

	@Override
	public Category findById(Integer id) {
		logger.debug("findById()...");
		return categoryDAO.findById(id);
	}

}
