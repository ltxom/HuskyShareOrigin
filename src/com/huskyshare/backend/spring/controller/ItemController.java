package com.huskyshare.backend.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("items")
public class ItemController {
	@RequestMapping(value="/items", method=RequestMethod.GET)
	public String printItems(ModelMap modelMap) {
		return "items";
	}
}

