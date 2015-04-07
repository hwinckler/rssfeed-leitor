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

public interface ChannelMapper {

	@Insert("INSERT INTO channel(id, title, description, link, lastSynchronize, synchronize, category_id) VALUES(#{id}, #{title}, #{description}, #{link}, #{lastSynchronize}, #{synchronize}, #{category.id})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	public void insert(Channel channel);
	
	@Select("SELECT * FROM channel ORDER BY id DESC")
	public List<Channel> findAll();

	@Select("SELECT * FROM channel WHERE id = #{id}")
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="title", column="title"),
			@Result(property="description", column="description"),
			@Result(property="link", column="link"),
			@Result(property="lastSynchronize", column="lastSynchronize"),
			@Result(property="synchronize", column="synchronize"),
            @Result(property="category", javaType=Category.class, column="category_id",
                   many=@Many(select="getCategory")),
            @Result(property="feeds", javaType=List.class, column="id",
            		many=@Many(select="getFeeds"))
            })	
	public Channel findById(Integer id);
	
	@Select("SELECT * FROM category where id = #{id}")
	public Category getCategory(Integer id);
	
	@Select("SELECT * FROM feed where channel_id = #{id}")
	public List<Feed> getFeeds(Integer id);

	@Update("UPDATE channel set category_id = #{param2} where id = #{param1}")
	public void update(Integer id, Integer categoryID);
	
	@Update("UPDATE channel set category_id = #{param2} where category_id = #{param1}")
	public void updateToDefaultCategory(Integer categoryID, Integer defaultCategoryID);

	@Select("SELECT * FROM channel where category_id = #{param1}")
	public List<Channel> findByCategory(Integer categoryID);

	@Delete("DELETE FROM channel WHERE id = #{id}")
	public void delete(Integer id);

	@Select("SELECT ch.id, ch.title, ch.description, ch.link, (SELECT max(f.pubDate) FROM feed f WHERE f.channel_id = ch.id) as lastPubDate FROM channel ch")
	public List<Channel> findAllWithLastPubDate();

}
