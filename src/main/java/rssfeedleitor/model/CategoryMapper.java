package rssfeedleitor.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface CategoryMapper {

	@Insert("INSERT INTO CATEGORY(TITLE, DATE) VALUES(#{title}, #{date})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	public void insert(Category category);
}
