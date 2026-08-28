package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Frames {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(1000)
        );

        Page page = browser.newPage();

        // Open Redbus
        page.navigate("https://www.redbus.in/");

        // Click Account
        page.locator("//*[contains(., 'Account')]")
                .first()
                .click();

        // Click Login
        page.locator("//*[contains(., 'Login')]")
                .first()
                .click();

        // Print all available frames
        System.out.println("Number of frames: " + page.frames().size());

        for (Frame frame : page.frames()) {
            System.out.println("Frame URL: " + frame.url());
        }

        // Wait for an iframe
        page.locator("iframe").first().waitFor();

        // Get the first iframe
        FrameLocator frame = page.frameLocator("iframe").first();

        // Enter mobile number
        frame.locator("#mobileNoInp").fill("8844552233");

        System.out.println("Mobile number entered successfully.");

        // Keep browser open for a few seconds
        page.waitForTimeout(5000);

        browser.close();
        playwright.close();
    }
}