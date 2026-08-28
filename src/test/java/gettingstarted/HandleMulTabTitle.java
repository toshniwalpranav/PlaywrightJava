package gettingstarted;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleMulTabTitle {

	public static void main(String[] args) {

		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");

		Locator allLinks = page.locator("//div[@class='social']//a");
		for (int i = 0; i < allLinks.count(); i++) {
			allLinks.nth(i).click();
		}

		List<Page> allPages = context.pages();
		for (Page p : allPages) {
			String title = p.title();

			if (title.contains("Facebook")) {
				p.bringToFront();
				p.locator("//input[@name='email']").last().fill("pranav@gmail.com");
				break;
			}
		}

		page.bringToFront();
		page.getByPlaceholder("Enter Email").fill("pranav@gmail.com");

		context.close();
		browser.close();
	}

}