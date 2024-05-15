/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author VICTUS
 */
public class NguoiDung_NhomDTO {
        private String emailND, maNhom;

    public NguoiDung_NhomDTO() {
    }

    public NguoiDung_NhomDTO(String emailND, String maNhom) {
        this.emailND = emailND;
        this.maNhom = maNhom;
    }

    @Override
    public String toString() {
        return "NguoiDung_NhomDTO{" + "emailND=" + emailND + ", maNhom=" + maNhom + '}';
    }

    public String getEmailND() {
        return emailND;
    }

    public void setEmailND(String emailND) {
        this.emailND = emailND;
    }

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }
        
}
