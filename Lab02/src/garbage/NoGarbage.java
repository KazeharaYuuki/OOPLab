package garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "test.exe"; // Đảm bảo dùng chung file với GarbageCreator[cite: 1]
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));[cite: 1]
            startTime = System.currentTimeMillis();[cite: 1]

            // StringBuilder thay đổi trực tiếp nội dung bên trong, không tạo bản sao rác[cite: 1]
            StringBuilder outputStringBuilder = new StringBuilder();[cite: 1]
            for (byte b : inputBytes) {
                outputStringBuilder.append((char) b);[cite: 1]
            }

            String outputString = outputStringBuilder.toString();[cite: 1]
            endTime = System.currentTimeMillis();[cite: 1]

            System.out.println("Processing time with StringBuilder: " + (endTime - startTime));[cite: 1]
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
