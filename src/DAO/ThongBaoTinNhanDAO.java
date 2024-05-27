/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ThongBaoTinNhanDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongBaoTinNhanDAO extends connection {
    SQLConnectUnit connect;
    public static SQLConnection connection = new SQLConnection("c##tictac", "tictac", "orcl");

    public void thongbaonguoigui(String senderEmail, String receiverEmail, String message) {
        Connection con = null;
        PreparedStatement pre = null;

        try {
            con = getConnection(); 
            if (con != null) {
                System.out.println("Kết nối thành công.");

                String sql = "INSERT INTO THONGBAOTINNHAN (senderEmail, receiverEmail, message) VALUES (?, ?, ?)";
                pre = con.prepareStatement(sql);
                pre.setString(1, senderEmail);
                pre.setString(2, receiverEmail);
                pre.setString(3, message);

                int rowsAffected = pre.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Thêm tin nhắn thành công.");
                } else {
                    System.out.println("Không thêm được tin nhắn.");
                }
            } else {
                System.out.println("Không thể kết nối cơ sở dữ liệu.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng PreparedStatement và Connection
            try {
                if (pre != null) {
                    pre.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<ThongBaoTinNhanDTO> layThongBao(String receiverEmail) {
        List<ThongBaoTinNhanDTO> dstb = new ArrayList<>();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            if (con != null) {
                System.out.println("Kết nối thành công.");
                String query = "SELECT MESSAGE, SENDEREMAIL FROM THONGBAOTINNHAN WHERE receiverEmail = ? AND isRead = 0";  // Sử dụng 0 thay cho FALSE
                pre = con.prepareStatement(query);
                pre.setString(1, receiverEmail);
                rs = pre.executeQuery();
                while (rs.next()) {
                    ThongBaoTinNhanDTO tb = new ThongBaoTinNhanDTO();
                    tb.setMessage(rs.getString("MESSAGE"));
                    tb.setSenderEmail(rs.getString("SENDEREMAIL"));
                    dstb.add(tb);
                    
                }
            } else {
                System.out.println("Không thể kết nối cơ sở dữ liệu.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pre != null) {
                    pre.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dstb;
    }
    
    public void xoaThongBao(String email) {
        Connection con = null;
        PreparedStatement pre = null;

        try {
            con = getConnection();
            if (con != null) {
                System.out.println("Kết nối thành công.");

                String sql = "DELETE FROM THONGBAOTINNHAN WHERE senderEmail = ?";
                pre = con.prepareStatement(sql);
                pre.setString(1, email);
                int rowsAffected = pre.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Xóa thông báo thành công.");
                } else {
                    System.out.println("Không có thông báo nào để xóa.");
                }
            } else {
                System.out.println("Không thể kết nối cơ sở dữ liệu.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pre != null) {
                    pre.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}


