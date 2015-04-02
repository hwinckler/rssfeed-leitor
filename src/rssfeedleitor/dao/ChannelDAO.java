package rssfeedleitor.dao;

import java.util.List;

import rssfeedleitor.model.Channel;

public interface ChannelDAO {

	public void insert(Channel channel);

	public List<Channel> findAll();

	public Channel findById(Integer id);

	public List<Channel> findByCategory(Integer categoryID);

	public void delete(Integer id);

	public void update(Integer id, Integer categoryID);

	public void updateToDefaultCategory(Integer categoryID, Integer defaultCategoryID);
}
