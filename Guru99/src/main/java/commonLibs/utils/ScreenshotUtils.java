package commonLibs.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;

public class ScreenshotUtils {

    private TakesScreenshot camera;

    public ScreenshotUtils(WebDriver driver) {
        camera = (TakesScreenshot) driver;
    }

    public void captureAndSaveScreenshot(String filename) throws Exception {
        filename = filename.trim();

        File imgFile, tmpFile;

        imgFile = new File(filename);

        if(imgFile.exists()) {
            throw new Exception("File already exists");
        }
        tmpFile = camera.getScreenshotAs(OutputType.FILE);

//        FileUtils.copyFile(tmpFile, imgFile);
        FileUtils.moveFile(tmpFile, imgFile);
    }

}
