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

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector("[value='Login'"));
    }

    public void waitForErrorMessageUsername() {
        wait
                .withMessage("|||TEXT: 'Epic sadface: Username is required' did not appear.")
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//h3[contains(text(),'Username is required')]")));
    }

    public WebElement getUsernameInputField(){
        return driver.findElement(By.cssSelector("[placeholder='Username']"));
    }

    public void waitForErrorMessagePassword(){
        wait
                .withMessage("|||TEXT: 'Epic sadface: Password is required' did not appear.")
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//h3[contains(text(),'Password is required')]")));
    }
}
