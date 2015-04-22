package rssfeedleitor.feed.dao;

import java.util.List;

import rssfeedleitor.feed.model.Feed;
import rssfeedleitor.user.model.User;

public interface FeedDAO {

	public void insert(Feed feed);

	public List<Feed> findAll(User user);

	public Feed findById(Integer id, User user);

	public void deleteByChannel(Integer id, User user);

	public List<Feed> findByCategory(Integer categoryID, User user);

	public void markAsRead(Integer feedID, User user);

	public void markAllAsRead(Integer categoryID, User user);

	public List<Feed> findUnread(User user);
}
