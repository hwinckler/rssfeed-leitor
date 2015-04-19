package rssfeedleitor.bo.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.bo.CategoryBO;
import rssfeedleitor.bo.UserBO;
import rssfeedleitor.dao.UserDAO;
import rssfeedleitor.exception.CategoryException;
import rssfeedleitor.exception.InvalidUserException;
import rssfeedleitor.exception.UserAlreadExistsException;
import rssfeedleitor.model.User;

public class UserBOImpl implements UserBO {

	private static final Logger logger = LoggerFactory.getLogger(UserBOImpl.class);
	
	@Inject
	private UserDAO userDAO;
	
	@Inject
	private CategoryBO categoryBO;
	
	@Override
	public void insert(User user) throws Exception{
		logger.debug("insert()...");
		validate(user);
		
		if(findByEmail(user.getEmail()) != null)
			throw new UserAlreadExistsException("user already exists!");
		
		userDAO.insert(user);
	}

	@Override
	public User findByEmail(String email) {
		logger.debug("findByEmail()...");
		return userDAO.findByEmail(email);
	}

	@Override
	public List<User> findAll() {
		logger.debug("findAll()...");
		return userDAO.findAll();
	}

	@Override
	public void delete(String email) {
		logger.debug("delete()...");
		userDAO.delete(email);
	}

	@Override
	public User createsNotExist(User user) throws InvalidUserException, CategoryException {
		logger.debug("createsNotExist()...");
		validate(user);
		
		User u = findByEmail(user.getEmail());
		if(u == null){
			userDAO.insert(user);
			
			categoryBO.createDefaultCategory(user);
		}
		return user;
	}

	private void validate(User user) throws InvalidUserException{
		if(user == null || (user.getEmail() == null || user.getEmail().isEmpty()))
			throw new InvalidUserException("invalid user");		
	}
}
