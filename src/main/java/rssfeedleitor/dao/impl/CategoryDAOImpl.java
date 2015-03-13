package rssfeedleitor.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.cdi.Mapper;

import rssfeedleitor.dao.CategoryDAO;
import rssfeedleitor.mapper.CategoryMapper;
import rssfeedleitor.model.Category;


public class CategoryDAOImpl implements CategoryDAO{

	private static final Logger logger = LogManager.getLogger(CategoryDAOImpl.class);
	
	@Inject 
	@Mapper
	private CategoryMapper categoryMapper;
	
	public void insert(Category category) {
		logger.debug("insert...");
		categoryMapper.insert(category);
	}

	@Override
	public List<Category> findAll() {
		logger.debug("findAll...");
		return categoryMapper.findAll();
	}

	@Override
	public Category findById(Integer id) {
		logger.debug("findById...");
		return categoryMapper.findById(id);
	}

}
