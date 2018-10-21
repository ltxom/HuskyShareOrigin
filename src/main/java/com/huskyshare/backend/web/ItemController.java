package com.huskyshare.backend.web;

import com.huskyshare.backend.entity.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ItemController {
	@RequestMapping(value = "/lend", method = RequestMethod.GET)
	public String lendItem(HttpServletRequest request, Model model) {
		model.addAttribute("errors", null);
		Category[] categories = new Category[3];

		// TODO replace with db queryset result
		categories[0] = new Category();
		categories[0].setCategory("Kitchen Appliances");
		categories[0].setId(0);
		categories[1] = new Category();
		categories[1].setCategory("Weapons");
		categories[1].setId(1);
		categories[2] = new Category();
		categories[2].setCategory("Food");
		categories[2].setId(2);
		// TODO END

		model.addAttribute("categories", categories);
		return "lend";
	}

//	@RequestMapping(value = "/")
}
