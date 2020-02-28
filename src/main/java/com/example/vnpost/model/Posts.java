package com.example.vnpost.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT")
    private String imageUrls;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date date;

    public Posts() {
    }

    public Posts(String title, String content, String imageUrls, Date date) {
        this.title = title;
        this.content = content;
        this.imageUrls = imageUrls;
        this.date = date;
    }

    public Posts(String title, String content, String imageUrls, User user, Date date) {
        this.title = title;
        this.content = content;
        this.imageUrls = imageUrls;
        this.user = user;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
