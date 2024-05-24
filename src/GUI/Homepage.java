/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.CongViecDAO;
import DAO.NguoiDungDAO;
import DAO.NguoiDung_NhomDAO;
import DAO.NhomDAO;
import DAO.ThucHienDAO;
import DTO.CongViecDTO;
import DTO.NguoiDung_NhomDTO;
import DTO.NhomDTO;
import DTO.ThucHienDTO;
import GUI.DangNhap;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Homepage extends javax.swing.JFrame {

    public static String mn;
    public static String tennhom;
    public static String laymanhom;
    public static String tencvcl;
    public static String tencvdl;
    public static String tencvdht;
    
    public static String macvcl;
    public static String macvdl;
    public static String macvdht;
        
    /**
     * Creates new form Homepage
     */
    public Homepage(){
        initComponents();
        thongtinnhom();
        addTableClick2Listener();
        addTableClick1Listener();
    try {
        dsCVcanlam();
        dsCVdahoanthanh();
        dsCVdanglam();
    } catch (ParseException ex) {
        Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    private void dsCVcanlam() throws ParseException {
        ThucHienDAO layma = new ThucHienDAO();
        List<ThucHienDTO> ma_nhom = layma.DSCongViec(DangNhap.pEmail, "Cần làm");
        CongViecDAO nhom = new CongViecDAO();
        DefaultTableModel model = (DefaultTableModel) table_CanLam_BangCV_VCT.getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (ThucHienDTO dsmanhom : ma_nhom) {
            CongViecDTO dscv = nhom.TimCV(dsmanhom.getMaCV_PhanCong());
            String manhomcl = dsmanhom.getMaNhom();
            if (dscv != null) { // Kiểm tra null để tránh NullPointerException
                String tencv = dscv.getTenCV();
                String linhvuc = dscv.getLinhVuc();
                String mota = dscv.getMoTa(); // Tên phương thức đã được sửa
                java.util.Date ngaybd = dscv.getNgayBD();
                java.util.Date ngaykt = dscv.getNgayKT();
                int muc_uutien = dscv.getMuc_uutien();
                model.addRow(new Object[]{manhomcl, tencv, linhvuc, mota, ngaybd, ngaykt, muc_uutien});
            }
            else {
                System.out.println("Một trong các công việc là null."); // Xử lý trường hợp null nếu cần thiết
            }
        }
    }
    
    private void dsCVdahoanthanh() throws ParseException {
        ThucHienDAO layma = new ThucHienDAO();
        List<ThucHienDTO> ma_nhom = layma.DSCongViec(DangNhap.pEmail, "Đã hoàn thành");
        CongViecDAO nhom = new CongViecDAO();
        DefaultTableModel model = (DefaultTableModel) table_DaHoanThanh_BangCV_VCT.getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (ThucHienDTO dsmanhom : ma_nhom) {
            CongViecDTO dscv = nhom.TimCV(dsmanhom.getMaCV_PhanCong());
            String manhomdht = dsmanhom.getMaNhom();
            if (dscv != null) { // Kiểm tra null để tránh NullPointerException
                String tencv = dscv.getTenCV();
                String linhvuc = dscv.getLinhVuc();
                String mota = dscv.getMoTa(); // Tên phương thức đã được sửa
                java.util.Date ngaybd = dscv.getNgayBD();
                java.util.Date ngaykt = dscv.getNgayKT();
                int muc_uutien = dscv.getMuc_uutien();
                model.addRow(new Object[]{manhomdht, tencv, linhvuc, mota, ngaybd, ngaykt, muc_uutien});
            }
            else {
                System.out.println("Một trong các công việc là null."); // Xử lý trường hợp null nếu cần thiết
            }
        }
    }

    
    private void dsCVdanglam() throws ParseException {
        ThucHienDAO layma = new ThucHienDAO();
        List<ThucHienDTO> ma_nhom = layma.DSCongViec(DangNhap.pEmail, "Đang làm");
        CongViecDAO nhom = new CongViecDAO();
        DefaultTableModel model = (DefaultTableModel) table_DangLam_BangCV_VCT.getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

        for (ThucHienDTO dsmanhom : ma_nhom) {
            CongViecDTO dscv = nhom.TimCV(dsmanhom.getMaCV_PhanCong());
            String manhomdl = dsmanhom.getMaNhom();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (dscv != null) { // Kiểm tra null để tránh NullPointerException
                String tencv = dscv.getTenCV();
                String linhvuc = dscv.getLinhVuc();
                String mota = dscv.getMoTa(); // Tên phương thức đã được sửa
                java.util.Date ngaybd = dscv.getNgayBD();
                java.util.Date ngaykt = dscv.getNgayKT();
                int muc_uutien = dscv.getMuc_uutien();
                model.addRow(new Object[]{manhomdl, tencv, linhvuc, mota, ngaybd, ngaykt, muc_uutien});
            }
            else {
                System.out.println("Một trong các công việc là null."); // Xử lý trường hợp null nếu cần thiết
            }
        }
    }


    
    

    private void thongtinnhom() {
        NhomDAO nhomDAO = new NhomDAO();
        List<NhomDTO> danhSachNhom = nhomDAO.layDanhSachNhomTheoEmail(DangNhap.pEmail);

        DefaultTableModel model = (DefaultTableModel) table_ThongTinNhom_NCT.getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

        for (NhomDTO nhom : danhSachNhom) {
            model.addRow(new Object[]{nhom.getTenNhom()});
        }
    }
    
    private void addTableClick2Listener() {
    table_ThongTinNhom_NCT.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) { // Kiểm tra xem có phải double-click không
            int row = table_ThongTinNhom_NCT.getSelectedRow();
            if (row >= 0) {
                tennhom = (String) table_ThongTinNhom_NCT.getValueAt(row, 0);
                ChiTietNhom nhom = new ChiTietNhom();
                nhom.show();
                dispose();
                
            }
        }
        }
    });
    table_CanLam_BangCV_VCT.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) { // Kiểm tra xem có phải double-click không
            int row = table_CanLam_BangCV_VCT.getSelectedRow();
            if (row >= 0) {
                macvcl = (String) table_CanLam_BangCV_VCT.getValueAt(row, 0);
                tencvcl = (String) table_CanLam_BangCV_VCT.getValueAt(row, 1);
                
                ChiTietCongViec ctcv = new ChiTietCongViec();
                ctcv.show();
                dispose();
                
            }
        }
        }
    }
    );
    table_DangLam_BangCV_VCT.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) { // Kiểm tra xem có phải double-click không
            int row = table_DangLam_BangCV_VCT.getSelectedRow();
            if (row >= 0) {
                macvdl = (String) table_DangLam_BangCV_VCT.getValueAt(row, 0);
                tencvdl = (String) table_DangLam_BangCV_VCT.getValueAt(row, 1);
                ChiTietCongViec ctcv = new ChiTietCongViec();
                ctcv.show();
                dispose();
                
            }
        }
        }
    }
    );
    table_DaHoanThanh_BangCV_VCT.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) { // Kiểm tra xem có phải double-click không
            int row = table_DaHoanThanh_BangCV_VCT.getSelectedRow();
            if (row >= 0) {
                macvdht = (String) table_DaHoanThanh_BangCV_VCT.getValueAt(row, 0);
                tencvdht = (String) table_DaHoanThanh_BangCV_VCT.getValueAt(row, 1);
                ChiTietCongViec ctcv = new ChiTietCongViec();
                ctcv.show();
                dispose();
                
            }
        }
        }
    }
    );
    
}
    
    private void addTableClick1Listener() {
        table_ThongTinNhom_NCT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Kiểm tra xem có phải click một lần không
                    int row = table_ThongTinNhom_NCT.getSelectedRow();
                    if (row >= 0) {
                        String lay_tennhom = (String) table_ThongTinNhom_NCT.getValueAt(row, 0);
                        tf_tennhom_homepage.setText(tennhom);

                        // Lấy mã nhóm dựa trên tên nhóm đã chọn
                        NhomDAO nhomDAO = new NhomDAO();
                        List<NhomDTO> danhSachNhom = nhomDAO.layDanhSachNhomTheoEmail(DangNhap.pEmail);
                        for (NhomDTO nhom : danhSachNhom) {
                            if (nhom.getTenNhom().equals(lay_tennhom)) {
                                mn = nhom.getMaNhom();
                                break;
                            }
                        }
                    }
                }
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TicTac = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_VCT_TicTac = new javax.swing.JButton();
        btn_NCT_TicTac = new javax.swing.JButton();
        btn_TK_TicTac = new javax.swing.JButton();
        btn_DX_TicTac = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panel_VCT = new javax.swing.JPanel();
        tf_timcongviec_VCT = new javax.swing.JTextField();
        btn_TimKiem_VCT = new javax.swing.JButton();
        tabbedpane_BangCV_VCT = new javax.swing.JTabbedPane();
        panel_CanLam_BangCV_VCT = new javax.swing.JPanel();
        scrpane_CanLam_BangCV_VCT = new javax.swing.JScrollPane();
        table_CanLam_BangCV_VCT = new javax.swing.JTable();
        panel_DangLam_BangCV_VCT = new javax.swing.JPanel();
        scrpane_DangLam_BangCV_VCT = new javax.swing.JScrollPane();
        table_DangLam_BangCV_VCT = new javax.swing.JTable();
        panel_DaHoanThanh_BangCV_VCT = new javax.swing.JPanel();
        scrpane_DaHoanThanh_BangCV_VCT = new javax.swing.JScrollPane();
        table_DaHoanThanh_BangCV_VCT = new javax.swing.JTable();
        panel_NCT = new javax.swing.JPanel();
        tf_TimNhom_NCT = new javax.swing.JTextField();
        btn_TimNhom_NCt = new javax.swing.JButton();
        scrpane_DanhSachNhom_NCT = new javax.swing.JScrollPane();
        table_ThongTinNhom_NCT = new javax.swing.JTable();
        btn_TaoNhom_NCT = new javax.swing.JButton();
        label_tennhom = new javax.swing.JLabel();
        tf_tennhom_homepage = new javax.swing.JTextField();
        label_thanhvien_homepage = new javax.swing.JLabel();
        tf_thanhvien_homepage = new javax.swing.JTextField();
        btn_themthanhvien_NCT = new javax.swing.JButton();
        scrpane_ThanhVien_TaoNhom = new javax.swing.JScrollPane();
        table_themtv = new javax.swing.JTable();
        btn_sua_NCT = new javax.swing.JButton();
        btn_Xoathanhvien_NCT = new javax.swing.JButton();
        btn_hoantac_NCT = new javax.swing.JButton();
        btn_roinhom_NCT = new javax.swing.JButton();
        btn_themcongviec_NCT = new javax.swing.JButton();
        panel_TK = new javax.swing.JPanel();
        label_TenNgDung_TK = new javax.swing.JLabel();
        label_MaNgDung_TK = new javax.swing.JLabel();
        tf_TenNgDung_TK = new javax.swing.JTextField();
        tf_MaNgDung_TK = new javax.swing.JTextField();
        btn_DoiPass_TK = new javax.swing.JButton();
        btn_XoaTK_TK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TicTac.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TicTac");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/teamwork (2).png"))); // NOI18N

        btn_VCT_TicTac.setBackground(new java.awt.Color(0, 0, 0));
        btn_VCT_TicTac.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_VCT_TicTac.setForeground(new java.awt.Color(255, 255, 255));
        btn_VCT_TicTac.setText("Việc của tôi");
        btn_VCT_TicTac.setBorder(null);
        btn_VCT_TicTac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_VCT_TicTacMouseClicked(evt);
            }
        });
        btn_VCT_TicTac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VCT_TicTacActionPerformed(evt);
            }
        });

        btn_NCT_TicTac.setBackground(new java.awt.Color(0, 0, 0));
        btn_NCT_TicTac.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_NCT_TicTac.setForeground(new java.awt.Color(255, 255, 255));
        btn_NCT_TicTac.setText("Nhóm của tôi");
        btn_NCT_TicTac.setBorder(null);
        btn_NCT_TicTac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_NCT_TicTacMouseClicked(evt);
            }
        });
        btn_NCT_TicTac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NCT_TicTacActionPerformed(evt);
            }
        });

        btn_TK_TicTac.setBackground(new java.awt.Color(0, 0, 0));
        btn_TK_TicTac.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_TK_TicTac.setForeground(new java.awt.Color(255, 255, 255));
        btn_TK_TicTac.setText("Tài khoản");
        btn_TK_TicTac.setBorder(null);
        btn_TK_TicTac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TK_TicTacMouseClicked(evt);
            }
        });
        btn_TK_TicTac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TK_TicTacActionPerformed(evt);
            }
        });

        btn_DX_TicTac.setBackground(new java.awt.Color(0, 102, 102));
        btn_DX_TicTac.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_DX_TicTac.setForeground(new java.awt.Color(255, 255, 255));
        btn_DX_TicTac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/log-out.png"))); // NOI18N
        btn_DX_TicTac.setText("Đăng xuất");
        btn_DX_TicTac.setToolTipText("");
        btn_DX_TicTac.setActionCommand("");
        btn_DX_TicTac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DX_TicTacMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TicTacLayout = new javax.swing.GroupLayout(TicTac);
        TicTac.setLayout(TicTacLayout);
        TicTacLayout.setHorizontalGroup(
            TicTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_VCT_TicTac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_NCT_TicTac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_TK_TicTac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(TicTacLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TicTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TicTacLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TicTacLayout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(btn_DX_TicTac)
                        .addGap(37, 37, 37))))
            .addGroup(TicTacLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        TicTacLayout.setVerticalGroup(
            TicTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicTacLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(64, 64, 64)
                .addComponent(btn_VCT_TicTac, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_NCT_TicTac, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_TK_TicTac, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                .addComponent(btn_DX_TicTac)
                .addGap(17, 17, 17))
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        panel_VCT.setBackground(new java.awt.Color(0, 102, 102));

        tf_timcongviec_VCT.setBackground(new java.awt.Color(0, 153, 153));
        tf_timcongviec_VCT.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        tf_timcongviec_VCT.setText("Nhập thông tin công việc");
        tf_timcongviec_VCT.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        btn_TimKiem_VCT.setBackground(new java.awt.Color(0, 102, 102));
        btn_TimKiem_VCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.png"))); // NOI18N
        btn_TimKiem_VCT.setBorder(null);
        btn_TimKiem_VCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiem_VCTActionPerformed(evt);
            }
        });

        tabbedpane_BangCV_VCT.setBackground(new java.awt.Color(0, 153, 153));
        tabbedpane_BangCV_VCT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        panel_CanLam_BangCV_VCT.setBackground(new java.awt.Color(204, 255, 204));

        table_CanLam_BangCV_VCT.setAutoCreateRowSorter(true);
        table_CanLam_BangCV_VCT.setBackground(new java.awt.Color(0, 153, 153));
        table_CanLam_BangCV_VCT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table_CanLam_BangCV_VCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Ma nhom", "Tên công việc", "Lĩnh vực", "Mô tả", "Ngày bắt đầu", "Ngày kết thúc", "Mức độ ưu tiên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_CanLam_BangCV_VCT.setGridColor(new java.awt.Color(255, 255, 255));
        table_CanLam_BangCV_VCT.setSelectionBackground(new java.awt.Color(204, 255, 204));
        table_CanLam_BangCV_VCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_CanLam_BangCV_VCTMouseClicked(evt);
            }
        });
        scrpane_CanLam_BangCV_VCT.setViewportView(table_CanLam_BangCV_VCT);

        javax.swing.GroupLayout panel_CanLam_BangCV_VCTLayout = new javax.swing.GroupLayout(panel_CanLam_BangCV_VCT);
        panel_CanLam_BangCV_VCT.setLayout(panel_CanLam_BangCV_VCTLayout);
        panel_CanLam_BangCV_VCTLayout.setHorizontalGroup(
            panel_CanLam_BangCV_VCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrpane_CanLam_BangCV_VCT, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
        );
        panel_CanLam_BangCV_VCTLayout.setVerticalGroup(
            panel_CanLam_BangCV_VCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrpane_CanLam_BangCV_VCT, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        );

        tabbedpane_BangCV_VCT.addTab("Cần làm", panel_CanLam_BangCV_VCT);

        panel_DangLam_BangCV_VCT.setBackground(new java.awt.Color(204, 255, 204));

        table_DangLam_BangCV_VCT.setAutoCreateRowSorter(true);
        table_DangLam_BangCV_VCT.setBackground(new java.awt.Color(0, 153, 153));
        table_DangLam_BangCV_VCT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table_DangLam_BangCV_VCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tên công việc", "Lĩnh vực", "Mô tả", "Ngày bắt đầu", "Ngày kết thúc", "Mức độ ưu tiên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_DangLam_BangCV_VCT.setGridColor(new java.awt.Color(255, 255, 255));
        table_DangLam_BangCV_VCT.setSelectionBackground(new java.awt.Color(204, 255, 204));
        scrpane_DangLam_BangCV_VCT.setViewportView(table_DangLam_BangCV_VCT);

        javax.swing.GroupLayout panel_DangLam_BangCV_VCTLayout = new javax.swing.GroupLayout(panel_DangLam_BangCV_VCT);
        panel_DangLam_BangCV_VCT.setLayout(panel_DangLam_BangCV_VCTLayout);
        panel_DangLam_BangCV_VCTLayout.setHorizontalGroup(
            panel_DangLam_BangCV_VCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrpane_DangLam_BangCV_VCT, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
        );
        panel_DangLam_BangCV_VCTLayout.setVerticalGroup(
            panel_DangLam_BangCV_VCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrpane_DangLam_BangCV_VCT, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        );

        tabbedpane_BangCV_VCT.addTab("Đang làm", panel_DangLam_BangCV_VCT);

        panel_DaHoanThanh_BangCV_VCT.setBackground(new java.awt.Color(204, 255, 204));

        table_DaHoanThanh_BangCV_VCT.setAutoCreateRowSorter(true);
        table_DaHoanThanh_BangCV_VCT.setBackground(new java.awt.Color(0, 153, 153));
        table_DaHoanThanh_BangCV_VCT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table_DaHoanThanh_BangCV_VCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tên công việc", "Lĩnh vực", "Mô tả", "Ngày bắt đầu", "Ngày kết thúc", "Mức độ ưu tiên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_DaHoanThanh_BangCV_VCT.setFocusable(false);
        table_DaHoanThanh_BangCV_VCT.setGridColor(new java.awt.Color(255, 255, 153));
        table_DaHoanThanh_BangCV_VCT.setInheritsPopupMenu(true);
        table_DaHoanThanh_BangCV_VCT.setSelectionBackground(new java.awt.Color(204, 255, 204));
        table_DaHoanThanh_BangCV_VCT.setShowGrid(false);
        table_DaHoanThanh_BangCV_VCT.setShowHorizontalLines(true);
        table_DaHoanThanh_BangCV_VCT.setUpdateSelectionOnSort(false);
        scrpane_DaHoanThanh_BangCV_VCT.setViewportView(table_DaHoanThanh_BangCV_VCT);

        javax.swing.GroupLayout panel_DaHoanThanh_BangCV_VCTLayout = new javax.swing.GroupLayout(panel_DaHoanThanh_BangCV_VCT);
        panel_DaHoanThanh_BangCV_VCT.setLayout(panel_DaHoanThanh_BangCV_VCTLayout);
        panel_DaHoanThanh_BangCV_VCTLayout.setHorizontalGroup(
            panel_DaHoanThanh_BangCV_VCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrpane_DaHoanThanh_BangCV_VCT)
        );
        panel_DaHoanThanh_BangCV_VCTLayout.setVerticalGroup(
            panel_DaHoanThanh_BangCV_VCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrpane_DaHoanThanh_BangCV_VCT)
        );

        tabbedpane_BangCV_VCT.addTab("Đã hoàn thành", panel_DaHoanThanh_BangCV_VCT);

        javax.swing.GroupLayout panel_VCTLayout = new javax.swing.GroupLayout(panel_VCT);
        panel_VCT.setLayout(panel_VCTLayout);
        panel_VCTLayout.setHorizontalGroup(
            panel_VCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_VCTLayout.createSequentialGroup()
                .addContainerGap(473, Short.MAX_VALUE)
                .addComponent(tf_timcongviec_VCT, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_TimKiem_VCT, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panel_VCTLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(tabbedpane_BangCV_VCT, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_VCTLayout.setVerticalGroup(
            panel_VCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_VCTLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(panel_VCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_timcongviec_VCT, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btn_TimKiem_VCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(tabbedpane_BangCV_VCT, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        panel_NCT.setBackground(new java.awt.Color(0, 102, 102));
        panel_NCT.setForeground(new java.awt.Color(255, 255, 255));

        tf_TimNhom_NCT.setBackground(new java.awt.Color(0, 153, 153));
        tf_TimNhom_NCT.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        tf_TimNhom_NCT.setText("Nhập thông tin nhóm");
        tf_TimNhom_NCT.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        tf_TimNhom_NCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_TimNhom_NCTActionPerformed(evt);
            }
        });

        btn_TimNhom_NCt.setBackground(new java.awt.Color(0, 102, 102));
        btn_TimNhom_NCt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.png"))); // NOI18N
        btn_TimNhom_NCt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimNhom_NCtActionPerformed(evt);
            }
        });

        table_ThongTinNhom_NCT.setAutoCreateRowSorter(true);
        table_ThongTinNhom_NCT.setBackground(new java.awt.Color(0, 153, 153));
        table_ThongTinNhom_NCT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table_ThongTinNhom_NCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Tên nhóm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_ThongTinNhom_NCT.setColumnSelectionAllowed(true);
        table_ThongTinNhom_NCT.setShowGrid(false);
        scrpane_DanhSachNhom_NCT.setViewportView(table_ThongTinNhom_NCT);
        table_ThongTinNhom_NCT.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btn_TaoNhom_NCT.setBackground(new java.awt.Color(0, 102, 102));
        btn_TaoNhom_NCT.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_TaoNhom_NCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/create.png"))); // NOI18N
        btn_TaoNhom_NCT.setText("Tạo nhóm");
        btn_TaoNhom_NCT.setBorder(null);
        btn_TaoNhom_NCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TaoNhom_NCTMouseClicked(evt);
            }
        });
        btn_TaoNhom_NCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TaoNhom_NCTActionPerformed(evt);
            }
        });

        label_tennhom.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_tennhom.setForeground(new java.awt.Color(255, 255, 255));
        label_tennhom.setText("Tên nhóm");

        tf_tennhom_homepage.setBackground(new java.awt.Color(0, 153, 153));
        tf_tennhom_homepage.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tf_tennhom_homepage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_tennhom_homepageActionPerformed(evt);
            }
        });

        label_thanhvien_homepage.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_thanhvien_homepage.setForeground(new java.awt.Color(255, 255, 255));
        label_thanhvien_homepage.setText("Thành viên");

        tf_thanhvien_homepage.setBackground(new java.awt.Color(0, 153, 153));
        tf_thanhvien_homepage.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tf_thanhvien_homepage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_thanhvien_homepageActionPerformed(evt);
            }
        });

        btn_themthanhvien_NCT.setBackground(new java.awt.Color(0, 102, 102));
        btn_themthanhvien_NCT.setForeground(new java.awt.Color(255, 255, 255));
        btn_themthanhvien_NCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus_4315609 (1).png"))); // NOI18N
        btn_themthanhvien_NCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themthanhvien_NCTActionPerformed(evt);
            }
        });

        table_themtv.setBackground(new java.awt.Color(0, 153, 153));
        table_themtv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Email", "Tên người dùng"
            }
        ));
        scrpane_ThanhVien_TaoNhom.setViewportView(table_themtv);

        btn_sua_NCT.setBackground(new java.awt.Color(0, 0, 0));
        btn_sua_NCT.setForeground(new java.awt.Color(255, 255, 255));
        btn_sua_NCT.setText("Sửa");
        btn_sua_NCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sua_NCTActionPerformed(evt);
            }
        });

        btn_Xoathanhvien_NCT.setBackground(new java.awt.Color(0, 0, 0));
        btn_Xoathanhvien_NCT.setForeground(new java.awt.Color(255, 255, 255));
        btn_Xoathanhvien_NCT.setText("Xóa");

        btn_hoantac_NCT.setBackground(new java.awt.Color(0, 0, 0));
        btn_hoantac_NCT.setForeground(new java.awt.Color(255, 255, 255));
        btn_hoantac_NCT.setText("Hoàn tác");
        btn_hoantac_NCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hoantac_NCTActionPerformed(evt);
            }
        });

        btn_roinhom_NCT.setBackground(new java.awt.Color(0, 0, 0));
        btn_roinhom_NCT.setForeground(new java.awt.Color(255, 255, 255));
        btn_roinhom_NCT.setText("Rời nhóm");
        btn_roinhom_NCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_roinhom_NCTActionPerformed(evt);
            }
        });

        btn_themcongviec_NCT.setBackground(new java.awt.Color(0, 0, 0));
        btn_themcongviec_NCT.setForeground(new java.awt.Color(255, 255, 255));
        btn_themcongviec_NCT.setText("Thêm công việc");
        btn_themcongviec_NCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_themcongviec_NCTMouseClicked(evt);
            }
        });
        btn_themcongviec_NCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themcongviec_NCTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_NCTLayout = new javax.swing.GroupLayout(panel_NCT);
        panel_NCT.setLayout(panel_NCTLayout);
        panel_NCTLayout.setHorizontalGroup(
            panel_NCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_NCTLayout.createSequentialGroup()
                .addGroup(panel_NCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_NCTLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btn_TaoNhom_NCT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_TimNhom_NCT, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_NCTLayout.createSequentialGroup()
                        .addContainerGap(59, Short.MAX_VALUE)
                        .addGroup(panel_NCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_NCTLayout.createSequentialGroup()
                                .addGroup(panel_NCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(label_thanhvien_homepage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label_tennhom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel_NCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_tennhom_homepage, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel_NCTLayout.createSequentialGroup()
                                        .addComponent(tf_thanhvien_homepage, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_themthanhvien_NCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(scrpane_ThanhVien_TaoNhom, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGroup(panel_NCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel_NCTLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                        .addComponent(btn_themcongviec_NCT))
                                    .addGroup(panel_NCTLayout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(panel_NCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_roinhom_NCT)
                                            .addGroup(panel_NCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btn_Xoathanhvien_NCT, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btn_sua_NCT, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btn_hoantac_NCT)))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(scrpane_DanhSachNhom_NCT, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_TimNhom_NCt)
                .addGap(23, 23, 23))
        );
        panel_NCTLayout.setVerticalGroup(
            panel_NCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_NCTLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(panel_NCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_TimNhom_NCT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_TimNhom_NCt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_TaoNhom_NCT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrpane_DanhSachNhom_NCT, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_NCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_NCTLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panel_NCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_tennhom)
                            .addComponent(tf_tennhom_homepage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel_NCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel_NCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(label_thanhvien_homepage)
                                .addComponent(tf_thanhvien_homepage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_themthanhvien_NCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panel_NCTLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_themcongviec_NCT)
                        .addGap(9, 9, 9)
                        .addComponent(btn_sua_NCT)
                        .addGap(9, 9, 9)
                        .addComponent(btn_Xoathanhvien_NCT)
                        .addGap(3, 3, 3)))
                .addGroup(panel_NCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrpane_ThanhVien_TaoNhom, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_NCTLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btn_hoantac_NCT)
                        .addGap(9, 9, 9)
                        .addComponent(btn_roinhom_NCT)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        panel_TK.setBackground(new java.awt.Color(0, 102, 102));

        label_TenNgDung_TK.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        label_TenNgDung_TK.setText("Tên người dùng");

        label_MaNgDung_TK.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        label_MaNgDung_TK.setText("Mã người dùng");

        tf_TenNgDung_TK.setBackground(new java.awt.Color(0, 153, 153));
        tf_TenNgDung_TK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tf_TenNgDung_TK.setText("Tên người dùng");
        tf_TenNgDung_TK.setBorder(null);
        tf_TenNgDung_TK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_TenNgDung_TKActionPerformed(evt);
            }
        });

        tf_MaNgDung_TK.setBackground(new java.awt.Color(0, 153, 153));
        tf_MaNgDung_TK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tf_MaNgDung_TK.setText("Mã người dùng");
        tf_MaNgDung_TK.setBorder(null);
        tf_MaNgDung_TK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_MaNgDung_TKActionPerformed(evt);
            }
        });

        btn_DoiPass_TK.setBackground(new java.awt.Color(0, 102, 102));
        btn_DoiPass_TK.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_DoiPass_TK.setText("Đổi mật khẩu");
        btn_DoiPass_TK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DoiPass_TKMouseClicked(evt);
            }
        });

        btn_XoaTK_TK.setBackground(new java.awt.Color(0, 102, 102));
        btn_XoaTK_TK.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_XoaTK_TK.setText("Xóa tài khoản");
        btn_XoaTK_TK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XoaTK_TKMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_TKLayout = new javax.swing.GroupLayout(panel_TK);
        panel_TK.setLayout(panel_TKLayout);
        panel_TKLayout.setHorizontalGroup(
            panel_TKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_TKLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_TKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_XoaTK_TK)
                    .addComponent(btn_DoiPass_TK))
                .addGap(339, 339, 339))
            .addGroup(panel_TKLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(panel_TKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_TenNgDung_TK)
                    .addComponent(label_MaNgDung_TK))
                .addGap(36, 36, 36)
                .addGroup(panel_TKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_TenNgDung_TK)
                    .addComponent(tf_MaNgDung_TK, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        panel_TKLayout.setVerticalGroup(
            panel_TKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_TKLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(panel_TKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_TenNgDung_TK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_TenNgDung_TK, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_TKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_MaNgDung_TK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_MaNgDung_TK, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(btn_DoiPass_TK)
                .addGap(18, 18, 18)
                .addComponent(btn_XoaTK_TK)
                .addContainerGap(315, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_VCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_NCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_TK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_VCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_NCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_TK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TicTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TicTac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_VCT_TicTacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VCT_TicTacActionPerformed

    }//GEN-LAST:event_btn_VCT_TicTacActionPerformed

    private void btn_TK_TicTacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TK_TicTacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_TK_TicTacActionPerformed

    private void btn_VCT_TicTacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_VCT_TicTacMouseClicked
        panel_VCT.setVisible(true);
        panel_NCT.setVisible(false);
        panel_TK.setVisible(false);
        
    }//GEN-LAST:event_btn_VCT_TicTacMouseClicked

    private void btn_NCT_TicTacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_NCT_TicTacMouseClicked
        panel_NCT.setVisible(true);
        panel_VCT.setVisible(false);
        panel_TK.setVisible(false);

    }//GEN-LAST:event_btn_NCT_TicTacMouseClicked

    private void tf_TimNhom_NCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_TimNhom_NCTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_TimNhom_NCTActionPerformed

    private void btn_TimNhom_NCtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimNhom_NCtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_TimNhom_NCtActionPerformed

    private void btn_TK_TicTacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TK_TicTacMouseClicked
        panel_TK.setVisible(true);
        panel_VCT.setVisible(false);
        panel_NCT.setVisible(false);
    }//GEN-LAST:event_btn_TK_TicTacMouseClicked

    private void btn_NCT_TicTacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NCT_TicTacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_NCT_TicTacActionPerformed

    private void btn_TaoNhom_NCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TaoNhom_NCTMouseClicked
       TaoNhom tn = new TaoNhom();
       tn.show();
    }//GEN-LAST:event_btn_TaoNhom_NCTMouseClicked

    private void btn_DoiPass_TKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DoiPass_TKMouseClicked
        NhapEmail ne = new NhapEmail();
        ne.show();
        dispose();
    }//GEN-LAST:event_btn_DoiPass_TKMouseClicked

    private void btn_XoaTK_TKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaTK_TKMouseClicked
        JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa tài khoản vĩnh viễn?");
        DangKi dk = new DangKi();
        dk.show();
        dispose();
    }//GEN-LAST:event_btn_XoaTK_TKMouseClicked

    private void btn_DX_TicTacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DX_TicTacMouseClicked
        DangNhap dn = new DangNhap();
        dn.show();
        dispose();
    }//GEN-LAST:event_btn_DX_TicTacMouseClicked

    private void btn_TimKiem_VCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiem_VCTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_TimKiem_VCTActionPerformed

    private void btn_TaoNhom_NCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TaoNhom_NCTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_TaoNhom_NCTActionPerformed

    private void tf_MaNgDung_TKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_MaNgDung_TKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_MaNgDung_TKActionPerformed

    private void tf_TenNgDung_TKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_TenNgDung_TKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_TenNgDung_TKActionPerformed

    private void table_CanLam_BangCV_VCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_CanLam_BangCV_VCTMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table_CanLam_BangCV_VCTMouseClicked

    private void btn_sua_NCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sua_NCTActionPerformed
        // TODO add your handling code here:
        
        String tennhom = tf_tennhom_homepage.getText();

    if (tennhom.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    } else {
        NhomDAO nhomDAO = new NhomDAO();
        
        // Kiểm tra tên nhóm trùng
        if (nhomDAO.kiemTraTenNhomTrung(tennhom)) {
            JOptionPane.showMessageDialog(this, "Tên nhóm đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<NhomDTO> danhSachNhom = nhomDAO.layDanhSachNhomTheoEmail(DangNhap.pEmail);

        if (!danhSachNhom.isEmpty()) {
            String maNhom = danhSachNhom.get(0).getMaNhom(); // Lấy mã nhóm từ danh sách nhóm
            mn = maNhom;
            boolean suaThanhCong = nhomDAO.suaNhom(maNhom, tennhom);

            if (suaThanhCong) {
                JOptionPane.showMessageDialog(this, "Cập nhật tên nhóm thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);

                // Cập nhật lại danh sách nhóm hiển thị trên JTable
                danhSachNhom = nhomDAO.layDanhSachNhomTheoEmail(DangNhap.pEmail);
                DefaultTableModel model = (DefaultTableModel) table_ThongTinNhom_NCT.getModel();
                model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

                for (NhomDTO nhom : danhSachNhom) {
                    model.addRow(new Object[]{nhom.getTenNhom()});
                }
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật tên nhóm thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhóm nào để cập nhật!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btn_sua_NCTActionPerformed

    private void btn_hoantac_NCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hoantac_NCTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hoantac_NCTActionPerformed

    private void btn_roinhom_NCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_roinhom_NCTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_roinhom_NCTActionPerformed

    private void btn_themcongviec_NCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_themcongviec_NCTMouseClicked
       

    }//GEN-LAST:event_btn_themcongviec_NCTMouseClicked

    private void tf_tennhom_homepageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_tennhom_homepageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_tennhom_homepageActionPerformed

    private void btn_themthanhvien_NCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themthanhvien_NCTActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) table_themtv.getModel();
    String email = tf_thanhvien_homepage.getText();
    NhomDAO nhomDAO = new NhomDAO();
    String manhom = nhomDAO.laymanhom(tf_tennhom_homepage.getText());
    model.setRowCount(0);

    if (email.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Chưa nhập tên thành viên nhóm");
    } else {
        NguoiDungDAO kiemtra = new NguoiDungDAO();
        NguoiDung_NhomDAO tv = new NguoiDung_NhomDAO();
        if (!kiemtra.kiemTraNguoiDung(email)) {
            JOptionPane.showMessageDialog(this, "Người dùng không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        NguoiDung_NhomDTO themtv = tv.themthanhvien(email, manhom);

        if (themtv != null) {
            // Kiểm tra xem thành viên đã tồn tại trong bảng chưa
            boolean isExist = false;
            for (int i = 0; i < model.getRowCount(); i++) {
                Object value = model.getValueAt(i, 0); // Lấy giá trị của cột đầu tiên
                if (value != null && value.toString().equals(email)) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                model.insertRow(0, new Object[]{email});
                JOptionPane.showMessageDialog(this, "Thêm thành viên thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Thành viên đã tồn tại trong nhóm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thành viên thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btn_themthanhvien_NCTActionPerformed

    private void tf_thanhvien_homepageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_thanhvien_homepageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_thanhvien_homepageActionPerformed

    private void btn_themcongviec_NCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themcongviec_NCTActionPerformed
        String email = tf_thanhvien_homepage.getText();
        NhomDAO layma = new NhomDAO();
        laymanhom = layma.laymanhom(tf_tennhom_homepage.getText());
        TaoCongViec tcv = new TaoCongViec();
        tcv.show();
        dispose();
    }//GEN-LAST:event_btn_themcongviec_NCTActionPerformed


    
    
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TicTac;
    private javax.swing.JButton btn_DX_TicTac;
    private javax.swing.JButton btn_DoiPass_TK;
    private javax.swing.JButton btn_NCT_TicTac;
    private javax.swing.JButton btn_TK_TicTac;
    private javax.swing.JButton btn_TaoNhom_NCT;
    private javax.swing.JButton btn_TimKiem_VCT;
    private javax.swing.JButton btn_TimNhom_NCt;
    private javax.swing.JButton btn_VCT_TicTac;
    private javax.swing.JButton btn_XoaTK_TK;
    private javax.swing.JButton btn_Xoathanhvien_NCT;
    private javax.swing.JButton btn_hoantac_NCT;
    private javax.swing.JButton btn_roinhom_NCT;
    private javax.swing.JButton btn_sua_NCT;
    private javax.swing.JButton btn_themcongviec_NCT;
    private javax.swing.JButton btn_themthanhvien_NCT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel label_MaNgDung_TK;
    private javax.swing.JLabel label_TenNgDung_TK;
    private javax.swing.JLabel label_tennhom;
    private javax.swing.JLabel label_thanhvien_homepage;
    private javax.swing.JPanel panel_CanLam_BangCV_VCT;
    private javax.swing.JPanel panel_DaHoanThanh_BangCV_VCT;
    private javax.swing.JPanel panel_DangLam_BangCV_VCT;
    private javax.swing.JPanel panel_NCT;
    private javax.swing.JPanel panel_TK;
    private javax.swing.JPanel panel_VCT;
    private javax.swing.JScrollPane scrpane_CanLam_BangCV_VCT;
    private javax.swing.JScrollPane scrpane_DaHoanThanh_BangCV_VCT;
    private javax.swing.JScrollPane scrpane_DangLam_BangCV_VCT;
    private javax.swing.JScrollPane scrpane_DanhSachNhom_NCT;
    private javax.swing.JScrollPane scrpane_ThanhVien_TaoNhom;
    private javax.swing.JTabbedPane tabbedpane_BangCV_VCT;
    private javax.swing.JTable table_CanLam_BangCV_VCT;
    private javax.swing.JTable table_DaHoanThanh_BangCV_VCT;
    private javax.swing.JTable table_DangLam_BangCV_VCT;
    private javax.swing.JTable table_ThongTinNhom_NCT;
    private javax.swing.JTable table_themtv;
    private javax.swing.JTextField tf_MaNgDung_TK;
    private javax.swing.JTextField tf_TenNgDung_TK;
    private javax.swing.JTextField tf_TimNhom_NCT;
    private javax.swing.JTextField tf_tennhom_homepage;
    private javax.swing.JTextField tf_thanhvien_homepage;
    private javax.swing.JTextField tf_timcongviec_VCT;
    // End of variables declaration//GEN-END:variables
}
