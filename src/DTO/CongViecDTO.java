/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author VICTUS
 */
public class CongViecDTO {
    private String maCV, maNhom, tenCV, linhVuc, moTa;
    private String muc_uutien;
    private String ngayBD, ngayKT;

    public CongViecDTO() {
    }

    public CongViecDTO(String maCV, String maNhom, String tenCV, String linhVuc, String moTa, String muc_uutien, String ngayBD, String ngayKT) {
        this.maCV = maCV;
        this.maNhom = maNhom;
        this.tenCV = tenCV;
        this.linhVuc = linhVuc;
        this.moTa = moTa;
        this.muc_uutien = muc_uutien;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
    }

    @Override
    public String toString() {
        return "CongViecDTO{" + "maCV=" + maCV + ", maNhom=" + maNhom + ", tenCV=" + tenCV + ", linhVuc=" + linhVuc + ", moTa=" + moTa + ", muc_uutien=" + muc_uutien + ", ngayBD=" + ngayBD + ", ngayKT=" + ngayKT + '}';
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getMuc_uutien() {
        return muc_uutien;
    }

    public void setMuc_uutien(String muc_uutien) {
        this.muc_uutien = muc_uutien;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }
}
