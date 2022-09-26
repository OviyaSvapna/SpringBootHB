package com.example.springbootdemoapp.dao;

import com.example.springbootdemoapp.entity.Room;
import com.example.springbootdemoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {

   // User findByUsername(String username);

    @Query("from User where userName = :username AND password = :password")
    User loginStatus(@Param("username")String username,@Param("password")String password);
}
