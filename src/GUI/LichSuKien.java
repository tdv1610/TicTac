/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DAO.ThucHienDAO;
import DTO.PhanCongDTO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LichSuKien extends JFrame {
    private JPanel calendarPanel;
    private JLabel monthLabel;
    private JButton prevButton;
    private JButton nextButton;
    private JButton[] dayButtons;
    private DefaultListModel<String> eventListModel;
    private JList<String> eventList;

    public LichSuKien() {
        setTitle("Sự Kiện");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        // Panel chứa lịch
        calendarPanel = new JPanel(new GridLayout(0, 7, 2, 2));
        calendarPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(calendarPanel, BorderLayout.CENTER);

        // Panel chứa label tháng và nút điều hướng
        JPanel monthPanel = new JPanel(new BorderLayout());
        add(monthPanel, BorderLayout.NORTH);

        // Label hiển thị tháng
        monthLabel = new JLabel("", SwingConstants.CENTER);
        monthPanel.add(monthLabel, BorderLayout.CENTER);

        // Nút điều hướng tháng trước
        prevButton = new JButton("<<");
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                previousMonth();
            }
        });
        monthPanel.add(prevButton, BorderLayout.WEST);

        // Nút điều hướng tháng sau
        nextButton = new JButton(">>");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextMonth();
            }
        });
        monthPanel.add(nextButton, BorderLayout.EAST);

        // Danh sách sự kiện
        eventListModel = new DefaultListModel<>();
        eventList = new JList<>(eventListModel);
        add(new JScrollPane(eventList), BorderLayout.SOUTH);

        // Hiển thị lịch cho tháng và năm hiện tại
        LocalDate currentDate = LocalDate.now();
        createCalendar(currentDate.getYear(), currentDate.getMonthValue());

        // Lắng nghe sự kiện khi nhấn vào ngày
        eventList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int index = eventList.locationToIndex(evt.getPoint());
                    JOptionPane.showMessageDialog(LichSuKien.this, eventListModel.getElementAt(index));
                    
                }
            }
        });
    }

    // Tạo lịch cho một tháng cụ thể
    private void createCalendar(int year, int month) {
        calendarPanel.removeAll();

        // Hiển thị tháng và năm
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        monthLabel.setText(monthFormatter.format(LocalDate.of(year, month, 1)));

        // Danh sách ngày trong tháng
        ArrayList<LocalDate> daysOfMonth = new ArrayList<>();
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        LocalDate lastDayOfMonth = firstDayOfMonth.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate currentDay = firstDayOfMonth;

        // Thêm tất cả các ngày trong tháng vào danh sách
        while (!currentDay.isAfter(lastDayOfMonth)) {
            daysOfMonth.add(currentDay);
            currentDay = currentDay.plusDays(1);
        }

        // Tạo các nút ngày cho mỗi ngày trong tháng
        dayButtons = new JButton[daysOfMonth.size()];
        for (int i = 0; i < daysOfMonth.size(); i++) {
            LocalDate date = daysOfMonth.get(i);
            JButton dayButton = new JButton(String.valueOf(date.getDayOfMonth()));
            dayButton.setToolTipText(date.toString());
            dayButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        XemSuKien(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(LichSuKien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            // Tô màu cho các ngày có sự kiện
            if (hasEvent(date)) {
                dayButton.setBackground(Color.YELLOW);
            }
            calendarPanel.add(dayButton);
            dayButtons[i] = dayButton;
        }

        // Cập nhật giao diện
        calendarPanel.revalidate();
        calendarPanel.repaint();
    }
    
    private boolean hasEvent(LocalDate date) {
        List<Date> eventDates = NgaySuKien();
        for (Date eventDate : eventDates) {
            LocalDate localDate = eventDate.toLocalDate();
            if (localDate.equals(date)) {
                return true;
            }
        }
        return false;
    }


    public void actionPerformed(ActionEvent e) {
    JButton button = (JButton) e.getSource();
    String buttonText = button.getText();
    int dayOfMonth = Integer.parseInt(buttonText);
    LocalDate selectedDate = LocalDate.of(
            Integer.parseInt(monthLabel.getText().split(" ")[1]),
            Month.valueOf(monthLabel.getText().split(" ")[0].toUpperCase()),
            dayOfMonth
    );
    try {
        XemSuKien(selectedDate);
    } catch (ParseException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(LichSuKien.this, "Đã xảy ra lỗi khi xem sự kiện!");
    }
}

    private void XemSuKien(LocalDate date) throws ParseException {
        StringBuilder eventStringBuilder = new StringBuilder("Sự kiện cho ngày ");
        eventStringBuilder.append(date.getDayOfMonth()).append(" ").append(date.getMonth()).append(" ").append(date.getYear()).append(":\n");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String dateString = dateFormat.format(java.sql.Date.valueOf(date));
        ThucHienDAO thucHienDAO = new ThucHienDAO();
        List<PhanCongDTO> dscongviecbd = thucHienDAO.layDanhCongViecBD(dateString, DangNhap.pEmail);
        List<PhanCongDTO> dscongvieckt = thucHienDAO.layDanhSachCongViecKT(dateString, DangNhap.pEmail);

        if ((dscongviecbd != null && !dscongviecbd.isEmpty()) || (dscongvieckt != null && !dscongvieckt.isEmpty())) {
            if (dscongviecbd != null && !dscongviecbd.isEmpty()) {
                eventStringBuilder.append("Công việc bắt đầu:\n");
                for (PhanCongDTO congViec : dscongviecbd) {
                    eventStringBuilder.append("- ").append(congViec.getTenCV()).append("\n");
                }
            }
            if (dscongvieckt != null && !dscongvieckt.isEmpty()) {
                eventStringBuilder.append("Công việc kết thúc:\n");
                for (PhanCongDTO congViec : dscongvieckt) {
                    eventStringBuilder.append("- ").append(congViec.getTenCV()).append("\n");
                }
            }
        } else {
            eventStringBuilder.append("Không có công việc cho ngày này.");
        }

        JOptionPane.showMessageDialog(this, eventStringBuilder.toString());
    }

    
    private List<Date> NgaySuKien(){
        List<Date> ngay = new ArrayList<>();
        ThucHienDAO thuchien = new ThucHienDAO();
        List<PhanCongDTO> dsngaybd = thuchien.layDanhSachNgayBD(DangNhap.pEmail);
        List<PhanCongDTO> dsngaykt = thuchien.layDanhSachNgayKT(DangNhap.pEmail);
        if(dsngaybd != null || dsngaykt != null){
            for(PhanCongDTO ngaybd : dsngaybd){
            ngay.add((Date) ngaybd.getNgayBD());
            }

            for(PhanCongDTO ngaykt : dsngaykt){
                ngay.add((Date) ngaykt.getNgayKT());       
            }
        
        }
        return ngay;
        
    }

    // Hiển thị tháng tiếp theo
    private void nextMonth() {
        LocalDate current = LocalDate.of(Integer.parseInt(monthLabel.getText().split(" ")[1]),
                Month.valueOf(monthLabel.getText().split(" ")[0].toUpperCase()), 1);
        LocalDate nextMonth = current.plusMonths(1);
        createCalendar(nextMonth.getYear(), nextMonth.getMonthValue());
    }

    // Hiển thị tháng trước đó
    private void previousMonth() {
        LocalDate current = LocalDate.of(Integer.parseInt(monthLabel.getText().split(" ")[1]),
                Month.valueOf(monthLabel.getText().split(" ")[0].toUpperCase()), 1);
        LocalDate previousMonth = current.minusMonths(1);
        createCalendar(previousMonth.getYear(), previousMonth.getMonthValue());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LichSuKien calendar = new LichSuKien();
                calendar.setVisible(true);
            }
        });
    }
}
