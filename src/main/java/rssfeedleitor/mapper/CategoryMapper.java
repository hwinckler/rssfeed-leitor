package rssfeedleitor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import rssfeedleitor.model.Category;

public interface CategoryMapper {

	@Insert("INSERT INTO CATEGORY(TITLE, DATE) VALUES(#{title}, #{date})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	public void insert(Category category);
	
	@Select("SELECT * FROM CATEGORY ORDER BY ID DESC")
	public List<Category> findAll();

	@Select("SELECT * FROM CATEGORY WHERE ID = #{id}")
	public Category findById(Integer id);
}
