package com.example.vnpost.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DanhMuc {
    private  static final  long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
//    private String nameChuyenMuc;

    @ManyToOne
    private ChuyenMuc chuyenMuc;


}
