/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NguoiDungDTO;
import DTO.NguoiDung_NhomDTO;
import DTO.NhomDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oracle
 */
public class NguoiDung_NhomDAO extends connection{
    
    SQLConnectUnit connect;
    
    public static SQLConnection connection = new SQLConnection("c##tictac", "tictac", "orcl");
    
    public List<NguoiDung_NhomDTO> layDanhSachNhomTheoEmail(String EMAILND) {
        List<NguoiDung_NhomDTO> danhSachNhom = new ArrayList<>();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            // Get the database connection
            con = getConnection();
            System.out.println("Connection established successfully.");

            String sql = "SELECT * FROM NGUOIDUNG_NHOM WHERE EMAILND = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, EMAILND);
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();

            while (rs.next()) {
                NguoiDung_NhomDTO nhom = new NguoiDung_NhomDTO();
                nhom.setMaNhom(rs.getString("MANHOM"));
                nhom.setEmailND(rs.getString("EMAILND"));
                danhSachNhom.add(nhom);
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
        return danhSachNhom;
    }
    
    public NguoiDung_NhomDTO themthanhvien(String EMAILND, String MaNhom) {
    NguoiDung_NhomDTO nd_nhom = null;
    try (Connection con = getConnection();
         CallableStatement cstmt = con.prepareCall("{CALL pc_themtvvaonhom(?, ?, ?)}")) {
        
        cstmt.setString(1, EMAILND);
        cstmt.setString(2, MaNhom);
        cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
        
        cstmt.execute();
        
        String result = cstmt.getString(3);
        if ("Them thanh vien vao nhom thanh cong.".equals(result)) {
            nd_nhom = new NguoiDung_NhomDTO();
            nd_nhom.setEmailND(EMAILND);
            nd_nhom.setMaNhom(MaNhom);
        } else {
            // Thông báo lỗi nếu không thêm được thành viên vào nhóm
            System.err.println(result);
        }
        
    } catch (SQLException ex) {
        // Log và xử lý ngoại lệ
        System.err.println("Lỗi khi thực thi procedure themthanhvien: " + ex.getMessage());
        ex.printStackTrace();
    }
    return nd_nhom;
}
    public List<NguoiDung_NhomDTO> layDanhSachTVTheoMaNhom(String MANHOM) {
        List<NguoiDung_NhomDTO> danhSachTV = new ArrayList<>();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            // Get the database connection
            con = getConnection();
            System.out.println("Connection established successfully.");

            // Update SQL to select both EMAILND and MANHOM
            String sql = "SELECT * FROM NGUOIDUNG_NHOM WHERE MANHOM = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, MANHOM);
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();

            while (rs.next()) {
                NguoiDung_NhomDTO tv = new NguoiDung_NhomDTO();
                tv.setMaNhom(rs.getString("MANHOM"));  // Ensure "MANHOM" is retrieved from the result set
                tv.setEmailND(rs.getString("EMAILND"));  // Ensure "EMAILND" is retrieved from the result set
                danhSachTV.add(tv);
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
        return danhSachTV;
        }
    public boolean xoathanhvien(String EMAILND, String MANHOM) {
        try (Connection con = getConnection();
             CallableStatement cstmt = con.prepareCall("{CALL pc_xoatvvkhoinhom(?, ?, ?)}")) {
            
            // Thiết lập tham số đầu vào
            cstmt.setString(1, EMAILND);
            cstmt.setString(2, MANHOM);
            
            // Thiết lập tham số đầu ra
            cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
            
            // Thực thi stored procedure
            cstmt.execute();

            // Lấy kết quả từ tham số đầu ra
            String result = cstmt.getString(3);

            // Kiểm tra kết quả và trả về
            return "SUCCESS".equals(result); // So sánh kết quả trả về với "SUCCESS"
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
