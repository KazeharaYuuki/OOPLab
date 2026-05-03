package garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.exe"; // Thay bằng tên file thực tế bạn có
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            // Đọc toàn bộ file thành mảng byte
            inputBytes = Files.readAllBytes(Paths.get(filename));[cite: 1]
            startTime = System.currentTimeMillis();[cite: 1]

            String outputString = "";[cite: 1]
            for (byte b : inputBytes) {
                // Mỗi lần cộng chuỗi, một đối tượng String mới được tạo ra trong Heap
                outputString += (char) b;[cite: 1]
            }

            endTime = System.currentTimeMillis();[cite: 1]
            // In ra thời gian xử lý (đơn vị: miligiây)[cite: 1]
            System.out.println("Processing time with String (+): " + (endTime - startTime));[cite: 1]
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
