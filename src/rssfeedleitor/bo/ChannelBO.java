package rssfeedleitor.bo;

import java.util.List;

import rssfeedleitor.model.Channel;

public interface ChannelBO {

	void updateToDefaultCategory(Integer id);

	List<Channel> findByCategory(Integer categoryID);

	void insert(String link, Integer categoryID) throws Exception;

	Channel findById(Integer id);

	void delete(Integer id);

	void update(Integer id, Integer categoryID);

}
