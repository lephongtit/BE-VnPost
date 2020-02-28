package com.example.vnpost.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nameDanhMuc;
    private String nameChuyenMuc;
    private List<Posts> postsList;

    public DanhMuc() {
    }

    public DanhMuc(String nameDanhMuc, String nameChuyenMuc) {
        this.nameDanhMuc = nameDanhMuc;
        this.nameChuyenMuc = nameChuyenMuc;
    }

    public DanhMuc(String nameDanhMuc, String nameChuyenMuc, List<Posts> postsList) {
        this.nameDanhMuc = nameDanhMuc;
        this.nameChuyenMuc = nameChuyenMuc;
        this.postsList = postsList;
    }

    public List<Posts> getPostsList() {
        return postsList;
    }

    public void setPostsList(List<Posts> postsList) {
        this.postsList = postsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDanhMuc() {
        return nameDanhMuc;
    }

    public void setNameDanhMuc(String nameDanhMuc) {
        this.nameDanhMuc = nameDanhMuc;
    }

    public String getNameChuyenMuc() {
        return nameChuyenMuc;
    }

    public void setNameChuyenMuc(String nameChuyenMuc) {
        this.nameChuyenMuc = nameChuyenMuc;
    }
}
