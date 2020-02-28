package com.example.vnpost.service.impl;

import com.example.vnpost.model.ChuyenMuc;
import com.example.vnpost.model.DanhMuc;
import com.example.vnpost.repository.ChuyenMucRepository;
import com.example.vnpost.repository.DanhMucRepository;
import com.example.vnpost.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DanhMucServiceImpl implements DanhMucService {
    @Autowired
    private DanhMucRepository danhMucRepository;
    @Autowired
    private ChuyenMucRepository chuyenMucRepository;
    @Override
    public Iterable<DanhMuc> findAll() {
        return danhMucRepository.findAll();
    }

    @Override
    public Optional<DanhMuc> findById(Long id) {
        return danhMucRepository.findById(id);
    }

    @Override
    public void save(DanhMuc danhMuc) {
        danhMucRepository.save(danhMuc);
    }

    @Override
    public void delete(Long id) {
        Optional<DanhMuc> danhMuc = danhMucRepository.findById(id);
        if (danhMuc.isPresent()){
            danhMucRepository.delete(danhMuc.get());
        }

    }



}
