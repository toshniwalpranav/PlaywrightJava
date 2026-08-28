package PageObjectModel;

import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class TestUsingPOM {

	
		@Test
		public void login()
		{
			Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();
			page.navigate("https://freelance-learn-automation.vercel.app/login");

	        page.locator("#email1").fill("admin@email.com");
	        page.locator("#password1").fill("admin@123");
	        page.locator("button[type='submit']").click();
	        page.waitForTimeout(3000);

	}

}
