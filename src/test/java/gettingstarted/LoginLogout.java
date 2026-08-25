package gettingstarted;

import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class LoginLogout {

	public static void main(String args[])
	{
		Browser browser = null;
		Page page = null;
		
		try
		{
			browser = 	Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
	        page=browser.newPage();
	        page.navigate("https://freelance-learn-automation.vercel.app/login");
	        String title = page.title();
	        PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
	       
	        page.locator("#email1").fill("admin@email.com");
	        page.locator("#password1").fill("admin@123");
	        //page.getByText("Sign in").click();
	        //page.getByText("Sign in").nth(1).click();
	        //page.getByText("Sign in").last().click();
	        page.locator("button[type='submit']").click();
	        PlaywrightAssertions.assertThat(page.locator(".welcomeMessage")).containsText("Welcome");
	        page.waitForTimeout(3000);
	        page.getByAltText("menu").click();
	        page.getByText("sign out").click();
	        PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("login"));
	        page.waitForTimeout(3000);
	 
		}
		finally
		{
			page.close();
			browser.close();
		}
	}
}
