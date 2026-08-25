package gettingstarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import net.datafaker.Faker;

public class Pause_Faker_RegisterNewUser2 {
	
	public static void main(String args[])
	{
	
	//Browser browser = Playwright.create().chromium().launch();
	Browser browser = 	Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1500));
	
	Page page=browser.newPage();
	
	page.navigate("https://freelance-learn-automation.vercel.app/login");
	page.pause();
	
	page.getByText("New user? Signup").click();
	//page.locator(".submit-btn");
	PlaywrightAssertions.assertThat(page.locator(".submit-btn")).isDisabled();
	
	page.locator("#name").fill(new Faker().name().fullName());
	page.locator("#email").fill(new Faker().name().firstName()+"_"+new Faker().name().lastName()+"@gmail.com");
	page.locator("#password").fill("pranav12345");
	page.locator("xpath=//label[text()='Java']").click();
	//page.getByText("Selenium").click();
	PlaywrightAssertions.assertThat(page.locator("xpath=//label[text()='Java']")).isChecked();
	
	
	page.locator("xpath=//input[@value='Male']").click();
	PlaywrightAssertions.assertThat(page.locator("xpath=//input[@value='Male']")).isChecked();
	
	page.locator("#state").selectOption("Goa");
	
	page.mouse().wheel(0, 600);
	
	String hobbies[] = {"Playing","Swimming"};
	
	page.locator("#hobbies").selectOption(hobbies);

	PlaywrightAssertions.assertThat(page.locator(".submit-btn")).isEnabled();
	page.locator(".submit-btn").click();
	
	
	
	
	
	
	}
}
