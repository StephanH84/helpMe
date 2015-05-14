package com.stephan.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stephan.model.Category;
import com.stephan.service.HelpMeService;

@RestController
@RequestMapping(value = "/rest")
public class restController {

	@Autowired
	private HelpMeService helpMeService;

	@RequestMapping(value = "/listCategories", method = RequestMethod.GET)
	public List<String> listCategories() {
		List<String> res = new ArrayList<String>();
		Collection<Category> cats = helpMeService.listAllCategories();
		for (Category cat : cats) {
			res.add(cat.getName());
		}
		return res;
	}
	
}
