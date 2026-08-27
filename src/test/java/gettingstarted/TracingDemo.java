package gettingstarted;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class TracingDemo {

	@Test
	public void LoginTest() {
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1500));
		  
		  BrowserContext context=browser.newContext();
          context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
		  
          Page page =context.newPage();
          
          page.navigate("https://freelance-learn-automation.vercel.app/login");

          String title = page.title();
          System.out.println("Page Title: " + title);

          PlaywrightAssertions.assertThat(page)
                  .hasTitle("Learn Automation Courses");

          page.locator("#email1").fill("admin@email.com");

          page.locator("#password1").fill("admin@123");

          page.locator("button[type='submit']").click();

          PlaywrightAssertions.assertThat(page.locator(".welcomeMessage"))
                  .containsText("Welcome");

          page.waitForTimeout(3000);

          page.getByAltText("menu").click();

          page.getByText("sign out").click();

          PlaywrightAssertions.assertThat(page)
                  .hasURL(Pattern.compile("login"));
          
          context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("Tracing.zip")));
          
          

	}

}
