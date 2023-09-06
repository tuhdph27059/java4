package com.example.demo.repository;

import com.example.demo.dto.KhachHangCustom;
import com.example.demo.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang,Long> {
    @Query(value = "select kh.MaKhachHang,kh.TenKhachHang,kh.SoDienThoai,kh.GioiTinh,hkh.MaHang,hkh.TenHang from KhachHang kh join HangKhachHang hkh on kh.HangKhachHang=hkh.MaHang",nativeQuery = true)
    List<KhachHangCustom> getAllKhachHang();
}
