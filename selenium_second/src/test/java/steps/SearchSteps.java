package steps;

import pages.SearchPage;

public class SearchSteps {
    private SearchPage searchPage = new SearchPage();

    public SearchResultsSteps executeSearchByKeyword(String keyword) throws InterruptedException {
        searchPage.clickCookieOrNo();
        searchPage.fieldIsFound();
        System.out.println("searchField is found correct");

        System.out.println("#info second message");
        searchPage.fillSearchField(keyword);
//        searchPage.pasteToSearchField(keyword);
        System.out.println("#info message after fill Search Field");
        searchPage.pressEnter();
        System.out.println("#info message after Press Enter");

        return new SearchResultsSteps();
    }

    public SearchSteps openTooltip() {
        searchPage.clickCookieOrNo();
        System.out.println("Cookie was clicked");
        searchPage.moveToVoiceSearchButton();
        return this;
    }

    public SearchSteps verifyThatTooltipContainsCorrectText(String text) {
        searchPage.assertThatVoiceSearchTooltipContainsText(text);
        return this;
    }

}
