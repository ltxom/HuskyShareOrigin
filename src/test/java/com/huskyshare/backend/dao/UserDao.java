package com.huskyshare.backend.dao;

import com.huskyshare.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
   @Query("select u from User u where u.username = ?1")
   User findByUsername(String username);

   @Query("select u from User u where u.email = ?1")
   User findByEmail(String email);
}
