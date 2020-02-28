package com.example.vnpost.repository;

import com.example.vnpost.model.ChuyenMuc;
import com.example.vnpost.model.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMuc,Long> {
    DanhMuc findByName(String name);
    Iterable<DanhMuc> findAllByNameChuyenMuc(ChuyenMuc chuyenMuc);

}
