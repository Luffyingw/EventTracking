package services;


import java.util.Collection;

import org.springframework.dao.DataAccessException;

import domain.User;

public interface UserService {
	
	/*Collection<User> findUserName(String name) throws DataAccessException;*/
	
	User loadUser(String userName) throws DataAccessException;

	void saveUser(User user) throws DataAccessException;
}