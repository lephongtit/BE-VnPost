package com.example.vnpost.service;


import com.example.vnpost.model.VerificationToken;

public interface VerificationTokenService {
    VerificationToken findByToken(String token);

    void  save(VerificationToken token);
}
