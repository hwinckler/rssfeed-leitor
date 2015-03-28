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

}
