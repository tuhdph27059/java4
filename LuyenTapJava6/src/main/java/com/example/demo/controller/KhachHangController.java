package com.example.demo.controller;


import com.example.demo.dto.KhachHangRequest;
import com.example.demo.model.KhachHang;
import com.example.demo.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangService service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/page")
    private ResponseEntity<?> getAllPage(@RequestParam(defaultValue = "0", name = "page") Integer page) {
        return ResponseEntity.ok(service.getPage(page));
    }

//    @PostMapping("/add")
//    public ResponseEntity<?> add(@RequestBody @Valid KhachHangRequest request, BindingResult result) {
//        if (result.hasErrors()) {
//            List<ObjectError> list = result.getAllErrors();
//            return ResponseEntity.ok(list);
//        } else {
//            return ResponseEntity.ok(service.add(request));
//        }
//    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody KhachHang kh) {
        return ResponseEntity.ok(service.add(kh));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (service.delete(id)) {
            return ResponseEntity.ok("Xóa thành công!");
        } else {
            return ResponseEntity.ok("Xóa thất bại!");
        }
    }

    @PutMapping("/update/{ma}")
    public ResponseEntity<?> update(@PathVariable Long ma,@RequestBody KhachHang kh) {
        return ResponseEntity.ok(service.update(kh, ma));
    }
}
