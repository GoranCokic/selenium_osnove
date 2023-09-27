//Zadatak
//Napisati program koji:
//Ucitava stranicu https://demoqa.com/automation-practice-form
//Popunjava formu sta stranice. Korisnik unosi podatke sa tastature za popunu forme.
//(za vezbanje) Probajte da unese i datum. Sa datumom se radi isto kao i sa obicnim inputom sa sendKeys.
//Klik na submit

package d_26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        Scanner s = new Scanner(System.in);

        System.out.println("Unesite ime");
        driver.findElement(By.cssSelector("#firstName")).clear();
        driver.findElement(By.cssSelector("#firstName")).sendKeys(s.next());

        System.out.println("Unesite prezime");
        driver.findElement(By.cssSelector("#lastName")).clear();
        driver.findElement(By.cssSelector("#lastName")).sendKeys(s.next());

        System.out.println("Unesite email");
        driver.findElement(By.cssSelector("#userEmail")).clear();
        driver.findElement(By.cssSelector("#userEmail")).sendKeys(s.next());

        System.out.println("Unesite pol 1-musko 2-zensko 3-ostalo");
        int broj = s.nextInt();
        driver.findElement(By.xpath("//label[@for='gender-radio-" + broj + "']")).click();

        System.out.println("Unesite broj");
        driver.findElement(By.cssSelector("#userNumber")).clear();
        driver.findElement(By.cssSelector("#userNumber")).sendKeys(s.next());

//        System.out.println("Unos datuma: ");
//        System.out.println("Odaberite dan od 1 do 30");
//        int dan = s.nextInt();
//        System.out.println("Odaberte mesec od 1 do 12");
//        int mesec = s.nextInt();
//        System.out.println("Odaberite godinu od 1900 do 2100");
//        int godina = s.nextInt();
//        driver.findElement(By.cssSelector("#dateOfBirthInput")).click();
//        driver.findElement(By.cssSelector("#dateOfBirthInput")).clear();
//        driver.findElement(By.cssSelector("#dateOfBirthInput")).sendKeys(dan + " " + mesec + " " + godina);

        System.out.println("Unesite studentske predmete: (neki tekst)");
        driver.findElement(By.cssSelector("#subjectsInput")).click();
        driver.findElement(By.cssSelector("#subjectsInput")).clear();
        driver.findElement(By.cssSelector("#subjectsInput")).sendKeys(s.next());

        //stavljas fajl
        driver.findElement(By.cssSelector("#uploadPicture")).sendKeys("C:\\Users\\Goran\\Desktop");

        System.out.println("Odaberite neke od sledecih hobija 1-Sport 2-Citanje 3-Muzika 0-za kraj unosa hobija");
        for (int i = 0; i < 3; i++) {
            broj = s.nextInt();
            if (broj != 0) {
                driver.findElement(By.cssSelector("label[for='hobbies-checkbox-" + s.nextInt() + "']")).click();
            } else {
                i = 100;
            }
        }
        System.out.println("Unesite vasu adresu: ");
        driver.findElement(By.cssSelector("#currentAddress")).sendKeys(s.next());

        //cant click element due to advert
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        driver.quit();
    }
}