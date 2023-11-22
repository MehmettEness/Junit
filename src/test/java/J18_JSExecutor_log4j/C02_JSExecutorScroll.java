package J18_JSExecutor_log4j;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C02_JSExecutorScroll extends TestBase {

    @Test
    public void test01() {

        //https://testpages.herokuapp.com/ adresine gidiniz
        driver.get("https://testpages.herokuapp.com/");

        //Challenges a kadar scroll yapiniz
        WebElement challScroll = driver.findElement(By.xpath("//h2[.='Challenges']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)" , challScroll); //true olduğunda ekran üstünde -- false yaptığımızda ekran altında görürüz

    }

    @Test
    public void test02() {
        //techproya git
        driver.get("https://techproeducation.com");

        //sayfa en altına git
        JavascriptExecutor jse = (JavascriptExecutor) driver;

       // jse.executeScript("window.scrollTo(0,2222)"); //bu değerleri istediğimiz gibi yazarız. Bu değer koordinat gibi düşünebiliriz.  (x, y koordinatları gibi.) Yani sayfanın bir kısmına kadar gelir.

        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //bu sayfanın tamamının yüksekliğini al tamamını ver dedik
    }

    @Test
    public void test03() {
        driver.get("https://techproeducation.com");

        //sayfanın en altına gidelim
        JS_ScrollToEnd(); //testbase de oluşturduk

        waitForSecond(2);

        //sayfanın en üstüne çıkalım
        JS_ScrollToHome(); //testbase de oluşturduk

    }
}
