package com.example.demo.service;

import com.example.demo.dto.KhachHangCustom;
import com.example.demo.dto.KhachHangRequest;
import com.example.demo.model.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService {
    @Autowired
    private KhachHangRepository repository;

    public List<KhachHangCustom> getAll() {
        return repository.getAllKhachHang();
    }

    public Page<KhachHang> getPage(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return repository.findAll(pageable);
    }

    public KhachHang add(KhachHang kh) {
        return repository.save(kh);
    }

//    public KhachHang add(KhachHangRequest request){
//        KhachHang kh=request.dto(new KhachHang());
//        return repository.save(kh);
//    }

    public Boolean delete(Long id) {
        Optional<KhachHang> optional = repository.findById(id);
        if (optional.isPresent()) {
            KhachHang kh = optional.get();
            repository.delete(kh);
            return true;
        } else {
            return false;
        }
    }

    public KhachHang update(KhachHang kh, Long id) {
        Optional<KhachHang> optional = repository.findById(id);
        return optional.map(o -> {
            o.setTen(kh.getTen());
            o.setSdt(kh.getSdt());
            o.setGioiTinh(kh.getGioiTinh());
            o.setHangKhachHang(kh.getHangKhachHang());
            return repository.save(o);
        }).orElse(null);
    }
}
