package Pages2;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Username {

    private Locator usernameLocator;

    public Username(Page page) {
        usernameLocator = page.getByPlaceholder("Enter Email");
    }

    public void enterUsername(String username) {
        usernameLocator.fill(username);
    }
}