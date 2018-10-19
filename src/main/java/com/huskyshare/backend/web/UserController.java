package com.huskyshare.backend.web;

import com.huskyshare.backend.entity.User;
import com.huskyshare.backend.dao.UserDao;
import com.huskyshare.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
   @Autowired
   UserService userService;

//   @GetMapping("/users")
//   public User createUser(@Valid @RequestBody User user) {
//      return userRepository.save(user);
//   }
//
//   @RequestMapping("/users/{username}")
//   public String getNoteById(@PathVariable(value = "username") String username) {
//      User user = userRepository.findByUsername(username);
//      if (user == null)
//         throw new ResourceNotFoundException("User", "username", username);
//      return user.getEmail();
//   }

   @RequestMapping("/")
   public ModelAndView index() {
      List<User> userList = userService.findAll();
      ModelAndView modelAndView = new ModelAndView("index");
      modelAndView.addObject("userList", userList);

      return modelAndView;
   }

   @RequestMapping(value = "/register", method = RequestMethod.GET)
   public ModelAndView registerForm() {
      ModelAndView modelAndView = new ModelAndView("register");
      return modelAndView;
   }

   @RequestMapping(value = "/register", method = RequestMethod.POST)
   public ModelAndView registerPost(@ModelAttribute("user") User user, Model model,
                                 HttpServletRequest request) {

      ModelAndView modelAndView = new ModelAndView("login");
      String msg = userService.register(user);
      if (msg.equals("SUCCESS")) {
         model.addAttribute("msg", "REGISTER_SUCCESS");
         model.addAttribute("email", user.getEmail());

         return modelAndView;
      }
      modelAndView.setViewName("register");
      model.addAttribute("msg",msg);

      return modelAndView;
   }

   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public ModelAndView loginForm() {
      ModelAndView modelAndView = new ModelAndView("login");
      return modelAndView;
   }

   @RequestMapping(value = "/login", method = RequestMethod.POST)
   public ModelAndView loginPost(@ModelAttribute("user") User user, Model model,
                                           HttpServletRequest request) {
      ModelAndView modelAndView = new ModelAndView("login");
      String msg = userService.login(user);
      if(msg.equals("SUCCESS")){
         modelAndView.setViewName("index");
         return modelAndView;
      }
      model.addAttribute("loginMsg",msg);

      return modelAndView;
   }
}
