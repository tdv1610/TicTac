/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NguoiDungDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public NguoiDungDTO xoataikhoan(String TENND,String EMAIL)
    { NguoiDungDTO nd = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();  // Get the database connection
            System.out.println("Connection established successfully.");

            String sql = "delete * from NGUOIDUNG where TENND = ? AND EMAILND = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, TENND);
            pre.setString(2, EMAIL);
            
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();

            if (rs.next()) {
                nd = new NguoiDungDTO();
                nd.setTENND(rs.getString("EMAIL"));
                nd.setEMAILND(rs.getString("TENND"));
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
}public NguoiDungDTO getUserByEmail(String EMAIL) {
        
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
                nd.setTENND(rs.getString("EMAIL"));
                nd.setEMAILND(rs.getString("TENND"));
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
    public void updatePassword( String Email) {
        String query = "UPDATE NGUOIDUNG SET MATKHAU= ? WHERE EMAILND = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, Email);
         
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}


