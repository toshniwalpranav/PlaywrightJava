package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutomateSliders {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page= browser.newPage();
		page.navigate("https://jqueryui.com/slider/");
		FrameLocator framelocator = page.frameLocator(".demo-frame");
		Locator sliderLocator = framelocator.locator("//span[contains(@class,'ui-slider-handle')]");
		sliderLocator.focus();
		for(int i=0 ; i<10; i++)
		{
			page.keyboard().press("ArrowRight");
	    }

	}

}
