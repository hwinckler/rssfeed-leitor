package rssfeedleitor.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.dao.ChannelDAO;
import rssfeedleitor.mapper.ChannelMapper;
import rssfeedleitor.model.Channel;


public class ChannelDAOImpl implements ChannelDAO{

	private static final Logger logger = LoggerFactory.getLogger(ChannelDAOImpl.class);
	
	@Inject 
	private SqlSessionFactory sqlSessionFactory;
	
	public void insert(Channel channel) {
		logger.debug("insert()...");
		try(SqlSession session = sqlSessionFactory.openSession()){
			ChannelMapper channelMapper = session.getMapper(ChannelMapper.class);
			channelMapper.insert(channel);
			session.commit();
		}
	}

	@Override
	public List<Channel> findAll() {
		logger.debug("findAll()...");
		try(SqlSession session = sqlSessionFactory.openSession()){
			ChannelMapper channelMapper = session.getMapper(ChannelMapper.class);
			return channelMapper.findAll();
		}
	}

	@Override
	public Channel findById(Integer id) {
		logger.debug("findById()...");
		try(SqlSession session = sqlSessionFactory.openSession()){
			ChannelMapper channelMapper = session.getMapper(ChannelMapper.class);
			return channelMapper.findById(id);
		}
	}

	@Override
	public List<Channel> findByCategory(Integer categoryID) {
		logger.debug("findByCategory()...");
		try(SqlSession session = sqlSessionFactory.openSession()){
			ChannelMapper channelMapper = session.getMapper(ChannelMapper.class);
			return channelMapper.findByCategory(categoryID);
		}
	}

	@Override
	public void delete(Integer id) {
		logger.debug("delete()...");
		try(SqlSession session = sqlSessionFactory.openSession()){
			ChannelMapper channelMapper = session.getMapper(ChannelMapper.class);
			channelMapper.delete(id);
			session.commit();
		}
	}

	@Override
	public void update(Integer id, Integer categoryID) {
		logger.debug("update()...");
		try(SqlSession session = sqlSessionFactory.openSession()){
			ChannelMapper channelMapper = session.getMapper(ChannelMapper.class);
			channelMapper.update(id, categoryID);
			session.commit();
		}
	}
	
	@Override
	public void updateToDefaultCategory(Integer categoryID, Integer defaultCategoryID) {
		logger.debug("update()...");
		try(SqlSession session = sqlSessionFactory.openSession()){
			ChannelMapper channelMapper = session.getMapper(ChannelMapper.class);
			channelMapper.updateToDefaultCategory(categoryID, defaultCategoryID);
			session.commit();
		}
	}

	@Override
	public List<Channel> findAllWithLastPubDate() {
		logger.debug("findAllWithLastPubDate()...");
		try(SqlSession session = sqlSessionFactory.openSession()){
			ChannelMapper channelMapper = session.getMapper(ChannelMapper.class);
			return channelMapper.findAllWithLastPubDate();
		}
	}

}
