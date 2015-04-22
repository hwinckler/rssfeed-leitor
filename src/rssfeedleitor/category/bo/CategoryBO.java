package rssfeedleitor.category.bo;

import java.util.List;

import rssfeedleitor.category.model.Category;
import rssfeedleitor.exception.CategoryException;
import rssfeedleitor.exception.InvalidCategoryException;
import rssfeedleitor.exception.UserException;
import rssfeedleitor.user.model.User;

public interface CategoryBO {

	public void insert(String title, User user) throws CategoryException, UserException;

	public List<Category> findAll(User user);

	public Category find(String title, User user) throws InvalidCategoryException, UserException;

	public void delete(Integer id, User user) throws CategoryException, UserException;

	public void update(Integer id, String title, User user) throws InvalidCategoryException, UserException, CategoryException;

	List<Category> findAllWithUnRead(User user);

	public void createDefaultCategory(User user) throws CategoryException, UserException;

	public Category findDefaultCategory(User user) throws UserException;

	public Category findById(Integer id, User user) throws CategoryException;
}
