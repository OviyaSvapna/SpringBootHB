package com.example.springbootdemoapp.service;

import com.example.springbootdemoapp.entity.User;

public interface UserService
{
    public void save(User user);

    int loginStatus(String userName,String password);
    // public boolean loginStatus(String username);

}
