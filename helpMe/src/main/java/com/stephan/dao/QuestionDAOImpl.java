package com.stephan.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stephan.model.Question;

@Transactional
@Repository
public class QuestionDAOImpl implements QuestionDAO {
	 
	@Autowired
	private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void save(Question Question) {
    	sessionFactory.getCurrentSession().saveOrUpdate(Question);
    }
 
    @SuppressWarnings("unchecked")
    public List<Question> list() {
        return sessionFactory.getCurrentSession().createQuery("from Question").list();
    }
    
	public Question findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (Question) session.get(Question.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Question> listByCategoryId(int id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select q from Question q join q.categories p where p.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        List<Question> list = query.list();
        return list;
	}
}
