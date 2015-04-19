package rssfeedleitor.dao;

import java.util.List;

import rssfeedleitor.model.User;

public interface UserDAO {

	void insert(User user);
	
	void delete(String email);

	User findByEmail(String email);

	List<User> findAll();

}
