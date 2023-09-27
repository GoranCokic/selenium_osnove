//Zadatak
//Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//Visit Paris
//Visit Prague
//Visit London
//Visit New York
//Visit Belgrade
//Maksimizirati prozor
//Ucitati stranicu https://example.cypress.io/todo
//Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//Nakon svakog unosa todo-a, unosi se enter. Koristan link
//Nakon svih unosa proci petljom kroz svaki todo koji je na stranici i za svaki cekirati da je completed.
//Cekanje od 5s
//Zatvorite pretrazivac

package d_25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://example.cypress.io/todo");
        driver.manage().window().maximize();

        String[] strings = {
                "Visit Paris",
                "Visit Prague",
                "Visit London",
                "Visit New York",
                "Visit Belgrade"
        };
        driver.findElement(By.cssSelector("input.new-todo")).click();
        Thread.sleep(500);
        for (int i = 0; i < strings.length; i++) {
            driver.findElement(By.cssSelector("input.new-todo")).sendKeys(strings[i]);
            driver.findElement(By.cssSelector("input.new-todo")).sendKeys(Keys.ENTER);
            Thread.sleep(500);
        }
        driver.quit();
    }
}
