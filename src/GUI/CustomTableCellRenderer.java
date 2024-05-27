package GUI;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    private String receiverEmail;

    public CustomTableCellRenderer(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        String senderEmail = (String) table.getValueAt(row, 1); // Cột chứa email người gửi

        if (senderEmail != null && !senderEmail.equals(receiverEmail)) {
            // In đậm tên và email của người gửi
            cellComponent.setFont(cellComponent.getFont().deriveFont(Font.BOLD));
        } else {
            // Đặt lại phông chữ bình thường cho các hàng khác
            cellComponent.setFont(cellComponent.getFont().deriveFont(Font.PLAIN));
        }

        return cellComponent;
    }
}
