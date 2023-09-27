package p_25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Uvod {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver hromdrajver = new ChromeDriver(); //ovo pravi drajver za chrome, moze bilo koji drugi browser
        hromdrajver.manage().window().maximize();


        hromdrajver.get("https://cms.demo.katalon.com/");
        //sada imas ucitanu stranicu otprilike... ima raznih ucitavanja

        //div[@id='primary-menu']/ul/li[1]/a
        //#primary-menu > ul > li:nth-child(1) > a

//        WebElement cartLink = hromdrajver.findElement(
//                By.xpath("div[@id='primary-menu']/ul/li[1]/a"));

//        WebElement cartLink = hromdrajver.findElement(
//                By.cssSelector("#primary-menu > ul > li:nth-child(1) > a"));

        hromdrajver.findElement(By.cssSelector("#username")).sendKeys("username"); //sad si uneo u polje sa idjem username, uneo si string "username"

        hromdrajver.quit();
    }
}
