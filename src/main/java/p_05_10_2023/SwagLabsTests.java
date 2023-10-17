package p_05_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class SwagLabsTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    private void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    private void beforeMethod() {
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1, retryAnalyzer =  SwagLabsRetry.class)
    private void verifyErrorIsDisplayedWhenUsernameIsMissing() {
        driver.findElement(By.cssSelector("[value='Login']")).click();
        wait
                .withMessage("|||TEXT: 'Epic sadface: Username is required' did not appear.")
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//h3[contains(text(),'Username is required')]")));
    }

    @Test(priority = 2, retryAnalyzer =  SwagLabsRetry.class)
    private void verifyErrorIsDisplayedWhenPasswordIsMissing() {
        String username = "some user name";
        driver.findElement(By.cssSelector("[placeholder='Username']")).sendKeys(username);
        driver.findElement(By.cssSelector("[value='Login']")).click();
        wait
                .withMessage("|||TEXT: 'Epic sadface: Password is required' did not appear.")
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//h3[contains(text(),'Password is required')]")));
    }

    @Test(priority = 3, retryAnalyzer =  SwagLabsRetry.class)
    private void verifyErrorIsDisplayedWhenCredentialsAreWrong() {
        String username = "standard_user";
        String password = "invalidpassword";
        driver.findElement(By.cssSelector("[placeholder='Username']")).sendKeys(username);
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();
        wait
                .withMessage("|||TEXT: 'Epic sadface: Password is required' did not appear.")
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//h3[contains(text(),'Username and password do not match')]")));
    }

    @Test(priority = 4, retryAnalyzer =  SwagLabsRetry.class)
    private void verifyErrorIsDisplayedWhenUserIsLocked() {
        String username = "locked_out_user";
        String password = "secret_sauce";
        driver.findElement(By.cssSelector("[placeholder='Username']")).sendKeys(username);
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();
        wait
                .withMessage("|||TEXT: 'Epic sadface: Sorry, this user has been locked out.' did not appear.")
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//h3[contains(text(),'this user has been locked')]")));
    }

    @Test(priority = 5, retryAnalyzer =  SwagLabsRetry.class)
    private void verifySuccessfulLogin() {
        String username = "standard_user";
        String password = "secret_sauce";
        driver.findElement(By.cssSelector("[placeholder='Username']")).sendKeys(username);
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();
        wait
                .withMessage("|||login failed but it shouldn't have|||")
                .until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        driver.findElement(By.cssSelector("button#react-burger-menu-btn")).click();
        wait
                .withMessage("|||Side scrolling menu did not appear but it should have|||")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bm-menu-wrap")));
        wait
                .withMessage("|||logout button does not exist, but it should")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=logout_sidebar_link]")));
        driver.findElement(By.cssSelector("[id=logout_sidebar_link]")).click();

        wait
                .withMessage("|||after successful logout, user does not return to 'login form'")
                .until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));
    }

    @Test(priority = 6, retryAnalyzer =  SwagLabsRetry.class)
    private void addingProductsToCart() {
        String username = "standard_user";
        String password = "secret_sauce";
        driver.findElement(By.cssSelector("[placeholder='Username']")).sendKeys(username);
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();
        wait
                .withMessage("|||login failed but it shouldn't have|||")
                .until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();

        List<WebElement> listOfCartItems = driver.findElements(By.cssSelector("[class='cart_item']"));

        for (int i = 0; i < listOfCartItems.size(); i++) {
            Assert.assertTrue(listOfCartItems.get(i).findElement(
                    By.cssSelector("#remove-sauce-labs-backpack")).isDisplayed(),
                    "remove button does not appear, but it should");
        }

        wait
                .withMessage("|||remove button did not appear, but it should have|||")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#remove-sauce-labs-backpack")));
        wait
                .withMessage("|||item was not added to cart, but it should have been added")
                .until(ExpectedConditions.textToBe(By.cssSelector("span.shopping_cart_badge"), "1"));
    }

    @Test(priority = 7, retryAnalyzer =  SwagLabsRetry.class)
    private void viewingProductDetails() {
        String username = "standard_user";
        String password = "secret_sauce";
        driver.findElement(By.cssSelector("[placeholder='Username']")).sendKeys(username);
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();
        wait
                .withMessage("|||login failed but it shouldn't have|||")
                .until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        driver.findElement(By.cssSelector("#item_4_title_link")).click();
        wait
                .withMessage("|||name of product does not appear, but it should|||")
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@class='inventory_details_name large_size']")));
        wait
                .withMessage("|||description of product does not appear, but it should|||")
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@class='inventory_details_desc large_size']")));
        wait
                .withMessage("|||price of product does not appear, but it should|||")
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@class='inventory_details_price']")));
        wait
                .withMessage("|||'add to cart' button of product does not appear, but it should|||")
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("#add-to-cart-sauce-labs-backpack")));
    }

    @Test(priority = 8, retryAnalyzer =  SwagLabsRetry.class)
    private void removingProductsFromCart() {
        String username = "standard_user";
        String password = "secret_sauce";
        driver.findElement(By.cssSelector("[placeholder='Username']")).sendKeys(username);
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        wait
                .withMessage("|||item was not added to cart, but it should have been added")
                .until(ExpectedConditions.textToBe(By.cssSelector("span.shopping_cart_badge"), "1"));
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"))
                .getText()
                .equals("Sauce Labs Backpack"),
                "Item wasn't added, but it should have been added");
        driver.findElement(By.cssSelector("#remove-sauce-labs-backpack")).click();
        Assert.assertTrue(driver.findElements(By.cssSelector("div.cart_list div.cart_item")).size()==0,
                "|||Item wasn't removed, but it should have been removed|||");
}

    @Test(priority = 9, retryAnalyzer =  SwagLabsRetry.class)
    private void productCheckout() {
        String username = "standard_user";
        String password = "secret_sauce";
        String checkoutName = "Pera";
        String checkoutLastName = "Peric";
        String checkoutZip = "18000";
        driver.findElement(By.cssSelector("[placeholder='Username']")).sendKeys(username);
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        wait
                .withMessage("|||item was not added to cart, but it should have been added")
                .until(ExpectedConditions.textToBe(By.cssSelector("span.shopping_cart_badge"), "1"));
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        driver.findElement(By.cssSelector("#checkout")).click();
        driver.findElement(By.cssSelector("#first-name")).sendKeys(checkoutName);
        driver.findElement(By.cssSelector("#last-name")).sendKeys(checkoutLastName);
        driver.findElement(By.cssSelector("#postal-code")).sendKeys(checkoutZip);
        driver.findElement(By.cssSelector("#continue")).click();
        Assert.assertTrue(driver.findElement(
                By.xpath("//div[text()='Sauce Labs Backpack']")).getText().equals("Sauce Labs Backpack"),
                "Item wasn't added, but it should have been added");
        driver.findElement(By.cssSelector("#finish")).click();
        wait
                .withMessage("|||Message 'Thank you for your order!' does not appear")
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//h2[text()='Thank you for your order!']")));
    }

    @AfterMethod
    private void afterMethod() throws InterruptedException {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor)(driver)).executeScript( String.format(
                "window.localStorage.removeItem('%s');", "cart-contents"));
    }

    @AfterClass
    private void afterClass() {
        driver.quit();
    }
}
