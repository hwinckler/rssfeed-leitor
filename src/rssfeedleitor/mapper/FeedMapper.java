package rssfeedleitor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import rssfeedleitor.model.Category;
import rssfeedleitor.model.Channel;
import rssfeedleitor.model.Feed;

public interface FeedMapper {

	@Insert("INSERT INTO feed(id, channel_id, title, description, pubDate, link, visualized) VALUES(#{id}, #{channel.id}, #{title}, #{description}, #{pubDate}, #{link}, #{visualized})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	public void insert(Feed feed);
	
	@Select("SELECT * FROM feed ORDER BY id DESC")
	public List<Feed> findAll();

	@Select("SELECT * FROM feed WHERE id = #{id}")
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="title", column="title"),
			@Result(property="description", column="description"),
			@Result(property="pubDate", column="pubDate"),
			@Result(property="link", column="link"),
			@Result(property="visualized", column="visualized"),
            @Result(property="channel", javaType=Channel.class, column="channel_id",
                   many=@Many(select="getChannel"))		
            })
	public Feed findById(Integer id);
	
	@Select("SELECT * FROM channel WHERE id = #{id}")
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
	
	@Select("SELECT * FROM category WHERE id = #{id}")
	public Category getCategory(Integer id);

	@Delete("DELETE FROM feed WHERE channel_id = #{id}")
	public void deleteByChannel(Integer id);

	@Select("SELECT * FROM feed f inner join channel c on (f.channel_id = c.id) WHERE c.category_id = #{param1}")
	public List<Feed> findByCategory(Integer categoryID);

	@Update("UPDATE feed set visualized = true WHERE id = #{para1}")
	public void markVisualized(Integer feedID);	
}
