package services;



import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDAO;
import domain.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDao;

	
	
	/**
	 * @param eventDao
	 */
    @Autowired
    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }
    
   /* @Override
	public Collection<User> findUserName(String name) throws DataAccessException{
		return userDao.findUserName(name);
	}
*/
    
	@Override
	@Transactional
	public void saveUser(User user) throws DataAccessException {
		userDao.saveUser(user);
	}

	@Override
	@Transactional
	public User loadUser(String userName) {
		return userDao.loadUser(userName);
	}
}


