package gettingstarted;

import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitUntilState;

public class HandleFrames {

	public static void main(String[] args) {

		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

		Page page = browser.newPage();

		page.navigate("https://www.redbus.in/", new Page.NavigateOptions()
				.setWaitUntil(WaitUntilState.DOMCONTENTLOADED)
				.setTimeout(60000));

		Locator accountBtn = page.locator("//*[contains(., 'Account')]").first();
		accountBtn.waitFor(new Locator.WaitForOptions().setTimeout(15000));
		accountBtn.click();

		page.waitForTimeout(2000);
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("after_account_click.png")).setFullPage(true));

		Locator loginBtn = page.locator("//*[contains(., 'Login')]").first();
		loginBtn.waitFor(new Locator.WaitForOptions().setTimeout(15000));
		loginBtn.click();

		List<Frame> allFrames = page.frames();
		System.out.println("Total number of frames " + allFrames.size());

		FrameLocator frame = page.frameLocator("//iframe[@class='modalIframe']");
		frame.locator("//input[@id='mobileNoInp']").fill("8844552233");

		page.close();
		browser.close();

	}

}