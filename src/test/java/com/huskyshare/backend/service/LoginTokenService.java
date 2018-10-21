package com.huskyshare.backend.service;

import com.huskyshare.backend.dao.LoginTokenDao;
import com.huskyshare.backend.entity.LoginToken;
import com.huskyshare.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginTokenService {
   @Autowired
   private LoginTokenDao loginTokenDao;

   public void saveToken(String token, User user) {
      LoginToken loginToken = new LoginToken();
      loginToken.setTokenValue(token);
      loginToken.setUser(user);
      loginTokenDao.save(loginToken);
   }

   public User searchToken(Object token) {
      if (token == null)
         return null;
      LoginToken loginToken = loginTokenDao.findByToken((String) token);
      if (loginToken != null)
         return loginToken.getUser();
      return null;
   }

   public boolean removeToken(Object token) {
      if (token == null)
         return false;
      try {
         loginTokenDao.delete(loginTokenDao.findByToken((String) token));
         return true;
      } catch (IllegalArgumentException e) {
         System.err.println("没有找到Token！");
         e.printStackTrace();
      }
      return false;
   }
}
