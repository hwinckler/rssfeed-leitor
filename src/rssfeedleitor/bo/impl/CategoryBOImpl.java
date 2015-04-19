package rssfeedleitor.bo.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.bo.CategoryBO;
import rssfeedleitor.bo.ChannelBO;
import rssfeedleitor.dao.CategoryDAO;
import rssfeedleitor.exception.CategoryAlreadExistsException;
import rssfeedleitor.exception.CategoryException;
import rssfeedleitor.exception.InvalidCategoryException;
import rssfeedleitor.model.Category;
import rssfeedleitor.model.User;

public class CategoryBOImpl implements CategoryBO {

	private static final Logger logger = LoggerFactory.getLogger(CategoryBOImpl.class);
	
	@Inject
	private CategoryDAO categoryDAO;
	@Inject
	private ChannelBO channelBO;
	
	public void insert(Category category) throws CategoryException {
		logger.debug("insert()...");
		
		if(category == null || (category.getTitle() == null && category.getTitle().isEmpty())){
			throw new InvalidCategoryException("Title is empty");
		}
		

		if(categoryDAO.find(category) != null){
			throw new CategoryAlreadExistsException("Title already exists");
		}
		
		categoryDAO.insert(category);
	}

	@Override
	public List<Category> findAllWithUnRead(User user) {
		logger.debug("findAllWithUnRead()...");
		return categoryDAO.findAllWithUnRead(user);
	}
	
	@Override
	public List<Category> findAll(User user) {
		logger.debug("findAll()...");
		return categoryDAO.findAll(user);
	}

	@Override
	public Category find(Category category) {
		logger.debug("findById()...");
		return categoryDAO.find(category);
	}

	@Override
	public void delete(Category category) throws CategoryException {
		logger.debug("delete()...");
		
		Category c = categoryDAO.find(category);
		
		if(c.getTitle().equalsIgnoreCase(Category.DEFAULT)){
			throw new CategoryException("Default category can't be excluded");
		}
		
		//TODO FIX
		//channelBO.updateToDefaultCategory(id, userID);

		categoryDAO.delete(c);
	}

	@Override
	public void update(Category category) {
		logger.debug("update()...");
	
		categoryDAO.update(category);
	}

	@Override
	public void createDefaultCategory(User user) throws CategoryException {
		logger.debug("createDefaultCategory()...");
		insert(Category.newDefault(user));
	}

	@Override
	public Category findDefaultCategory(User user) {
		logger.debug("findDefaultCategory()...");
		return categoryDAO.findDefaultCategory(user);
	}

	@Override
	public Category findById(Integer id, User user) {
		logger.debug("findById()...");
		return categoryDAO.findById(id, user);
	}
	
}
