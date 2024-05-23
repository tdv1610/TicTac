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
    SQLConnectUnit connect;
    
    public static SQLConnection connection = new SQLConnection("c##TICTAC", "123", "orcl");
    
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

}
