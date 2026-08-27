package gettingstarted;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class video {

    public static void main(String args[]) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1500));
        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions()
                        .setRecordVideoSize(500, 500)
                        .setRecordVideoDir(Paths.get("Videos/")));
        Page page = context.newPage();
        page.navigate("https://freelance-learn-automation.vercel.app/login");

        page.locator("#email1").fill("admin@email.com");

        page.close();
        context.close();
        browser.close();
        
    }
}