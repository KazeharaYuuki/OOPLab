package hust.soict.swing; // Thay đổi theo chuyên ngành của bạn

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {
    private TextField tfInput;   // Ô nhập dữ liệu
    private TextField tfOutput;  // Ô hiển thị kết quả
    private int sum = 0;         // Biến lưu tổng cộng dồn, khởi tạo bằng 0

    // Constructor để thiết lập giao diện và xử lý sự kiện
    public AWTAccumulator() {
        // Thiết lập layout dạng lưới 2 hàng, 2 cột
        setLayout(new GridLayout(2, 2));

        // Hàng 1: Nhãn và Ô nhập dữ liệu
        add(new Label("Enter an Integer: "));
        tfInput = new TextField(10);
        add(tfInput);

        // Đăng ký bộ lắng nghe sự kiện hành động cho ô nhập dữ liệu
        tfInput.addActionListener(new TFInputListener());

        // Hàng 2: Nhãn và Ô hiển thị kết quả
        add(new Label("The Accumulated Sum is: "));
        tfOutput = new TextField(10);
        tfOutput.setEditable(false); // Chỉ cho phép đọc, không cho sửa trực tiếp
        add(tfOutput);

        // Thiết lập thuộc tính cho cửa sổ (Frame)
        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    // Named Inner Class xử lý sự kiện khi người dùng nhấn "Enter" ở tfInput
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            // Lấy chuỗi ký tự, chuyển thành số nguyên
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;      // Cộng dồn vào biến sum
            tfInput.setText("");  // Xóa trống ô nhập dữ liệu
            tfOutput.setText(sum + ""); // Hiển thị tổng mới lên ô kết quả
        }
    }

    public static void main(String[] args) {
        new AWTAccumulator(); // Khởi chạy ứng dụng
    }
}