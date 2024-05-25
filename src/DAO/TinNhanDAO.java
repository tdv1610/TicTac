/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TinNhanDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;


/**
 *
 * @author Oracle
 */
public class TinNhanDAO extends connection {
    SQLConnectUnit connect;
    public static SQLConnection connection = new SQLConnection("c##tictac", "tictac", "orcl");
    
    public void sendMessage(String senderEmail, String receiverEmail, String messageText) {
        TinNhanDTO tn = null;
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        
        try {
            con = getConnection();  // Lấy kết nối đến cơ sở dữ liệu
            System.out.println("Kết nối thành công.");
            String sql = "INSERT INTO MESSAGES (SENDER_EMAIL, RECEIVER_EMAIL, MESSAGE_TEXT) VALUES (?, ?, ?)";
            
            pre = con.prepareStatement(sql);
            pre.setString(1, senderEmail);
            pre.setString(2, receiverEmail);
            pre.setString(3, messageText);
            
            System.out.println("Đang thực thi truy vấn: " + sql);

            int rowsAffected = pre.executeUpdate(); // Thực thi câu lệnh INSERT và lấy số hàng ảnh hưởng
            if (rowsAffected > 0) {
            tn = new TinNhanDTO();
            tn.setReceiver(receiverEmail);
            tn.setSender(senderEmail);
            tn.setText(messageText);
            System.out.println("Thêm tin nhắn thành công: " + tn.toString());
        } else {
            System.out.println("LỖI!.");
        }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TinNhanDTO> getMessages(String senderEmail, String receiverEmail) {
        List<TinNhanDTO> dstinnhan = new ArrayList<>();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            // Get the database connection
            con = getConnection();
            System.out.println("Connection established successfully.");

            String sql = "SELECT SENDER_EMAIL, RECEIVER_EMAIL, MESSAGE_TEXT, TIMESTAMP FROM MESSAGES WHERE "
            + "(SENDER_EMAIL = ? AND RECEIVER_EMAIL = ?) OR (SENDER_EMAIL = ? AND RECEIVER_EMAIL = ?)"
            + "ORDER BY TIMESTAMP";
            pre = con.prepareStatement(sql);
            pre.setString(1, senderEmail);
            pre.setString(2, receiverEmail);
            pre.setString(3, receiverEmail);
            pre.setString(4, senderEmail);

            
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();

            while (rs.next()) {
                String sender = rs.getString("SENDER_EMAIL");
                String receiver = rs.getString("RECEIVER_EMAIL");
                String text = rs.getString("MESSAGE_TEXT");
                Timestamp timestamp = rs.getTimestamp("TIMESTAMP");
                dstinnhan.add(new TinNhanDTO(sender, receiver, text, timestamp));
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
        
        return dstinnhan;

    }
    
    
    
}
