/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DTO.ADMINDTO;

public class ADMINDAO {
    private SQLConnectUnit connectUnit;

    public ADMINDAO() {
        connectUnit = new SQLConnectUnit();
    }

    public List<ADMINDTO> docDB() throws SQLException, Exception {
        List<ADMINDTO> admins = new ArrayList<>();
        try {
            ResultSet rs = connectUnit.Select("AD"); // Tên bảng là "AD"
            while (rs.next()) {
                ADMINDTO admin = new ADMINDTO();
                admin.setEmailAd(rs.getString("EMAILAD"));
                admin.setTenAd(rs.getString("TENAD"));
                admin.setMatKhau(rs.getString("MATKHAU"));
                admins.add(admin);
            }
        } catch (SQLException e) {
            throw new SQLException("Error while reading ADMIN database: " + e.getMessage());
        } finally {
            connectUnit.Close();
        }
        return admins;
    }
}
