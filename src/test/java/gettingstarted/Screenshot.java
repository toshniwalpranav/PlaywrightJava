		package gettingstarted;

		import java.nio.file.Paths;
		import java.util.Base64;

		import com.microsoft.playwright.Browser;
		import com.microsoft.playwright.BrowserType;
		import com.microsoft.playwright.Locator;
		import com.microsoft.playwright.Page;
		import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitUntilState;



public class Screenshot {

	public static void main(String[] args) {



				Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

				Page page = browser.newPage();

				page.navigate("https://www.naukri.com/", new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));

				page.locator("//a[@title='Jobseeker Login']").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("ElementScreenshot.png")));

				//byte[] arr=page.screenshot();

				byte[] arr = page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("Screenshot2.png")));

				System.out.println(Base64.getEncoder().encodeToString(arr));

				page.close();

				browser.close();

			}

		}
		// TODO Auto-generated method stub




