package com.huskyshare.backend.dao;

import com.huskyshare.backend.entity.LoginToken;
import com.huskyshare.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginTokenDao extends JpaRepository<LoginToken, Long> {
   @Query("select l from LoginToken l where l.tokenValue = ?1")
   LoginToken findByToken(String tokenValue);

   @Query("select l from LoginToken l where l.user = ?1")
   LoginToken findByUser(User user);

}
