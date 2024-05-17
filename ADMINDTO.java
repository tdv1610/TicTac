/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author VICTUS
 */
public class ADMINDTO {
    private String emailAd;
    private String tenAd;
    private String matKhauAd;

    public ADMINDTO() {
    }

    public ADMINDTO(String emailAd, String tenAd, String matKhauAd) {
        this.emailAd = emailAd;
        this.tenAd = tenAd;
        this.matKhauAd = matKhauAd;
    }

    @Override
    public String toString() {
        return "ADMINDTO{" + "emailAd=" + emailAd + ", tenAd=" + tenAd + ", matKhauAd=" + matKhauAd + '}';
    }

    public void setEmailAd(String emailAd) {
        this.emailAd = emailAd;
    }

    public void setTenAd(String tenAd) {
        this.tenAd = tenAd;
    }

    public void setMatKhauAd(String matKhauAd) {
        this.matKhauAd = matKhauAd;
    }

    public String getEmailAd() {
        return emailAd;
    }

    public String getTenAd() {
        return tenAd;
    }

    public String getMatKhauAd() {
        return matKhauAd;
    }

   
}
