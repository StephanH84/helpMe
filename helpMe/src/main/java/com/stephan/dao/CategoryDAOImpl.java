package com.stephan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stephan.model.Category;
import com.stephan.model.User;

@Transactional
@Repository
public class CategoryDAOImpl implements CategoryDAO {
	 
	@Autowired
    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void save(Category category) {
    	sessionFactory.getCurrentSession().saveOrUpdate(category);
    }
 
    @SuppressWarnings("unchecked")
    public List<Category> list() {
        return sessionFactory.getCurrentSession().createQuery("from Category").list();
    }
    
	public Category findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (Category) session.get(Category.class, id);
	}

	public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Category cat = (Category) session.get(Category.class, id);
        session.delete(cat);
	}
}
