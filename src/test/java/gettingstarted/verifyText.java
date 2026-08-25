package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class verifyText 
{
	public static void main(String args[]) 
	{
	Browser browser = 	Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    Page page=browser.newPage();
    page.navigate("https://freelance-learn-automation.vercel.app/login");
    page.locator(".submit-btn").click();
    String expected ="Email and Password is required";
    String msg=page.locator(".errorMessage").textContent();
    System.out.println("Error msg is " +msg);
    PlaywrightAssertions.assertThat(page.locator(".errorMessage"));
    
    page.close();
    browser.close();
	}
}
