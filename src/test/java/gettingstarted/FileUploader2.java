package gettingstarted;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileUploader2 {
	public static void main(String args[]) {
	
	Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page= browser.newPage();
	page.navigate("https://the-internet.herokuapp.com/upload");
	FileChooser filechooser=page.waitForFileChooser(() -> page.locator("#drag-drop-upload").click());
	filechooser.setFiles(Paths.get("C:\\Users\\HP\\Downloads\\a.jpeg"));

}
}
