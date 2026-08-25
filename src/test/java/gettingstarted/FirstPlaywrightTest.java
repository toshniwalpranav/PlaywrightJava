package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstPlaywrightTest {
	
	public static void main(String args[])
	{
		Playwright pw = Playwright.create(); //create playwright instance
		BrowserType browserType = pw.chromium(); //browsertype
		//Browser browser = browserType.launch(); //browser instance
		Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false) );
		Page page = browser.newPage();
		page.navigate("https:ww.google.com");
		String title=page.title();
		System.out.println("title is " +title);
		page.close();
		browser.close();
		pw.close();
	}

}
