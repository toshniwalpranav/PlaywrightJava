package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleAutoSuggestion {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.google.com");

		page.locator("xpath=//textarea[@title='Search']")
			.pressSequentially("pranav", new Locator.PressSequentiallyOptions().setDelay(100));
		page.waitForTimeout(1500);

		Locator locator = page.locator("xpath=//ul[@role='listbox']//li");
		int count = locator.count();
		System.out.println("Total suggestions: " + count);

		for (int i = 0; i < count; i++) {
			String text = locator.nth(i).innerText().trim();
			if (!text.isEmpty()) {
				System.out.println((i + 1) + ": " + text);
			}
		}


	}

}