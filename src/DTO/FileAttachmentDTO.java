/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Oracle
 */
public class FileAttachmentDTO {
    private int maFile;
    private String tenFile;
    private String loaiFile;
    private long kichThuoc;
    private String duongDan;
    private String maCongViec;
    
    public FileAttachmentDTO(){
        
    }

    // Constructor
    public FileAttachmentDTO(int maFile, String tenFile, String loaiFile, long kichThuoc, String duongDan, String maCongViec) {
        this.maFile = maFile;
        this.tenFile = tenFile;
        this.loaiFile = loaiFile;
        this.kichThuoc = kichThuoc;
        this.duongDan = duongDan;
        this.maCongViec = maCongViec;
    }

    // Getters and setters
    public int getMaFile() {
        return maFile;
    }

    public void setMaFile(int maFile) {
        this.maFile = maFile;
    }

    public String getTenFile() {
        return tenFile;
    }

    public void setTenFile(String tenFile) {
        this.tenFile = tenFile;
    }

    public String getLoaiFile() {
        return loaiFile;
    }

    public void setLoaiFile(String loaiFile) {
        this.loaiFile = loaiFile;
    }

    public long getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(long kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getDuongDan() {
        return duongDan;
    }

    public void setDuongDan(String duongDan) {
        this.duongDan = duongDan;
    }

    public String getMaCongViec() {
        return maCongViec;
    }

    public void setMaCongViec(String maCongViec) {
        this.maCongViec = maCongViec;
    }

    // toString method
    @Override
    public String toString() {
        return "FileAttachmentDTO{" +
                "maFile=" + maFile +
                ", tenFile='" + tenFile + '\'' +
                ", loaiFile='" + loaiFile + '\'' +
                ", kichThuoc=" + kichThuoc +
                ", duongDan='" + duongDan + '\'' +
                ", maCongViec=" + maCongViec +
                '}';
    }
}
