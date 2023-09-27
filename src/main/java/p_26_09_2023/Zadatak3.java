//3.Zadatak
//Napisti program koji:
//Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//Hvata sve elemente iz tabele i stampa tekst svakog elementa. Kako da od nekog elementa procitamo tekst imate na sledecem linku
//Ceka 5s
//Zatvara pretrazivac
//Stampa treba da bude kao u primeru:
//John	Doe	john@example.com
//Mary	Moe	mary@example.com
//July	Dooley	july@example.com
//
//HINT: bice vam lakse da radite ulancano trazenje. findElement().findELement()...

package p_26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://s.bootsnipp.com/iframe/z80en");

        driver.findElement(By.xpath("//a[@href='#lorem']")).click();

        WebElement prvaTabela = driver.findElement(By.xpath("//div[@id='lorem']//tbody"));
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                System.out.print(prvaTabela.findElement(By.xpath("tr[" + i + "]/td[" + j + "]")).getText());
                System.out.print(" ");
            }
            System.out.println();
        }
        driver.quit();
    }
}
