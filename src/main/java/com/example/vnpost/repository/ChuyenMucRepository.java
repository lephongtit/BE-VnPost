package com.example.vnpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuyenMucRepository extends JpaRepository<ChuyenMucRepository,Long> {
    ChuyenMucRepository findByName(String name);
}
