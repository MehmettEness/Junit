package J13_SeleniumWaits_exception;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class C02_ExpilicitiWait_FluentWait extends TestBase {

    @Test
    public void Test01() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorld=  driver.findElement(By.xpath("//h4[.='Hello World!']"));
        FluentWait<WebDriver> wait = new FluentWait<>(driver); //wait objesi üzerinden hazır methodlar kullanacağız

        wait.withTimeout(Duration.ofSeconds(20))//Fluent waitin max beklemesi gereken süreyi belirtiriz.
                .pollingEvery(Duration.ofMillis(200)) //Her 200 milisaniyede 1 vereceğim koşulu kontrol et
                .withMessage("Webelement ve sureyi kontrol et")//Eğer belirtilen sürede eger yine belirtilenkoşul gerçekleşmezse buradaki
                                                               // hata mesajı TimeOutException hatası ile bu yazı görünür.
                .until(ExpectedConditions.visibilityOf(helloWorld));//Helloworld elementinin görününr olup olmadığını kontrol eder.

        Assert.assertEquals("Hello World!" , helloWorld.getText());

    }
    //////////////2.yol

    @Test
    public void Test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorld=  driver.findElement(By.xpath("//h4[.='Hello World!']"));
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(200))
                .withMessage("Webelement ve sureyi kontrol et")
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[.='Hello World!']")));

        Assert.assertEquals("Hello World!" , helloWorld.getText());

    }
}
