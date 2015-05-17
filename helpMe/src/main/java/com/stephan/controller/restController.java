package com.stephan.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stephan.model.Category;
import com.stephan.model.Question;
import com.stephan.model.restAnswer;
import com.stephan.service.HelpMeService;

@RestController
@RequestMapping(value = "/rest")
public class restController {

	@Autowired
	private HelpMeService helpMeService;

	@RequestMapping(value = "/listCategories", method = RequestMethod.GET)
	public Collection<Category> listCategories() {
		Collection<Category> cats = helpMeService.listAllCategories();
		return cats;
	}
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public void addCategory(@RequestBody String categoryName) {
		Category cat = new Category();
		cat.setName(categoryName);
		helpMeService.addCategory(cat);
	}
	
	@RequestMapping(value = "/deleteCategory", method = RequestMethod.PUT)
	public void deleteCategory(@RequestBody Integer id) {
		helpMeService.deleteCategory(id);
	}
	

	@RequestMapping(value="/questionsPerCategory/{id}", method = RequestMethod.GET)
	public Collection<Question> questionsByCategory(@PathVariable(value = "id") String id) {
		Collection<Question> questions = helpMeService.getAllQuestionsByCategory(Integer.valueOf(id));
		return questions;
	}
	
	@RequestMapping(value="/Question/{id}", method = RequestMethod.GET)
	public Question questionsById(@PathVariable(value = "id") String id) {
		return helpMeService.getQuestionById(Integer.valueOf(id));
	}
	
	@RequestMapping(value="/addAnswer", method = RequestMethod.POST)
	public void addAnswer(@RequestBody restAnswer answer) {
		System.out.println(answer);
		//return helpMeService.getQuestionById(Integer.valueOf(id));
	}
}
