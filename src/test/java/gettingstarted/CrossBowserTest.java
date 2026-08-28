
package gettingstarted;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CrossBowserTest {

    Browser browser;
    Page page;
    Playwright pw;

    @Parameters("BrowserName")
    @BeforeMethod
    public void setup(@Optional("Chrome") String browserName) {

        pw = Playwright.create();

        BrowserType browserType;

        if (browserName.equalsIgnoreCase("Chrome")) {

            browserType = pw.chromium();

        } else if (browserName.equalsIgnoreCase("Firefox")) {

            browserType = pw.firefox();

        } else if (browserName.equalsIgnoreCase("Safari")) {

            browserType = pw.webkit();

        } else {

            throw new IllegalArgumentException(
                "Invalid browser name: " + browserName
            );
        }

        browser = browserType.launch(
            new BrowserType.LaunchOptions().setHeadless(false)
        );

        page = browser.newPage();
    }

    @Test
    public void test() {

        page.navigate(
            "https://freelance-learn-automation.vercel.app/login"
        );

        System.out.println(page.title());
    }

    @AfterMethod
    public void tearDown() {

        page.close();
        browser.close();
        pw.close();
    }
}

