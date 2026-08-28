package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Locator usernameLocator;
	
	private Locator passwordLocator;
	
	private Locator submitbuttonLocator;
	
	public LoginPage(Page page) //constructor
	{
        usernameLocator = page.getByPlaceholder("Enter Email");
        passwordLocator = page.getByPlaceholder("Enter Password");
        submitbuttonLocator=page.locator(".submit-btn");
	}

	public void loginToApplication(String user, String pass)
	{
		usernameLocator.fill(user);
		passwordLocator.fill(pass);
		submitbuttonLocator.click();
	}
}
