package practice;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSExecutor extends TestBase {
    @Test
    public void test01() {
        driver.get("https://amazon.com");
        //driver.navigate().refresh();
        //driver.navigate().refresh();
        waitForSecond(4);
        WebElement giftCardsLink = driver.findElement(By.xpath("(//*[text()='Gift Cards'])[1]"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();" , giftCardsLink);

        driver.get("https://testpages.herokuapp.com/");
        //Challenges a kadar scroll yapiniz
        WebElement challScroll = driver.findElement(By.xpath("//h2[.='Challenges']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)" , challScroll); //true olduğunda ekran üstünde -- false yaptığımızda ekran altında görürüz

        //sayfa en altına git


        // jse.executeScript("window.scrollTo(0,2222)"); //bu değerleri istediğimiz gibi yazarız. Bu değer koordinat gibi düşünebiliriz.  (x, y koordinatları gibi.) Yani sayfanın bir kısmına kadar gelir.

        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //bu sayfanın tamamının yüksekliğini al tamamını ver dedik


    }
    @Test
    public void test02() {
        //amazona gidelim
        driver.get("https://amazon.com");

        //jsexecutor ile arama kutusuna selenium yazdıralım
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='selenium'",searchBox);

        searchBox.submit();

        /*
        Eğer sendkeys ile bir webelemente text gönderemezsek yukarıda yazmıs olduğumuz kod sayesinde bunu yapabiliriz.
         */

    }
    @Test
    public void test03() {
        //amazon sayfasina gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();


        //arama kutus id attribute degerini ismimiz ile degistirelim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id','mea')",searchBox);

        //degistirmis oldugumuz id ile arama kutusunu locate ederek java aratalim
        driver.findElement(By.id("mea")).sendKeys("java");

        //bu konu çalıştırdıktan sonra bu id yi incelediğinde ismi artık mea oldu


    }
}
