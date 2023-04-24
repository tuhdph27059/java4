package com.example.ASJava4.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "IdSP")
    private UUID idSP;
    @Column(name = "IdNsx")
    private UUID idNsx;
    @Column(name = "IdMauSac")
    private UUID idMauSac;
    @Column(name = "IdDongSP")
    private UUID idDongSP;
    @Column(name = "NamBH")
    private Integer namBH;
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "SoLuongTon")
    private Integer soLuongTon;
    @Column(name = "GiaNhap")
    private Integer giaNhap;
    @Column(name = "GiaBan")
    private Integer giaBan;

    public ChiTietSP() {
    }

    public ChiTietSP(UUID id, UUID idSP, UUID idNsx, UUID idMauSac, UUID idDongSP, Integer namBH, String moTa, Integer soLuongTon, Integer giaNhap, Integer giaBan) {
        this.id = id;
        this.idSP = idSP;
        this.idNsx = idNsx;
        this.idMauSac = idMauSac;
        this.idDongSP = idDongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdSP() {
        return idSP;
    }

    public void setIdSP(UUID idSP) {
        this.idSP = idSP;
    }

    public UUID getIdNsx() {
        return idNsx;
    }

    public void setIdNsx(UUID idNsx) {
        this.idNsx = idNsx;
    }

    public UUID getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(UUID idMauSac) {
        this.idMauSac = idMauSac;
    }

    public UUID getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(UUID idDongSP) {
        this.idDongSP = idDongSP;
    }

    public Integer getNamBH() {
        return namBH;
    }

    public void setNamBH(Integer namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Integer getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Integer giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Integer getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Integer giaBan) {
        this.giaBan = giaBan;
    }
}
