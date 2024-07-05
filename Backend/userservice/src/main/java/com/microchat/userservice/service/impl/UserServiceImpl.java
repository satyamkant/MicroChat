package com.microchat.userservice.service.impl;

import com.microchat.userservice.repository.UserRepository;
import com.microchat.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Long gerUser(Long id){
        return userRepository.findById(id).orElseThrow().getId();
    }

    @Override
    public Long getUser(String name){
        return userRepository.findByUserName(name).orElseThrow().getId();
    }

    @Override
    public Long getUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow().getId();
    }
}
