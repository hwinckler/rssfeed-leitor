package rssfeedleitor.feed.bo;

import java.util.List;

import rssfeedleitor.feed.model.Feed;
import rssfeedleitor.user.model.User;

public interface FeedBO {

	List<Feed> findAll(User user);

	void insert(Feed feed);

	void deleteByChannel(Integer id, User user);

	List<Feed> findByCategory(Integer categoryID, User user);

	void markAsRead(Integer id, User user);

	void markAllAsRead(Integer categoryID, User user);

	Feed findById(Integer id, User user);

	List<Feed> findUnread(User user);

}
