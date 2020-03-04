package com.example.vnpost.model;
import javax.persistence.*;
import java.util.List;

@Entity
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameDanhMuc;

    @ManyToOne
    @JoinColumn(name = "ChuyenMuc")
    private ChuyenMuc chuyenMuc;

    @OneToMany(targetEntity = Posts.class)
    private List<Posts> postsList;

    public DanhMuc() {
    }

    public DanhMuc(String nameDanhMuc, ChuyenMuc chuyenMuc, List<Posts> postsList) {
        this.nameDanhMuc = nameDanhMuc;
        this.chuyenMuc = chuyenMuc;
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

    public ChuyenMuc getChuyenMuc() {
        return chuyenMuc;
    }

    public void setChuyenMuc(ChuyenMuc chuyenMuc) {
        this.chuyenMuc = chuyenMuc;
    }

    public List<Posts> getPostsList() {
        return postsList;
    }

    public void setPostsList(List<Posts> postsList) {
        this.postsList = postsList;
    }
}
