package com.example.vnpost.service.impl;

import com.example.vnpost.model.User;
import com.example.vnpost.model.UserPrinciple;
import com.example.vnpost.repository.UserRepository;
import com.example.vnpost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public User getCurrentUser() {
        User user;
        String username;
        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            username=(((UserDetails) principal).getUsername());

        }else {
            username=principal.toString();
        }
        user=this.findByName(username);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserId(Long id) {
        Optional<User> user=userRepository.findById(id);
        if (!user.isPresent()){
            throw new NullPointerException();
        }
        return UserPrinciple.build(user.get());
    }

    @Override
    public boolean CheckLogin(User user) {
        Iterable<User> users=this.findAll();
        boolean isCorrectUser =false;
        for (User currentUser:users){
            if (currentUser.getUsername().equals(user.getUsername())
            && user.getPassword().equals(currentUser.getPassword())
            &&currentUser.isEnabled()){
                isCorrectUser=true;
            }
        }
        return isCorrectUser;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean isRegister(User user) {
        boolean isCorrentConfirmPassword=false;
        if (user.getPassword().equals(user.getConfirmPassword())){
            isCorrentConfirmPassword=true;
        }
        return isCorrentConfirmPassword;
    }

    @Override
    public boolean isCorrectConfirmPassword(User user) {
        boolean isCorrectConfirmPassword=false;
        if (user.getPassword().equals(user.getConfirmPassword())){
            isCorrectConfirmPassword=true;
        }
        return isCorrectConfirmPassword;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException(username);
        }
        if (this.CheckLogin(user)){
            return UserPrinciple.build(user);
        }
        boolean enable = false;
        boolean accountNonExpired=false;
        boolean credentialsNonExpired= false;
        boolean accountNonLocked= false;
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), enable, accountNonExpired, credentialsNonExpired,
                accountNonLocked, null);
    }
}
