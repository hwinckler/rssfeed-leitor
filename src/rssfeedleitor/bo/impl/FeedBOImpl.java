package rssfeedleitor.bo.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.bo.FeedBO;
import rssfeedleitor.dao.FeedDAO;
import rssfeedleitor.model.Feed;

public class FeedBOImpl implements FeedBO {

	private static final Logger logger = LoggerFactory.getLogger(FeedBOImpl.class);

	@Inject
	private FeedDAO feedDAO;

	@Override
	public List<Feed> findAll() {
		logger.debug("findAll()...");
		return feedDAO.findAll();
	}

	@Override
	public void insert(Feed feed) {
		logger.debug("insert()...");
		feedDAO.insert(feed);
	}

	@Override
	public void deleteByChannel(Integer id) {
		logger.debug("deleteByChannel()...");
		feedDAO.deleteByChannel(id);
	}

	@Override
	public List<Feed> findByCategory(Integer categoryID) {
		logger.debug("findByCategory()...");
		return feedDAO.findByCategory(categoryID);
	}

	@Override
	public void markAsRead(Integer feedID) {
		logger.debug("markAsRead()...");
		feedDAO.markAsRead(feedID);
	}

	@Override
	public void markAllAsRead(Integer categoryID) {
		logger.debug("markAllAsRead()...");
		feedDAO.markAllAsRead(categoryID);		
	}

}
