package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    WebDriverWait wait;
    Actions builder;
    JavascriptExecutor executor;

    public BasePage() {
        this.driver = BaseTest.driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        builder = new Actions(driver);
        executor = (JavascriptExecutor) driver;
    }

    void pasteTextToElementFromClipboard(WebElement element, String text) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection stringSelection = new StringSelection(text);
        clipboard.setContents(stringSelection, null);
        element.sendKeys(Keys.COMMAND, "v");
    }

    void clickWithJavascript(WebElement element) {
        executor.executeScript("arguments[0].click()", element);
    }
}
