/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NguoiDungDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Oracle
 */
public class NguoiDungDAO extends connection{
     SQLConnectUnit connect;
      public static SQLConnection connection = new SQLConnection("c##TicTac", "tictac", "orcl");
    ;
    public NguoiDungDTO dangnhap(String EMAILND, String MATKHAU) {
        NguoiDungDTO nd = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();  // Get the database connection
            System.out.println("Connection established successfully.");

            String sql = "SELECT * FROM NGUOIDUNG WHERE EMAILND = ? AND MATKHAU = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, EMAILND);
            pre.setString(2, MATKHAU);
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();

            if (rs.next()) {
                nd = new NguoiDungDTO();
                nd.setTENND(rs.getString("TENND"));
                nd.setEMAILND(rs.getString("EMAILND"));
                nd.setMATKHAU(rs.getString("MATKHAU"));
               
                System.out.println("User found: " + nd.toString());
            } else {
                System.out.println("No user found with the provided credentials.");
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

        return nd;
    }
    public NguoiDungDTO dangki( String EMAIL,String TENND, String MATKHAU){
        NguoiDungDTO nd = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();  // Get the database connection
            System.out.println("Connection established successfully.");

            
            String sql = "insert into NGUOIDUNG values(?,?,?)";
            pre = con.prepareStatement(sql);
            pre.setString(1, EMAIL);
            pre.setString(2, TENND);
            pre.setString(3, MATKHAU);
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();

            if (rs.next()) {
                nd = new NguoiDungDTO();
                nd.setTENND(rs.getString("EMAIL"));
                nd.setEMAILND(rs.getString("TENND"));
                nd.setMATKHAU(rs.getString("MATKHAU"));
               
               
            } else {
                System.out.println("No user found with the provided credentials.");
            
            
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

        return nd;
    }
    
    public boolean xoathanhvien(String EMAILND) {
        try (Connection con = getConnection();
             CallableStatement cstmt = con.prepareCall("{CALL XOA_NGUOIDUNG(?)}")) {
            
            // Thiết lập tham số đầu vào
            cstmt.setString(1, EMAILND);
           
            // Thực thi stored procedure
            cstmt.execute(); // Thực thi stored procedure

            return true; // Trả về true nếu cập nhật thành công
        }
        catch (SQLException ex) {
            // Log lỗi hoặc xử lý nếu cần thiết
            ex.printStackTrace();
            return false; // Trả về false nếu có lỗi xảy ra
        }
    }
    
    public NguoiDungDTO getUserByEmail(String EMAIL) {
        
        NguoiDungDTO nd = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();  // Get the database connection
            System.out.println("Connection established successfully.");

            String sql = "SELECT * from NGUOIDUNG where EMAILND = ?";
            pre = con.prepareStatement(sql);
          
            pre.setString(1, EMAIL);
            
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();

            if (rs.next()) {
                nd = new NguoiDungDTO();
                nd.setEMAILND(rs.getString("EMAILND"));
                nd.setTENND(rs.getString("TENND"));
                nd.setMATKHAU(rs.getString("MATKHAU"));
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
        return nd;
    }
    public NguoiDungDTO updatePassword(String EMAIL, String matkhaumoi) {
        NguoiDungDTO nd = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();  // Get the database connection
            System.out.println("Connection established successfully.");

            String sql = "UPDATE NGUOIDUNG SET MATKHAU = ? WHERE EMAILND = ?";
            pre = con.prepareStatement(sql);

            // Đặt tham số đúng thứ tự
            pre.setString(1, matkhaumoi);
            pre.setString(2, EMAIL);

            System.out.println("Executing query: " + sql);

            int rowsUpdated = pre.executeUpdate();  // Sử dụng executeUpdate cho câu lệnh UPDATE

            if (rowsUpdated > 0) {
                // Truy vấn lại để lấy thông tin đã cập nhật (nếu cần)
                String selectSql = "SELECT EMAILND, TENND, MATKHAU FROM NGUOIDUNG WHERE EMAILND = ?";
                pre = con.prepareStatement(selectSql);
                pre.setString(1, EMAIL);
                rs = pre.executeQuery();

                if (rs.next()) {
                    nd = new NguoiDungDTO();
                    nd.setEMAILND(rs.getString("EMAILND"));
                    nd.setTENND(rs.getString("TENND"));
                    nd.setMATKHAU(rs.getString("MATKHAU"));
                }
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
        return nd;
    }
    



    public String getTenNguoiDungByEmail(String email) {
        String tenNguoiDung = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();  // Lấy kết nối đến cơ sở dữ liệu
            String sql = "SELECT TENND FROM NGUOIDUNG WHERE EMAILND = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, email);
            rs = pre.executeQuery();

            if (rs.next()) {
                tenNguoiDung = rs.getString("TENND");
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
        return tenNguoiDung;
    }
    
    public boolean kiemTraNguoiDung(String email) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String sql = "SELECT COUNT(*) FROM NGUOIDUNG WHERE EMAILND = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, email);
            rs = pre.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
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
        return false;
    }
    
    public NguoiDungDTO them(String EMAILND) {
        NguoiDungDTO nd = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();  // Get the database connection
            System.out.println("Connection established successfully.");

            String sql = "SELECT * FROM NGUOIDUNG WHERE EMAILND = ? ";
            pre = con.prepareStatement(sql);
            pre.setString(1, EMAILND);
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();

            if (rs.next()) {
                nd = new NguoiDungDTO();
                nd.setEMAILND(rs.getString("EMAILND"));
                nd.setTENND(rs.getString("TENND"));
               
                System.out.println("User found: " + nd.toString());
            } else {
                System.out.println("Người dùng không tồn tại.");
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

        return nd;
    }
}
