package com.example.vnpost.controller;

import com.example.vnpost.model.ChuyenMuc;
import com.example.vnpost.model.DanhMuc;
import com.example.vnpost.service.ChuyenMucService;
import com.example.vnpost.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class DanhMucController {
    @Autowired
    private DanhMucService danhMucService;
    @Autowired
    private ChuyenMucService chuyenMucService;

    //danh sach all danh muc

    @GetMapping("/danh-muc")
    public  ResponseEntity<Iterable<DanhMuc>> listDanhMuc(){
        Iterable<DanhMuc> danhMucs=danhMucService.findAll();
        return  new ResponseEntity<>(danhMucs,HttpStatus.OK);
    }


   // them danh muc

    @PostMapping("/danh-muc")
    public ResponseEntity<DanhMuc> createDanhmuc(@RequestBody DanhMuc danhMuc){
        if (danhMuc.getChuyenMuc()!= null){
            String nameChuyenMuc = danhMuc.getChuyenMuc().getName();
            ChuyenMuc chuyenMuc =  chuyenMucService.findByName(nameChuyenMuc);
            danhMuc.setChuyenMuc(chuyenMuc);
        }
        danhMucService.save(danhMuc);
        return new ResponseEntity<>(danhMuc,HttpStatus.CREATED);
    }

    //xoa 1 danh muc
    @DeleteMapping("danh-muc/{id}")
    public ResponseEntity<Void> deleteDanhMucInChuyenMuc(@PathVariable("id")Long id){
        Optional<DanhMuc> danhMuc= danhMucService.findById(id);
        if (danhMuc==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        danhMucService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // sua 1 danh muc trong chuyen muc

    @PutMapping("/danh-muc/{id}")
    public ResponseEntity<Iterable<DanhMuc>> edit(@PathVariable("id")Long id,@RequestBody DanhMuc danhMuc){
        Optional<DanhMuc> danhMuc1=danhMucService.findById(id);
        if (danhMuc1.isPresent()) {
            if (!danhMuc.getNameDanhMuc().equals("")){
                danhMuc1.get().setNameDanhMuc(danhMuc.getNameDanhMuc());
            }
            if (danhMuc.getChuyenMuc().getId()!=null){
                String nameChuyenMuc = danhMuc.getChuyenMuc().getName();
                ChuyenMuc chuyenMuc= chuyenMucService.findByName(nameChuyenMuc);
                danhMuc1.get().setChuyenMuc(chuyenMuc);
            }
            danhMucService.save(danhMuc1.get());
            return new ResponseEntity(danhMuc1,HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //chi tiet 1 danh muc
    @GetMapping("danh-muc/{id}")
    public ResponseEntity<DanhMuc> findById(@PathVariable Long id){
        Optional<DanhMuc> danhMuc=danhMucService.findById(id);
        if (danhMuc == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(danhMuc,HttpStatus.OK);
    }





}
