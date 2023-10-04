package comGuru99.tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Parameters({"username", "password"})
    @Test
    public void verifyUserLoginWithCorrectCridentials(String username, String password){
        reportUtils.createATestCase("Verify User Login With Correct Cridentials");
        reportUtils.addTestLog(Status.INFO, "Performing Login");
        loginPage.loginToApplication(username, password);

        String expectedTitle = "Guru99 Bank Manager Home Page";
        String actualTitle = cmnDriver.getTitleOfThePage();
        reportUtils.addTestLog(Status.INFO, "Comparing expected and actual title");
        Assert.assertEquals(actualTitle, expectedTitle);

    }


}
