package com.example.vnpost.controller;

import com.example.vnpost.model.ChuyenMuc;
import com.example.vnpost.service.ChuyenMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")

public class ChuyenMucController {
    @Autowired
    private ChuyenMucService chuyenMucService;

    @GetMapping("/chuyen-muc")
    public ResponseEntity<Iterable<ChuyenMuc>> listChuyenMuc(){
        Iterable<ChuyenMuc> chuyenMucs=chuyenMucService.findAll();
        return new ResponseEntity<>(chuyenMucs, HttpStatus.OK);
    }

    @PostMapping("/chuyen-muc")
    public ResponseEntity<ChuyenMuc> creatChuyenMuc (@RequestBody ChuyenMuc chuyenMuc){
        chuyenMucService.save(chuyenMuc);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/chuyen-muc/{id}")
    public ResponseEntity<ChuyenMuc> editChuyenMuc(@PathVariable("id")Long id,@RequestBody ChuyenMuc chuyenMuc){
        Optional<ChuyenMuc> chuyenMuc1=chuyenMucService.findByid(id);
        if (chuyenMuc1.isPresent()){
            chuyenMuc1.get().setName(chuyenMuc.getName());
            chuyenMucService.save(chuyenMuc1.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/chuyen-muc/{id}")
    public ResponseEntity<ChuyenMuc> deleteChuyenMuc(@PathVariable("id")Long id){
        Optional<ChuyenMuc> chuyenMuc= chuyenMucService.findByid(id);
            if (chuyenMuc.isPresent()){
                chuyenMucService.delete(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
