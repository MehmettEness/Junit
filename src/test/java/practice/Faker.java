package practice;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Faker extends TestBase {

    @Test
    public void name() {

        com.github.javafaker.Faker faker = new com.github.javafaker.Faker();


        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //"create new account" butonuna basin
        driver.findElement(By.xpath("//a[.='Yeni hesap oluştur']")).click();

        //"firstName" giris kutusuna bir isim yazin
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName() , Keys.TAB , faker.name().lastName() , Keys.TAB , faker.number().digits(11) , Keys.TAB , faker.internet().password() ,
        Keys.TAB , Keys.TAB);

        WebElement gun = driver.findElement(By.xpath("//select[@id='day']"));
        selectIndex(gun , 10);
        WebElement ay = driver.findElement(By.xpath("//select[@id='month']"));
        selectIndex(ay , 3);
        WebElement yil = driver.findElement(By.xpath("//select[@id='year']"));
        selectVisible(yil , "2010");

        driver.findElement(By.xpath("(//input[@name='sex'])[1]")).click();
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

    }

    }



