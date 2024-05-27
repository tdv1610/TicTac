/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Oracle
 */
public class ThongBaoDTO {
    private String thongbao;
    
    public ThongBaoDTO(String thongbao) {
        this.thongbao = thongbao;
    }
    
    public ThongBaoDTO(){
        
    }
    
    public void setTB(String thongbao){
        this.thongbao = thongbao;
    }
    
    public String getTB(){
        return thongbao;
    }
    
    @Override
    public String toString() {
        return "Thông báo: " + this.thongbao;
    }

    
}