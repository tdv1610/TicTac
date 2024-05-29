/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.NguoiDungDAO;
import DTO.NguoiDungDTO;
import GUI.TaoMKMoi;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.swing.JOptionPane;
import utils.mailsender;

/**
 *
 * @author ASUS
 */
public class NhapEmail extends javax.swing.JFrame {
private String OTP;
     public static String pEmail;
    public static String pTen;
    public static String pmatkhau;
    
    /**
     * Creates new form NhapEmail
     */
    public NhapEmail() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_OTP = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label_Email_OTP = new javax.swing.JLabel();
        tf_Email_OTP = new javax.swing.JTextField();
        btn_NhanEmail_OTP = new javax.swing.JButton();
        label_OTP_OTP = new javax.swing.JLabel();
        tf_OTP_OTP = new javax.swing.JTextField();
        btn_Xong_OTP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_OTP.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to TicTac");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/teamwork (2).png"))); // NOI18N

        label_Email_OTP.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        label_Email_OTP.setForeground(new java.awt.Color(255, 255, 255));
        label_Email_OTP.setText("Email");

        tf_Email_OTP.setBackground(new java.awt.Color(253, 253, 223));
        tf_Email_OTP.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        tf_Email_OTP.setText("Nhập email để nhận OTP");
        tf_Email_OTP.setToolTipText("");
        tf_Email_OTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_Email_OTPMouseClicked(evt);
            }
        });

        btn_NhanEmail_OTP.setText("Nhận");
        btn_NhanEmail_OTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NhanEmail_OTPActionPerformed(evt);
            }
        });

        label_OTP_OTP.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        label_OTP_OTP.setForeground(new java.awt.Color(255, 255, 255));
        label_OTP_OTP.setText("OTP");

        tf_OTP_OTP.setBackground(new java.awt.Color(253, 253, 223));
        tf_OTP_OTP.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N

        btn_Xong_OTP.setText("Xong");
        btn_Xong_OTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Xong_OTPMouseClicked(evt);
            }
        });
        btn_Xong_OTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Xong_OTPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_OTPLayout = new javax.swing.GroupLayout(panel_OTP);
        panel_OTP.setLayout(panel_OTPLayout);
        panel_OTPLayout.setHorizontalGroup(
            panel_OTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_OTPLayout.createSequentialGroup()
                .addGroup(panel_OTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_OTPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                    .addGroup(panel_OTPLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(panel_OTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_OTP_OTP, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_Email_OTP))
                        .addGap(18, 18, 18)
                        .addGroup(panel_OTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_Email_OTP, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_OTP_OTP, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_OTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_NhanEmail_OTP)
                            .addComponent(btn_Xong_OTP))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_OTPLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(179, 179, 179))
        );
        panel_OTPLayout.setVerticalGroup(
            panel_OTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_OTPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(panel_OTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Email_OTP)
                    .addComponent(tf_Email_OTP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_NhanEmail_OTP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_OTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_OTP_OTP)
                    .addComponent(tf_OTP_OTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Xong_OTP))
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_OTP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_OTP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_NhanEmail_OTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NhanEmail_OTPActionPerformed
                pEmail = tf_Email_OTP.getText();
                String EMAIL = tf_Email_OTP.getText();
                NguoiDungDAO userDAO = new NguoiDungDAO();
                NguoiDungDTO user = userDAO.getUserByEmail(EMAIL);
    
                if(user!=null){
                     // Generate 4-digit OTP
                    mailsender.sendEmail(EMAIL,  "OTP của bạn là" + "", OTP);
                    JOptionPane.showMessageDialog(null, "OTP đã được gửi tới email của bạn.");
                }
                    else
                {
                     JOptionPane.showMessageDialog(null, "Email này không tồn tại.");
                }
                   
               
            
    }//GEN-LAST:event_btn_NhanEmail_OTPActionPerformed

    private void btn_Xong_OTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Xong_OTPMouseClicked
        TaoMKMoi tmkm = new TaoMKMoi();
        tmkm.show();
        dispose();
    }//GEN-LAST:event_btn_Xong_OTPMouseClicked

    private void btn_Xong_OTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Xong_OTPActionPerformed
         String enteredOtp = tf_OTP_OTP.getText();
         
        String otp= mailsender.getOTP();
            if (!enteredOtp.equals(otp)) 
                    JOptionPane.showMessageDialog(null, "OTP không đúng.");
            else
            {
                JOptionPane.showMessageDialog(null, "Xac nhan OTP thanh cong.");
                new TaoMKMoi().setVisible(true);
                this.dispose();
             
            }    
    }//GEN-LAST:event_btn_Xong_OTPActionPerformed

    private void tf_Email_OTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_Email_OTPMouseClicked
        if (tf_Email_OTP.getText().equals("Nhập email để nhận OTP")) {
                    tf_Email_OTP.setText("");
                }
    }//GEN-LAST:event_tf_Email_OTPMouseClicked
    
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
            java.util.logging.Logger.getLogger(NhapEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhapEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhapEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhapEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhapEmail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_NhanEmail_OTP;
    private javax.swing.JButton btn_Xong_OTP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_Email_OTP;
    private javax.swing.JLabel label_OTP_OTP;
    private javax.swing.JPanel panel_OTP;
    private javax.swing.JTextField tf_Email_OTP;
    private javax.swing.JTextField tf_OTP_OTP;
    // End of variables declaration//GEN-END:variables
}
