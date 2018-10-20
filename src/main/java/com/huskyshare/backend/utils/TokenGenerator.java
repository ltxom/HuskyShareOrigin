package com.huskyshare.backend.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

@Component
@Scope(scopeName = "singleton")
public class TokenGenerator {

   public String generateToken() {
      String token = (System.currentTimeMillis() + new Random().nextInt((int)1.0E9-1)) + "";
      try {
         MessageDigest md = MessageDigest.getInstance("md5");
         byte md5[] = md.digest(token.getBytes());
         BASE64Encoder encoder = new BASE64Encoder();
         return encoder.encode(md5);
      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
      }
      return null;
   }
}
