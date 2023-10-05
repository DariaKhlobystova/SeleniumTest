package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsPage extends BasePage {

    private WebElement result = driver.findElement(By.xpath("//*[@id='rso']/div"));
    private List<WebElement> results = driver.findElements(By.xpath("//*[@id='rso']/div"));

    public SearchResultsPage() {
        super();
    }

    public void assertThatTopResultContainsCorrectText(String expected) {
        wait.until(ExpectedConditions.visibilityOfAllElements(results));
        assertThat(result.getText()).as("Wrong text has been displayed!").containsIgnoringCase(expected);
        assertThat(results.stream().map(e -> e.getText()).collect(Collectors.toList()).toString())
                .as("Wrong text has been displayed!")
                .containsAnyOf(expected);
    }

    public void assertThatTopResultContainsProperAttributeText(String expected) {
        assertThat(result.getAttribute("class")).as("Wrong attribute text!").contains(expected);
    }
}
