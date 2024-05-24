/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.NhomDTO;
import DTO.CongViecDTO;
import DAO.CongViecDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Types;
import java.sql.CallableStatement; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class CongViecDAO extends connection{
  SQLConnectUnit connect;
    
    public static SQLConnection connection = new SQLConnection("c##tictac", "tictac", "orcl");
    
    public CongViecDTO TimCV(String MACV) throws ParseException {
        CongViecDTO cv = new CongViecDTO();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        try{
            con = getConnection();  // Get the database connection
            System.out.println("Connection established successfully.");

            String sql = "SELECT * FROM CONGVIEC WHERE MACV = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, MACV);
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();
            
            if(rs.next()){
                cv.setMaCV(MACV);
                cv.setMaNhom(rs.getString("MANHOM"));
                cv.setTenCV(rs.getString("TENCV"));
                cv.setLinhVuc(rs.getString("LINHVUC"));
                cv.setMoTa(rs.getString("MOTACV"));
                cv.setMuc_uutien(rs.getInt("MUC_UUTIEN"));
                cv.setNgayBD(rs.getDate("NGAYBD"));
                cv.setNgayKT(rs.getDate("NGAYKT"));
                
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
        return cv;
    }
    
    public CongViecDTO ThemCV(String MANHOM, String TENCV, String LINHVUC, String MOTACV, String MUC_UUTIEN, String NGAYBD, String NGAYKT) {
        CongViecDTO cviec = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try (Connection con = getConnection();
            CallableStatement cstmt = con.prepareCall("{CALL THEM_CONGVIEC(?, ?, ?, ?, ?, ?, ?, ?)}")) {

        // Tách phần số từ chuỗi MUC_UUTIEN
            int mucUuTien;
            try {
                String[] parts = MUC_UUTIEN.split("\\.");
                mucUuTien = Integer.parseInt(parts[0].trim());
            } 
            catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.err.println("Mức ưu tiên không hợp lệ: " + MUC_UUTIEN);
                return null;
            }

            cstmt.setString(1, MANHOM);
            cstmt.setString(2, TENCV);
            cstmt.setString(3, LINHVUC);
            cstmt.setString(4, MOTACV);
            cstmt.setInt(5, mucUuTien);
            cstmt.setDate(6, new java.sql.Date(sdf.parse(NGAYBD).getTime()));
            cstmt.setDate(7, new java.sql.Date(sdf.parse(NGAYKT).getTime()));
            cstmt.registerOutParameter(8, java.sql.Types.VARCHAR);

            cstmt.execute();

            String result = cstmt.getString(8);
            if ("Them cong viec thanh cong.".equals(result)) {
                cviec = new CongViecDTO();
                cviec.setMaNhom(MANHOM);
                cviec.setTenCV(TENCV);
                cviec.setLinhVuc(LINHVUC);
                cviec.setMoTa(MOTACV);
                cviec.setMuc_uutien(mucUuTien);
                cviec.setNgayBD(sdf.parse(NGAYBD));
                cviec.setNgayKT(sdf.parse(NGAYKT));
            } 
            else {
                System.err.println("Stored Procedure Response: " + result);
            }

        }
        catch (SQLException ex) {
            System.err.println("Error while executing stored procedure THEM_CONGVIEC: " + ex.getMessage());
            ex.printStackTrace();
        } 
        catch (ParseException ex) {
            System.err.println("Error while parsing date: " + ex.getMessage());
            ex.printStackTrace();
        }
        return cviec;
    }

    public String laymacv(String MANHOM, String TENCV){
        String macv = null; // Khai báo biến để lưu mã nhóm
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();  // Lấy kết nối tới cơ sở dữ liệu
            System.out.println("KẾT NỐI THÀNH CÔNG.");

            String sql = "SELECT MACV FROM CONGVIEC WHERE MANHOM = ? AND TENCV = ? "; 
            pre = con.prepareStatement(sql);
            pre.setString(1, MANHOM);
            pre.setString(2, TENCV);
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();

            if (rs.next()) {
                macv = rs.getString("MACV"); 
                System.out.println("MÃ CÔNG VIỆC ĐƯỢC PHÂN : " + macv);
            } else {
                System.out.println("CÔNG VIỆC KHÔNG TỒN TẠI");
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
        return macv;
    }
    
}
