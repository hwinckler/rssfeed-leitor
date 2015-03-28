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

public interface CategoryMapper {

	@Insert("INSERT INTO category(id, title, date) VALUES(#{id}, #{title}, #{date})")
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

	@Delete("DELETE FROM category WHERE id = #{id}")
	public void delete(Integer id);

	@Update("UPDATE category set title = #{param2} WHERE id = #{param1}")
	public void update(Integer id, String title);

	@Select("SELECT id FROM category where title = '" + Category.DEFAULT + "'")
	public Integer findIdFromDefaultCategory();
}
