package Pages2;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Password {

    private Locator passwordLocator;

    public Password(Page page) {
        passwordLocator = page.getByPlaceholder("Enter Password");
    }

    public void enterPassword(String password) {
        passwordLocator.fill(password);
    }
}