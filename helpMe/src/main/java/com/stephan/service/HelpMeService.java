package com.stephan.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.stephan.model.Answer;
import com.stephan.model.Category;
import com.stephan.model.Question;
import com.stephan.model.User;

public interface HelpMeService {	
	void addCategory(Category category);
	
	Collection<Category> listAllCategories();
	
	Collection<Question> getAllQuestionsByCategory(Category category);
	
	Collection<Category> getSubcategories(Category category);
	
	void addQuestion(Question question);
	
	void addUser(User user);
	
	void setVotesForQuestion(int vote);
	
	void setVotesForAnswer(int vote);
	
	void editTextForQuestion(Question question, String newText);
	
	void editTextForAnswer(Answer answer, String newText);
	
	void addCategoryToQuestion(Question question, Category category);
	
	void searchForQuestion(String query);
	
}
