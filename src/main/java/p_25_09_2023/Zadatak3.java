//3. Zadatak
//Napisati program koji:
//Ucitava stranicu https://demoqa.com/text-box
//Unosi informacije za 3 osobe koristeci petlju
//Full Name
//Email
//Current Address
//Permanent Address
//Klik na submit
//Ceka 2 sekunde
//Osvezava stranicu
//Zatvara pretrazivac

package p_25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

    }
}
