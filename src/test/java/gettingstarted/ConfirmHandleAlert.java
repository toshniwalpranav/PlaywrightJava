package gettingstarted;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ConfirmHandleAlert {
	
	public static void main(String args[])
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page= browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		page.onceDialog(dialog ->{
			
			String msg=dialog.message();
			System.out.println("Dialig text is " +msg);
			Assert.assertTrue(msg.contains("I am a JS Confirm"));
			dialog.accept();
			//dialog.dismiss();
			});

		page.locator("//button[text()='Click for JS Confirm']").click();
	}

}
