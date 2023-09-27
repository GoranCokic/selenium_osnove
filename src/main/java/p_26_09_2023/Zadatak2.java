//2.Zadatak
//Napisti program koji:
//Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//Hvata sve elemente prve kolone i stampa tekst svakog elementa. Kako da od nekog elementa procitamo tekst imate na sledecem linku
//Ceka 1s
//Hvata sve elemente prvog reda i stampa tekst svakog elementa
//Ceka 5s
//Zatvara pretrazivac

package p_26_09_2023;

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
        driver.navigate().to("https://s.bootsnipp.com/iframe/z80en");

        WebElement contentBox = driver.findElement(By.xpath("//div[@class='content_box']"));
        WebElement tabela1Levo = contentBox.findElement(By.xpath("//a[@href='#lorem']"));
        tabela1Levo.click();
        WebElement prviRedDesno = contentBox.findElement(By.cssSelector("table.table>tbody :nth-child(1)"));
        for (int i = 1; i <= 3; i++) {
            WebElement prviRedDesnoPreciznije = prviRedDesno.findElement(By.xpath("td[" + i + "]"));

            System.out.println(prviRedDesnoPreciznije.getText());
            Thread.sleep(2000);
        }
        driver.quit();
    }
}
