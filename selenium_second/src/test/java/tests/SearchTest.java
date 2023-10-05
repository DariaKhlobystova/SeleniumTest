package tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "dataProvider")
    public void openGoogleComTest(String text) throws InterruptedException {
        steps.executeSearchByKeyword(text)
                .verifyThatTopResultContainsCorrectText("chrome")
                .verifyThatTopResultContainsProperAttributeText("MjjYud");
    }

    @Test
    public void verifySearchByVoiceTooltipOnGoogle() {
        steps.openTooltip()
                .verifyThatTooltipContainsCorrectText("Search by voice")
                .verifyThatTooltipContainsCorrectText("Голосовой поиск");
    }
}

