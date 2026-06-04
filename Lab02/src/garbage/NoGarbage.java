package garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = args.length > 0 ? args[0] : "test.exe";
        byte[] inputBytes;
        long startTime;
        long endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();

            StringBuilder outputStringBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                outputStringBuilder.append((char) b);
            }

            String outputString = outputStringBuilder.toString();
            endTime = System.currentTimeMillis();

            System.out.println("Processing time with StringBuilder: " + (endTime - startTime) + " ms");
            System.out.println("Output length: " + outputString.length());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
