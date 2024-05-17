/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import DAO.ConnectionDAO;
import DTO.ADMINDTO;
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

        ResultSet result = this.connect.Select("NGUOIDUNG", condition, orderBy);
        ArrayList<ADMINDTO> admin = new ArrayList<>();
        while (result.next()) {
            ADMINDTO ad = new ADMINDTO();
           
            ad.setEmailAd(result.getString("Email"));
            ad.setTenAd(result.getString("Ten"));
            ad.setMatKhauAd(result.getString("MatKhau"));
            admin.add(ad);
        }
        connect.Close();
        return admin;
    }

    public ArrayList<ADMINDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }

    public ArrayList<ADMINDTO> docDB() throws Exception {
        return docDB(null);
    }

    public Boolean suaThongTin(ADMINDTO ad) throws Exception {
        String sql = "UPDATE ADMIN SET EmailAd = ?, TenAd = ?, matKhauAd = ? ";
                
        try {
            pst = this.connection.getConnect().prepareStatement(sql);

            pst.setString(1, ad.getEmailAd());
            pst.setString(2, ad.getTenAd());
            pst.setString(3, ad.getMatKhauAd());
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
}

