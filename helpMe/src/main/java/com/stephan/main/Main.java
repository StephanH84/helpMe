package com.stephan.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stephan.dao.AnswerDAO;
import com.stephan.dao.CategoryDAO;
import com.stephan.dao.QuestionDAO;
import com.stephan.dao.UserDAO;
import com.stephan.model.Answer;
import com.stephan.model.Category;
import com.stephan.model.Question;
import com.stephan.model.User;
import com.stephan.service.HelpMeService;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/business-config.xml");
		
		HelpMeService helpMeService = ctx.getBean("helpMeService", HelpMeService.class);
		
		
		Category cat2 = new Category();
        cat2.setName("Category 2");
        helpMeService.addCategory(cat2);
		
        UserDAO userDAO = ctx.getBean("userDAO", UserDAO.class);
 
        User user = new User();
        
        //user = userDAO.findById(1);
        user.setFirstName("Stephan 123");
        user.setLastName("Hähne");
        //user.setId(1);
        
        userDAO.save(user);
        
        //List<User> list = userDAO.list();
        
//        for(User p : list){
//            System.out.println("Person List::"+p);
//        }
        
		
		CategoryDAO categoryDAO = ctx.getBean("categoryDAO", CategoryDAO.class);
        Category catRoot = new Category();
        catRoot.setName("Root");
        
        Category cat1 = new Category();
        cat1.setName("Category 1");
        cat1.setParentCategory(catRoot);
        
        categoryDAO.save(catRoot);
        categoryDAO.save(cat1);

        //List<Category> list = categoryDAO.list();
        

		QuestionDAO questionDAO = ctx.getBean("questionDAO", QuestionDAO.class);
		
		Question question = new Question();
		question.setVotes(2);
		
		Set<Category> categories = new HashSet<Category>();
		//Category cat1 = categoryDAO.findById(3);
		categories.add(cat1);
		
		question.setAuthor(user);
		question.setCategories(categories);
		question.setName("Title of question");
		question.setText("Which are nice potato recipes");

		Answer answer = new Answer();
		answer.setText("Potatos are green");
		answer.setCategories(categories);
		answer.setDate(new DateTime());
		answer.setQuestion(question);

		Set<Answer> answers = new HashSet();
		answers.add(answer);
		//question.setAnswers(answers);
		
		questionDAO.save(question);
		
		
		AnswerDAO answerDAO = ctx.getBean("answerDAO", AnswerDAO.class);		
		
		answerDAO.save(answer);
		
        //List<Question> list = questionDAO.list();
		
        //close resources
        ctx.close();  
	}

}
