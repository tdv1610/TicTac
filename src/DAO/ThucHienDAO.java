package DAO;

import DTO.CongViecDTO;
import DTO.NhomDTO;
import DTO.PhanCongDTO;
import DTO.ThucHienDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThucHienDAO extends connection {
    SQLConnectUnit connect;
    
    public static SQLConnection connection = new SQLConnection("c##tictac", "tictac", "orcl");
    
    public List<PhanCongDTO> layDanhSachPhanCongTrongNhom(String maNhom) {
        List<PhanCongDTO> danhSachPhanCong = new ArrayList<>();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String sql = "SELECT CV.TENCV, TH.EMAIL_TV, TH.TRANGTHAI, CV.NGAYBD, CV.NGAYKT " +
                         "FROM CONGVIEC CV INNER JOIN THUCHIEN TH ON CV.MACV = TH.MACV_PC " +
                         "WHERE CV.MANHOM = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, maNhom);
            rs = pre.executeQuery();

            while (rs.next()) {
                PhanCongDTO phanCong = new PhanCongDTO();
                phanCong.setTenCV(rs.getString("TENCV"));
                phanCong.setEmailThanhVien(rs.getString("EMAIL_TV"));
                phanCong.setTrangThai(rs.getString("TRANGTHAI"));
                phanCong.setNgayBD(rs.getDate("NGAYBD"));
                phanCong.setNgayBD(rs.getDate("NGAYKT"));
                danhSachPhanCong.add(phanCong);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close resources
        }
        return danhSachPhanCong;
    }
    
    public List<PhanCongDTO> layDanhSachCongViecKT(String Ngay, String Email) throws ParseException {
        List<PhanCongDTO> danhSachPhanCong = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String sql = "SELECT CV.TENCV, TH.TRANGTHAI " +
                         "FROM THUCHIEN TH INNER JOIN CONGVIEC CV ON TH.MACV_PC = CV.MACV " +
                         "WHERE CV.NGAYKT = ? AND TH.EMAIL_TV = ?";
            pre = con.prepareStatement(sql);
            pre.setDate(1, new java.sql.Date(sdf.parse(Ngay).getTime()));
            pre.setString(2, Email);
            rs = pre.executeQuery();

            while (rs.next()) {
                PhanCongDTO phanCong = new PhanCongDTO();
                phanCong.setTenCV(rs.getString("TENCV"));
                phanCong.setTrangThai(rs.getString("TRANGTHAI"));
                danhSachPhanCong.add(phanCong);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close resources
        }
        return danhSachPhanCong;
    }
    
    public List<PhanCongDTO> layDanhCongViecBD(String Ngay, String Email) throws ParseException {
        List<PhanCongDTO> danhSachPhanCong = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String sql = "SELECT CV.TENCV, TH.TRANGTHAI " +
                         "FROM THUCHIEN TH INNER JOIN CONGVIEC CV ON TH.MACV_PC = CV.MACV " +
                         "WHERE CV.NGAYBD = ? AND TH.EMAIL_TV = ?";
            pre = con.prepareStatement(sql);
            pre.setDate(1, new java.sql.Date(sdf.parse(Ngay).getTime()));
            pre.setString(2, Email);
            rs = pre.executeQuery();

            while (rs.next()) {
                PhanCongDTO phanCong = new PhanCongDTO();
                phanCong.setTenCV(rs.getString("TENCV"));
                phanCong.setTrangThai(rs.getString("TRANGTHAI"));
                danhSachPhanCong.add(phanCong);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close resources
        }
        return danhSachPhanCong;
    }
     public List<PhanCongDTO> layDanhSachTrangThaiCVTrongNhom(String maNhom,String trangthai) {
        List<PhanCongDTO> danhSachCv = new ArrayList<>();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String sql = "SELECT TH.EMAIL_TV, CV.TENCV " +
                         "FROM CONGVIEC CV INNER JOIN THUCHIEN TH ON CV.MACV = TH.MACV_PC " +
                         "WHERE CV.MANHOM = ? AND TH.TRANGTHAI= ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, maNhom);
            pre.setString(2, trangthai);
            rs = pre.executeQuery();

            while (rs.next()) {
                PhanCongDTO phanCong = new PhanCongDTO();
                phanCong.setEmailThanhVien(rs.getString("EMAIL_TV"));
                phanCong.setTenCV(rs.getString("TENCV"));
                danhSachCv.add(phanCong);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close resources
        }
        return danhSachCv;
    }
     
   public int demSLTrangThaiCongViecTrongNhom(String maNhom, String trangthai) {
    int SLCV = 0;
    Connection con = null;
    PreparedStatement pre = null;
    ResultSet rs = null;

    try {
        con = getConnection();
        String sql = "SELECT COUNT(*) AS SLCV " +
                     "FROM THUCHIEN " +
                     "WHERE MANHOM = ? AND TRANGTHAI = ?";
        pre = con.prepareStatement(sql);
        pre.setString(1, maNhom);
        pre.setString(2, trangthai);
        rs = pre.executeQuery();

        if (rs.next()) {
            SLCV = rs.getInt("SLCV");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pre != null) pre.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return SLCV;
}
    public List<Map<String, Object>> layDanhSachCVTheoEmail(String emailThanhVien) {
        List<Map<String, Object>> danhSachCV = new ArrayList<>();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String sql = "SELECT CV.TENCV, CV.LINHVUC, CV.MOTACV, CV.MUC_UUTIEN, CV.NGAYBD, CV.NGAYKT, TH.MACV_PC " +
                         "FROM CONGVIEC CV INNER JOIN THUCHIEN TH ON CV.MACV = TH.MACV_PC " +
                         "WHERE TH.EMAIL_TV = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, emailThanhVien);
            rs = pre.executeQuery();

            while (rs.next()) {
                Map<String, Object> cv = new HashMap<>();
                cv.put("TENCV", rs.getString("TENCV"));
                cv.put("LINHVUC", rs.getString("LINHVUC"));
                cv.put("MOTACV", rs.getString("MOTACV"));
                cv.put("MUC_UUTIEN", rs.getInt("MUC_UUTIEN"));
                cv.put("NGAYBD", rs.getDate("NGAYBD"));
                cv.put("NGAYKT", rs.getDate("NGAYKT"));
                cv.put("TRANGTHAI", "Cần làm"); // Đặt trạng thái công việc thành "cần làm"

                danhSachCV.add(cv);

                // Cập nhật trạng thái công việc trong cơ sở dữ liệu
                String updateSql = "UPDATE THUCHIEN SET TRANGTHAI = ? WHERE MACV_PC = ?";
                try (PreparedStatement updatePre = con.prepareStatement(updateSql)) {
                    updatePre.setString(1, "Cần làm");
                    updatePre.setString(2, rs.getString("MACV_PC"));
                    updatePre.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try { rs.close(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
            if (pre != null) {
                try { pre.close(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
            if (con != null) {
                try { con.close(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
        }
        return danhSachCV;
    }
    public ThucHienDTO themthuchien(String EMAIL_TV, String MACV_PC, String MANHOM, String TRANGTHAI){
    ThucHienDTO them = null;
    Connection con = null;
    PreparedStatement pre = null;
    ResultSet rs = null;

    try {
        con = getConnection();  // Lấy kết nối đến cơ sở dữ liệu
        System.out.println("Kết nối thành công.");

        String sql = "INSERT INTO THUCHIEN VALUES (?, ?, ?, ?)";
        pre = con.prepareStatement(sql);
        pre.setString(1, EMAIL_TV);
        pre.setString(2, MACV_PC);
        pre.setString(3, MANHOM);
        pre.setString(4, TRANGTHAI);
        System.out.println("Đang thực thi truy vấn: " + sql);

        int rowsAffected = pre.executeUpdate(); // Thực thi câu lệnh INSERT và lấy số hàng ảnh hưởng

        if (rowsAffected > 0) {
            them = new ThucHienDTO();
            them.setEmailThanhVien(EMAIL_TV);
            them.setMaCV_PhanCong(MACV_PC);
            them.setMaNhom(MANHOM);
            them.setTrangThai(TRANGTHAI);
            System.out.println("Thêm thực hiện thành công: " + them.toString());
        } else {
            System.out.println("LỖI!.");
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

    return them;
}

    public String laymanhomcuacv(String EMAIL_TV, String TRANGTHAI){
    String manhom = null; // Khai báo biến để lưu mã nhóm
    Connection con = null;
    PreparedStatement pre = null;
    ResultSet rs = null;

    try {
        con = getConnection();  // Lấy kết nối tới cơ sở dữ liệu
        System.out.println("KẾT NỐI THÀNH CÔNG.");

        String sql = "SELECT MANHOM FROM THUCHIEN WHERE EMAIL_TV = ? AND TRANGTHAI = ? "; // 
        pre = con.prepareStatement(sql);
        pre.setString(1, EMAIL_TV);
        pre.setString(2, TRANGTHAI);
        System.out.println("Executing query: " + sql);

        rs = pre.executeQuery();

        if (rs.next()) {
            manhom = rs.getString("MANHOM"); 
            System.out.println("MÃ CÔNG VIỆC ĐƯỢC PHÂN : " + manhom);
        } else {
            System.out.println("CÔNG VIỆC KHÔNG TỒN TẠI");
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
    return manhom;
    }

    public List<ThucHienDTO> DSCongViec(String EMAIL_TV, String TRANGTHAI) {
        List<ThucHienDTO> danhSach = new ArrayList<>();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;        
        try {
            con = getConnection();  // Get the database connection
            System.out.println("Connection established successfully.");

            String sql = "SELECT MACV_PC, MANHOM FROM THUCHIEN WHERE EMAIL_TV = ? AND TRANGTHAI = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, EMAIL_TV);
            pre.setString(2, TRANGTHAI);
            System.out.println("Executing query: " + sql);
            
            rs = pre.executeQuery();
            
            while (rs.next()) {
                ThucHienDTO cv_th = new ThucHienDTO();
                cv_th.setEmailThanhVien(EMAIL_TV);
                cv_th.setMaCV_PhanCong(rs.getString("MACV_PC"));
                cv_th.setMaNhom(rs.getString("MANHOM"));
                cv_th.setTrangThai(TRANGTHAI);
                danhSach.add(cv_th);
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        } 
        finally {
            try {
                if (rs != null) rs.close();
                if (pre != null) pre.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return danhSach;
    }
    
    public boolean capNhatTrangThaiCongViec(String MACV_PC, String TRANGTHAI) {
        try (Connection con = getConnection();
            CallableStatement cstmt = con.prepareCall("{CALL CAPNHAT_TRANGTHAI_CONGVIEC(?, ?)}")) { // Gọi stored procedure

        // Thiết lập giá trị cho các tham số
            cstmt.setString(1, MACV_PC); 
            cstmt.setString(2, TRANGTHAI); 

            cstmt.execute(); // Thực thi stored procedure

            return true; // Trả về true nếu cập nhật thành công
        }
        catch (SQLException ex) {
            // Log lỗi hoặc xử lý nếu cần thiết
            ex.printStackTrace();
            return false; 
        }
    }
    
    public String laymacvtheonguoiphutrach(String EMAIL_TV, String MANHOM){
        String macv = null; // Khai báo biến để lưu mã nhóm
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();  // Lấy kết nối tới cơ sở dữ liệu
            System.out.println("KẾT NỐI THÀNH CÔNG.");

            String sql = "SELECT MACV_PC FROM THUCHIEN WHERE EMAIL_TV = ? AND MANHOM = ? "; 
            pre = con.prepareStatement(sql);
            pre.setString(1, EMAIL_TV);
            pre.setString(2, MANHOM);
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();

            if (rs.next()) {
                macv = rs.getString("MACV_PC"); 
                System.out.println("MÃ CÔNG VIỆC: " + macv);
            } else {
                System.out.println("CÔNG VIỆC KHÔNG TỒN TẠI");
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
        return macv;
    }
    
    public String layTrangThaiCV(String EMAIL_TV, String MANHOM){
        String trangthai = null; // Khai báo biến để lưu mã nhóm
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();  // Lấy kết nối tới cơ sở dữ liệu
            System.out.println("KẾT NỐI THÀNH CÔNG.");

            String sql = "SELECT TRANGTHAI FROM THUCHIEN WHERE EMAIL_TV = ? AND MANHOM = ? "; 
            pre = con.prepareStatement(sql);
            pre.setString(1, EMAIL_TV);
            pre.setString(2, MANHOM);
            System.out.println("Executing query: " + sql);

            rs = pre.executeQuery();

            if (rs.next()) {
                trangthai = rs.getString("TRANGTHAI"); 
                System.out.println("Trạng thái: " + trangthai);
            } else {
                System.out.println("CÔNG VIỆC KHÔNG TỒN TẠI");
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
        return trangthai;
    }

    public List<PhanCongDTO> layDanhSachNgayBD(String Email) {
        List<PhanCongDTO> danhSach = new ArrayList<>();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String sql = "SELECT CV.NGAYBD " +
                         "FROM CONGVIEC CV INNER JOIN THUCHIEN TH ON CV.MACV = TH.MACV_PC " +
                         "WHERE TH.EMAIL_TV = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, Email);
            rs = pre.executeQuery();

            while (rs.next()) {
                PhanCongDTO pc = new PhanCongDTO();
                pc.setNgayBD(rs.getDate("NGAYBD"));
                danhSach.add(pc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng kết nối và các tài nguyên
        }
        return danhSach;
    }
    
    public List<PhanCongDTO> layDanhSachNgayKT(String Email) {
        List<PhanCongDTO> danhSach = new ArrayList<>();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String sql = "SELECT CV.NGAYKT " +
                         "FROM CONGVIEC CV INNER JOIN THUCHIEN TH ON CV.MACV = TH.MACV_PC " +
                         "WHERE TH.EMAIL_TV = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, Email);
            rs = pre.executeQuery();

            while (rs.next()) {
                PhanCongDTO pc = new PhanCongDTO();
                pc.setNgayKT(rs.getDate("NGAYKT"));
                danhSach.add(pc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng kết nối và các tài nguyên
        }
        return danhSach;
    }
    
    

}
