package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtility {

    public static String captureScreenshot(WebDriver driver) {
        try {
            // Capture screenshot as bytes
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // Create directory if not exists
            createDirectory("test-output/screenshots");

            // Generate unique file name
            String fileName = generateFileName();

            // Save screenshot to file
            File screenshotFile = new File("test-output/screenshots/" + fileName + ".png");
            FileUtils.writeByteArrayToFile(screenshotFile, screenshotBytes);

            return screenshotFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void createDirectory(String directoryPath) throws IOException {
        if (!Files.exists(Paths.get(directoryPath))) {
            Files.createDirectories(Paths.get(directoryPath));
        }
    }

    private static String generateFileName() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return now.format(formatter);
    }
}

