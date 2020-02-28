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

    //list danh muc trong 1 chuyen muc

    @GetMapping("/chuyen-muc/{id}/danh-muc")
    public ResponseEntity<Iterable<ChuyenMuc>> listDanhMucInChuyenMuc(@PathVariable("id")Long id){
        Optional<ChuyenMuc> chuyenMuc=chuyenMucService.findByid(id);
        if (!chuyenMuc.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Iterable<DanhMuc>danhMucs=danhMucService.findAllByChuyenMuc(chuyenMuc.get());
        return new ResponseEntity(danhMucs,HttpStatus.OK);
    }

    //them danh muc trong 1 chuyen muc
//    @PostMapping("/chuyen-muc/{id}/danh-muc")
//    public ResponseEntity<Iterable<ChuyenMuc>> createDanhMucInChuyenMuc(@PathVariable("id")Long id, @RequestBody DanhMuc danhMuc){
//        Optional<ChuyenMuc> chuyenMuc= chuyenMucService.findByid(id);
//        if (chuyenMuc.isPresent()){
//            danhMuc.setNameChuyenMuc(chuyenMuc.get().getName());
//            danhMucService.save(danhMuc);
//            chuyenMuc.get().getDanhMucs().add(danhMuc);
//            chuyenMucService.save(chuyenMuc.get());
//            return new ResponseEntity(chuyenMuc, HttpStatus.OK);
//        }else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    //xoa 1 danh muc trong 1 chuyen muc
    @DeleteMapping("/chuyen-muc/{id}/danh-muc/{id}")
    public ResponseEntity<Iterable<ChuyenMuc>> deleteDanhMucInChuyenMuc(@PathVariable("id")Long id,@RequestBody DanhMuc danhMuc){
        Optional<ChuyenMuc> chuyenMuc= chuyenMucService.findByid(id);
        if (chuyenMuc==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            Optional<DanhMuc> danhMuc1=danhMucService.findById(id);
            if (danhMuc1==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            danhMucService.delete(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
    }

    // sua 1 danh muc trong chuyen muc

    @PutMapping("/chuyen-muc/{id}/danh-muc/{id}")
    public ResponseEntity<Iterable<ChuyenMuc>> edit( @PathVariable("id")Long id, @RequestBody DanhMuc danhMuc){
        Optional<ChuyenMuc> chuyenMuc= chuyenMucService.findByid(id);
        if (chuyenMuc.isPresent()){
            Optional<DanhMuc> danhMuc1=danhMucService.findById(id);
            if (danhMuc1.isPresent()){
                danhMuc1.get().setName(danhMuc.getName());
                danhMucService.save(danhMuc1.get());
                return new ResponseEntity<>(HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





}
