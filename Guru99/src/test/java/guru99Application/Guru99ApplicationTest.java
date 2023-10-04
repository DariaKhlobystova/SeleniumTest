package guru99Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Guru99ApplicationTest {
    ChromeDriver driver;
    String url = "http://demo.guru99.com/v4";

    @Test (priority = -100)
    public void invokeBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(url);
        driver.manage().window().maximize();

        // work with cookieFrame and get back on main page:
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gdpr-consent-notice"));
        System.out.println("i'm on frame now");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("save")));
        System.out.println("i'm waiting");
        WebElement cookie = driver.findElement(By.xpath("//*[@id='save']"));
        cookie.click();
        System.out.println("click on submit");
        driver.switchTo().defaultContent();
        System.out.println("i'm on main page Guru99");
    }

    @Test (priority = 0)
    public void verifyTitleOfThePage(){
        String expectedTitle = "Guru99 Bank Home Page";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test (priority = 100)
    public void verifyLoginToGuru99Application(){
        WebElement userIdField = driver.findElement(By.name("uid"));
        userIdField.sendKeys("mngr529957");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("tymumUh");
        WebElement loginButton = driver.findElement(By.name("btnLogin"));
        loginButton.click();
    }

    @Test (priority = 200)
    public void addCustomer(){
        WebElement addCustomerLink = driver.findElement(By.linkText("New Customer"));
        addCustomerLink.click();
//        WebElement sex = driver.findElement(By.xpath("//input[@value='f']"));
//        sex.click();
        WebElement userName = driver.findElement(By.name("name"));
        userName.sendKeys("Mikel Jordan");
        WebElement dayOfBirth = driver.findElement(By.name("dob"));
        dayOfBirth.sendKeys("13/6/1986");
        WebElement addres = driver.findElement(By.name("addr"));
        addres.sendKeys("Sydney 2");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Sydney");
        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("Australia");
        WebElement pinCode = driver.findElement(By.name("pinno"));
        pinCode.sendKeys("122001");
        WebElement telephonNumber = driver.findElement(By.name("telephoneno"));
        telephonNumber.sendKeys("97834523577");
        WebElement email = driver.findElement(By.name("emailid"));
        email.sendKeys("df3567@ya.com");
        WebElement passwordOfUser = driver.findElement(By.name("password"));
        passwordOfUser.sendKeys("poiy@1256");
        WebElement submitButton = driver.findElement(By.name("sub"));
        submitButton.click();
    }

    @Test (priority = 300)
    public void getCustomerId(){
        String customerId = driver.findElement(By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]")).getText();
        System.out.println("Customer ID: " + customerId);
    }

//    @AfterClass
//    public void closeBrowser(){
//        driver.quit();
//    }
}
