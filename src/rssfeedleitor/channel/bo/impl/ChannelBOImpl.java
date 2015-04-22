package rssfeedleitor.channel.bo.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.category.bo.CategoryBO;
import rssfeedleitor.category.bo.impl.CategoryBOImpl;
import rssfeedleitor.category.model.Category;
import rssfeedleitor.channel.bo.ChannelBO;
import rssfeedleitor.channel.dao.ChannelDAO;
import rssfeedleitor.channel.model.Channel;
import rssfeedleitor.exception.CategoryException;
import rssfeedleitor.exception.ChannelException;
import rssfeedleitor.exception.UserException;
import rssfeedleitor.feed.bo.FeedBO;
import rssfeedleitor.feed.model.Feed;
import rssfeedleitor.user.model.User;

public class ChannelBOImpl implements ChannelBO {

	private static final Logger logger = LoggerFactory.getLogger(CategoryBOImpl.class);

	@Inject
	private ChannelDAO channelDAO;
	
	@Inject
	private CategoryBO categoryBO;
	
	@Inject
	private FeedBO feedBO;


	public void updateToDefaultCategory(Integer id, User user) throws UserException {
		logger.debug("updateToDefaultCategory()...");
		
		Category category = categoryBO.findDefaultCategory(user);
		
		channelDAO.updateToDefaultCategory(id, category.getId(), user);

	}

	@Override
	public List<Channel> findByCategory(Integer categoryID, User user) {
		logger.debug("findByCategory()...");
		
		
		return channelDAO.findByCategory(categoryID, user);
	}

	@Override
	public void insert(Channel channel, User user) throws ChannelException, CategoryException, UserException {
		logger.debug("insert()...");
		
		if(channel.getCategory() == null){
			
			Category category = categoryBO.findDefaultCategory(user);
			
			channel.setCategory(category);
		}
		
		channel.setUser(user);
		
		channelDAO.insert(channel);
		List<Feed> feeds = null;
		if(!(feeds = channel.getFeeds()).isEmpty()){
			for (Feed feed : feeds) {
				feedBO.insert(feed);
			}
		}
	}

	@Override
	public Channel findById(Integer id, User user) {
		logger.debug("findById()...");
		return channelDAO.findById(id, user);
	}

	@Override
	public void delete(Integer id, User user) {
		logger.debug("findById()...");
		
		feedBO.deleteByChannel(id, user);
		channelDAO.delete(id, user);
	}

	@Override
	public void update(Integer id, Integer categoryID, User user) {
		logger.debug("update()...");
		
		channelDAO.update(id, categoryID, user);
	}


	@Override
	public List<Channel> findAll(User user) {
		logger.debug("findAll()...");
		return channelDAO.findAll(user);
	}

	@Override
	public List<Channel> findAllWithLastPubDate(User user) {		logger.debug("findAllWithLastPubDate()...");
		return channelDAO.findAllWithLastPubDate(user);
	}

}
