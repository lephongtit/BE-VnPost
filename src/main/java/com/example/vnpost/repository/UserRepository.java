package com.example.vnpost.repository;

import com.example.vnpost.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String userName );
    User findByEmail(String email);
}
