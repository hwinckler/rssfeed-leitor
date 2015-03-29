package rssfeedleitor.bo;

import java.util.List;

import rssfeedleitor.model.Feed;

public interface FeedBO {

	List<Feed> findAll();

	void insert(Feed feed);

	void deleteByChannel(Integer id);

	List<Feed> findByCategory(Integer categoryID);

}
