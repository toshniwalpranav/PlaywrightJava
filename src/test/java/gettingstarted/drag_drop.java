package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class drag_drop {

	public static void main(String[] args) {
	
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page= browser.newPage();
		page.navigate("https://jqueryui.com/droppable/");
		FrameLocator frameLocator = page.frameLocator(".demo-frame");
		frameLocator.locator("#draggable").dragTo(frameLocator.locator("#droppable"));
		/*
		frameLocator.locator("#draggable").hover();
		page.mouse().down();
		frameLocator.locator("#droppable").hover();
		page.mouse().up();
         */
	}

}
