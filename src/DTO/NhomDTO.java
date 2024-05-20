/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author VICTUS
 */
public class NhomDTO {

    private String maNhom;
    private String tenNhom, emailTruongNhom;

    public NhomDTO() {
    }

    public NhomDTO(String maNhom, String tenNhom, String emailTruongNhom) {
        this.maNhom = maNhom;
        this.tenNhom = tenNhom;
        this.emailTruongNhom = emailTruongNhom;
    }

    @Override
    public String toString() {
        return "NhomDTO{" + "maNhom=" + maNhom + ", tenNhom=" + tenNhom + ", emailTruongNhom=" + emailTruongNhom + '}';
    }

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }

    public String getTenNhom() {
        return tenNhom;
    }

    public void setTenNhom(String tenNhom) {
        this.tenNhom = tenNhom;
    }

    public String getEmailTruongNhom() {
        return emailTruongNhom;
    }

    public void setEmailTruongNhom(String emailTruongNhom) {
        this.emailTruongNhom = emailTruongNhom;
    }
    
}
