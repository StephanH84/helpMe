package com.stephan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stephan.service.HelpMeService;

@Controller
public class CategoryController {
	
	@Autowired
	private HelpMeService helpMeService;

	@RequestMapping(value="/Categories")
	public String allCategories() {
		return "categories";
	}
	
	@RequestMapping(value="/Category/{id}")
	public String questionsByCategory(@PathVariable(value = "id") String id, Model model) {
		model.addAttribute("catId", id);
		return "questionsPerCategory";
	}
	
	@RequestMapping(value="/Question/{id}")
	public String findQuestionById(@PathVariable(value = "id") String id, Model model) {
		model.addAttribute("questionId", id);
		return "question";
	}
}
