/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import GUI.ChiTietNhom;
import DAO.NhomDAO;
import DAO.ThucHienDAO;
import DTO.PhanCongDTO;
import DTO.ThucHienDTO;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author VICTUS
 */
public class ThongKe extends javax.swing.JFrame {

    /**
     * Creates new form ThongKe
     */
    public ThongKe() {
        initComponents();
        thongTinPhanCongCanLam();
        thongTinPhanCongDangLam();
        thongTinPhanCongDaLam();
        demSLCVCanLam();
        demSLCVDangLam();
        demSLCVDaLam();
    }
  private void thongTinPhanCongCanLam() {

    ThucHienDAO thuchien = new ThucHienDAO();
    NhomDAO nhom = new NhomDAO();
    String manhom = nhom.laymanhom(ChiTietNhom.laytennhomCTN);
    List<PhanCongDTO> danhSachPhanCongCanLam = thuchien.layDanhSachTrangThaiCVTrongNhom(manhom, "Cần làm");

    DefaultTableModel model = (DefaultTableModel) Table_CanLam.getModel();
    model.setRowCount(0); // Clear all existing rows in the table

    for(PhanCongDTO phanCong : danhSachPhanCongCanLam) {
        model.addRow(new Object[]{phanCong.getEmailThanhVien(), phanCong.getTenCV()});
    }
}
  private void thongTinPhanCongDangLam() {

    ThucHienDAO thuchien = new ThucHienDAO();
    NhomDAO nhom = new NhomDAO();
    String manhom = nhom.laymanhom(ChiTietNhom.laytennhomCTN);
    List<PhanCongDTO> danhSachPhanCongDangLam = thuchien.layDanhSachTrangThaiCVTrongNhom(manhom, "Đang làm");

    DefaultTableModel model = (DefaultTableModel) Table_DangLam.getModel();
    model.setRowCount(0); // Clear all existing rows in the table

    for(PhanCongDTO phanCong : danhSachPhanCongDangLam) {
        model.addRow(new Object[]{phanCong.getEmailThanhVien(), phanCong.getTenCV()});
    }
   }
    
   private void thongTinPhanCongDaLam() {
    ThucHienDAO thuchien = new ThucHienDAO();
    NhomDAO nhom = new NhomDAO();
    String manhom = nhom.laymanhom(ChiTietNhom.laytennhomCTN);
    List<PhanCongDTO> danhSachPhanCongDaLam = thuchien.layDanhSachTrangThaiCVTrongNhom(manhom, "Đã hoàn thành");

    DefaultTableModel model = (DefaultTableModel) Table_Dalam.getModel();
    model.setRowCount(0); // Clear all existing rows in the table

    for(PhanCongDTO phanCong : danhSachPhanCongDaLam) {
        model.addRow(new Object[]{phanCong.getEmailThanhVien(), phanCong.getTenCV()});
    }
    }
    
   private void demSLCVCanLam(){
    ThucHienDAO thuchien = new ThucHienDAO();
    NhomDAO nhom = new NhomDAO();
    String manhom = nhom.laymanhom(ChiTietNhom.laytennhomCTN);
    int SLCV = thuchien.demSLTrangThaiCongViecTrongNhom(manhom, "Cần làm");
    String TongSLCV = String.valueOf(SLCV);
    LB_TongSLCVCanLam.setText(TongSLCV);
    }
    
   private void demSLCVDangLam(){
    ThucHienDAO thuchien = new ThucHienDAO();
    NhomDAO nhom = new NhomDAO();
    String manhom = nhom.laymanhom(ChiTietNhom.laytennhomCTN);
    int SLCV = thuchien.demSLTrangThaiCongViecTrongNhom(manhom, "Đang làm");
    String TongSLCV = String.valueOf(SLCV);
    LB_TongSLCV_DangLam.setText(TongSLCV);
    }
    
  private void demSLCVDaLam(){
    ThucHienDAO thuchien = new ThucHienDAO();
    NhomDAO nhom = new NhomDAO();
    String manhom = nhom.laymanhom(ChiTietNhom.laytennhomCTN);
    int SLCV = thuchien.demSLTrangThaiCongViecTrongNhom(manhom, "Đã hoàn thành");
    String TongSLCV = String.valueOf(SLCV);
    LB_TongSLCVDaLam.setText(TongSLCV);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        LB_SLCV_CanLam = new javax.swing.JLabel();
        LB_SLCV_DangLam = new javax.swing.JLabel();
        LB_SLCV_DaLam = new javax.swing.JLabel();
        LB_TongSLCVCanLam = new javax.swing.JLabel();
        LB_TongSLCV_DangLam = new javax.swing.JLabel();
        LB_TongSLCVDaLam = new javax.swing.JLabel();
        btn_backCTNhom = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Canlam = new javax.swing.JPanel();
        ScrollPane_CanLam = new javax.swing.JScrollPane();
        Table_CanLam = new javax.swing.JTable();
        Danglam = new javax.swing.JPanel();
        ScrollPane_DangLam = new javax.swing.JScrollPane();
        Table_DangLam = new javax.swing.JTable();
        Dalam = new javax.swing.JPanel();
        ScrollPane_DaLam = new javax.swing.JScrollPane();
        Table_Dalam = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Thống kê");

        LB_SLCV_CanLam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LB_SLCV_CanLam.setForeground(new java.awt.Color(255, 255, 255));
        LB_SLCV_CanLam.setText("SLCV Cần làm ");

        LB_SLCV_DangLam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LB_SLCV_DangLam.setForeground(new java.awt.Color(255, 255, 255));
        LB_SLCV_DangLam.setText("SLCV Đang làm");

        LB_SLCV_DaLam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LB_SLCV_DaLam.setForeground(new java.awt.Color(255, 255, 255));
        LB_SLCV_DaLam.setText("SLCV Đã làm");

        LB_TongSLCVCanLam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LB_TongSLCVCanLam.setForeground(new java.awt.Color(255, 255, 255));
        LB_TongSLCVCanLam.setText("__");

        LB_TongSLCV_DangLam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LB_TongSLCV_DangLam.setForeground(new java.awt.Color(255, 255, 255));
        LB_TongSLCV_DangLam.setText("__");

        LB_TongSLCVDaLam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LB_TongSLCVDaLam.setForeground(new java.awt.Color(255, 255, 255));
        LB_TongSLCVDaLam.setText("__");

        btn_backCTNhom.setText("Quay lại");
        btn_backCTNhom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backCTNhomMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LB_SLCV_DangLam)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LB_SLCV_CanLam)
                                .addComponent(jLabel3)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(LB_SLCV_DaLam)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(LB_TongSLCVDaLam, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(LB_TongSLCV_DangLam))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(LB_TongSLCVCanLam))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btn_backCTNhom)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(LB_SLCV_CanLam)
                .addGap(18, 18, 18)
                .addComponent(LB_TongSLCVCanLam)
                .addGap(17, 17, 17)
                .addComponent(LB_SLCV_DangLam)
                .addGap(21, 21, 21)
                .addComponent(LB_TongSLCV_DangLam)
                .addGap(18, 18, 18)
                .addComponent(LB_SLCV_DaLam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LB_TongSLCVDaLam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_backCTNhom)
                .addGap(22, 22, 22))
        );

        jPanel2.setBackground(new java.awt.Color(253, 253, 223));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        Table_CanLam.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null}
            },
            new String [] {
                "Email", "Tên công việc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollPane_CanLam.setViewportView(Table_CanLam);

        javax.swing.GroupLayout CanlamLayout = new javax.swing.GroupLayout(Canlam);
        Canlam.setLayout(CanlamLayout);
        CanlamLayout.setHorizontalGroup(
            CanlamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane_CanLam, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );
        CanlamLayout.setVerticalGroup(
            CanlamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane_CanLam, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cần làm", Canlam);

        Table_DangLam.setBackground(new java.awt.Color(182, 231, 245));
        Table_DangLam.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null}
            },
            new String [] {
                "Email", "Tên công việc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollPane_DangLam.setViewportView(Table_DangLam);

        javax.swing.GroupLayout DanglamLayout = new javax.swing.GroupLayout(Danglam);
        Danglam.setLayout(DanglamLayout);
        DanglamLayout.setHorizontalGroup(
            DanglamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane_DangLam, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );
        DanglamLayout.setVerticalGroup(
            DanglamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane_DangLam, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Đang làm", Danglam);

        Table_Dalam.setBackground(new java.awt.Color(182, 231, 245));
        Table_Dalam.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null}
            },
            new String [] {
                "Email", "Tên công việc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollPane_DaLam.setViewportView(Table_Dalam);

        javax.swing.GroupLayout DalamLayout = new javax.swing.GroupLayout(Dalam);
        Dalam.setLayout(DalamLayout);
        DalamLayout.setHorizontalGroup(
            DalamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane_DaLam, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );
        DalamLayout.setVerticalGroup(
            DalamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane_DaLam, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Đã làm", Dalam);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backCTNhomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backCTNhomMouseClicked
        // TODO add your handling code here:
        ChiTietNhom ctn = new ChiTietNhom();
        ctn.show();
        dispose();
    }//GEN-LAST:event_btn_backCTNhomMouseClicked

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
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Canlam;
    private javax.swing.JPanel Dalam;
    private javax.swing.JPanel Danglam;
    private javax.swing.JLabel LB_SLCV_CanLam;
    private javax.swing.JLabel LB_SLCV_DaLam;
    private javax.swing.JLabel LB_SLCV_DangLam;
    private javax.swing.JLabel LB_TongSLCVCanLam;
    private javax.swing.JLabel LB_TongSLCVDaLam;
    private javax.swing.JLabel LB_TongSLCV_DangLam;
    private javax.swing.JScrollPane ScrollPane_CanLam;
    private javax.swing.JScrollPane ScrollPane_DaLam;
    private javax.swing.JScrollPane ScrollPane_DangLam;
    private javax.swing.JTable Table_CanLam;
    private javax.swing.JTable Table_Dalam;
    private javax.swing.JTable Table_DangLam;
    private javax.swing.JButton btn_backCTNhom;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
