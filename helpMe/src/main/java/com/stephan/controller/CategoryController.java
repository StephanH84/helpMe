package com.stephan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stephan.service.HelpMeService;

@Controller
public class CategoryController {
	
	@Autowired
	private HelpMeService helpMeService;

	@RequestMapping(value="/allCategories")
	public String process(Model model) {
		model.addAttribute("categories", helpMeService.listAllCategories());
		return "Categories";
	}
}
