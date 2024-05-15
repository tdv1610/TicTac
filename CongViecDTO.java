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
    private int muc_uutien;
    private Date ngayBD, ngayKT;

    public CongViecDTO() {
    }

    public CongViecDTO(String maCV, String maNhom, String tenCV, String linhVuc, String moTa, int muc_uutien, Date ngayBD, Date ngayKT) {
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

    public int getMuc_uutien() {
        return muc_uutien;
    }

    public void setMuc_uutien(int muc_uutien) {
        this.muc_uutien = muc_uutien;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }
}
