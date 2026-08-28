package PageObjectModel1;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import Pages2.Password;
import Pages2.Username;

public class TestUsingPOM3 {

    @Test
    public void login() {

        Playwright pw = Playwright.create();

        Browser browser = pw.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        Page page = browser.newPage();

        page.navigate("https://freelance-learn-automation.vercel.app/login");

        Username username = new Username(page);
        Password password = new Password(page);

        username.enterUsername("admin@gmail.com");
        password.enterPassword("admin@123");

        page.locator(".submit-btn").click();

        browser.close();
        pw.close();
    }
}