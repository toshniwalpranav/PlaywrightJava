package gettingstarted;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class KeyboardDemo {

	@Test
    public void test(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1500));

        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://freelance-learn-automation.vercel.app/login");
        page.waitForLoadState();

        page.locator("#email1").fill("admin@gmail.com");

        page.keyboard().down("Control");
        page.keyboard().press("a");
        page.keyboard().up("Control");

        page.keyboard().down("Control");
        page.keyboard().press("c");
        page.keyboard().up("Control");

        page.keyboard().press("Tab");

        page.keyboard().down("Control");
        page.keyboard().press("v");
        page.keyboard().up("Control");

        context.close();
        browser.close();
        playwright.close();
    }
}