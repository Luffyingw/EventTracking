package dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import domain.Event;
import domain.User;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;
    
	/*
	@SuppressWarnings("unchecked")
    @Override
     public Collection<User> findUserName(String name) throws DataAccessException {
			Query query = this.em.createQuery("SELECT DISTINCT userName FROM User userName WHERE user.userName LIKE :userName");
			query.setParameter("userName", "%" + name + "%");  //userName is an Email address
		    return query.getResultList();  
	}*/
	    
	
	@Override
	public void saveUser(User user) throws DataAccessException {
		if (user.getId() == null) {
			this.em.persist(user);
		} else {
		  this.em.merge(user);
		}
	}

	@Override
	public User loadUser(String userName) throws DataAccessException {
		return this.em.find(User.class, userName);
	}
}

