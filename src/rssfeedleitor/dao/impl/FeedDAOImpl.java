package rssfeedleitor.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.dao.FeedDAO;
import rssfeedleitor.mapper.FeedMapper;
import rssfeedleitor.model.Feed;


public class FeedDAOImpl implements FeedDAO{

	private static final Logger logger = LoggerFactory.getLogger(FeedDAOImpl.class);
	
	@Inject 
	private SqlSessionFactory sqlSessionFactory;
	
	public void insert(Feed feed) {
		logger.debug("insert()...");
		
		try(SqlSession session = sqlSessionFactory.openSession()){
			FeedMapper feedMapper = session.getMapper(FeedMapper.class);
			feedMapper.insert(feed);
			session.commit();
		}
	
	}

	@Override
	public List<Feed> findAll() {
		logger.debug("findAll()...");
		
		try(SqlSession session = sqlSessionFactory.openSession()){
			FeedMapper feedMapper = session.getMapper(FeedMapper.class);
			return feedMapper.findAll();
		}
	}

	@Override
	public Feed findById(Integer id) {
		logger.debug("findById()...");
		
		try(SqlSession session = sqlSessionFactory.openSession()){
			FeedMapper feedMapper = session.getMapper(FeedMapper.class);
			return feedMapper.findById(id);
		}
	}

	@Override
	public void deleteByChannel(Integer id) {
		logger.debug("deleteByChannel()...");
		try(SqlSession session = sqlSessionFactory.openSession()){
			FeedMapper feedMapper = session.getMapper(FeedMapper.class);
			feedMapper.deleteByChannel(id);
			session.commit();
		}
		
	}

	@Override
	public List<Feed> findByCategory(Integer categoryID) {
		logger.debug("findByCategory()...");
		
		try(SqlSession session = sqlSessionFactory.openSession()){
			FeedMapper feedMapper = session.getMapper(FeedMapper.class);
			return feedMapper.findByCategory(categoryID);
		}
	}

	@Override
	public void markAsRead(Integer feedID) {
		logger.debug("markAsRead()...");
		try(SqlSession session = sqlSessionFactory.openSession()){
			FeedMapper feedMapper = session.getMapper(FeedMapper.class);
			feedMapper.markAsRead(feedID);
			session.commit();
		}
	}

	@Override
	public void markAllAsRead(Integer categoryID) {
		logger.debug("markAllAsRead()...");
		try(SqlSession session = sqlSessionFactory.openSession()){
			FeedMapper feedMapper = session.getMapper(FeedMapper.class);
			feedMapper.markAllAsRead(categoryID);
			session.commit();
		}
	}
}
