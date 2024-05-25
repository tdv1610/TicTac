/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.NguoiDungDAO;
import DTO.NguoiDungDTO;
import GUI.DangNhap;
import com.sun.jdi.connect.spi.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

/**
 *
 * @author ASUS
 */
public class DangKi extends javax.swing.JFrame {
 Connection conn = null;
    PreparedStatement ps = null, ps1 = null, ps2 = null;
    ResultSet rs = null, rs1 = null, rs2 = null;

    /**
     * Creates new form DangKi
     */
    public DangKi() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        panel_DangKi = new javax.swing.JPanel();
        label_Welcome_DangKi = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        label_Email_DangKi = new javax.swing.JLabel();
        label_TenNgDung_DangKi = new javax.swing.JLabel();
        label_MatKhau_DangKi = new javax.swing.JLabel();
        tf_Email_DangKi = new javax.swing.JTextField();
        tf_TenNgDung_Dangki = new javax.swing.JTextField();
        pwf_MatKhau_DangKi = new javax.swing.JPasswordField();
        btn_DangKi_DangKI = new javax.swing.JButton();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/teamwork (2).png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_DangKi.setBackground(new java.awt.Color(53, 94, 219));

        label_Welcome_DangKi.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        label_Welcome_DangKi.setForeground(new java.awt.Color(255, 255, 255));
        label_Welcome_DangKi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Welcome_DangKi.setText("Welcome to TicTac");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/teamwork (2).png"))); // NOI18N

        label_Email_DangKi.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        label_Email_DangKi.setForeground(new java.awt.Color(255, 255, 255));
        label_Email_DangKi.setText("Email");

        label_TenNgDung_DangKi.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        label_TenNgDung_DangKi.setForeground(new java.awt.Color(255, 255, 255));
        label_TenNgDung_DangKi.setText("Tên người dùng");

        label_MatKhau_DangKi.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        label_MatKhau_DangKi.setForeground(new java.awt.Color(255, 255, 255));
        label_MatKhau_DangKi.setText("Mật khẩu");

        tf_Email_DangKi.setBackground(new java.awt.Color(182, 231, 245));

        tf_TenNgDung_Dangki.setBackground(new java.awt.Color(182, 231, 245));

        pwf_MatKhau_DangKi.setBackground(new java.awt.Color(182, 231, 245));

        btn_DangKi_DangKI.setBackground(new java.awt.Color(44, 65, 230));
        btn_DangKi_DangKI.setForeground(new java.awt.Color(255, 255, 255));
        btn_DangKi_DangKI.setText("Đăng kí");
        btn_DangKi_DangKI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DangKi_DangKIMouseClicked(evt);
            }
        });
        btn_DangKi_DangKI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DangKi_DangKIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_DangKiLayout = new javax.swing.GroupLayout(panel_DangKi);
        panel_DangKi.setLayout(panel_DangKiLayout);
        panel_DangKiLayout.setHorizontalGroup(
            panel_DangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_DangKiLayout.createSequentialGroup()
                .addGroup(panel_DangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_DangKiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_Welcome_DangKi, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                    .addGroup(panel_DangKiLayout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panel_DangKiLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(panel_DangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_TenNgDung_DangKi)
                    .addComponent(label_MatKhau_DangKi)
                    .addComponent(label_Email_DangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_DangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_TenNgDung_Dangki, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pwf_MatKhau_DangKi, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_Email_DangKi, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_DangKiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_DangKi_DangKI)
                .addGap(142, 142, 142))
        );
        panel_DangKiLayout.setVerticalGroup(
            panel_DangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_DangKiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_Welcome_DangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_DangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Email_DangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_Email_DangKi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_DangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_TenNgDung_DangKi)
                    .addComponent(tf_TenNgDung_Dangki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panel_DangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_MatKhau_DangKi)
                    .addComponent(pwf_MatKhau_DangKi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_DangKi_DangKI)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_DangKi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_DangKi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_DangKi_DangKIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DangKi_DangKIMouseClicked
        DangNhap dn = new DangNhap();
        dn.show();
        dispose();
    }//GEN-LAST:event_btn_DangKi_DangKIMouseClicked

    private void btn_DangKi_DangKIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DangKi_DangKIActionPerformed
        NguoiDungDAO nd = new NguoiDungDAO();
        NguoiDungDTO nd1=nd.dangki(tf_Email_DangKi.getText(),tf_TenNgDung_Dangki.getText(),pwf_MatKhau_DangKi.getText());
        if(tf_Email_DangKi.getText().equals("")||tf_TenNgDung_Dangki.getText().equals("")||pwf_MatKhau_DangKi.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Không để thông tin trống");
        }
        else{
            if(nd1==null){
                JOptionPane.showMessageDialog(null, "Email đã tồn tại");
            }
            else{
                JOptionPane.showMessageDialog(null,"Bạn đã đăng kí tài khoản thành công");
                new DangNhap().setVisible(true);
                dispose();
                return;
            }
        }
    }//GEN-LAST:event_btn_DangKi_DangKIActionPerformed

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
            java.util.logging.Logger.getLogger(DangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DangKi_DangKI;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel label_Email_DangKi;
    private javax.swing.JLabel label_MatKhau_DangKi;
    private javax.swing.JLabel label_TenNgDung_DangKi;
    private javax.swing.JLabel label_Welcome_DangKi;
    private javax.swing.JPanel panel_DangKi;
    private javax.swing.JPasswordField pwf_MatKhau_DangKi;
    private javax.swing.JTextField tf_Email_DangKi;
    private javax.swing.JTextField tf_TenNgDung_Dangki;
    // End of variables declaration//GEN-END:variables
}
