/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Oracle
 */
public class SQLConnectUnit {
    // Biến kết nối cơ bản
    private SQLConnection connect;
    PreparedStatement ps = null;

    // Hàm khởi tạo kết nối mặc định
    public SQLConnectUnit() {
        connect = new SQLConnection("c##sinhvien07", "123", "orcl");
    }

    // Hàm khởi tạo cơ bản
    public SQLConnectUnit(String Username, String Password, String Sid) {
        connect = new SQLConnection(Username, Password, Sid);
    }

    // Hàm hỗ trợ Select CSDL
    /**
     * Select * From Table Where Condition Order by OrderBy
     *
     * @throws Exception
     */
    public ResultSet Select(String TableName, String Condition, String OrderBy) throws Exception {
        // Khai báo biến StringBuilder để tạo chuỗi Select
        StringBuilder query = new StringBuilder("SELECT * FROM " + TableName);
        // Đưa câu lệnh điều kiện vào câu query
        this.AddCondition(query, Condition);
        // Đưa câu lệnh Order vào query
        this.AddOrderBy(query, OrderBy);
        // Thực thi câu lệnh query và trả kết quả
        return this.connect.getConnect().prepareStatement(query.toString()).executeQuery();
    }

    // Hàm overload Select giảm OrderBy parameter
    /**
     * Select * From Table Where Condition
     *
     * @throws Exception
     */
    public ResultSet Select(String TableName, String Condition) throws Exception {
        return this.Select(TableName, Condition, null);
    }

    // Hàm overload Select giảm Condition parameter
    /**
     * Select * From Table
     *
     * @throws Exception
     */
    public ResultSet Select(String TableName) throws Exception {
        return this.Select(TableName, null, null);
    }

    // Hàm thêm điều kiện vào query
    private void AddCondition(StringBuilder query, String Condition) {
        // Kiểm tra nếu condition khác null
        if (Condition != null && !Condition.isEmpty()) {
            query.append(" WHERE " + Condition);
        }
    }

    // Hàm thêm OrderBy vào query
    private void AddOrderBy(StringBuilder query, String OrderBy) {
        // Kiểm tra OrderBy khác null và không rỗng
        if (OrderBy != null && !OrderBy.isEmpty()) {
            query.append(" ORDER BY " + OrderBy);
        }
    }

    public static int getColumnCount(ResultSet result) throws SQLException {
        return result.getMetaData().getColumnCount();
    }

    // Hàm lấy tên cột trong result select từ CSDL
    public static String[] getColumnName(ResultSet result) throws SQLException {
        // Lấy resultSetMetaData từ Result
        ResultSetMetaData rsMetaData = result.getMetaData();
        // Lấy số lượng cột trong Result
        int ColumnCount = rsMetaData.getColumnCount();
        // Khai báo danh sách các cột
        String[] list = new String[ColumnCount];
        for (int i = 0; i < ColumnCount; i++) {
            list[i] = rsMetaData.getColumnName(i + 1); // sửa i + 1 để lấy đúng tên cột
        }
        return list;
    }

    // Hàm đóng kết nối
    public void Close() throws SQLException {
        if (ps != null) {
            ps.close();
        }
        if (connect != null) {
            connect.Close();
        }
    }
}
