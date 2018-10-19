package com.huskyshare.backend.dao;

import com.huskyshare.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   @Query("SELECT username FROM tb_user u WHERE u.username = ?1")
   User findByUsername(String fooIn);
}
