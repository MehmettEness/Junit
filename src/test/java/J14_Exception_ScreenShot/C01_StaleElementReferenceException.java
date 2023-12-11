package J14_Exception_ScreenShot;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.security.KeyFactorySpi;

public class C01_StaleElementReferenceException extends TestBase {
    /*
/*
StaleElementReferenceException
==>Bu hatayi neden aliriz?
    Bir sayfadaki bir webelementi locate ettikten ve bunu bir webelement seklinde store ettikten sonra o sayfada
    herhangi bir yenileme islemi yapildiginda (navigate.refresh(), back(), forward()) locate ini aldigimiz webelementi
    tekrar kullanmnak istersek bu exceptionu aliriz

==>Bu hatayi nasil handle ederiz?
    Bu exceptionu handle edebilmek icin elementin locate ini refresh(), back(), forward() gibi methodlar kullandiktan
    sonra tekrar almamiz gerekir
 */

    /*
    ==> InvalidSelectorException -> Belirtilen bir locator gecersiz oldugunda ortaya cikar
    ==> WebDriverException -> Webdriver ile ilgili kurulum, yada versiyon uyumsuzluklari
    ==> ElementClickInterceptedException ->Bir webelementin baska bir webelement(pop-up, reklam) tarafindan engellenmesi
    ==> ElementNotInteractable -> Bir webelement uzerinde cesitli islemler yapmaya elverisli degilse
    ==> InvalidArgumentException -> Bakiniz test methodu 3. gecersiz datanin methoda gönderilmesi
     */



    @Test
    public void test01() {
        Actions actions = new Actions(driver);

        //amazona gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        //arama kutusuna laptop aratalım
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");
        searchBox.submit();

        //ana sayfaya dönelim
        driver.navigate().back();

        //arama kutusuna desktop aratalım
        WebElement searchBox2 = driver.findElement(By.id("twotabsearchtextbox"));
        //aslında yukardakiyle her ikiside aynı ancak site geri gittiğinde searchBox tek kullanımlıkmış gibi davranıyor.

       // searchBox.sendKeys("desktop");
       // searchBox.submit();
        searchBox2.sendKeys("desktop");
        searchBox2.submit();
        actions.sendKeys(Keys.END).perform();
    }
}
