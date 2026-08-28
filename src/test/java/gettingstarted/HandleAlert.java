package gettingstarted;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleAlert {

	public static void main(String[] args) {
		
		
		Browser browser= Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1500));
		Page page= browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		page.onceDialog(dialog ->{
			
		String msg=dialog.message();
		System.out.println("Dialig text is " +msg);
		Assert.assertTrue(msg.contains("I am a JS Alert"));
		dialog.accept();
		});
		page.locator("//button[normalize-space()='Click for JS Alert']").click();
		

	}

}
