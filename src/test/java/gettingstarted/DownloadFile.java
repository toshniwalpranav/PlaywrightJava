package gettingstarted;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadFile {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/download");

		Download download = page.waitForDownload(() -> {
			page.locator("//a[text()='test-file.txt']").click();
		});

		String downloadpath = System.getProperty("user.dir") + "/downloadfiles/" + download.suggestedFilename();
		System.out.println("Download path would be " + downloadpath);
		download.saveAs(Paths.get(downloadpath));
		System.out.println("Suggested filename: " + download.suggestedFilename());
		System.out.println("Download URL: " + download.url());

		browser.close();
		playwright.close();
	}
}