package com.example.vnpost.service;

import com.example.vnpost.model.ChuyenMuc;
import com.example.vnpost.model.DanhMuc;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface ChuyenMucService {
    Iterable<ChuyenMuc> findAll();

    Optional<ChuyenMuc> findByid(Long id);

    void save(ChuyenMuc chuyenMuc);

    void delete(Long id);

    ChuyenMuc findByName(String name);



}
