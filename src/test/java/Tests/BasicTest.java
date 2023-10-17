package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.time.Duration;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;

    @BeforeClass
    protected void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver,wait);
    }

    @BeforeMethod
    protected void beforeMethod() {
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    protected void afterMethod() throws InterruptedException {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor)(driver)).executeScript( String.format(
                "window.localStorage.removeItem('%s');", "cart-contents"));
    }

    @AfterClass
    protected void afterClass() {
        driver.quit();
    }
}
