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


public class CongViecDAO extends connection{
  SQLConnectUnit connect;
    
    public static SQLConnection connection = new SQLConnection("c##tictac", "tictac", "orcl");
    
    public CongViecDTO TimCV(String TENCV){
        CongViecDTO cv = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        
        try{
            con = getConnection();  // Get the database connection
            System.out.println("Connection established successfully.");

            String sql = "SELECT * FROM CONGVIEC WHERE TENCV = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, TENCV);
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();
            
            if(rs.next()){
                cv = new CongViecDTO();
                cv.setMaCV(rs.getString("MACV"));
                cv.setTenCV(rs.getString("TENCV"));
                cv.setMaNhom("MANHOM");
                cv.setLinhVuc("LINHVUC");
                cv.setMoTa("MOTA");
                cv.setMuc_uutien("MUC_UUTIEN");
                cv.setNgayBD("NGAYBD");
                cv.setNgayKT("NGAYKT");
                
                System.out.println("User found: " + cv.toString());
            }
            else {
                System.out.println("No group found with the provided credentials.");
            }
               
        }
        
        catch(SQLException ex){
            ex.printStackTrace();
            
        }
        finally {
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
    public CongViecDTO ThemCV(String TENCV, String MANHOM, String LINHVUC, String MOTA, String MUC_UUTIEN, String NGAYBD){
    CongViecDTO cviec = null;
    try (Connection con = getConnection();
         CallableStatement cstmt = con.prepareCall("{CALL TAOCONGVIEC(?, ?, ?, ?, ?, ?, ?, ?)}")) {
        
        cstmt.setString(1, TENCV);
        cstmt.setString(2, MANHOM);
        cstmt.setString(3, LINHVUC);
        cstmt.setString(4, MOTA);
        cstmt.setString(5, MUC_UUTIEN);
        cstmt.setString(6, NGAYBD);
         cstmt.setString(7, NGAYKT);
        cstmt.registerOutParameter(8, java.sql.Types.VARCHAR);
        
        cstmt.execute();
        
        String result = cstmt.getString(3);
        if ("Thêm công việc thành công.".equals(result)) {
            cviec = new CongViecDTO();
            cviec.setTenCV("TENCV");
            cviec.setMaCV("MACV");
            cviec.setMaNhom("MANHOM");
            cviec.setLinhVuc("LINHVUC");
            cviec.setMoTa("MOTA");
            cviec.setMuc_uutien("MUC_UUTIEN");
            cviec.setNgayBD("NGAYBD");
            cviec.setNgayKT("NGAYKT");
        } else {
            System.err.println(result);
        }
        
    } catch (SQLException ex) {
        // Log the exception with more context
        System.err.println("Error while executing stored procedure TAO: " + ex.getMessage());
        ex.printStackTrace();
    }
    return cviec;
}

    public CongViecDTO ThemCV(String text, String pMaNhom, String text0, String text1, String string, String dateFormatString, String dateFormatString0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
