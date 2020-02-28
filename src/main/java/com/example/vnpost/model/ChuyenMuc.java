package com.example.vnpost.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ChuyenMuc {
    private  static final  long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(targetEntity = DanhMuc.class)
    private List<DanhMuc> danhMucList;

}
