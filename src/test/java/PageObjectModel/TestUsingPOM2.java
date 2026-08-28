package PageObjectModel;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import Pages.LoginPage;

public class TestUsingPOM2 {


	@Test
	public void login()
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		LoginPage loginPage = new LoginPage(page);
		loginPage.loginToApplication("pranav@gmail.com","pranav12345");
		
	}
}
