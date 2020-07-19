package com.project.music_store.service;


import com.project.music_store.model.User;
import com.project.music_store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public User findUserByUsername(String username) {
        return userRepository.findFirstByUsername(username);
    }
}
