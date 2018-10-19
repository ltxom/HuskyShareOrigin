package com.huskyshare.backend.controller;

import com.huskyshare.backend.exception.ResourceNotFoundException;
import com.huskyshare.backend.model.User;
import com.huskyshare.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
   @Autowired
   private UserRepository userRepository;

//   @GetMapping("/users")
//   public User createUser(@Valid @RequestBody User user) {
//      return userRepository.save(user);
//   }

   @RequestMapping("/users/{username}")
   public String getNoteById(@PathVariable(value = "username") String username) {
      User user = userRepository.findByUsername(username);
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
