package rssfeedleitor.channel.dao;

import java.util.List;

import rssfeedleitor.channel.model.Channel;
import rssfeedleitor.user.model.User;

public interface ChannelDAO {

	public void insert(Channel channel);

	public List<Channel> findAll(User user);

	public Channel findById(Integer id, User user);

	public List<Channel> findByCategory(Integer categoryID, User user);

	public void delete(Integer id, User user);

	public void update(Integer id, Integer categoryID, User user);

	public void updateToDefaultCategory(Integer categoryID, Integer defaultCategoryID, User user);

	public List<Channel> findAllWithLastPubDate(User user);
}
