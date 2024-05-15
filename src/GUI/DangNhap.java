/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author ASUS
 */
public class DangNhap extends javax.swing.JFrame {

    /**
     * Creates new form DN_DK
     */
    public DangNhap() {
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

        panel_DangNhap = new javax.swing.JPanel();
        label_Wealcome_DangNhap = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label_TenNgDung_DangNhap = new javax.swing.JLabel();
        label_MatKhau_DangNhap = new javax.swing.JLabel();
        tf_TenNgDung_DangNhap = new javax.swing.JTextField();
        pwf_MatKhau_DangNhap = new javax.swing.JPasswordField();
        btn_DangNhap_DangNhap = new javax.swing.JButton();
        btn_QuenMatKhau_DangNhap = new javax.swing.JButton();
        label_ChuaCoTaiKhoan_DangNhap = new javax.swing.JLabel();
        btn_DangKi_DangNhap = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_DangNhap.setBackground(new java.awt.Color(0, 102, 102));

        label_Wealcome_DangNhap.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        label_Wealcome_DangNhap.setForeground(new java.awt.Color(255, 255, 255));
        label_Wealcome_DangNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Wealcome_DangNhap.setText("Welcome to TicTac");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/teamwork (2).png"))); // NOI18N

        label_TenNgDung_DangNhap.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        label_TenNgDung_DangNhap.setForeground(new java.awt.Color(255, 255, 255));
        label_TenNgDung_DangNhap.setText("Tên người dùng");

        label_MatKhau_DangNhap.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        label_MatKhau_DangNhap.setForeground(new java.awt.Color(255, 255, 255));
        label_MatKhau_DangNhap.setText("Mật khẩu");

        tf_TenNgDung_DangNhap.setBackground(new java.awt.Color(0, 102, 102));

        pwf_MatKhau_DangNhap.setBackground(new java.awt.Color(0, 102, 102));

        btn_DangNhap_DangNhap.setBackground(new java.awt.Color(0, 102, 102));
        btn_DangNhap_DangNhap.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        btn_DangNhap_DangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btn_DangNhap_DangNhap.setText("Quên mật khẩu");
        btn_DangNhap_DangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DangNhap_DangNhapMouseClicked(evt);
            }
        });

        btn_QuenMatKhau_DangNhap.setBackground(new java.awt.Color(0, 102, 102));
        btn_QuenMatKhau_DangNhap.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        btn_QuenMatKhau_DangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btn_QuenMatKhau_DangNhap.setText("Đăng nhập");
        btn_QuenMatKhau_DangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_QuenMatKhau_DangNhapMouseClicked(evt);
            }
        });
        btn_QuenMatKhau_DangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QuenMatKhau_DangNhapActionPerformed(evt);
            }
        });

        label_ChuaCoTaiKhoan_DangNhap.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        label_ChuaCoTaiKhoan_DangNhap.setForeground(new java.awt.Color(255, 255, 255));
        label_ChuaCoTaiKhoan_DangNhap.setText("Chưa có tài khoản?");

        btn_DangKi_DangNhap.setBackground(new java.awt.Color(0, 204, 204));
        btn_DangKi_DangNhap.setForeground(new java.awt.Color(0, 204, 204));
        btn_DangKi_DangNhap.setText("Đăng kí");
        btn_DangKi_DangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DangKi_DangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DangKi_DangNhapMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_DangNhapLayout = new javax.swing.GroupLayout(panel_DangNhap);
        panel_DangNhap.setLayout(panel_DangNhapLayout);
        panel_DangNhapLayout.setHorizontalGroup(
            panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_Wealcome_DangNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_DangNhapLayout.createSequentialGroup()
                .addGroup(panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_DangNhapLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_TenNgDung_DangNhap)
                            .addComponent(label_MatKhau_DangNhap))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_TenNgDung_DangNhap)
                            .addComponent(pwf_MatKhau_DangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)))
                    .addGroup(panel_DangNhapLayout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_DangNhapLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(label_ChuaCoTaiKhoan_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_DangKi_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_DangNhap_DangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_QuenMatKhau_DangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(132, 132, 132))
        );
        panel_DangNhapLayout.setVerticalGroup(
            panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_DangNhapLayout.createSequentialGroup()
                .addComponent(label_Wealcome_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_TenNgDung_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_TenNgDung_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_MatKhau_DangNhap)
                    .addComponent(pwf_MatKhau_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_QuenMatKhau_DangNhap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_DangNhapLayout.createSequentialGroup()
                        .addComponent(btn_DangNhap_DangNhap)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_DangNhapLayout.createSequentialGroup()
                        .addGroup(panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_ChuaCoTaiKhoan_DangNhap)
                            .addComponent(btn_DangKi_DangNhap))
                        .addGap(15, 15, 15))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_DangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_DangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_DangKi_DangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DangKi_DangNhapMouseClicked
        DangKi dk = new DangKi();
        dk.show();
        dispose();
    }//GEN-LAST:event_btn_DangKi_DangNhapMouseClicked

    private void btn_QuenMatKhau_DangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_QuenMatKhau_DangNhapMouseClicked
        Homepage hp = new Homepage();
        hp.show();
        dispose();
    }//GEN-LAST:event_btn_QuenMatKhau_DangNhapMouseClicked

    private void btn_DangNhap_DangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DangNhap_DangNhapMouseClicked
        NhapEmail ne = new NhapEmail();
        ne.show();
        dispose();
    }//GEN-LAST:event_btn_DangNhap_DangNhapMouseClicked

    private void btn_QuenMatKhau_DangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QuenMatKhau_DangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_QuenMatKhau_DangNhapActionPerformed

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
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_DangKi_DangNhap;
    private javax.swing.JButton btn_DangNhap_DangNhap;
    private javax.swing.JButton btn_QuenMatKhau_DangNhap;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_ChuaCoTaiKhoan_DangNhap;
    private javax.swing.JLabel label_MatKhau_DangNhap;
    private javax.swing.JLabel label_TenNgDung_DangNhap;
    private javax.swing.JLabel label_Wealcome_DangNhap;
    private javax.swing.JPanel panel_DangNhap;
    private javax.swing.JPasswordField pwf_MatKhau_DangNhap;
    private javax.swing.JTextField tf_TenNgDung_DangNhap;
    // End of variables declaration//GEN-END:variables
}
