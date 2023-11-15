package J13_SeleniumWaits_exception;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C04_TimeOutException extends TestBase {

    /*
    TimeOutException..

    Explicit Wait kullanıldıgında ve webelement bulunamadıgında alınan hatadır.
    implicitwait de süre yeterli olmazsa NosuchelemnetException alırız.

    Eger TimeOutException alıyorsak
    1- Explicit waitte kullandıgımız maksimum süreyi kontrol etmeliyiz.
    2- Explicit waitte almış oldugumuz locatei kontrol etmeliyiz.
    3- Explicit waitte kullandığımız methodu kontrol etmeliyiz.
    4- Explicit waitte aldığımız locate iframe içinde olabilir.
     */

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et


        WebElement helloWorld=  driver.findElement(By.xpath("//h4[.='Hello World!']"));

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(2));

        wait.until(ExpectedConditions.visibilityOf(helloWorld));




    }
    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et


       // WebElement helloWorld=  driver.findElement(By.xpath("//h4[.='Hello World!']"));

        WebElement helloWorld = new WebDriverWait(driver , Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("YANLIŞ LOCATE"))); //yanlış locate sonucu oluşan hata
        Assert.assertEquals("Hello World!" , helloWorld.getText());



    }

}
