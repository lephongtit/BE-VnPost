package com.example.vnpost.service;

import com.example.vnpost.model.ChuyenMuc;

import java.util.Optional;

public interface ChuyenMucService {
    Iterable<ChuyenMuc> findAll();

    Optional<ChuyenMuc> findByid(Long id);

    void save(ChuyenMuc chuyenMuc);

    void delete(Long id);

    ChuyenMuc findByName(String name);

}
