/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.ADMINDAO;
import DAO.NguoiDungDAO;
import DAO.NguoiDung_NhomDAO;
import DAO.NhomDAO;
import DAO.ThongBaoTinNhanDAO;
import DAO.TinNhanDAO;
import DTO.ADMINDTO;
import DTO.NguoiDungDTO;
import DTO.NguoiDung_NhomDTO;
import DTO.ThongBaoTinNhanDTO;
import DTO.TinNhanDTO;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;


/**
 *
 * @author Oracle
 */
public class ChatWindow extends javax.swing.JFrame {
    
    public static String email;
    public static String emailNguoinhan;
    
    /**
     * Creates new form ChatWindow
     */
    public ChatWindow() {
        initComponents();
        thongtin();
        addTableClickListener();
        HienThi();

        // Tạo một luồng mới để cập nhật thông báo
            Thread updateThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            // Cập nhật thông báo mỗi 5 giây
                            Thread.sleep(5000);
                            HienThiThongBao();
                            HienThi();
                        } catch (InterruptedException ex) {
                            // Xử lý ngoại lệ nếu có
                            ex.printStackTrace();
                        }
                    }
                }
            });
            // Bắt đầu luồng cập nhật
            updateThread.start();
        
        setLocationRelativeTo(null);
    }
    
    private void thongtin() {
        NguoiDung_NhomDAO nguoidung = new NguoiDung_NhomDAO();
        NhomDAO nhom = new NhomDAO();
        NguoiDungDAO nd = new NguoiDungDAO();
        String nd1 = nd.getTenNguoiDungByEmail(DangNhap.pEmail);
        DefaultTableModel model = (DefaultTableModel) table_danhsach.getModel();

        if(nd1 != null){
            String manhom = nhom.laymanhom(Homepage.tennhom);
            List<NguoiDung_NhomDTO> danhsachnd = nguoidung.layDanhSachTVTheoMaNhom(manhom);
            for(NguoiDung_NhomDTO nd_nhom : danhsachnd){
                model.insertRow(0, new Object[]{nd.getTenNguoiDungByEmail(nd_nhom.getEmailND()), nd_nhom.getEmailND()});
            }
        }
        else{
            ADMINDAO admin = new ADMINDAO();
            List<ADMINDTO> danhsachAd = admin.layDanhSachAd();
            for (ADMINDTO dsAdmin : danhsachAd) {
                model.insertRow(0, new Object[]{dsAdmin.getTenAd(), dsAdmin.getEmailAd()});
            }
        }
    }
    
    private void addTableClickListener() {
        table_danhsach.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table_danhsach.getSelectedRow();
                if (row >= 0) {
                    String ten = (String) table_danhsach.getValueAt(row, 0);
                    email = (String) table_danhsach.getValueAt(row, 1);
                    jlable_tenad.setText(ten); 
                    compareAndDeleteNotifications(email);
                    HienThi();
                }
            }
        });
    }
    
    private void HienThi(){
        HienThiTinNhan(DangNhap.pEmail, email); 
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
        jPanel2 = new javax.swing.JPanel();
        tf_timkiem = new javax.swing.JTextField();
        btn_timkhiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_thongbao = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_danhsach = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_guitinnhan = new javax.swing.JButton();
        jlable_tenad = new javax.swing.JLabel();
        tf_tinnhan = new javax.swing.JTextField();
        scrollPane1 = new java.awt.ScrollPane();
        jpanel_tinnhan = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        tf_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_timkiemActionPerformed(evt);
            }
        });

        btn_timkhiem.setBackground(new java.awt.Color(253, 253, 223));
        btn_timkhiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.png"))); // NOI18N
        btn_timkhiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkhiemActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(204, 255, 255));

        table_thongbao.setBackground(new java.awt.Color(253, 253, 223));
        table_thongbao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Thông báo", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_thongbao.setGridColor(new java.awt.Color(153, 255, 255));
        table_thongbao.setSelectionBackground(new java.awt.Color(204, 255, 255));
        jScrollPane1.setViewportView(table_thongbao);

        jScrollPane2.setViewportView(jScrollPane1);

        table_danhsach.setBackground(new java.awt.Color(253, 253, 223));
        table_danhsach.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null}
            },
            new String [] {
                "Tên", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_danhsach.setShowGrid(false);
        jScrollPane4.setViewportView(table_danhsach);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(tf_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_timkhiem, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_timkiem)
                    .addComponent(btn_timkhiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));
        jPanel3.setOpaque(false);

        btn_guitinnhan.setBackground(new java.awt.Color(253, 253, 223));
        btn_guitinnhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/send.png"))); // NOI18N
        btn_guitinnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guitinnhanActionPerformed(evt);
            }
        });

        jlable_tenad.setBackground(new java.awt.Color(204, 204, 255));
        jlable_tenad.setOpaque(true);

        jpanel_tinnhan.setBackground(new java.awt.Color(253, 253, 223));
        jpanel_tinnhan.setLayout(new java.awt.GridBagLayout());
        scrollPane1.add(jpanel_tinnhan);

        jButton1.setText("Quay lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jlable_tenad, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(jButton1))
                    .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tf_tinnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_guitinnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jlable_tenad, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(21, 21, 21)))
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_guitinnhan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_tinnhan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btn_timkhiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkhiemActionPerformed
        // TODO add your handling code here:
        String nd = tf_timkiem.getText();
        // Kiểm tra nếu email không rỗng
        if (nd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên để tìm kiếm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) table_thongbao.getModel();
        
        ADMINDAO tim = new ADMINDAO();
        ADMINDTO tenAd = tim.TimAD(nd);
        NguoiDungDAO ndung = new NguoiDungDAO();
        NguoiDungDTO nd1 = ndung.LayNDTheoTen(nd);
        
        if(tenAd != null || nd1 != null){
            if(tenAd != null){
                model.setRowCount(0);
                model.insertRow(0, new Object[]{nd, tenAd.getEmailAd()});
            }
            else{
                model.setRowCount(0);
                model.insertRow(0, new Object[]{nd, nd1.getEMAILND()});
            }
        }
        
        else{
            JOptionPane.showMessageDialog(this, "Không tìm thấy!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }     
      
    }//GEN-LAST:event_btn_timkhiemActionPerformed

    private void btn_guitinnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guitinnhanActionPerformed
        // Lấy chỉ mục của hàng đã chọn trong bảng Admin
        int row = table_danhsach.getSelectedRow();
        // Kiểm tra xem đã chọn hàng nào hay chưa
        if (row >= 0) {
            // Lấy email của người gửi tin nhắn
            String senderEmail = DangNhap.pEmail;

            // Lấy email của người nhận tin nhắn từ bảng
            String receiverEmail = (String) table_danhsach.getValueAt(row, 1);

            // Lấy nội dung tin nhắn từ text field
            String tinnhan = tf_tinnhan.getText();

            // Kiểm tra xem nội dung tin nhắn có rỗng hay không
            if (!tinnhan.isEmpty()) {
                // Gửi tin nhắn
                TinNhanDAO tn = new TinNhanDAO();
                ThongBaoTinNhanDAO tbtn = new ThongBaoTinNhanDAO();
                tn.sendMessage(senderEmail, receiverEmail, tinnhan);
                
                tbtn.thongbaonguoigui(senderEmail, receiverEmail, "Có tin nhắn từ " + senderEmail);
                
                // Xóa nội dung tin nhắn từ text field sau khi đã gửi
                tf_tinnhan.setText("");

                HienThiTinNhan(senderEmail, receiverEmail);
            } else {
                // Hiển thị thông báo lỗi nếu nội dung tin nhắn rỗng
                JOptionPane.showMessageDialog(this, "Vui lòng nhập tin nhắn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Hiển thị thông báo lỗi nếu không có hàng nào được chọn trong bảng Admin
            JOptionPane.showMessageDialog(this, "Vui lòng chọn người để gửi tin nhắn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_guitinnhanActionPerformed

    private void tf_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_timkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_timkiemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ChiTietNhom ctn = new ChiTietNhom();
        ctn.show();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private JPanel TaoPanelTinNhan(String messageText, boolean NguoiGui) {
        JLabel messageLabel = new JLabel(messageText);
        messageLabel.setOpaque(true);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(NguoiGui ? FlowLayout.RIGHT : FlowLayout.LEFT));
        panel.add(messageLabel);

        if (NguoiGui) {
            messageLabel.setBackground(Color.BLUE);
            messageLabel.setForeground(Color.WHITE);
        } else {
            messageLabel.setBackground(Color.LIGHT_GRAY);
        }

        return panel;
    }

    private void HienThiTinNhan(String EmailNguoiGui, String EmailNguoiNhan) {
        TinNhanDAO tinnhanDAO = new TinNhanDAO();
        List<TinNhanDTO> tin_nhan = tinnhanDAO.getMessages(EmailNguoiGui, EmailNguoiNhan);
        jpanel_tinnhan.removeAll();

        // Đặt layout manager cho jpanel_tinnhan
        jpanel_tinnhan.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0; // Bắt đầu từ dòng đầu tiên

        
        for (TinNhanDTO tinNhanDTO : tin_nhan) {
            JPanel panel = TaoPanelTinNhan(tinNhanDTO.getText(), tinNhanDTO.getSender().equals(EmailNguoiGui));
            jpanel_tinnhan.add(panel, gbc);
            gbc.gridy++;
        }

        // Cập nhật giao diện người dùng
        jpanel_tinnhan.revalidate();
        jpanel_tinnhan.repaint();
    }
    

    private void HienThiThongBao() {
        ThongBaoTinNhanDAO ThongBaoDAO = new ThongBaoTinNhanDAO();
        List<ThongBaoTinNhanDTO> dsthongbao = ThongBaoDAO.layThongBao(DangNhap.pEmail);
        DefaultTableModel model = (DefaultTableModel) table_thongbao.getModel();
        model.setRowCount(0); // Xóa các dòng hiện tại
        for (ThongBaoTinNhanDTO tb : dsthongbao) {
            model.addRow(new Object[]{tb.getMessage(), tb.getSenderEmail()});
        }
    }

    private void compareAndDeleteNotifications(String selectedEmail) {
        ThongBaoTinNhanDAO tbtn = new ThongBaoTinNhanDAO();
        DefaultTableModel model = (DefaultTableModel) table_thongbao.getModel();        
        for (int i = 0; i < table_thongbao.getRowCount(); i++) {
            String thongbaoEmail = (String) table_thongbao.getValueAt(i, 1); 
            if (selectedEmail.equals(thongbaoEmail)) {
                // Xóa thông báo từ cơ sở dữ liệu nếu email trùng khớp
                tbtn.xoaThongBao(thongbaoEmail);
                // Xóa hàng khỏi table_thongbao
                model.removeRow(i);
                i--; 
            }
        }
    }

    
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
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guitinnhan;
    private javax.swing.JButton btn_timkhiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jlable_tenad;
    private javax.swing.JPanel jpanel_tinnhan;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JTable table_danhsach;
    private javax.swing.JTable table_thongbao;
    private javax.swing.JTextField tf_timkiem;
    private javax.swing.JTextField tf_tinnhan;
    // End of variables declaration//GEN-END:variables
}
