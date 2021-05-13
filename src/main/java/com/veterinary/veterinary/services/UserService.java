package com.veterinary.veterinary.services;

import com.veterinary.veterinary.models.UserModel;
import com.veterinary.veterinary.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    public UserModel saveUser(UserModel user) {
        String encodedPassword = BCrypt.hashpw(user.getPwd(), BCrypt.gensalt());
        user.setPwd(encodedPassword);
        return userRepository.save(user);
    }

    public ArrayList<UserModel> getAllUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel login(UserModel user) {
        return userRepository.login(user.getUser());
    }
}
