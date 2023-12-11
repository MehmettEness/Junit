package J13_SeleniumWaits_exception;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExpilicitWait_WebDriverWait extends TestBase {

    /*
    SELENIUM WAIT

        1- Implicitly Wait;
            Driver'i bir sayfaya gittikten sonra sayfadaki
            tüm webelementler ile etkileşime girebilmesi için belirtmis olduğumuz maksimum süre kadar beklletir.

        2- Expilicit Wait;

             a- WebdriverWait ;
                Sayfa yüklendikten sonra bir webelementin etkileşime girebilmesi için max. belirtmiş olduğumuz süre kadar
                ve default olarak yarım saniyelik aralıklarla bekler.

                  Ornegin bir webelemente tikladiktan sonra cikan bir webelement yada bir alert cikmasi testimizi
                  calistirirken farkli sürelerde olusabilir, Bu süreyi tam olarak belirleyemedigimizden dolayi
                  Thread.sleep () kullanmak profosyonelce olmaz.
                  Bu gibi durumlarda Webdriver wait ile bir webelementin olusmasini bekletmek daha profosyonel ve
                  dynamic olur

             b- Fluent Wait;
                Bir webelementin sayfa yüklendikten sonra etkileşime geçebilmesi için max. belirtilen süre kadar yine belirtebileceğimiz aralıklarla bekler.
     */

    /*
    Ana Farklar:

 1. Implicit Wait, tüm sayfa için genel bir bekleme süresi belirlerken, Explicit Wait belirli bir koşulu karşılayana kadar bekler.

 2. Implicit Wait, bir kere tanımlandığında tüm WebDriver işlemleri boyunca geçerli olur. Explicit Wait ise belirli bir bekleme süresini sadece ihtiyaç duyulan yerlerde kullanmanıza olanak tanır.

 3. Explicit Wait, daha esnek ve spesifik bekleme stratejileri uygulamanıza olanak tanır, bu da test senaryolarını daha güçlü ve güvenilir hale getirebilir.
     */

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et

        /*
        1-Hello World! webelementi görünür olana kadar beklemek için bu webelementi locate ettik
        2-WebDriverWait objesi oluştururuz ve constructor parantezi içinde driver ve Duration olarak Drivere max. ne kadar bekletilsin bunu belirtiriz.
        3-wait objemiz üzerinden senaryoya özel methodu seçiyoruz ve yarım saniyelik aralıklarla kontrol ederek beklediğimiz koşulun gerçekleşmesini bekliyoruz

        ==> Boylece koşul gercekleşmesi durumunda driver , fazla bekletmeyerek dynamic bekleme yapmış oluruz
         */

       WebElement helloWorld=  driver.findElement(By.xpath("//h4[.='Hello World!']"));

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOf(helloWorld)); //helloworld elementi görünür olana kadar beklett.
                                                                    //visibilityOf = Görünür olana kadar


    }
    ////////////////2.yol

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et

        WebElement helloWorld = new WebDriverWait(driver , Duration.ofSeconds(20))
                        .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//h4[.='Hello World!']"))); //visibilityOfElementLocated = Parantez içindeki locate görünür olana kadar bekle dedik

        Assert.assertEquals("Hello World!" , helloWorld.getText());

    }

    @Test
    public void test03() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
       driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h4[.='Hello World!']")));
        Assert.assertEquals("Hello World!" , element.getText());




    }
}
