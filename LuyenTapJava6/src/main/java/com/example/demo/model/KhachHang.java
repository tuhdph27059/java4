package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKhachHang")
    private Long maKhachHang;

    @Column(name = "TenKhachHang")
    private String ten;

    @Column(name = "SoDienThoai")
    private String sdt;

    @Column(name = "GioiTinh")
    private Boolean gioiTinh;

    @ManyToOne
    @JoinColumn(name = "HangKhachHang")
    private HangKhachHang hangKhachHang;
}
