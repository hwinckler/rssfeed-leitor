package rssfeedleitor.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.cdi.Mapper;

import rssfeedleitor.dao.FeedDAO;
import rssfeedleitor.mapper.FeedMapper;
import rssfeedleitor.model.Feed;


public class FeedDAOImpl implements FeedDAO{

	private static final Logger logger = LogManager.getLogger(FeedDAOImpl.class);
	
	@Inject 
	@Mapper
	private FeedMapper feedMapper;
	
	public void insert(Feed feed) {
		logger.debug("insert...");
		feedMapper.insert(feed);
	}

	@Override
	public List<Feed> findAll() {
		logger.debug("findAll...");
		return feedMapper.findAll();
	}

	@Override
	public Feed findById(Integer id) {
		logger.debug("findById...");
		return feedMapper.findById(id);
	}

}
