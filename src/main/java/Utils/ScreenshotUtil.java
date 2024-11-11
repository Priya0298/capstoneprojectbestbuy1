package Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String fileName) {
        // Convert WebDriver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        // Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        try {
            // Define the directory to save screenshots
            String directory = System.getProperty("user.dir") + "/screenshots/";
            createDirectory(directory);
            // Define the file path
            String filePath = directory + fileName + ".png";
            // Copy file to Desired Location
            Path destinationPath = Paths.get(filePath);
            Files.copy(SrcFile.toPath(), destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    private static void createDirectory(String directory) {
        File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
}