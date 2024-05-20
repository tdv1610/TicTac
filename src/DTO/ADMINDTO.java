/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author VICTUS ne
 */
public class ADMINDTO {
    private String emailAd;
    private String tenAd;
    private String matKhau;

    public ADMINDTO() {
    }

    public ADMINDTO(String emailAd, String tenAd, String matKhau) {
        this.emailAd = emailAd;
        this.tenAd = tenAd;
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return "ADMINDTO{" + "emailAd=" + emailAd + ", tenAd=" + tenAd + ", matKhau=" + matKhau + '}';
    }

    public void setEmailAd(String emailAd) {
        this.emailAd = emailAd;
    }

    public void setTenAd(String tenAd) {
        this.tenAd = tenAd;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmailAd() {
        return emailAd;
    }

    public String getTenAd() {
        return tenAd;
    }

    public String getMatKhau() {
        return matKhau;
    }

}
