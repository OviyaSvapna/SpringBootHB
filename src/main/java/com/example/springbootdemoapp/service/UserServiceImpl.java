package com.example.springbootdemoapp.service;

import com.example.springbootdemoapp.dao.UserRepository;
import com.example.springbootdemoapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository theUserRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        theUserRepository=userRepository;
    }
    @Override
    public void save(User user) {
        theUserRepository.save(user);
    }

    @Override
    public int loginStatus(String username,String password) {
        User user=theUserRepository.loginStatus(username,password);
        if(user!=null){
            int id=user.getId();
            return id;
        }
        return 0;
    }

}
