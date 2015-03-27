package rssfeedleitor.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.dao.CategoryDAO;
import rssfeedleitor.mapper.CategoryMapper;
import rssfeedleitor.model.Category;


public class CategoryDAOImpl implements CategoryDAO{

	private static final Logger logger = LoggerFactory.getLogger(CategoryDAOImpl.class);
	
	@Inject 
	private SqlSessionFactory sqlSessionFactory;
	
	public void insert(Category category) {
		logger.debug("insert()...");
		
		try(SqlSession session = sqlSessionFactory.openSession()){
			CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
			categoryMapper.insert(category);
			session.commit();
		}
	}

	@Override
	public List<Category> findAll() {
		logger.debug("findAll()...");
		
		try(SqlSession session = sqlSessionFactory.openSession()){
			CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
			return categoryMapper.findAll();
		}
	}

	@Override
	public Category findById(Integer id) {
		logger.debug("findById()...");
		
		try(SqlSession session = sqlSessionFactory.openSession()){
			CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
			return categoryMapper.findById(id);
		}
	}

	@Override
	public Category findByTitle(String title) {
		logger.debug("findByTitle()...");
		
		try(SqlSession session = sqlSessionFactory.openSession()){
			CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
			return categoryMapper.findByTitle(title);
		}
	}

}
