package com.stephan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stephan.model.Answer;
import com.stephan.model.Category;
import com.stephan.model.User;

@Transactional
@Repository
public class AnswerDAOImpl implements AnswerDAO {
	 
	@Autowired
	private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	public void save(Answer answer) {
    	sessionFactory.getCurrentSession().saveOrUpdate(answer);
	}

	public Answer findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (Answer) session.get(Answer.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Answer> list() {
        return sessionFactory.getCurrentSession().createQuery("from Answer").list();
	}
}
