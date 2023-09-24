package p_22_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestExample {
    public static void main(String[] args) throws InterruptedException {
        // Postavljanje ChromeDriver koristeći WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Kreiranje instance ChromeDriver-a
        WebDriver driver = new ChromeDriver();
        // Otvaranje veb stranice
        driver.get("https://google.com");
        // Mesto za test kod ...

        Thread.sleep(5000); //wait 5 seconds
        driver.get("https://youtube.com");
        Thread.sleep(5000); //wait 5 seconds
        driver.get("https://youtube.com");
        Thread.sleep(5000); //wait 5 seconds

        // Zatvoranje pretrazivaca nakon sto se zavrsi testiranje
        driver.quit();
    }
}
