/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author VICTUS
 */
public class ThucHienDTO {
    private String emailThanhVien, maCV_PhanCong, maNhom, trangThai;

    public ThucHienDTO() {
    }

    public ThucHienDTO(String emailThanhVien, String maCV_PhanCong, String maNhom, String trangThai) {
        this.emailThanhVien = emailThanhVien;
        this.maCV_PhanCong = maCV_PhanCong;
        this.maNhom = maNhom;
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "ThucHienDTO{" + "emailThanhVien=" + emailThanhVien + ", maCV_PhanCong=" + maCV_PhanCong + ", maNhom=" + maNhom + ", trangThai=" + trangThai + '}';
    }

    public String getEmailThanhVien() {
        return emailThanhVien;
    }

    public void setEmailThanhVien(String emailThanhVien) {
        this.emailThanhVien = emailThanhVien;
    }

    public String getMaCV_PhanCong() {
        return maCV_PhanCong;
    }

    public void setMaCV_PhanCong(String maCV_PhanCong) {
        this.maCV_PhanCong = maCV_PhanCong;
    }

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
}
