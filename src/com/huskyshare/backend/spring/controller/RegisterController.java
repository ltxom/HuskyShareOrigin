package com.huskyshare.backend.spring.controller;

import com.huskyshare.backend.hibernate.dao.UserDao;
import com.huskyshare.backend.model.user.User;
import com.huskyshare.backend.service.UserService;
import com.huskyshare.backend.spring.test.UnitTestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "register")
	public ModelAndView register(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("register");
		mav.addObject("user", new User());
		return mav;
	}

	@RequestMapping(value = "submitReg", method = RequestMethod.POST)
	public String submitReg(@ModelAttribute("user") User user, Model model, HttpServletRequest request){
		userService = (UserService)RequestContextUtils.getWebApplicationContext(request).getBean("userService");
		userService.register(user);
		request.setAttribute("msg","REGISTER_SUCCESS");
		request.setAttribute("email",user.getEmail());
		return "login";
	}
}