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

public interface ChannelMapper {

	@Insert("INSERT INTO channel(title, link, lastSynchronize, synchronize, category_id) VALUES(#{title}, #{link}, #{lastSynchronize}, #{synchronize}, #{category.id})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	public void insert(Channel channel);
	
	@Select("SELECT * FROM channel ORDER BY id DESC")
	public List<Channel> findAll();

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
	public Channel findById(Integer id);
	
	@Select("SELECT * FROM category where id = #{id}")
	public Category getCategory(Integer id);
}
