//7. Zadatak (ZA VEZBANJE)
//Ucitati stranicu https://netoglasi.rs/
//Ispisati sve nazive kategorija iz leve navigacije
//Validirati da je kategorija Automobili na prvom mestu
//Klik na kategoriju Automobili
//Validarati da je kategorija Automobili izbacena iz liste.

package p_26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak7 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://netoglasi.rs/");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        List<WebElement> categories = driver.findElements(By.cssSelector("ion-list.category-list > app-category-picker-item"));
        for (int i = 0; i < categories.size(); i++) {
            System.out.println(categories.get(i).findElement(By.cssSelector("a")).getText());
        }
        driver.quit();
    }
}
