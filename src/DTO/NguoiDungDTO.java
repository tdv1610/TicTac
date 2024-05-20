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
    private String EMAILND, TENND, MATKHAU;

    public NguoiDungDTO(String EMAILND, String TENND, String MATKHAU) {
        this.EMAILND = EMAILND;
        this.TENND = TENND;
        this.MATKHAU = MATKHAU;
       
    }

    public NguoiDungDTO() {
    }

   
    

    

    public String getEMAILND() {
        return EMAILND;
    }

    public void setEMAILND(String EMAILND) {
        this.EMAILND = EMAILND;
    }

    public String getTENND() {
        return TENND;
    }

    public void setTENND(String TENND) {
        this.TENND = TENND;
    }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

 
    
 @Override
    public String toString() {
        return "NguoiDungDTO{" +  ", strEmail=" + EMAILND + ", strMatKhau=" + MATKHAU + ", strHoTen=" + TENND +   '}';
    }

 
    
}
