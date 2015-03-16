package rssfeedleitor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import rssfeedleitor.model.Category;
import rssfeedleitor.model.Channel;
import rssfeedleitor.model.Feed;

public interface FeedMapper {

	@Insert("INSERT INTO feed(channel_id, guid, title, pubDate, link) VALUES(#{channel.id}, #{guid}, #{title}, #{pubDate}, #{link})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	public void insert(Feed feed);
	
	@Select("SELECT * FROM feed ORDER BY id DESC")
	public List<Feed> findAll();

	@Select("SELECT * FROM feed WHERE id = #{id}")
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="title", column="title"),
			@Result(property="guid", column="guid"),
			@Result(property="pubDate", column="pubDate"),
			@Result(property="link", column="link"),
            @Result(property="channel", javaType=Channel.class, column="channel_id",
                   many=@Many(select="getChannel"))		
            })
	public Feed findById(Integer id);
	
	@Select("SELECT * FROM channel where id = #{id}")
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="title", column="title"),
			@Result(property="link", column="link"),
			@Result(property="lastSynchronize", column="lastSynchronize"),
			@Result(property="synchronize", column="synchronize"),
            @Result(property="category", javaType=Category.class, column="category_id",
                   many=@Many(select="getCategory"))
            })	
	public Channel getChannel(Integer id);
	
	@Select("SELECT * FROM category where id = #{id}")
	public Category getCategory(Integer id);	
}
