package com.example.vnpost.repository;

import com.example.vnpost.model.ChuyenMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuyenMucRepository extends JpaRepository<ChuyenMuc,Long>{

    ChuyenMuc findByName(String name);

}