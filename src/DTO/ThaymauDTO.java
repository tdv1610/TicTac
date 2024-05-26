package DTO;

import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.util.Date;
import java.util.List;

public class ThaymauDTO implements IDateEvaluator {

    private final List<Date> eventDates;

    public ThaymauDTO(List<Date> eventDates) {
        this.eventDates = eventDates;
    }

    @Override
    public boolean isSpecial(Date date) {
        return eventDates.contains(date);
    }

    @Override
    public Color getSpecialForegroundColor() {
        return null; // Bạn có thể trả về màu chữ đặc biệt nếu cần thiết
    }

    @Override
    public Color getSpecialBackroundColor() {
        return Color.YELLOW; // Màu nền cho các ngày có sự kiện
    }

    @Override
    public String getSpecialTooltip() {
        return "Có sự kiện"; // Tooltip cho các ngày có sự kiện
    }

    @Override
    public boolean isInvalid(Date date) {
        return false; // Không cần kiểm tra ngày không hợp lệ trong trường hợp này
    }

    @Override
    public Color getInvalidForegroundColor() {
        return null; // Màu chữ cho ngày không hợp lệ
    }

    @Override
    public Color getInvalidBackroundColor() {
        return null; // Màu nền cho ngày không hợp lệ
    }

    @Override
    public String getInvalidTooltip() {
        return null; // Tooltip cho ngày không hợp lệ
    }

    public String getValidToolTip() {
        return null; // Tooltip cho ngày hợp lệ
    }
}
