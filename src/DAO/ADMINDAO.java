/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ADMINDTO;
import java.util.ArrayList;
import DAO.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Oracle
 */
public class ADMINDAO extends connection{
      SQLConnectUnit connect;
      public static SQLConnection connection = new SQLConnection("c##tictac", "tictac", "orcl");
    
    
    public ADMINDTO dangnhap(String EmailAD, String MATKHAUAD) {
        ADMINDTO ad = null;
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        try {
            // Kết nối đến cơ sở dữ liệu
            con = getConnection();  // Get the database connection
            System.out.println("Connection established successfully.");

            // Kiểm tra trong bảng admin
            String sqlAdmin = "SELECT * FROM AD WHERE EmailAd = ? AND matKhau = ?";
            p= con.prepareStatement(sqlAdmin);
            p.setString(1, EmailAD);
            p.setString(2, MATKHAUAD);
            rs = p.executeQuery();

            if (rs.next()) {
                ad = new ADMINDTO();
               
                ad.setEmailAd(rs.getString("EMAILAD"));
                ad.setMatKhau(rs.getString("MATKHAU"));
                ad.setTenAd(rs.getString("TENAD"));
                System.out.println("User found: " + ad.toString());
            } else {
                System.out.println("No user found with the provided credentials.");
            }
        }

         
            catch (Exception ex) {
          ex.printStackTrace();
        } finally {
            try {
                // Đóng tất cả các tài nguyên
                if (rs != null) rs.close();
                if (p != null) p.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    return ad;
    }
    
    public List<ADMINDTO> layDanhSachAd() {
        List<ADMINDTO> danhsachAd = new ArrayList<>();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            // Get the database connection
            con = getConnection();
            System.out.println("Connection established successfully.");

            String sql = "SELECT * FROM AD";
            pre = con.prepareStatement(sql);
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();

            while (rs.next()) {
                ADMINDTO admin = new ADMINDTO();
                admin.setTenAd(rs.getString("TENAD"));
                admin.setEmailAd(rs.getString("EMAILAD"));
                danhsachAd.add(admin);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pre != null) pre.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return danhsachAd;
    }
    
    public ADMINDTO TimAD(String EMAILAD) {
        ADMINDTO ad = new ADMINDTO();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;        
        try{
            con = getConnection();  
            System.out.println("Connection established successfully.");

            String sql = "SELECT * FROM AD WHERE EMAILAD = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, EMAILAD);
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();
            
            if(rs.next()){
                
            }
               
        }catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pre != null) pre.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ad;
    }
    
    
}

