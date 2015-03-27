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

public interface CategoryMapper {

	@Insert("INSERT INTO CATEGORY(TITLE, DATE) VALUES(#{title}, #{date})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	public void insert(Category category);
	
	@Select("SELECT * FROM category ORDER BY id DESC")
	public List<Category> findAll();

	@Select("SELECT * FROM category WHERE id = #{id}")
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="title", column="title"),
			@Result(property="date", column="date"),
            @Result(property="channels", javaType=List.class, column="id",
                   many=@Many(select="getChannels"))
            })
	public Category findById(Integer id);
	
	@Select("SELECT * FROM channel WHERE category_id = #{id}")
	public List<Channel> getChannels(Integer id);

	@Select("SELECT * FROM category WHERE title = #{title}")
	public Category findByTitle(String title);
}
