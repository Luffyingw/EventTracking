package dao;


import java.util.Collection;

import org.springframework.dao.DataAccessException;

import domain.User;

public interface UserDAO {
	
	/*Collection<User> findUserName(String name) throws DataAccessException;*/
	
	void saveUser(User user) throws DataAccessException;

	User loadUser(String userName) throws DataAccessException;

	
}
