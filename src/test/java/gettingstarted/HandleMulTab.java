package gettingstarted;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleMulTab {
	
	public static void main(String args[])
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page= browser.newPage();
		BrowserContext context=browser.newContext();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		
		Page newPage=context.waitForPage(()->
		{
			page.locator("//a[contains(@href,'facebook')]").first().click();
		});
		
		newPage.locator("//input[@name='email']").last().fill("pranav@gmail.com");
	}

}
