package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class wait {

	public static void main(String[] args) {
		Browser browser = 	Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        Page page=browser.newPage();
        //page.navigate("https://freelance-learn-automation.vercel.app/login");
        page.navigate("https://freelance-learn-automation.vercel.app/login",new Page.NavigateOptions().setTimeout(1000));
        
        page.setDefaultTimeout(1000);
        
        page.locator("#mukesh").click();
        
        

	}

}
