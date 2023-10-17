package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UrlPage extends BasicPage {
    protected String baseUrl = "https://www.saucedemo.com";


    public UrlPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForUrlToBeInventory() {
        wait
                .withMessage("|||login failed but it shouldn't have|||")
                .until(ExpectedConditions.urlToBe(baseUrl + "/inventory.html"));
    }

    public void waitForUrlToBeLoginForm() {
        wait
                .withMessage("|||after successful logout, user does not return to 'login form'")
                .until(ExpectedConditions.urlToBe(baseUrl));
    }
}
