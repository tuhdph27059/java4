package com.example.demo.dto;


import com.example.demo.model.HangKhachHang;
import com.example.demo.model.KhachHang;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KhachHangRequest {
    @NotBlank(message = "Ten khong duoc de trong!")
    private String ten;

    private String sdt;

    private String gioiTinh;

    private String maHang;

    public KhachHang dto(KhachHang kh) {
        kh.setTen(this.getTen());
        kh.setSdt(this.getSdt());
        kh.setGioiTinh(Boolean.valueOf(this.getGioiTinh()));
        kh.setHangKhachHang(HangKhachHang.builder().maHang(Integer.valueOf(this.getMaHang())).build());
        return kh;
    }
}
