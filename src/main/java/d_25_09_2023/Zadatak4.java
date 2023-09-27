//Zadatak
//Maksimizirati prozor
//Ucitati stranicu https://artplayer.org/
//U fokusu je player sa desne strane
//Ceka 3-4s
//Klik na play dugme
//Klik na na zvucnik za mute
//Ceka 3s
//Klik na screenshot
//Klik na PIP mode
//Ceka 1s
//Klik na Exit PIP mode
//Klik na WebFullscreen
//Klik na Exit WebFullscreen
//Cekanje od 5s
//Zatvorite pretrazivac

package d_25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://artplayer.org/");
        driver.manage().window().maximize();
        Thread.sleep(4000);

        driver.findElement(By.cssSelector("i.art-icon-play>svg>path")).click(); //click on play

        driver.findElement(By.cssSelector("i.art-icon-volume>svg>path")).click(); //click on volume to mute
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("i.art-icon-screenshot>svg")).click(); //click on screenshot
        driver.findElement(By.cssSelector("i.art-icon-pip>svg")).click(); //click on enter pip mode
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("i.art-icon-pip>svg")).click(); //click on exit pip mode
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("i.art-icon-fullscreenWebOn")).click(); //click on fullscreen mode
        Thread.sleep(500);
        driver.findElement(By.cssSelector("i.art-icon-fullscreenWebOff")).click(); // exit fullscreen mode
        Thread.sleep(5000);

        driver.quit();
    }
}
