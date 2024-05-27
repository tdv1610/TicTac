/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ThongBaoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oracle
 */
public class ThongBaoDAO extends connection {
    
    SQLConnectUnit connect;
    public static SQLConnection connection = new SQLConnection("c##tictac", "tictac", "orcl");
    
    public ThongBaoDTO ThemTB(String thongbao) {
        ThongBaoDTO tb = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();  // Get the database connection
            System.out.println("Connection established successfully.");

            
            String sql = "insert into THONGBAO (THONG_BAO) values(?)";
            pre = con.prepareStatement(sql);
            pre.setString(1, thongbao);
            System.out.println("Executing query: " + sql);

            int rowsAffected = pre.executeUpdate(); // Thực thi câu lệnh INSERT và lấy số hàng ảnh hưởng
            if (rowsAffected > 0) {
            tb = new ThongBaoDTO();
            tb.setTB(thongbao);
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

        return tb;
    }
    
    public List<ThongBaoDTO> layDanhSachTB() {
        List<ThongBaoDTO> danhSachTB = new ArrayList<>();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            // Get the database connection
            con = getConnection();  // Lấy kết nối tới cơ sở dữ liệu
            System.out.println("Connection established successfully.");

            String sql = "SELECT * FROM THONGBAO";
            pre = con.prepareStatement(sql);
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();

            while (rs.next()) {
                ThongBaoDTO thongbao = new ThongBaoDTO();
                thongbao.setTB(rs.getString("THONG_BAO"));
                danhSachTB.add(thongbao);
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
        return danhSachTB;
    }
    
}
