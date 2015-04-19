package rssfeedleitor.bo;

import java.util.List;

import rssfeedleitor.exception.CategoryException;
import rssfeedleitor.exception.InvalidUserException;
import rssfeedleitor.model.User;

public interface UserBO {

	void insert(User user) throws Exception;
	
	void delete(String email);

	List<User> findAll();

	User findByEmail(String email);

	User createsNotExist(User user) throws InvalidUserException, CategoryException;

}
