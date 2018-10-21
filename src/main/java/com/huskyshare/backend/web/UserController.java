package com.huskyshare.backend.web;

import com.huskyshare.backend.entity.User;
import com.huskyshare.backend.dao.UserDao;
import com.huskyshare.backend.service.LoginTokenService;
import com.huskyshare.backend.service.UserService;
import com.huskyshare.backend.utils.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;
import java.util.List;

@Controller
public class UserController {
   @Autowired
   private UserService userService;

   @Autowired
   private LoginTokenService loginTokenService;

   @Autowired
   private TokenGenerator tokenGenerator;

   /**
    * 访问网站的根目录
    */
   @RequestMapping("/")
   public ModelAndView index(HttpServletRequest request, Model model) {
      ModelAndView modelAndView = new ModelAndView("index");
      handleLoginState(request, model);
      return modelAndView;
   }

   /**
    * 访问注册界面
    * 如果用户已登录，则会自动被跳转至根目录
    */
   @RequestMapping(value = "/register", method = RequestMethod.GET)
   public ModelAndView registerForm(HttpServletRequest request, Model model) {
      ModelAndView modelAndView = new ModelAndView("register");
      if (handleLoginState(request, model) != null)
         modelAndView.setViewName("redirect:/");
      return modelAndView;
   }

   /**
    * 提交注册表单
    * 若注册成功则跳转至登录界面
    * 若注册失败则返回msg到前端
    */
   @RequestMapping(value = "/register", method = RequestMethod.POST)
   public ModelAndView registerPost(@ModelAttribute("user") User user, Model model,
                                    HttpServletRequest request) {

      ModelAndView modelAndView = new ModelAndView("login");
      if (handleLoginState(request, model) != null) {
         modelAndView.setViewName("redirect:/");
         return modelAndView;
      }
      String msg = userService.register(user);
      if (msg.equals("SUCCESS")) {
         model.addAttribute("msg", "REGISTER_SUCCESS");
         model.addAttribute("email", user.getEmail());

         return modelAndView;
      }
      modelAndView.setViewName("register");
      model.addAttribute("msg", msg);

      return modelAndView;
   }

   /**
    * 访问登录界面
    * 若已有登录token则跳转至根目录
    */
   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public ModelAndView loginForm(HttpServletRequest request, Model model) {
      ModelAndView modelAndView = new ModelAndView("login");
      if (handleLoginState(request, model) != null) {
         modelAndView.setViewName("redirect:/");
         return modelAndView;
      }

      return modelAndView;
   }

   /**
    * 提交登录表单
    * 若账户/密码不匹配则返回msg到前端
    * 若已有登录token则跳转至根目录
    */
   @RequestMapping(value = "/login", method = RequestMethod.POST)
   public ModelAndView loginPost(@ModelAttribute("user") User user, Model model,
                                 HttpServletRequest request) {
      ModelAndView modelAndView = new ModelAndView("login");
      if (handleLoginState(request, model) != null) {
         modelAndView.setViewName("redirect:/");
         return modelAndView;
      }

      String msg = userService.login(user);
      if (msg.equals("SUCCESS")) {
         user = userService.findUserByEmail(user.getEmail());
         String userToken = loginTokenService.searchUser(user);
         if (userToken == null) {
            userToken = tokenGenerator.generateToken();
            loginTokenService.saveToken(userToken, user);
         }
         request.getSession().setAttribute("token", userToken);

         modelAndView.setViewName("redirect:/");
         return modelAndView;
      }
      model.addAttribute("loginMsg", msg);

      return modelAndView;
   }

   /**
    * 注销当前用户
    */
   @RequestMapping(value = "/logout", method = RequestMethod.GET)
   public ModelAndView logoutForm(HttpServletRequest request, Model model) {
      ModelAndView modelAndView = new ModelAndView("redirect:/");
      handleLoginState(request, model);
      if (loginTokenService.removeToken(request.getSession().getAttribute("token"))) {
         request.getSession().setAttribute("token", null);
         return modelAndView;
      }

      return modelAndView;
   }


   // 判断用户是否拥有login token，并返回登陆的用户对象，若无则返回null
   // 同时若用户拥有login token则会将用户名username返回至前端
   private User handleLoginState(HttpServletRequest request, Model model) {
      User user = loginTokenService.searchToken(request.getSession().getAttribute("token"));
      if (user != null) {
         model.addAttribute("username", user.getUsername());
      }
      return user;
   }

}
