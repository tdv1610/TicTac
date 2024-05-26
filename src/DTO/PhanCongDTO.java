package DTO;

import java.util.Date;

public class PhanCongDTO {
    private String tenCV;
    private String emailThanhVien;
    private String trangThai;
    private Date ngayBD, ngayKT;

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
    
    public Date getNgayBD(){
        return ngayBD;
    }
    public void setNgayBD(Date ngayBD){
        this.ngayBD = ngayBD;
    }
    
    public Date getNgayKT(){
        return ngayKT;
    }
    public void setNgayKT(Date ngayKT){
        this.ngayKT = ngayKT;
    }
    
    public String toString() {
        return "Tên công việc: " + this.tenCV + ", Người phụ trách: " + this.emailThanhVien + "Trạng thai: " + this.trangThai + ", Ngày bắt đầu: " + this.ngayBD + ", Ngày kết thúc: " + this.ngayKT;
    }
}
