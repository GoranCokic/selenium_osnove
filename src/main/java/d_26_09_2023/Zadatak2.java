//Zadatak
//Napisati program koji:
//Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//POMOC: Brisite elemente odozdo.
//(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

package d_26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://s.bootsnipp.com/iframe/Dq2X");
        driver.manage().window().maximize();

        Thread.sleep(1000);
        List<WebElement> webElements = driver.findElements(By.cssSelector("div.alert"));
        for (int i = 0; i < webElements.size(); i++) {
            System.out.println(webElements.get(webElements.size()-1-i).findElement(By.cssSelector("strong")).getText());
            webElements.get(webElements.size()-1-i).findElement(By.cssSelector("button")).click();
            Thread.sleep(1000);
        }
    }
}
