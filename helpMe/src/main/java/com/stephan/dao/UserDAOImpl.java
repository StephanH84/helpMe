package com.stephan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stephan.model.User;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void save(User user) {
    	sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
 
    @SuppressWarnings("unchecked")
    public List<User> list() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

	public User findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.get(User.class, id);
	}
}
