package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import steps.SearchSteps;
import utils.DriverFactory;

import static utils.PropertyReader.getBrowser;
import static utils.PropertyReader.getUrl;

public abstract class BaseTest {
    public static WebDriver driver;
    SearchSteps steps;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = DriverFactory.getDriver(getBrowser());
        driver.get(getUrl());
        driver.manage().window().maximize();
        steps = new SearchSteps();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void goBack() {
        driver.navigate().back();
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"chromedriver"}, {"selenium"}};
    }
}
