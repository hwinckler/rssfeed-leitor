package rssfeedleitor.dao.impl;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.cdi.Mapper;

import rssfeedleitor.dao.CategoryDAO;
import rssfeedleitor.model.Category;
import rssfeedleitor.model.CategoryMapper;

public class CategoryDAOImpl implements CategoryDAO{

	private static final Logger logger = LogManager.getLogger(CategoryDAOImpl.class);
	
	@Inject 
	@Mapper
	private CategoryMapper categoryMapper;
	
	public void insert(Category category) {
		logger.debug("inserindo...");
		categoryMapper.insert(category);
		logger.debug("inserido!");
	}

}
