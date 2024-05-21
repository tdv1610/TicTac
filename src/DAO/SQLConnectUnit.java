package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLConnectUnit {
    // Biến kết nối cơ bản
    private SQLConnection connect;
    PreparedStatement ps = null;

    // Hàm khởi tạo kết nối mặc định
    public SQLConnectUnit() {
        connect = new SQLConnection("C##TICTAC", "123", "orcl");
    }

    // Hàm khởi tạo cơ bản
    public SQLConnectUnit(String Username, String Password, String Sid) {
        connect = new SQLConnection(Username, Password, Sid);
    }

    // Hàm hỗ trợ Select CSDL
    /**
     * Select * From Table Where Condition Order by OrderBy
     *
     * @throws SQLException
     */
    public ResultSet Select(String TableName, String Condition, String OrderBy) throws SQLException {
        StringBuilder query = new StringBuilder("SELECT * FROM ").append(TableName);

        if (Condition != null && !Condition.isEmpty()) {
            query.append(" WHERE ").append(Condition);
        }

        if (OrderBy != null && !OrderBy.isEmpty()) {
            query.append(" ORDER BY ").append(OrderBy);
        }

        try (PreparedStatement ps = (PreparedStatement) this.connect.getConnect().prepareStatement(query.toString())) {
            return ps.executeQuery();
        } catch (Exception ex) {
            Logger.getLogger(SQLConnectUnit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Hàm over load Select giảm OrderBy parameter
    /**
     * Select * From Table Where Condition
     *
     * @throws SQLException
     */
    public ResultSet Select(String TableName, String Condition) throws SQLException {
        return this.Select(TableName, Condition, null);
    }

    // Hàm over load Select giảm Condition parameter
    /**
     * Select * From Table
     *
     * @throws SQLException
     */
    public ResultSet Select(String TableName) throws SQLException {
        return this.Select(TableName, null, null);
    }

    // Hàm thêm điều kiện vào query
    private void AddCondition(StringBuilder query, String Condition) {
        // kiểm tra nếu condition khác null
        if (Condition != null) {
            query.append(" WHERE ").append(Condition);
        }
    }

    // Hàm thêm OrderBy vào query
    private void AddOrderBy(StringBuilder query, String OrderBy) {
        // Kiểm tra OrderBy Khác null
        if (OrderBy != null) {
            query.append(" ORDER BY ").append(OrderBy);
        }
    }

    public static int getColumnCount(ResultSet result) throws SQLException {
        return result.getMetaData().getColumnCount();
    }

    // Hàm lấy tên cột trong result select từ CSDL
    public static String[] getColumnName(ResultSet result) throws SQLException {
        ResultSetMetaData rsMetaData = result.getMetaData();
        // lấy số lượng cột trong Result
        int ColumnCount = rsMetaData.getColumnCount();
        // khai báo danh sách các cột
        String[] list = new String[ColumnCount];
        for (int i = 1; i <= ColumnCount; i++) { // Column indices start at 1
            list[i - 1] = rsMetaData.getColumnName(i);
        }
        return list;
    }
    
    // Hàm gọi procedure
    public void callProcedure(String procedureName, String... parameters) throws SQLException {
    StringBuilder call = new StringBuilder("{call ");
    call.append(procedureName).append("(");
    for (int i = 0; i < parameters.length; i++) {
        call.append(i == 0 ? "?" : ", ?");
    }
    call.append(")}");

    try (CallableStatement cs = this.connect.getConnect().prepareCall(call.toString())) {
        for (int i = 0; i < parameters.length; i++) {
            cs.setString(i + 1, parameters[i]);
        }
        cs.execute();
    } catch (Exception ex) {
        Logger.getLogger(SQLConnectUnit.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    // Hàm đóng kết nối
    public void Close() throws SQLException, Exception {
        this.connect.Close();
    }
}