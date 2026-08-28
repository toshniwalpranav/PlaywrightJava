
package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SSLError {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        NewContextOptions contextOptions =
                new Browser.NewContextOptions();

        contextOptions.setIgnoreHTTPSErrors(true);

        BrowserContext context =
                browser.newContext(contextOptions);

        // IMPORTANT: Create the page from the configured context
        Page page = context.newPage();

        page.navigate("https://expired.badssl.com/");


        page.waitForTimeout(5000);

        context.close();
        browser.close();
    }
}
