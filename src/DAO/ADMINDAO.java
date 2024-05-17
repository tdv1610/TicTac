/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.ADMINDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Oracle
 */
public class ADMINDAO {
    SQLConnectUnit connect;
    public static SQLConnection connection = new SQLConnection("c##sinhvien07", "123", "orcl");
    ;
    public static PreparedStatement pst = null;

    /**
     * Lấy thông tin từ Database
     */
    public ArrayList<ADMINDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new SQLConnectUnit();

        ResultSet result = this.connect.Select("ADMIN", condition, orderBy);
        ArrayList<ADMINDTO> admins = new ArrayList<>();
        while (result.next()) {
            ADMINDTO admin = new ADMINDTO();
            admin.setEmailAd(result.getString("Emial"));
            admin.setTenAd(result.getString("Ten"));
            admin.setMatKhauAd(result.getString("MatKhau"));
            admins.add(admin);
        }
        connect.Close();
        return admins;
    }
    public ArrayList<ADMINDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    public ArrayList<ADMINDTO> docDB() throws Exception {
        return docDB(null);
    }
    
    public ADMINDTO findById(String Email) throws Exception {
        String sql = "Select * from ADMIN where Email = ?";
        try {
            pst = this.connection.getConnect().prepareStatement(sql);

            pst.setString(1, Email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ADMINDTO ad  = new ADMINDTO();
                ad.setEmailAd(rs.getString("Email"));
                ad.setTenAd(rs.getString("Ten"));
                ad.setMatKhauAd(rs.getString("MatKhau"));
                
                return ad;
            }
            return null;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }

    
}
