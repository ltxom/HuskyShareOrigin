package com.huskyshare.backend.spring.controller;

import com.huskyshare.backend.hibernate.util.HibernateUtil;
import com.huskyshare.backend.model.user.User;
import org.hibernate.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @RequestMapping("user")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
         HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<User> listOfUsers = session.createQuery("from User").list();
        mav.addObject("userList",listOfUsers);
        mav.setViewName("user");
        return mav;
    }
}
