package com.huskyshare.backend.spring.controller;

import com.huskyshare.backend.hibernate.dao.UserDao;
import com.huskyshare.backend.model.user.User;
import com.huskyshare.backend.service.UserService;
import com.huskyshare.backend.spring.test.UnitTestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "register")
	public ModelAndView register(HttpServletRequest request) {
		System.out.println("Registering");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("register");
		return mav;
	}

	@RequestMapping("submitReg")
	public String submitReg(User user, Model model){
		UnitTestBase unitTestBase = new UnitTestBase("classpath*:spring/applicationContext.xml");
		userService = unitTestBase.getBean("userService");
		userService.register(user);
		model.addAttribute("msg","REGISTER_SUCCESS");
		model.addAttribute("email",user.getEmail());
		return "login";
	}
}