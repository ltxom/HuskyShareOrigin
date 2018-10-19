package com.huskyshare.backend.web;

import com.huskyshare.backend.exception.ResourceNotFoundException;
import com.huskyshare.backend.entity.User;
import com.huskyshare.backend.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {
   @Autowired
   private UserDao userDao;

//   @GetMapping("/users")
//   public User createUser(@Valid @RequestBody User user) {
//      return userRepository.save(user);
//   }

   @RequestMapping("/users/{username}")
   public String getNoteById(@PathVariable(value = "username") String username) {
      User user = userDao.findByUsername(username);
      if (user == null)
         throw new ResourceNotFoundException("User", "username", username);
      return user.getEmail();
   }

   @RequestMapping("/users/login")
   public ModelAndView login() {
      System.out.println("Loging in");
      ModelAndView mav = new ModelAndView();
      mav.setViewName("/WEB-INF/view/login.jsp");
      return mav;
   }
}
