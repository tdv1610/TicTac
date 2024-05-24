    
package DAO;

import DTO.NguoiDungDTO;
import DTO.NhomDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.util.Types;
import javax.swing.JOptionPane;

/**
 * @author Oracle
 */
public class NhomDAO extends connection {
    SQLConnectUnit connect;
    
    public static SQLConnection connection = new SQLConnection("c##tictac", "tictac", "orcl");
    
    public String laymanhom(String TENNHOM){
    String maNhom = null; // Khai báo biến để lưu mã nhóm
    Connection con = null;
    PreparedStatement pre = null;
    ResultSet rs = null;

    try {
        con = getConnection();  // Lấy kết nối tới cơ sở dữ liệu
        System.out.println("KẾT NỐI THÀNH CÔNG.");

        String sql = "SELECT MANHOM FROM NHOM WHERE TENNHOM = ? "; // Chỉ lấy cột MANHOM
        pre = con.prepareStatement(sql);
        pre.setString(1, TENNHOM);
        System.out.println("Executing query: " + sql);

        rs = pre.executeQuery();

        if (rs.next()) {
            maNhom = rs.getString("MANHOM"); // Lưu mã nhóm từ cột MANHOM
            System.out.println("MÃ NHÓM: " + maNhom);
        } else {
            System.out.println("NHÓM KHÔNG TỒN TẠI");
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
    return maNhom;
    }
    
    public String laytennhom(String MANHOM){
    String tennhom = null; // Khai báo biến để lưu mã nhóm
    Connection con = null;
    PreparedStatement pre = null;
    ResultSet rs = null;

    try {
        con = getConnection();  // Lấy kết nối tới cơ sở dữ liệu
        System.out.println("KẾT NỐI THÀNH CÔNG.");

        String sql = "SELECT TENNHOM FROM NHOM WHERE MANHOM = ? "; // Chỉ lấy cột MANHOM
        pre = con.prepareStatement(sql);
        pre.setString(1, MANHOM);
        System.out.println("Executing query: " + sql);

        rs = pre.executeQuery();

        if (rs.next()) {
            tennhom = rs.getString("TENNHOM"); // Lưu mã nhóm từ cột MANHOM
            System.out.println("TÊN NHÓM: " + tennhom);
        } else {
            System.out.println("NHÓM KHÔNG TỒN TẠI");
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

    return tennhom; // Trả về tên nhóm
    }
    
    public String layemailtruongnhom(String manhom) {
        String emailTruongNhom = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            conn = getConnection(); // Establish the database connection

            if (conn != null) {
                String sql = "SELECT EMAIL_TRUONGNHOM FROM NHOM WHERE MANHOM = ?";
                pre = conn.prepareStatement(sql);
                pre.setString(1, manhom);
                rs = pre.executeQuery();

                if (rs.next()) {
                    emailTruongNhom = rs.getString("EMAIL_TRUONGNHOM");
                }
            } else {
                System.err.println("Failed to establish a connection.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pre != null) pre.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emailTruongNhom;
    }


    public NhomDTO themnhom(String TENNHOM, String EMAIL_TRUONGNHOM) {
        NhomDTO nhom = null;
        try (Connection con = getConnection();
             CallableStatement cstmt = con.prepareCall("{CALL TAONHOM(?, ?, ?)}")) {
            
            cstmt.setString(1, TENNHOM);
            cstmt.setString(2, EMAIL_TRUONGNHOM);
            cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
            
            cstmt.execute();
            
            String result = cstmt.getString(3);
            if ("Thêm nhóm thành công.".equals(result)) {
                nhom = new NhomDTO();
                nhom.setTenNhom(TENNHOM);
                nhom.setEmailTruongNhom(EMAIL_TRUONGNHOM);
            } else {
                System.err.println(result);
            }
            
        } catch (SQLException ex) {
            // Log the exception with more context
            System.err.println("Error while executing stored procedure TAONHOM: " + ex.getMessage());
            ex.printStackTrace();
        }
        return nhom;
   }
    
    public boolean xoanhom(String MANHOM) {
    try (Connection con = getConnection();
         CallableStatement cstmt = con.prepareCall("{CALL XOANHOM(?, ?)}")) {
        cstmt.setString(1, MANHOM); 
        cstmt.registerOutParameter(2, java.sql.Types.VARCHAR); 

        cstmt.execute();

        String result = cstmt.getString(2); // Lấy thông báo kết quả

        return true; // Trả về true nếu xóa thành công, ngược lại trả về false
    } catch (SQLException ex) {
        // Log lỗi hoặc xử lý nếu cần thiết
        ex.printStackTrace();
        return false; // Trả về false nếu có lỗi xảy ra
    }
}
    
    
    public boolean suaNhom(String maNhom, String tenNhomMoi) {
    Connection con = null;
    PreparedStatement pre = null;

    try {
        con = getConnection();
        String sql = "UPDATE NHOM SET TENNHOM = ? WHERE MANHOM = ?";
        pre = con.prepareStatement(sql);
        pre.setString(1, tenNhomMoi);
        pre.setString(2, maNhom);

        System.out.println("Executing query: " + sql);
        System.out.println("With parameters: TENNHOM = " + tenNhomMoi + ", MANHOM = " + maNhom);

        int rowsUpdated = pre.executeUpdate();
        System.out.println("Rows updated: " + rowsUpdated);
        return rowsUpdated > 0; // Trả về true nếu có dòng được cập nhật

    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    } finally {
        try {
            if (pre != null) pre.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    public String timnhom(String tennhom) {
    Connection con = null;
    PreparedStatement pre = null;
    ResultSet rs = null;

    try {
        con = getConnection();
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Kết nối cơ sở dữ liệu thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        // Tạo câu lệnh SQL để tìm kiếm nhóm theo tên nhóm
        String sql = "SELECT * FROM NHOM WHERE TENNHOM = ?";
        pre = con.prepareStatement(sql);
        pre.setString(1, tennhom);

        // Thực thi câu lệnh truy vấn
        rs = pre.executeQuery();

        // Nếu tìm thấy nhóm, trả về tên nhóm
        if (rs.next()) {
            String tenNhomTimThay = rs.getString("TENNHOM");
            return tenNhomTimThay;
        } else {
            return null;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm nhóm! Chi tiết: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        return null;
    } finally {
        // Đóng kết nối sau khi thao tác xong
        try {
            if (rs != null) rs.close();
            if (pre != null) pre.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

    
    public boolean kiemTraTenNhomTrung(String tenNhom) {
    Connection con = null;
    PreparedStatement pre = null;
    ResultSet rs = null;

    try {
        con = getConnection();
        String sql = "SELECT COUNT(*) FROM NHOM WHERE TENNHOM = ?";
        pre = con.prepareStatement(sql);
        pre.setString(1, tenNhom);
        rs = pre.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
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
    return false;
}
}
