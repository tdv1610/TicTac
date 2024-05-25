/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.CongViecDAO;
import DAO.FileAttachmentDAO;
import DAO.FileAttachmentService;
import DAO.ThucHienDAO;
import DTO.CongViecDTO;
import DTO.FileAttachmentDTO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ChiTietCongViec extends javax.swing.JFrame {
    public static String ma_cv;
    String tencvhome = Homepage.tencv;
    String manhomhome = Homepage.lay_manhom;
    
    /**
     * Creates new form ChiTietCongViec
     */
    public ChiTietCongViec() {
        initComponents();
        try {
            XemCVCanlam();
            XemCVDangLam();
            XemCVDaHoanThanh();
        } catch (ParseException ex) {
            Logger.getLogger(ChiTietCongViec.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void XemCVCanlam() throws ParseException{
        String tencv = tencvhome;
        String manhom_cl = manhomhome;
        CongViecDAO congviec = new CongViecDAO();
        String laymacv = congviec.laymacv(manhom_cl, tencv);
        CongViecDTO congvieccanlam = congviec.TimCV(laymacv);
        if (congvieccanlam != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            jlabel_tencv_ChiTietCongViec.setText(congvieccanlam.getTenCV());
            tf_Mota_Chitietcongviec.setText(congvieccanlam.getMoTa());
            jlabel_linhvuc_ChiTietCongViec.setText(congvieccanlam.getLinhVuc());
            jlabel_mucuutien_ChiTietCongViec.setText(String.valueOf(congvieccanlam.getMuc_uutien()));
            jlabel_ngaybd_ChiTietCongViec.setText(dateFormat.format(congvieccanlam.getNgayBD()));
            jlabel_ngaykt_ChiTietCongViec.setText(dateFormat.format(congvieccanlam.getNgayKT()));
            ma_cv = congvieccanlam.getMaCV();
        }
        else {
            // Xử lý khi công việc không tồn tại
            jlabel_tencv_ChiTietCongViec.setText("Công việc không tồn tại");
            tf_Mota_Chitietcongviec.setText("");
            jlabel_linhvuc_ChiTietCongViec.setText("");
            jlabel_mucuutien_ChiTietCongViec.setText("");
            jlabel_ngaybd_ChiTietCongViec.setText("");
            jlabel_ngaykt_ChiTietCongViec.setText("");
        }
        
    }
    
    private void XemCVDangLam() throws ParseException{
        String tencv = tencvhome;
        String manhom_dl = manhomhome;
        CongViecDAO congviec = new CongViecDAO();
        String laymacv = congviec.laymacv(manhom_dl, tencv);
        CongViecDTO congviecdanglam = congviec.TimCV(laymacv);
        if (congviecdanglam != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            jlabel_tencv_ChiTietCongViec.setText(congviecdanglam.getTenCV());
            tf_Mota_Chitietcongviec.setText(congviecdanglam.getMoTa());
            jlabel_linhvuc_ChiTietCongViec.setText(congviecdanglam.getLinhVuc());
            jlabel_mucuutien_ChiTietCongViec.setText(String.valueOf(congviecdanglam.getMuc_uutien()));
            jlabel_ngaybd_ChiTietCongViec.setText(dateFormat.format(congviecdanglam.getNgayBD()));
            jlabel_ngaykt_ChiTietCongViec.setText(dateFormat.format(congviecdanglam.getNgayKT()));
            ma_cv = congviecdanglam.getMaCV();
        }
        else {
            // Xử lý khi công việc không tồn tại
            jlabel_tencv_ChiTietCongViec.setText("Công việc không tồn tại");
            tf_Mota_Chitietcongviec.setText("");
            jlabel_linhvuc_ChiTietCongViec.setText("");
            jlabel_mucuutien_ChiTietCongViec.setText("");
            jlabel_ngaybd_ChiTietCongViec.setText("");
            jlabel_ngaykt_ChiTietCongViec.setText("");
        }
        
    }
    
    private void XemCVDaHoanThanh() throws ParseException{
        String tencv = tencvhome;
        String manhom_dht = manhomhome;
        CongViecDAO congviec = new CongViecDAO();
        String laymacv = congviec.laymacv(manhom_dht, tencv);
        CongViecDTO congviecdht = congviec.TimCV(laymacv);
        if (congviecdht != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            jlabel_tencv_ChiTietCongViec.setText(congviecdht.getTenCV());
            tf_Mota_Chitietcongviec.setText(congviecdht.getMoTa());
            jlabel_linhvuc_ChiTietCongViec.setText(congviecdht.getLinhVuc());
            jlabel_mucuutien_ChiTietCongViec.setText(String.valueOf(congviecdht.getMuc_uutien()));
            jlabel_ngaybd_ChiTietCongViec.setText(dateFormat.format(congviecdht.getNgayBD()));
            jlabel_ngaykt_ChiTietCongViec.setText(dateFormat.format(congviecdht.getNgayKT()));
            ma_cv = congviecdht.getMaCV();
        }
        else {
            // Xử lý khi công việc không tồn tại
            jlabel_tencv_ChiTietCongViec.setText("Công việc không tồn tại");
            tf_Mota_Chitietcongviec.setText("");
            jlabel_linhvuc_ChiTietCongViec.setText("");
            jlabel_mucuutien_ChiTietCongViec.setText("");
            jlabel_ngaybd_ChiTietCongViec.setText("");
            jlabel_ngaykt_ChiTietCongViec.setText("");
        }
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel_Chitietcongviec = new javax.swing.JPanel();
        jlabel_tencongviec = new javax.swing.JLabel();
        jlabel_mota = new javax.swing.JLabel();
        jlabel_linhvuc = new javax.swing.JLabel();
        jlabel_mucuutien = new javax.swing.JLabel();
        jlabel_ngaybd = new javax.swing.JLabel();
        jlabel_ngaykt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_Mota_Chitietcongviec = new javax.swing.JTextArea();
        btn__filledinhkem_chitietCV = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_file_ChitiecCV = new javax.swing.JList<>();
        btn_HoanThanh_ChiTiecCongViec = new javax.swing.JButton();
        jlabel_Trangthaicongviec = new javax.swing.JLabel();
        jcombobox_trangthai = new javax.swing.JComboBox<>();
        jlabel_tencv_ChiTietCongViec = new javax.swing.JLabel();
        jlabel_linhvuc_ChiTietCongViec = new javax.swing.JLabel();
        jlabel_mucuutien_ChiTietCongViec = new javax.swing.JLabel();
        jlabel_ngaybd_ChiTietCongViec = new javax.swing.JLabel();
        jlabel_ngaykt_ChiTietCongViec = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpanel_Chitietcongviec.setBackground(new java.awt.Color(0, 102, 102));

        jlabel_tencongviec.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlabel_tencongviec.setForeground(new java.awt.Color(255, 255, 255));
        jlabel_tencongviec.setText("Tên công việc");

        jlabel_mota.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlabel_mota.setForeground(new java.awt.Color(255, 255, 255));
        jlabel_mota.setText("Mô tả");

        jlabel_linhvuc.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlabel_linhvuc.setForeground(new java.awt.Color(255, 255, 255));
        jlabel_linhvuc.setText("Lĩnh vực");

        jlabel_mucuutien.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlabel_mucuutien.setForeground(new java.awt.Color(255, 255, 255));
        jlabel_mucuutien.setText("Mức độ ưu tiên");

        jlabel_ngaybd.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlabel_ngaybd.setForeground(new java.awt.Color(255, 255, 255));
        jlabel_ngaybd.setText("Ngày bắt đầu");

        jlabel_ngaykt.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlabel_ngaykt.setForeground(new java.awt.Color(255, 255, 255));
        jlabel_ngaykt.setText("Ngày kết thúc");

        tf_Mota_Chitietcongviec.setBackground(new java.awt.Color(255, 255, 204));
        tf_Mota_Chitietcongviec.setColumns(20);
        tf_Mota_Chitietcongviec.setRows(5);
        tf_Mota_Chitietcongviec.setBorder(null);
        jScrollPane1.setViewportView(tf_Mota_Chitietcongviec);

        btn__filledinhkem_chitietCV.setBackground(new java.awt.Color(0, 153, 153));
        btn__filledinhkem_chitietCV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/attached.png"))); // NOI18N
        btn__filledinhkem_chitietCV.setText("Đính kèm");
        btn__filledinhkem_chitietCV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn__filledinhkem_chitietCVMouseClicked(evt);
            }
        });
        btn__filledinhkem_chitietCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn__filledinhkem_chitietCVActionPerformed(evt);
            }
        });

        list_file_ChitiecCV.setBackground(new java.awt.Color(255, 255, 204));
        jScrollPane2.setViewportView(list_file_ChitiecCV);

        btn_HoanThanh_ChiTiecCongViec.setBackground(new java.awt.Color(0, 51, 51));
        btn_HoanThanh_ChiTiecCongViec.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btn_HoanThanh_ChiTiecCongViec.setForeground(new java.awt.Color(255, 255, 255));
        btn_HoanThanh_ChiTiecCongViec.setText("Hoàn thành");
        btn_HoanThanh_ChiTiecCongViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HoanThanh_ChiTiecCongViecActionPerformed(evt);
            }
        });

        jlabel_Trangthaicongviec.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jlabel_Trangthaicongviec.setForeground(new java.awt.Color(255, 255, 255));
        jlabel_Trangthaicongviec.setText("Trạng thái công việc");

        jcombobox_trangthai.setBackground(new java.awt.Color(0, 153, 153));
        jcombobox_trangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cần làm", "Đang làm", "Đã hoàn thành" }));
        jcombobox_trangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcombobox_trangthaiActionPerformed(evt);
            }
        });

        jlabel_tencv_ChiTietCongViec.setBackground(new java.awt.Color(255, 255, 204));
        jlabel_tencv_ChiTietCongViec.setText("jLabel1");
        jlabel_tencv_ChiTietCongViec.setOpaque(true);

        jlabel_linhvuc_ChiTietCongViec.setBackground(new java.awt.Color(255, 255, 204));
        jlabel_linhvuc_ChiTietCongViec.setText("jLabel2");
        jlabel_linhvuc_ChiTietCongViec.setOpaque(true);

        jlabel_mucuutien_ChiTietCongViec.setBackground(new java.awt.Color(255, 255, 204));
        jlabel_mucuutien_ChiTietCongViec.setText("jLabel3");
        jlabel_mucuutien_ChiTietCongViec.setOpaque(true);

        jlabel_ngaybd_ChiTietCongViec.setBackground(new java.awt.Color(255, 255, 204));
        jlabel_ngaybd_ChiTietCongViec.setText("jLabel4");
        jlabel_ngaybd_ChiTietCongViec.setOpaque(true);

        jlabel_ngaykt_ChiTietCongViec.setBackground(new java.awt.Color(255, 255, 204));
        jlabel_ngaykt_ChiTietCongViec.setText("jLabel5");
        jlabel_ngaykt_ChiTietCongViec.setOpaque(true);

        javax.swing.GroupLayout jpanel_ChitietcongviecLayout = new javax.swing.GroupLayout(jpanel_Chitietcongviec);
        jpanel_Chitietcongviec.setLayout(jpanel_ChitietcongviecLayout);
        jpanel_ChitietcongviecLayout.setHorizontalGroup(
            jpanel_ChitietcongviecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_ChitietcongviecLayout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(btn_HoanThanh_ChiTiecCongViec)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpanel_ChitietcongviecLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jpanel_ChitietcongviecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel_ChitietcongviecLayout.createSequentialGroup()
                        .addComponent(jlabel_Trangthaicongviec)
                        .addGap(44, 44, 44)
                        .addComponent(jcombobox_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpanel_ChitietcongviecLayout.createSequentialGroup()
                        .addGroup(jpanel_ChitietcongviecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpanel_ChitietcongviecLayout.createSequentialGroup()
                                .addComponent(jlabel_mota)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(jpanel_ChitietcongviecLayout.createSequentialGroup()
                                .addComponent(btn__filledinhkem_chitietCV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2))
                            .addGroup(jpanel_ChitietcongviecLayout.createSequentialGroup()
                                .addGroup(jpanel_ChitietcongviecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpanel_ChitietcongviecLayout.createSequentialGroup()
                                        .addComponent(jlabel_ngaybd)
                                        .addGap(18, 18, 18)
                                        .addComponent(jlabel_ngaybd_ChiTietCongViec, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpanel_ChitietcongviecLayout.createSequentialGroup()
                                        .addComponent(jlabel_linhvuc)
                                        .addGap(18, 18, 18)
                                        .addComponent(jlabel_linhvuc_ChiTietCongViec, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlabel_ngaykt)
                                .addGap(18, 18, 18)
                                .addComponent(jlabel_ngaykt_ChiTietCongViec, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpanel_ChitietcongviecLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jpanel_ChitietcongviecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jpanel_ChitietcongviecLayout.createSequentialGroup()
                                        .addComponent(jlabel_tencongviec)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlabel_tencv_ChiTietCongViec, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(139, 139, 139))
                                    .addGroup(jpanel_ChitietcongviecLayout.createSequentialGroup()
                                        .addComponent(jlabel_mucuutien)
                                        .addGap(18, 18, 18)
                                        .addComponent(jlabel_mucuutien_ChiTietCongViec, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(319, 319, 319)))))
                        .addGap(71, 71, 71))))
        );
        jpanel_ChitietcongviecLayout.setVerticalGroup(
            jpanel_ChitietcongviecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_ChitietcongviecLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jpanel_ChitietcongviecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel_tencongviec)
                    .addComponent(jlabel_tencv_ChiTietCongViec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanel_ChitietcongviecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_mota)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_ChitietcongviecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel_linhvuc)
                    .addComponent(jlabel_linhvuc_ChiTietCongViec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanel_ChitietcongviecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel_mucuutien)
                    .addComponent(jlabel_mucuutien_ChiTietCongViec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanel_ChitietcongviecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel_ngaybd)
                    .addComponent(jlabel_ngaykt)
                    .addComponent(jlabel_ngaybd_ChiTietCongViec)
                    .addComponent(jlabel_ngaykt_ChiTietCongViec))
                .addGap(18, 18, 18)
                .addGroup(jpanel_ChitietcongviecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn__filledinhkem_chitietCV)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jpanel_ChitietcongviecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel_Trangthaicongviec)
                    .addComponent(jcombobox_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(btn_HoanThanh_ChiTiecCongViec)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel_Chitietcongviec, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel_Chitietcongviec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn__filledinhkem_chitietCVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn__filledinhkem_chitietCVMouseClicked

    }//GEN-LAST:event_btn__filledinhkem_chitietCVMouseClicked

    private void btn__filledinhkem_chitietCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn__filledinhkem_chitietCVActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(true);
        int x = fc.showDialog(this, "Chọn");
        if (x == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fc.getSelectedFiles();
            DefaultListModel<String> model = new DefaultListModel<>();
            for (File file : selectedFiles) {
                if (saveFileToDatabase(file, ma_cv)&& GrantDatabase(file)) {
                    model.addElement(file.getAbsolutePath());
                    list_file_ChitiecCV.setModel(model);
                    JOptionPane.showMessageDialog(this, "Thêm file thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                JOptionPane.showMessageDialog(this, "Thêm file thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    private boolean saveFileToDatabase(File file, String ma_cv) {
        FileAttachmentDAO fileAttachmentDAO = new FileAttachmentDAO();
        String filePath = file.getAbsolutePath();
        fileAttachmentDAO.Capquyen(filePath);
        return fileAttachmentDAO.insertFileAttachment(filePath, ma_cv);
    }
    
    private boolean GrantDatabase(File file) {
        FileAttachmentDAO fileAttachmentDAO = new FileAttachmentDAO();
        String filePath = file.getAbsolutePath();
        return fileAttachmentDAO.Capquyen(filePath);
    }


    private byte[] convertFileToByteArray(File file) {
        byte[] fileData = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            fileData = bos.toByteArray();
            fis.close();
            bos.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return fileData;
    }//GEN-LAST:event_btn__filledinhkem_chitietCVActionPerformed

    private void btn_HoanThanh_ChiTiecCongViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HoanThanh_ChiTiecCongViecActionPerformed
        // TODO add your handling code here:
        ThucHienDAO thuchien = new ThucHienDAO();
        CongViecDAO congviec = new CongViecDAO();
        String trangthai = (String) jcombobox_trangthai.getSelectedItem();
        String ma = congviec.laymacv(manhomhome, tencvhome);
        
        boolean kt = thuchien.capNhatTrangThaiCongViec(ma, trangthai);
        if(kt){
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);

        }
        Homepage home = new Homepage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_HoanThanh_ChiTiecCongViecActionPerformed

    private void jcombobox_trangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcombobox_trangthaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcombobox_trangthaiActionPerformed

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
            java.util.logging.Logger.getLogger(ChiTietCongViec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietCongViec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietCongViec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietCongViec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChiTietCongViec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_HoanThanh_ChiTiecCongViec;
    private javax.swing.JButton btn__filledinhkem_chitietCV;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcombobox_trangthai;
    private javax.swing.JLabel jlabel_Trangthaicongviec;
    private javax.swing.JLabel jlabel_linhvuc;
    private javax.swing.JLabel jlabel_linhvuc_ChiTietCongViec;
    private javax.swing.JLabel jlabel_mota;
    private javax.swing.JLabel jlabel_mucuutien;
    private javax.swing.JLabel jlabel_mucuutien_ChiTietCongViec;
    private javax.swing.JLabel jlabel_ngaybd;
    private javax.swing.JLabel jlabel_ngaybd_ChiTietCongViec;
    private javax.swing.JLabel jlabel_ngaykt;
    private javax.swing.JLabel jlabel_ngaykt_ChiTietCongViec;
    private javax.swing.JLabel jlabel_tencongviec;
    private javax.swing.JLabel jlabel_tencv_ChiTietCongViec;
    private javax.swing.JPanel jpanel_Chitietcongviec;
    private javax.swing.JList<String> list_file_ChitiecCV;
    private javax.swing.JTextArea tf_Mota_Chitietcongviec;
    // End of variables declaration//GEN-END:variables
}
