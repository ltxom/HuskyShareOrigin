package com.huskyshare.backend.service;

import com.huskyshare.backend.dao.UserDao;
import com.huskyshare.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
   @Autowired
   private UserDao userDao;

   public String register(User user) {
      if (userDao.findByEmail(user.getEmail()) == null) {
         if (userDao.findByUsername(user.getUsername()) == null) {
            userDao.save(user);
            return "SUCCESS";
         }
         return "DUPLICATE_USERNAME";
      }
      return "DUPLICATE_EMAIL";
   }

   public List<User> findAll() {
      return userDao.findAll();
   }

   public String login(User user) {
      if (user.getEmail() != null) {
         User userInDB = userDao.findByEmail(user.getEmail());
         if(userInDB==null)
            return "ERROR_NO_USER";
         if(!userInDB.getPassword().equals(user.getPassword()))
            return "ERROR_INCORRECT_PASS";
         return "SUCCESS";
      }
      return "ERROR_INVALID";
   }
}

