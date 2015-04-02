package rssfeedleitor.bo.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.bo.ChannelBO;
import rssfeedleitor.bo.FeedBO;
import rssfeedleitor.bo.RSSFeedBO;
import rssfeedleitor.dao.ChannelDAO;
import rssfeedleitor.model.Category;
import rssfeedleitor.model.Channel;
import rssfeedleitor.model.Feed;

public class ChannelBOImpl implements ChannelBO {

	private static final Logger logger = LoggerFactory.getLogger(CategoryBOImp.class);

	@Inject
	private ChannelDAO channelDAO;
	
	@Inject
	private RSSFeedBO rssFeedBO;
	
	@Inject
	private FeedBO feedBO;

	public void updateToDefaultCategory(Integer id) {
		logger.debug("updateToDefaultCategory()...");
		
		channelDAO.updateToDefaultCategory(id, Category.DEFAULT_ID);

	}

	@Override
	public List<Channel> findByCategory(Integer categoryID) {
		logger.debug("findByCategory()...");
		return channelDAO.findByCategory(categoryID);
	}

	@Override
	public void insert(String link, Integer categoryID) throws Exception {
		logger.debug("insert()...");
		
		Channel channel = rssFeedBO.parse(link);
		channel.setCategory(new Category(categoryID));
		channelDAO.insert(channel);
		List<Feed> feeds = null;
		if(!(feeds = channel.getFeeds()).isEmpty()){
			for (Feed feed : feeds) {
				feedBO.insert(feed);
			}
		}
	}

	@Override
	public Channel findById(Integer id) {
		logger.debug("findById()...");
		return channelDAO.findById(id);
	}

	@Override
	public void delete(Integer id) {
		logger.debug("findById()...");
		
		feedBO.deleteByChannel(id);
		channelDAO.delete(id);
	}

	@Override
	public void update(Integer id, Integer categoryID) {
		logger.debug("update()...");
		
		channelDAO.update(id, categoryID);
	}

}
