package common;

public class Config {

    /**
     * Specify for browser and platform for test:
     * CHROME_MAC
     * CHROME_WINDOWS
     * MOZILLA_MAC
     **/
    public static final String BROWSER_AND_PLATFORM = "CHROME_MAC";

    /** Clean browser cookie after each iteration */
    public static final Boolean CLEAR_COOKIES = false;

    /** To keep the browser open after all scenario/tests */
    public static final Boolean HOLD_BROWSER_OPEN = true;

    /** Clear the reports-directory before starting the build */
    public static final Boolean CLEAR_REPORTS_DIR = true;
}
