/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author VICTUS
 */
public class NguoiDungDTO {
    private String emailND, tenND, matKhauND;

    public NguoiDungDTO(String emailND, String tenND, String matKhauND) {
        this.emailND = emailND;
        this.tenND = tenND;
        this.matKhauND = matKhauND;
    }

    public NguoiDungDTO() {
    }

    @Override
    public String toString() {
        return "NguoiDungDTO{" + "emailND=" + emailND + ", tenND=" + tenND + ", matKhauND=" + matKhauND + '}';
    }

    public String getEmailND() {
        return emailND;
    }

    public void setEmailND(String emailND) {
        this.emailND = emailND;
    }

    public String getTenND() {
        return tenND;
    }

    public void setTenND(String tenND) {
        this.tenND = tenND;
    }

    public String getMatKhauND() {
        return matKhauND;
    }

    public void setMatKhauND(String matKhauND) {
        this.matKhauND = matKhauND;
    }
    
    
}
