/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

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
    
}






