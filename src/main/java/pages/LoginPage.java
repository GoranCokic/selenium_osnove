package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLoginForm(){
        return driver.findElement(By.cssSelector("[value='Login'"));
    }
    public void waitForErrorMessage(){
        wait
                .withMessage("|||TEXT: 'Epic sadface: Username is required' did not appear.")
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//h3[contains(text(),'Username is required')]")));
    }
}
