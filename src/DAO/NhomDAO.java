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

/**
 * @author Oracle
 */
public class NhomDAO extends connection {
    SQLConnectUnit connect;
    
    public static SQLConnection connection = new SQLConnection("c##tictac", "tictac", "orcl");

    public List<NhomDTO> layDanhSachNhomTheoEmail(String EMAIL_TRUONGNHOM) {
        List<NhomDTO> danhSachNhom = new ArrayList<>();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            // Get the database connection
            con = getConnection();
            System.out.println("Connection established successfully.");

            String sql = "SELECT * FROM NHOM WHERE EMAIL_TRUONGNHOM = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, EMAIL_TRUONGNHOM);
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();

            while (rs.next()) {
                NhomDTO nhom = new NhomDTO();
                nhom.setMaNhom(rs.getString("MANHOM"));
                nhom.setTenNhom(rs.getString("TENNHOM"));
                nhom.setEmailTruongNhom(rs.getString("EMAIL_TRUONGNHOM"));
                danhSachNhom.add(nhom);
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
        return danhSachNhom;
    }
    
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

    return maNhom; // Trả về mã nhóm
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
    
    public boolean suaNhom(String maNhom, String tenNhom) {
        Connection con = null;
        PreparedStatement pre = null;

        try {
            con = getConnection();
            String sql = "UPDATE NHOM SET TENNHOM = ? WHERE MANHOM = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, tenNhom);
            pre.setString(2, maNhom);

            int rowsUpdated = pre.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (pre != null) pre.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
}
