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
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class connection {
    // Thay đổi các thông số kết nối tương ứng với cơ sở dữ liệu Oracle của bạn
    private static final String DB_URL = "jdbc:oracle:thin:@lvlykatie:1521:orcl";
    private static final String USERNAME = "c##tictac";
    private static final String PASSWORD = "tictac";

    // Phương thức để thiết lập và trả về kết nối cơ sở dữ liệu
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // Đăng ký Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Tạo kết nối
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

   

    
}
