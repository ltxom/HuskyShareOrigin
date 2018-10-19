package com.huskyshare.backend.controller;

import com.huskyshare.backend.exception.ResourceNotFoundException;
import com.huskyshare.backend.model.User;
import com.huskyshare.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
   @Autowired
   UserRepository userRepository;

//   @GetMapping("/users")
//   public User createUser(@Valid @RequestBody User user) {
//      return userRepository.save(user);
//   }

//   @RequestMapping("/users/{username}")
//   public String getNoteById(@PathVariable(value = "username") String username) {
//      User user = userRepository.findByUsername(username);
//      if (user == null)
//         throw new ResourceNotFoundException("User", "username", username);
//      return user.getEmail();
//   }

   @RequestMapping("/")
   public ModelAndView user() {
      List<User> userList = userRepository.findAll();
      ModelAndView modelAndView = new ModelAndView("index");
      modelAndView.addObject("userList", userList);

      return modelAndView;
   }
}
