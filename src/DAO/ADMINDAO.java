/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.ADMINDTO;
import DAO.connection;
import GUI.AdminHomepage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ADMINDAO extends connection{
      SQLConnectUnit connect;
      public static SQLConnection connection = new SQLConnection("c##TICTAC", "123", "orcl");
    
       public ADMINDTO dangnhap(String TENAD, String MATKHAUAD) {
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
            p.setString(1, TENAD);
            p.setString(2, MATKHAUAD);
            rs = p.executeQuery();

            if (rs.next()) {
                ad = new ADMINDTO();
               
                ad.setEmailAd(rs.getString("EMAILAD"));
                ad.setMatKhauAd(rs.getString("MATKHAU"));
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
}
