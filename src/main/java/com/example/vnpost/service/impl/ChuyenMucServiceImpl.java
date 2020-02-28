package com.example.vnpost.service.impl;

import com.example.vnpost.model.ChuyenMuc;
import com.example.vnpost.repository.ChuyenMucRepository;
import com.example.vnpost.service.ChuyenMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ChuyenMucServiceImpl implements ChuyenMucService {

    @Autowired
    private ChuyenMucRepository chuyenMucRepository;

    @Override
    public Iterable<ChuyenMuc> findAll() {
        return chuyenMucRepository.findAll();
    }

    @Override
    public Optional<ChuyenMuc> findByid(Long id) {
        return chuyenMucRepository.findById(id);
    }

    @Override
    public void save(ChuyenMuc chuyenMuc) {
        chuyenMucRepository.save(chuyenMuc);

    }

    @Override
    public void delete(Long id) {
        Optional<ChuyenMuc> chuyenMuc= chuyenMucRepository.findById(id);
        if (chuyenMuc.isPresent()){
            chuyenMucRepository.deleteById(id);
        }

    }

    @Override
    public ChuyenMuc findByName(String name) {
        return chuyenMucRepository.findByName(name);
    }
}
