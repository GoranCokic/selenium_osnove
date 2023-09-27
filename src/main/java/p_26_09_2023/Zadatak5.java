//5. Zadatak
//Napisati program koji ucitava stranicu http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.
//Na kraju programa proverite da li je element cekiran. Izguglajte kako mozemo da proverimo da li je element cekiran.

package p_26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://cms.demo.katalon.com/my-account/");

        WebElement box = driver.findElement(By.xpath("//input[@type='checkbox']"));
        box.click();
        if (box.isSelected()){
            System.out.println("is selected");
        }else{
            System.out.println("isnt selected");
        }
        driver.quit();
    }
}
