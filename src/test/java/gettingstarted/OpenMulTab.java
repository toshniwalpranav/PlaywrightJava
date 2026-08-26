package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class OpenMulTab {
	public static void main(String args[])
	{
	
	Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	BrowserContext context = browser.newContext();
	Page page=context.newPage();
	page.navigate("https://freelance-learn-automation.vercel.app/login");
    page.locator("//div[@class='social']//a");
    Locator allLinks=page.locator("//div[@class='social']//a");
    for(int i=0; i<allLinks.count();i++)
    {
    	allLinks.nth(i).click();
    }
    
   
}
}
