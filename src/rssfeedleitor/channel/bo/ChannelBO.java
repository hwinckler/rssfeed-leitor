package rssfeedleitor.channel.bo;

import java.util.List;

import rssfeedleitor.channel.model.Channel;
import rssfeedleitor.exception.CategoryException;
import rssfeedleitor.exception.ChannelException;
import rssfeedleitor.exception.UserException;
import rssfeedleitor.user.model.User;

public interface ChannelBO {

	void updateToDefaultCategory(Integer id, User user) throws UserException;

	List<Channel> findByCategory(Integer categoryID, User uer);

	void insert(Channel channel, User user) throws ChannelException, CategoryException, UserException;

	Channel findById(Integer id, User user);

	void delete(Integer id, User user);

	void update(Integer id, Integer categoryID, User user);

	List<Channel> findAll(User user);

	List<Channel> findAllWithLastPubDate(User user);

}
