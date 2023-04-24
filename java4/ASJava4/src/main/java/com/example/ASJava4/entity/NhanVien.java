package com.example.ASJava4.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "TenDem")
    private String tenDem;
    @Column(name = "Ho")
    private String ho;
    @Column(name = "GioiTinh")
    private String gioiTinh;
    @Column(name = "NgaySinh")
    private Date ngaySinh;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "MatKhau")
    private String matKhau;
    @Column(name = "IdCH")
    private UUID idCH;
    @Column(name = "IdCV")
    private UUID idCV;
    @Column(name = "IdGuiBC")
    private UUID idGuiBC;
    @Column(name = "TrangThai")
    private Integer trangThai;

    public NhanVien() {
    }

    public NhanVien(UUID id, String ma, String ten, String tenDem, String ho, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, UUID idCH, UUID idCV, UUID idGuiBC, Integer trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.idCH = idCH;
        this.idCV = idCV;
        this.idGuiBC = idGuiBC;
        this.trangThai = trangThai;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public UUID getIdCH() {
        return idCH;
    }

    public void setIdCH(UUID idCH) {
        this.idCH = idCH;
    }

    public UUID getIdCV() {
        return idCV;
    }

    public void setIdCV(UUID idCV) {
        this.idCV = idCV;
    }

    public UUID getIdGuiBC() {
        return idGuiBC;
    }

    public void setIdGuiBC(UUID idGuiBC) {
        this.idGuiBC = idGuiBC;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
}
