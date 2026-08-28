package gettingstarted;

import java.nio.file.Path;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileUploader {

	public static void main(String[] args) {
		
		Browser browser =Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://the-internet.herokuapp.com/upload");
		
		page.locator("#file-upload").setInputFiles(Path.of(System.getProperty("user.dir")+"\\Files\\a.jpeg"));
		
		

	}

}
