package com.example.vnpost.service;

import com.example.vnpost.model.Role;
import org.springframework.stereotype.Service;


public interface RoleService {
    Iterable<Role> findAll();
    void save(Role role);
    Role findByName (String name);

}
