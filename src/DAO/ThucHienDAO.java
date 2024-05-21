package DAO;

import DTO.PhanCongDTO;
import DTO.ThucHienDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}
