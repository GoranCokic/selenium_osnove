//Napisati program koji:
//ima niz od 5 stringova. Svaki element u nizu je url stranice:
//https://www.google.com/
//https://www.facebook.com/
//https://www.youtube.com/
//https://www.ebay.com/
//https://www.katalon.com/
//zatim koristeci for petlju otvara svaku stranicu iz niza u pretrazivacu prateci sledeca pravila:
//za svaku stranicu se kreira nova infrastuktura
//ucitava stranica
//pravi pauza od 1s
//ponistava testna stuktura

package d_22_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        String[] urlArray = {
                "https://www.google.com/",
                "https://www.facebook.com/",
                "https://www.youtube.com/",
                "https://www.ebay.com/",
                "https://www.katalon.com/"};

        for (int i = 0; i < urlArray.length; i++) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get(urlArray[i]);
            Thread.sleep(1000);
            driver.quit();
        }
    }
}
