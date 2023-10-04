package comGuru99.tests;

import com.aventstack.extentreports.Status;
import comGuru99.pages.LoginPage;
import commonLibs.utils.ConfigUtils;
import commonLibs.implementation.CommonDriver;
import commonLibs.utils.ReportUtils;
import commonLibs.utils.ScreenshotUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Properties;

public class BaseTest {
    CommonDriver cmnDriver;
    String url;
    WebDriver driver;
    LoginPage loginPage;
    String configFileName;
    String currentWorkingDirectory;
    Properties configProperty;
    String reportFileName;
    ReportUtils reportUtils;
    ScreenshotUtils screenshot;

    @BeforeSuite
    public void preSetup() throws Exception {
        currentWorkingDirectory = System.getProperty("user.dir");
        configFileName = currentWorkingDirectory + "/config/config.properties";
        reportFileName = currentWorkingDirectory + "/reports/guru99TestReport.html";
        configProperty = ConfigUtils.readProperties(configFileName);
        reportUtils = new ReportUtils(reportFileName);
    }

    @BeforeClass
    public void setup() throws Exception {
        url = configProperty.getProperty("baseUrl");
        String browserType = configProperty.getProperty("browserType");

        cmnDriver = new CommonDriver(browserType);
        driver = cmnDriver.getDriver();
        loginPage = new LoginPage(driver);
        screenshot = new ScreenshotUtils(driver);
        cmnDriver.navigateToUrl(url);
    }

    @AfterMethod
    public void postTestAction(ITestResult result) throws Exception {
        String testCaseName = result.getName();
        long executionTime = System.currentTimeMillis();

//         File screenshotFileName = new File(currentWorkingDirectory + "\\screenshots\\" + testCaseName + executionTime + ".png");
//         String errorFile = screenshotFileName.getAbsolutePath();
//        FileUtils.copyFile(screenshotFileName, errorFile);
// /Users/aleksandrkhlobystov/Desktop/learn/selenium/Guru99/screenshots/verifyUserLoginWithCorrectCridentials1696426953245.jpeg
        String screenshotFileName = currentWorkingDirectory + "/screenshots/" + testCaseName + executionTime + ".jpeg";
        if(result.getStatus() == ITestResult.FAILURE) {
            reportUtils.addTestLog(Status.FAIL, "One or more steps failed");
            screenshot.captureAndSaveScreenshot(screenshotFileName);
            reportUtils.attachScreenshotToReport(screenshotFileName);
        }
    }
    @AfterClass
    public void tearDown(){
        cmnDriver.closeAllBrowser();
    }

    @AfterSuite
    public void postTearDown(){
        reportUtils.flushReport();
    }

}
