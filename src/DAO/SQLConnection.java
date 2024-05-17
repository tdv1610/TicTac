/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLConnection {

    String Username;
    String Password;
    String Sid;
    Connection connect = null;

    public SQLConnection(String Username, String Password, String Sid) {
        this.Username = Username;
        this.Password = Password;
        this.Sid = Sid;
    }

    protected void driveTest() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQL Developer driver not found", e);
        }
    }

    public Connection getConnect() throws SQLException {
        if (this.connect == null) {
            try {
                driveTest();
                String url = "jdbc:oracle:thin:@localhost:1521:" + this.Sid;
                this.connect = DriverManager.getConnection(url, this.Username, this.Password);
            } catch (SQLException e) {
                throw new SQLException("Unable to connect to Database", e);
            }
        }
        return this.connect;
    }

    public void Close() throws SQLException {
        try {
            if (this.connect != null && !this.connect.isClosed()) {
                this.connect.close();
            }
        } catch (SQLException e) {
            throw new SQLException("Error closing connection", e);
        } finally {
            this.connect = null;
        }
    }
}
