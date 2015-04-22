package rssfeedleitor.user.bo;

import java.util.List;

import rssfeedleitor.exception.CategoryException;
import rssfeedleitor.exception.UserException;
import rssfeedleitor.user.model.User;

public interface UserBO {

	void insert(User user) throws UserException;
	
	void delete(String email);

	List<User> findAll();

	User findByEmail(String email);

	User createsNotExist(User user) throws CategoryException, UserException;

}
