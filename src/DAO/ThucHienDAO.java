package DAO;

import DTO.CongViecDTO;
import DTO.NhomDTO;
import DTO.PhanCongDTO;
import DTO.ThucHienDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThucHienDAO extends connection {
    public List<PhanCongDTO> layDanhSachPhanCongTrongNhom(String maNhom) {
        List<PhanCongDTO> danhSachPhanCong = new ArrayList<>();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String sql = "SELECT CV.TENCV, TH.EMAIL_TV, TH.TRANGTHAI " +
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
                danhSachPhanCong.add(phanCong);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close resources
        }
        return danhSachPhanCong;
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

}
