package rssfeedleitor.bo;

import java.util.List;

import rssfeedleitor.model.Category;

public interface CategoryBO {

	public void insert(String title) throws Exception;

	public List<Category> findAll();

	public Category findById(Integer id);

	public void delete(Integer id) throws Exception;

	public void update(Integer id, String title);

	List<Category> findAllWithUnRead();
}
