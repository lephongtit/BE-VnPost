package com.example.vnpost.service;

import com.example.vnpost.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Iterable<User> findAll();
    void save(User user);
    User findByName(String name);

    //lay tai khoan dang chay
    User getCurrentUser();

    Optional<User> findById(Long id);

    UserDetails loadUserId(Long id);

    boolean CheckLogin(User user);

    User findByEmail(String email);

    boolean isRegister(User user);

    //check password
    boolean isCorrectConfirmPassword(User user);

}
