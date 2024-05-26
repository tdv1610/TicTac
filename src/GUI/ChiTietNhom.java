/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.NhomDAO;
import DAO.ThucHienDAO;
import DTO.PhanCongDTO;
import DTO.ThucHienDTO;
import GUI.Homepage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ChiTietNhom extends javax.swing.JFrame {
    public static String ten_nhom;
    public static String nguoiphutrach;
    public static String tencv;
    public static String trangthai;

    
    /**
     * Creates new form ChiTietNhom
     */
    public static String laytennhomCTN;
    public ChiTietNhom() {
        initComponents();
        thongTinPhanCong();
        xemtennhom();
        addTableClickListener();
    }
    
    private void thongTinPhanCong() {
    jlable_tennhom.setText(Homepage.tennhom);
    laytennhomCTN= jlable_tennhom.getText();
    ThucHienDAO thuchien = new ThucHienDAO();
    NhomDAO nhom = new NhomDAO();
    String manhom = nhom.laymanhom(Homepage.tennhom);
    List<PhanCongDTO> danhSachPhanCong = thuchien.layDanhSachPhanCongTrongNhom(manhom);

        DefaultTableModel model = (DefaultTableModel) table_DanhSachPhanCong.getModel();

        for(PhanCongDTO phanCong : danhSachPhanCong) {
            model.insertRow(0, new Object[]{phanCong.getTenCV(), phanCong.getEmailThanhVien(), phanCong.getTrangThai()});
        }
    }
    private void xemtennhom(){
        Homepage homepage = new Homepage();
        jlable_tennhom.setText(homepage.tennhom);
    }
    
    private void addTableClickListener() {
        table_DanhSachPhanCong.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Kiểm tra xem có phải double-click không
                    int row = table_DanhSachPhanCong.getSelectedRow();
                    if (row >= 0) {
                        ten_nhom = jlable_tennhom.getText();
                        tencv = (String) table_DanhSachPhanCong.getValueAt(row, 0);
                        nguoiphutrach = (String) table_DanhSachPhanCong.getValueAt(row, 1);
                        trangthai = (String) table_DanhSachPhanCong.getValueAt(row, 2);
                        XemTienDoCongViec chitiet = new XemTienDoCongViec();
                        chitiet.show();
                        dispose();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        scrpane_ThanhVien_TaoNhom = new javax.swing.JScrollPane();
        table_DanhSachPhanCong = new javax.swing.JTable();
        btn_ThongKe = new javax.swing.JButton();
        jlable_tennhom = new javax.swing.JLabel();
        btn_BackNCTHomePage = new javax.swing.JButton();
        btn_tinnhan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(109, 129, 245));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Tên nhóm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Danh sách phân công");

        table_DanhSachPhanCong.setBackground(new java.awt.Color(182, 231, 245));
        table_DanhSachPhanCong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên công việc", "Tên người phụ trách", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrpane_ThanhVien_TaoNhom.setViewportView(table_DanhSachPhanCong);

        btn_ThongKe.setBackground(new java.awt.Color(49, 141, 245));
        btn_ThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_ThongKe.setText("Thống kê");
        btn_ThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThongKeMouseClicked(evt);
            }
        });
        btn_ThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThongKeActionPerformed(evt);
            }
        });

        jlable_tennhom.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlable_tennhom.setText("jlabel");
        jlable_tennhom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn_BackNCTHomePage.setBackground(new java.awt.Color(49, 141, 245));
        btn_BackNCTHomePage.setText("Quay lại");
        btn_BackNCTHomePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_BackNCTHomePageMouseClicked(evt);
            }
        });

        btn_tinnhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/chat.png"))); // NOI18N
        btn_tinnhan.setContentAreaFilled(false);
        btn_tinnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tinnhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(50, 50, 50)
                                .addComponent(jlable_tennhom, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_tinnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_BackNCTHomePage))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_ThongKe)
                            .addComponent(scrpane_ThanhVien_TaoNhom, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jlable_tennhom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btn_BackNCTHomePage))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_tinnhan)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(btn_ThongKe))
                .addGap(18, 18, 18)
                .addComponent(scrpane_ThanhVien_TaoNhom, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThongKeActionPerformed
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_btn_ThongKeActionPerformed

    private void btn_ThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThongKeMouseClicked
        // TODO add your handling code here:
        ThongKe tk= new ThongKe();
        tk.show();
        dispose();
    }//GEN-LAST:event_btn_ThongKeMouseClicked

    private void btn_BackNCTHomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BackNCTHomePageMouseClicked
        // TODO add your handling code here:
        Homepage hp= new Homepage();
        hp.show();
        dispose();
    }//GEN-LAST:event_btn_BackNCTHomePageMouseClicked

    private void btn_tinnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tinnhanActionPerformed
        // TODO add your handling code here:
        ChatWindow dn = new ChatWindow();
        dn.show();
        dispose();
    }//GEN-LAST:event_btn_tinnhanActionPerformed

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
            java.util.logging.Logger.getLogger(ChiTietNhom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietNhom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietNhom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietNhom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietNhom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_BackNCTHomePage;
    private javax.swing.JButton btn_ThongKe;
    private javax.swing.JButton btn_tinnhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlable_tennhom;
    private javax.swing.JScrollPane scrpane_ThanhVien_TaoNhom;
    private javax.swing.JTable table_DanhSachPhanCong;
    // End of variables declaration//GEN-END:variables
}
