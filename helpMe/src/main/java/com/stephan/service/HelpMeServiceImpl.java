package com.stephan.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephan.dao.AnswerDAO;
import com.stephan.dao.CategoryDAO;
import com.stephan.dao.QuestionDAO;
import com.stephan.dao.UserDAO;
import com.stephan.model.Answer;
import com.stephan.model.Category;
import com.stephan.model.Question;
import com.stephan.model.User;

@Service
public class HelpMeServiceImpl implements HelpMeService {

    private CategoryDAO categoryDAO;
    private QuestionDAO questionDAO;
    private AnswerDAO answerDAO;
    private UserDAO userDAO;

    @Autowired
    public HelpMeServiceImpl(CategoryDAO categoryDAO, QuestionDAO questionDAO, UserDAO userDAO, AnswerDAO answerDAO) {
    	this.categoryDAO = categoryDAO;
    	this.questionDAO = questionDAO;
    	this.userDAO = userDAO;
    	this.answerDAO = answerDAO;
    }
	
	public void addCategory(Category category) {
		categoryDAO.save(category);
	}

	public Collection<Category> listAllCategories() {
		return categoryDAO.list();
	}

	public void deleteCategory(int id) {
		categoryDAO.delete(id);
	}
	
	public Collection<Question> getAllQuestionsByCategory(int id) {
		return questionDAO.listByCategoryId(id);
	}

	public Collection<Category> getSubcategories(Category category)
			 {
		// TODO Auto-generated method stub
		return null;
	}

	public void addQuestion(Question question) {
		questionDAO.save(question);
	}

	public void addUser(User user) {
		userDAO.save(user);
	}

	public void setVotesForQuestion(int vote) {
		// TODO Auto-generated method stub
		
	}

	public void setVotesForAnswer(int vote) {
		// TODO Auto-generated method stub
		
	}

	public void editTextForQuestion(Question question, String newText) {
		// TODO Auto-generated method stub
		
	}

	public void editTextForAnswer(Answer answer, String newText) {
		// TODO Auto-generated method stub
		
	}

	public void addCategoryToQuestion(Question question, Category category) {
		// TODO Auto-generated method stub
		
	}

	public void searchForQuestion(String query) {
		// TODO Auto-generated method stub
		
	}

	public Question getQuestionById(int id) {
		return questionDAO.findById(id);
	}


}
