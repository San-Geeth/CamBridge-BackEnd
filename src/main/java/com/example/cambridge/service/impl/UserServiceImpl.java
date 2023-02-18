package com.example.cambridge.service.impl;

import com.example.cambridge.entity.user.User;
import com.example.cambridge.entity.user.UserType;
import com.example.cambridge.repo.user.UserRepo;
import com.example.cambridge.repo.user.UserTypeRepo;
import com.example.cambridge.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private UserTypeRepo userTypeRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserTypeRepo userTypeRepo) {
        this.userRepo = userRepo;
        this.userTypeRepo = userTypeRepo;
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

}
