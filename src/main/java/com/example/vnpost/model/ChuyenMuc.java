package com.example.vnpost.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ChuyenMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(targetEntity = DanhMuc.class)
    private List<DanhMuc> danhMucList;

    public ChuyenMuc() {
    }

    public ChuyenMuc(String name, List<DanhMuc> danhMucList) {
        this.name = name;
        this.danhMucList = danhMucList;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DanhMuc> getDanhMucList() {
        return danhMucList;
    }

    public void setDanhMucList(List<DanhMuc> danhMucList) {
        this.danhMucList = danhMucList;
    }
}
