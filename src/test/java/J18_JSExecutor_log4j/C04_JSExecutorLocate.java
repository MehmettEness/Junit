package J18_JSExecutor_log4j;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C04_JSExecutorLocate extends TestBase {

    @Test
    public void test01() {
        //https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html   adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");

        //Hello Shadow DOM elementini locate edelim
        // bu locate xpath ile bulunamıyor.Çünkü ana dokümandan izole edilmiştir

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        /*
        // document.getElementById("content");
        locateini alamadığımız yazı Hello Shadow DOM nın locate'i
        Peki nasıl aldık;
        Locate edeceğimiz kısmı incele dedik, ancak oranın locatei yok o yüzden altta script yazan kısımdan aldık
         */

        WebElement helloShadowDOM = (WebElement) jse.executeScript("return document.getElementById('content');");

        Assert.assertEquals("Hello Shadow DOM" , helloShadowDOM.getText());




    }

    @Test
    public void name() {

        //amazona git
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //aramaya selenium yaz
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium");

        //arama kutusuna başarılı bir şekilde yazinin gönderildiğini tespit et
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        String searchBoxValue = jse.executeScript("return document.getElementById('twotabsearchtextbox').value").toString();
        //twotabsearchtextbox locateine yazdığımız webelementin değerini(value) getir dedik.

        System.out.println("searchBoxValue = " + searchBoxValue);

        Assert.assertEquals("selenium" , searchBoxValue);


        //twotabsearchtextbox type değerini getir dedik
        String typeAttributeDegeri = jse.executeScript("return document.getElementById('twotabsearchtextbox').type").toString();
        System.out.println("typeAttributeDegeri = " + typeAttributeDegeri);


        //twotabsearchtextbox className değerini getir dedik
        String classnameAttributeDegeri = jse.executeScript("return document.getElementById('twotabsearchtextbox').className").toString();
        System.out.println("classnameAttributeDegeri = " + classnameAttributeDegeri);

        //twotabsearchtextbox name değerini getir dedik
        String nameAttributeDegeri = jse.executeScript("return document.getElementById('twotabsearchtextbox').name").toString();
        System.out.println("nameAttributeDegeri = " + nameAttributeDegeri);


    }


}
