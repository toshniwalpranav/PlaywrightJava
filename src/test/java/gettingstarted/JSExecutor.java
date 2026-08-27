package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JSExecutor {

	public static void main(String[] args) {
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
         page.navigate("https://login.yahoo.com/");
         System.out.println(page.locator("#persistent").boundingBox().height);
         System.out.println(page.locator("#persistent").boundingBox().width);
         //page.locator("#persistent").click();
         //page.evaluate("document.getElementById('persistent').click()");
         
         Locator checkbox = page.locator("#persistent");
         checkbox.evaluate("checkbox => checkbox.click()");
	}

}
