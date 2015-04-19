package rssfeedleitor.bo;

import java.util.List;

import rssfeedleitor.exception.CategoryException;
import rssfeedleitor.model.Category;
import rssfeedleitor.model.User;

public interface CategoryBO {

	public void insert(Category category) throws CategoryException;

	public List<Category> findAll(User user);

	public Category find(Category category);

	public void delete(Category category) throws CategoryException;

	public void update(Category category);

	List<Category> findAllWithUnRead(User user);

	public void createDefaultCategory(User user) throws CategoryException;

	public Category findDefaultCategory(User user);

	public Category findById(Integer id, User user);
}
