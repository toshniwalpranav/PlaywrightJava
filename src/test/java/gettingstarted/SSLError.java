package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SSLError {

	public static void main(String[] args) {
        
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        
		NewContextOptions contextOptions = new Browser.NewContextOptions();
		
		contextOptions.setIgnoreHTTPSErrors(true);
		
		BrowserContext context = browser.newContext(contextOptions);
		
		Page page = browser.newPage();
		page.navigate("https://expired.badssl.com");
		

	}

}
