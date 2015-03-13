package rssfeedleitor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import rssfeedleitor.model.Feed;

public interface FeedMapper {

	@Insert("INSERT INTO feed(guid, title, pubDate, link) VALUES(#{guid}, #{title}, #{pubDate}, #{link})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	public void insert(Feed feed);
	
	@Select("SELECT * FROM feed ORDER BY id DESC")
	public List<Feed> findAll();

	@Select("SELECT * FROM feed WHERE id = #{id}")
	public Feed findById(Integer id);
}
