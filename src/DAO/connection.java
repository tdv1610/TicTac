/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Oracle
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Đăng ký driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Tạo kết nối
            connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl", // URL của cơ sở dữ liệu
                "c##sinhvien05", // Tên người dùng Oracle
                "1610"  // Mật khẩu của bạn
            );

            if (connection != null) {
                System.out.println("Kết nối thành công!");
            } else {
                System.out.println("Kết nối thất bại!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver không tìm thấy!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại!");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
