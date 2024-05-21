package DTO;

public class PhanCongDTO {
    private String tenCV;
    private String emailThanhVien;
    private String trangThai;

    public PhanCongDTO() {
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public String getEmailThanhVien() {
        return emailThanhVien;
    }

    public void setEmailThanhVien(String emailThanhVien) {
        this.emailThanhVien = emailThanhVien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
