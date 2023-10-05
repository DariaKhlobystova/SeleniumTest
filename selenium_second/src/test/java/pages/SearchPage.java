package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;


public class SearchPage extends BasePage {

    protected WebElement searchFieldFirst;
    protected WebElement cookiesDenied = driver.findElement(By.xpath("//*[@id='W0wltc']/div"));
    protected WebElement pageBody = driver.findElement(By.xpath("//body"));
    protected WebElement voiceSearch = driver.findElement(By.cssSelector("div.XDyW0e"));

    public SearchPage() {
        super();
    }

    public boolean cif() {
        boolean present = false;
        try {
            WebElement x = driver.findElement(By.xpath("//*[@id='W0wltc']/div"));
            if (x.isDisplayed()) {
                present = true;
            }
        } catch (NoSuchElementException e) {
            present = false;
        }
        System.out.println(present);
        return present;
    }

    public void cookieIsFound() {
        try {
            cookiesDenied.click();
        } catch (Exception e) {
            throw e;
        }
    }

    public void clickCookieOrNo() {
        if (cif()) {
            System.out.println("i'm in If statement");
            cookieIsFound();
        }
        System.out.println("#info message");
    }

    public boolean searchFieldIsExist() {
        boolean present2 = false;
        try {
            WebElement x = driver.findElement(By.xpath("//*[@id='APjFqb']"));
            if (x.isDisplayed()) {
                present2 = true;
            }
        } catch (NoSuchElementException e) {
            present2 = false;
        }
        System.out.println(present2);
        return present2;
    }

    public void fieldIsFound() {
        if (!searchFieldIsExist()) {
            searchFieldFirst = driver.findElement(By.xpath("//*[@id='input']"));
        } else {
            searchFieldFirst = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        }
    }

    public void pasteToSearchField(String text) {
        pasteTextToElementFromClipboard(searchFieldFirst, text);
    }

    public void fillSearchField(String text) throws InterruptedException {
        System.out.println("before click");
        searchFieldFirst.click();
//        clickWithJavascript(searchFieldFirst);
        System.out.println("before clear");
        searchFieldFirst.sendKeys(Keys.chord(Keys.CONTROL + "A", Keys.DELETE));
        System.out.println("before send Keys");
        searchFieldFirst.sendKeys(text);
    }

    public void pressEnter() {
        searchFieldFirst.submit();
    }


    public void moveToVoiceSearchButton() {
        System.out.println("I'm start to wait");
        wait.until(ExpectedConditions.visibilityOf(voiceSearch));
        System.out.println("Wait was successful");
        builder.moveToElement(voiceSearch).build().perform();
    }

    public void assertThatVoiceSearchTooltipContainsText(String text) {
        assertThat(pageBody.findElements(By.xpath("//*[contains(text(), '" + text + "')]")).size())
                .as("Expected tooltip [" + text + "] was not found").isNotNull();
    }
}
