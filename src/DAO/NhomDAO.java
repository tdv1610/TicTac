/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhomDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Oracle
 */
public class NhomDAO extends connection{
    SQLConnectUnit connect;
    
    public static SQLConnection connection = new SQLConnection("c##tictac", "tictac", "orcl");
    
    public NhomDTO timnhom(String TENNHOM, String EMAIL_TRUONGNHOM){
        NhomDTO nhom1 = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        
        try{
            con = getConnection();  // Get the database connection
            System.out.println("Connection established successfully.");

            String sql = "SELECT * FROM NHOM WHERE TENNHOM = ? AND EMAIL_TRUONGNHOM = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, TENNHOM);
            pre.setString(3, EMAIL_TRUONGNHOM);
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();
            
            if(rs.next()){
                nhom1 = new NhomDTO();
                nhom1.setMaNhom(rs.getString("MANHOM"));
                nhom1.setTenNhom(rs.getString("TENNHOM"));
                nhom1.setEmailTruongNhom("EMAIL_TRUONGNHOM");
                
                System.out.println("User found: " + nhom1.toString());
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
        return nhom1;
    }
    
    
    public NhomDTO themnhom(String TENNHOM, String EMAIL_TRUONGNHOM) {
    NhomDTO nhom = null;
    try (Connection con = getConnection();
         CallableStatement cstmt = con.prepareCall("{CALL TAONHOM(?, ?, ?)}")) {
        
        cstmt.setString(1, TENNHOM);
        cstmt.setString(2, EMAIL_TRUONGNHOM);
        cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
        
        cstmt.execute();
        
        String result = cstmt.getString(3);
        if ("Thêm nhóm thành công.".equals(result)) {
            nhom = new NhomDTO();
            nhom.setTenNhom(TENNHOM);
            nhom.setEmailTruongNhom(EMAIL_TRUONGNHOM);
        } else {
            System.err.println(result);
        }
        
    } catch (SQLException ex) {
        // Log the exception with more context
        System.err.println("Error while executing stored procedure TAONHOM: " + ex.getMessage());
        ex.printStackTrace();
    }
    return nhom;
}


}