/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import java.sql.Connection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement; 

/**
 *
 * @author ASUS
 */
public class AdminHomepage extends javax.swing.JFrame {
private Connection connection;
private String originalEmail;
private String originalTenND;
    /**
     * Creates new form AdminHomepage
     */
    public AdminHomepage() {
        initComponents();
        connectToDatabase();
        loadUserData();
        addTableClickListener();
    }

    private void connectToDatabase(){
         // Kết nối đến cơ sở dữ liệu
            try{
               Class.forName("oracle.jdbc.driver.OracleDriver");
               connection= DriverManager.getConnection("jdbc:oracle:thin:@laptop-n4ku63sd:1521:orcl", "c##TICTAC", "123");
            } catch (ClassNotFoundException | SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "ko the ket noi dc");
                
            }        
    }
    
    private void loadUserData(){
         try {
            String sql = "SELECT EMAILND, TENND FROM NGUOIDUNG";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table_dsND.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                String email = resultSet.getString("EMAILND");
                String tenND = resultSet.getString("TENND");
                model.addRow(new Object[]{email, tenND});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi lấy dữ liệu người dùng!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void addTableClickListener() {
        table_dsND.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table_dsND.getSelectedRow();
                if (row >= 0) {
                    String email = (String) table_dsND.getValueAt(row, 0);
                    String tenND = (String) table_dsND.getValueAt(row, 1);
                    TF_emailND.setText(email);
                    TF_tenND.setText(tenND);
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btn_DX_TicTac = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        tf_nhaptenNDcantim = new javax.swing.JTextField();
        btn_searchND = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_dsND = new javax.swing.JTable();
        lb_emailND = new javax.swing.JLabel();
        lb_tenND = new javax.swing.JLabel();
        TF_emailND = new javax.swing.JTextField();
        TF_tenND = new javax.swing.JTextField();
        btn_suaND = new javax.swing.JButton();
        btn_xoaND = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        label_tenAD = new javax.swing.JLabel();
        label_emailAD = new javax.swing.JLabel();
        btn_DoiPass_TK = new javax.swing.JButton();
        lb_gettenAD = new javax.swing.JLabel();
        label_getEmailAD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TicTac");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/teamwork (2).png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Quản lí người dùng");
        jButton1.setBorder(null);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Tài khoản");
        jButton2.setBorder(null);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(39, 39, 39))
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btn_DX_TicTac)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(52, 52, 52)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_DX_TicTac)
                .addGap(124, 124, 124))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        tf_nhaptenNDcantim.setBackground(new java.awt.Color(0, 153, 153));

        btn_searchND.setBackground(new java.awt.Color(0, 153, 153));
        btn_searchND.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.png"))); // NOI18N
        btn_searchND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchNDActionPerformed(evt);
            }
        });

        table_dsND.setBackground(new java.awt.Color(0, 153, 153));
        table_dsND.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_dsND);

        lb_emailND.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lb_emailND.setForeground(new java.awt.Color(255, 255, 255));
        lb_emailND.setText("Email");

        lb_tenND.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lb_tenND.setForeground(new java.awt.Color(255, 255, 255));
        lb_tenND.setText("Tên người dùng");

        TF_emailND.setBackground(new java.awt.Color(0, 153, 153));
        TF_emailND.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        TF_tenND.setBackground(new java.awt.Color(0, 153, 153));
        TF_tenND.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btn_suaND.setBackground(new java.awt.Color(0, 51, 51));
        btn_suaND.setForeground(new java.awt.Color(255, 255, 255));
        btn_suaND.setText("Sửa");
        btn_suaND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaNDActionPerformed(evt);
            }
        });

        btn_xoaND.setBackground(new java.awt.Color(0, 51, 51));
        btn_xoaND.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoaND.setText("Xóa");
        btn_xoaND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaNDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(tf_nhaptenNDcantim, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_searchND, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_emailND, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_tenND))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TF_emailND, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(TF_tenND))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_xoaND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_suaND, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_searchND)
                    .addComponent(tf_nhaptenNDcantim, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_emailND)
                            .addComponent(TF_emailND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_tenND)
                            .addComponent(TF_tenND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_suaND)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xoaND)
                        .addGap(9, 9, 9)))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        label_tenAD.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_tenAD.setForeground(new java.awt.Color(255, 255, 255));
        label_tenAD.setText("Tên admin");

        label_emailAD.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_emailAD.setForeground(new java.awt.Color(255, 255, 255));
        label_emailAD.setText("Email admin");

        btn_DoiPass_TK.setBackground(new java.awt.Color(0, 51, 51));
        btn_DoiPass_TK.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_DoiPass_TK.setForeground(new java.awt.Color(255, 255, 255));
        btn_DoiPass_TK.setText("Đổi mật khẩu");
        btn_DoiPass_TK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DoiPass_TKMouseClicked(evt);
            }
        });

        lb_gettenAD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_gettenAD.setForeground(new java.awt.Color(255, 255, 255));
        lb_gettenAD.setText("jLabel3");

        label_getEmailAD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_getEmailAD.setForeground(new java.awt.Color(255, 255, 255));
        label_getEmailAD.setText("jLabel4");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_emailAD)
                    .addComponent(label_tenAD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_gettenAD, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(label_getEmailAD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(193, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(327, 327, 327)
                    .addComponent(btn_DoiPass_TK)
                    .addContainerGap(328, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_tenAD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_gettenAD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_emailAD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_getEmailAD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(459, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(307, 307, 307)
                    .addComponent(btn_DoiPass_TK)
                    .addContainerGap(308, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        jPanel3.setVisible(true);
        jPanel4.setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        jPanel3.setVisible(false);
        jPanel4.setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked

    private void btn_DoiPass_TKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DoiPass_TKMouseClicked
        NhapEmail ne = new NhapEmail();
        ne.show();
        dispose();
    }//GEN-LAST:event_btn_DoiPass_TKMouseClicked

    private void btn_DX_TicTacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DX_TicTacMouseClicked
        DangNhap dn = new DangNhap();
        dn.show();
        dispose();
    }//GEN-LAST:event_btn_DX_TicTacMouseClicked

    private void btn_suaNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaNDActionPerformed
        // TODO add your handling code here:
      // TODO add your handling code here:
    String email = TF_emailND.getText();
    String tenND = TF_tenND.getText();

    // Kiểm tra nếu các JTextField không rỗng
    if (email.isEmpty() || tenND.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
    // Lưu trữ thông tin ban đầu
    originalEmail = email;
    originalTenND = tenND;

    // Kết nối tới cơ sở dữ liệu
    connectToDatabase();

    if (connection != null) {
        try {
            // Tạo câu lệnh SQL để cập nhật tên người dùng
            String sql = "UPDATE NGUOIDUNG SET TENND = ? WHERE EMAILND = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, tenND);
            pstmt.setString(2, email);

            // Thực thi câu lệnh cập nhật
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                loadUserData(); // Refresh dữ liệu trên table_dsND
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật thông tin! Chi tiết: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                // Đóng kết nối sau khi thao tác xong
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Kết nối cơ sở dữ liệu thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btn_suaNDActionPerformed
    
    private void btn_searchNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchNDActionPerformed
        // TODO add your handling code here:
        String email = tf_nhaptenNDcantim.getText();

    // Kiểm tra nếu email không rỗng
    if (email.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập email để tìm kiếm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Kết nối tới cơ sở dữ liệu
    connectToDatabase();

    if (connection != null) {
        try {
            // Tạo câu lệnh SQL để tìm kiếm người dùng theo email
            String sql = "SELECT * FROM NGUOIDUNG WHERE EMAILND = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, email);

            // Thực thi câu lệnh truy vấn
            ResultSet rs = pstmt.executeQuery();

            // Xóa dữ liệu cũ trên bảng
            DefaultTableModel model = (DefaultTableModel) table_dsND.getModel();
            model.setRowCount(0);

            // Nếu tìm thấy người dùng, thêm vào bảng
            if (rs.next()) {
                Object[] row = {
                    rs.getString("EMAILND"),
                    rs.getString("TENND"),
                    // Thêm các cột khác nếu cần
                };
                model.addRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tìm kiếm người dùng! Chi tiết: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                // Đóng kết nối sau khi thao tác xong
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Kết nối cơ sở dữ liệu thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btn_searchNDActionPerformed

    private void btn_xoaNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaNDActionPerformed
        // TODO add your handling code here:
        // Lấy dòng được chọn trong bảng
    int selectedRow = table_dsND.getSelectedRow();

    // Kiểm tra nếu không có dòng nào được chọn
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một người dùng để xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Lấy email từ dòng được chọn
    DefaultTableModel model = (DefaultTableModel) table_dsND.getModel();
    String email = (String) model.getValueAt(selectedRow, 0); // Giả sử cột email là cột đầu tiên
 

    // Kết nối tới cơ sở dữ liệu
    connectToDatabase();

    if (connection != null) {
        try {
            // Gọi procedure để xóa người dùng và các thông tin liên quan
            String sql = "{call pc_xoaND(?)}";
            CallableStatement cstmt = connection.prepareCall(sql);
            cstmt.setString(1, email);

            // Thực thi procedure
            cstmt.execute();

            JOptionPane.showMessageDialog(this, "Xóa người dùng thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            model.removeRow(selectedRow); // Xóa dòng khỏi bảng

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi xóa người dùng! Chi tiết: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                // Đóng kết nối sau khi thao tác xong
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Kết nối cơ sở dữ liệu thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btn_xoaNDActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    
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
            java.util.logging.Logger.getLogger(AdminHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHomepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TF_emailND;
    private javax.swing.JTextField TF_tenND;
    private javax.swing.JButton btn_DX_TicTac;
    private javax.swing.JButton btn_DoiPass_TK;
    private javax.swing.JButton btn_searchND;
    private javax.swing.JButton btn_suaND;
    private javax.swing.JButton btn_xoaND;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_emailAD;
    private javax.swing.JLabel label_getEmailAD;
    private javax.swing.JLabel label_tenAD;
    private javax.swing.JLabel lb_emailND;
    private javax.swing.JLabel lb_gettenAD;
    private javax.swing.JLabel lb_tenND;
    private javax.swing.JTable table_dsND;
    private javax.swing.JTextField tf_nhaptenNDcantim;
    // End of variables declaration//GEN-END:variables
}
