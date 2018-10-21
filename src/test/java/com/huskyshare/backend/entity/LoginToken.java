package com.huskyshare.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_token")
public class LoginToken {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "token_id")
   private Integer id;

   @Column(name = "token_value", unique = true)
   private String tokenValue;

   @OneToOne
   @JoinColumn(name = "user_id", unique = true)
   private User user;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getTokenValue() {
      return tokenValue;
   }

   public void setTokenValue(String tokenValue) {
      this.tokenValue = tokenValue;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

}
