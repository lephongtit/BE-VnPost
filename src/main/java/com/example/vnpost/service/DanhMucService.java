package com.example.vnpost.service;

import com.example.vnpost.model.ChuyenMuc;
import com.example.vnpost.model.DanhMuc;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface DanhMucService {
    Iterable<DanhMuc> findAll();

    Optional<DanhMuc> findById(Long id);

    void save (DanhMuc danhMuc);

    void delete(Long id);

    DanhMuc findByName(String name);

    Iterable<DanhMuc> findAllByChuyenMuc(ChuyenMuc chuyenMuc);
}
