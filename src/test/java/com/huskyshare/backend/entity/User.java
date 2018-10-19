package com.huskyshare.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "tb_user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class User implements Serializable {
   // 编号
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   // 用户名
   @Column(updatable = false, name = "username", nullable = false, length=50)
   private String username;

   // 密码
   @Column(updatable = true, name = "password",  nullable = false, length=50)
   private String password;

   // email
   @Column(updatable = true,  name = "email", nullable = false, length=50)
   private String email;

   // First Name
   @Column(updatable = true, name = "firstName",  nullable = false, length=50)
   private String firstName;

   // Last Name
   @Column(updatable = true, name = "lastName",  nullable = false, length=50)
   private String lastName;

   // Mobile
   @Column(updatable = true, name = "mobile",  nullable = true, length=16)
   private String mobile;

   public String getMobile() {
      return mobile;
   }

   public void setMobile(String mobile) {
      this.mobile = mobile;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
}
