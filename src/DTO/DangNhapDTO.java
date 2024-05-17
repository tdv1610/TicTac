/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Oracle
 */
public class DangNhapDTO {
    private String Email;
    private String Matkhau;
    
    public DangNhapDTO(String email, String matkhau) {
		super();
		this.Email = email;
		this.Matkhau= matkhau;
	}
    public DangNhapDTO(){
        
    }
    
    public String getEmail(){
        return Email;
    }
    
    public String getMatkhau(){
        return Matkhau;
    }
    
    public void setEmail(String email){
        this.Email = email;
    }
    
    public void setMatkhau(String mk){
        this.Matkhau = mk;
    }
    
    public boolean CheckInfor(String email, String mk)
	{
        // Từ cơ sở dữ liệu, duyệt qua tất cả thông tin, lấy từng thông tin kiểm tra
        
		return this.getEmail().equals(email) && this.getMatkhau().equals(mk);
	}
}
