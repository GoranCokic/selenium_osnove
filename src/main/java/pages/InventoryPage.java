package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class InventoryPage extends BasicPage {
    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getSideBurgerMenu() {
        return driver.findElement(By.cssSelector("button#react-burger-menu-btn"));
    }

    public void waitForBurgerMenuToFinishSliding() {
        wait
                .withMessage("|||Side scrolling menu did not appear but it should have|||")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bm-menu-wrap")));
    }

    public void waitLogoutButtonFromBurgerMenuToAppear() {
        wait
                .withMessage("|||logout button does not exist, but it should")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=logout_sidebar_link]")));
    }

    public WebElement getLogoutButtonFromBurgerMenu() {
        return driver.findElement(By.cssSelector("[id=logout_sidebar_link]"));
    }

    public WebElement getProductById(String selector) {
        return driver.findElement(By.cssSelector(selector));
    }

    public void didRemoveButtonOfItemAppear(String removeButtonProductId) {
        Assert.assertTrue(driver.findElement(By.cssSelector(removeButtonProductId)).isDisplayed(),
                "remove button does not appear, but it should");
    }

    public String getNumberOfItemsInCart() {
        return driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
    }
}
