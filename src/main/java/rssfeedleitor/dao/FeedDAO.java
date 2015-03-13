package rssfeedleitor.dao;

import java.util.List;

import rssfeedleitor.model.Feed;

public interface FeedDAO {

	public void insert(Feed feed);

	public List<Feed> findAll();

	public Feed findById(Integer id);
}
