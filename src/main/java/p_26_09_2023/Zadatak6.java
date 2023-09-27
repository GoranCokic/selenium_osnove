//6. Zadatak
//Ucitati stranicu https://cms.demo.katalon.com/
//Maksimizovati prozor
//Proveriri da li je je crno MENU dugme vidljivo (Ispisati poruke u konzoli). Izguglajte na koji nacin se proverava da li je neki element vidljiv na stranici.
//Prostavite duzinu prozora na 700px i visinu na 700px
//Proverite da li je crno MENU dugme vidljivo (Ispisati poruke u konzoli)

package p_26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");

        Dimension newSize = new Dimension(700, 700);
        driver.manage().window().setSize(newSize);

        Thread.sleep(5000);
        driver.quit();
    }
}
