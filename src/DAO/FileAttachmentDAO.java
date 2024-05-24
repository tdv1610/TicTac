/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.FileAttachmentDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileAttachmentDAO extends connection {

    public boolean insertFileAttachment(String DUONGDAN, String MA_CV) {
        try (Connection con = getConnection();
             CallableStatement cstmt = con.prepareCall("{CALL INSERT_FILE_ATTACHMENT(?, ?)}")) {

            cstmt.setString(1, DUONGDAN);
            cstmt.setString(2, MA_CV);

            int rowsAffected = cstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException ex) {
            System.err.println("Error while executing stored procedure INSERT_FILE_ATTACHMENT: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean Capquyen(String DUONGDAN) {
        try (Connection con = getConnection();
             CallableStatement cstmt = con.prepareCall("{CALL GRANT_FILE_PERMISSION(?)}")) {

            cstmt.setString(1, DUONGDAN);
            int rowsAffected = cstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException ex) {
            System.err.println("Error while executing stored procedure INSERT_FILE_ATTACHMENT: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
    
    public List<FileAttachmentDTO> layDanhSachFileTheoMacv(String MA_CV) {
    List<FileAttachmentDTO> danhSachfile = new ArrayList<>();
    Connection con = null;
    PreparedStatement pre = null;
    ResultSet rs = null;

    try {
        // Get the database connection
        con = getConnection();
        System.out.println("Connection established successfully.");

        String sql = "SELECT * FROM FILE_ATTACHMENT WHERE MA_CV = ?";
        pre = con.prepareStatement(sql);
        pre.setString(1, MA_CV);
        System.out.println("Executing query: " + sql);

        rs = pre.executeQuery();

        while (rs.next()) {
            FileAttachmentDTO file = new FileAttachmentDTO();
            file.setDuongDan(rs.getString("DUONGDAN")); // Sửa lại chỗ này
            /*file.setTenFile(rs.getString("TENFILE"));
            file.setMaFile(rs.getInt("MAFILE"));
            file.setKichThuoc(rs.getLong("KICHTHUOC"));
            file.setMaCongViec(MA_CV); */
            danhSachfile.add(file);
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
    return danhSachfile;
}

    
}






