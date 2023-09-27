//Zadatak
//Napisati program koji vrsi dodavanje 5 redova
//Maksimizirati prozor
//Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//Dodati 5 redova sa istim podacima.Jedan red u jednoj iteraciji
//Klik na dugme Add New
//Unesite name,departmant i phone (uvek iste vrednost)
//Trazenje po name atributu
//Kliknite na zeleno Add dugme.
//PAZNJA: Pogledajte strukturu stranice i videcete da se u svakom redu poslednje kolone javljaju dugmici edit, add, delete ali zbog prirode reda neki dugmici se vide a neki ne.
//Morate da dohvatite uvek Add dugme iz poslednjeg reda tabele. Mozete koristeci index iz petlje, a mozete koristeci i last() fukncionalnost za xpath. Koristan link last mehnizma
//Cekanje od 0.5s
//Na kraju programa ugasite pretrazivac.

package d_25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
        driver.manage().window().maximize();

        String[] values = {
                "Name and Surname",
                "Company",
                "phone number"
        };

        driver.findElement(By.cssSelector("button[type='button']")).click();
        for (int k = 0; k < 5; k++) {
            Thread.sleep(500);
            List<WebElement> polja = driver.findElements(By.cssSelector("table[class='table table-bordered'] input"));
            for (int i = 0; i < polja.size(); i++) {
                polja.get(i).sendKeys(values[i]);
                Thread.sleep(500);
            }
            driver.findElement(By.xpath("//table/tbody//tr[last()]//a[@class='add']")).click();
            Thread.sleep(500);
            driver.findElement(By.cssSelector("button[type='button']")).click();
        }
        driver.quit();
    }
}
