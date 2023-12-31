//Napisati program koji:
//ima niz od 5 stringova. Svaki element u nizu je url stranice:
//https://www.google.com/
//https://www.facebook.com/
//https://www.youtube.com/
//https://www.ebay.com/
//https://www.katalon.com/
//kreira testnu infrastukturu
//zatim koristeci for petlju otvara svaku stranicu iz niza u pretrazivacu i pritom pravi pauzu od 2 sekunde izmedju svaka dva ucitanja stranice
//Na kraju program ponisava testnu ifrastukturu

package d_22_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        String[] urlArray = {
                "https://www.google.com/",
                "https://www.facebook.com/",
                "https://www.youtube.com/",
                "https://www.ebay.com/",
                "https://www.katalon.com/"};
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        for (int i = 0; i < urlArray.length; i++) {
            driver.get(urlArray[i]);
            Thread.sleep(2000);
        }
        driver.quit();
    }
}
