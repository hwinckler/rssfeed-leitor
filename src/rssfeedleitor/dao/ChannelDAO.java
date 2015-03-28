package rssfeedleitor.dao;

import java.util.List;

import rssfeedleitor.model.Channel;

public interface ChannelDAO {

	public void insert(Channel channel);

	public List<Channel> findAll();

	public Channel findById(Integer id);

	public void updateToDefaultCategory(Integer id, Integer defaultCategoryId);
}
