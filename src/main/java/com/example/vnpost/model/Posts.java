package com.example.vnpost.model;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity

public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT")
    private String imageUrls;

    private String userName;
    private String nameDanhMuc;

//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp
//    private Date date;


    public Posts() {
    }

    public Posts(String title, String content, String imageUrls, String userName, String nameDanhMuc) {
        this.title = title;
        this.content = content;
        this.imageUrls = imageUrls;
        this.userName = userName;
        this.nameDanhMuc = nameDanhMuc;
    }

    public String getNameDanhMuc() {
        return nameDanhMuc;
    }

    public void setNameDanhMuc(String nameDanhMuc) {
        this.nameDanhMuc = nameDanhMuc;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
}
