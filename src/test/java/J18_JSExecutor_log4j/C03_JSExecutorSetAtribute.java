package J18_JSExecutor_log4j;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C03_JSExecutorSetAtribute extends TestBase {

    @Test
    public void test01() {
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
    public void test02() {
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //jsexecutor ile arama kutusuna selenium yazdıralım
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        JS_SendKeys(searchBox , "nükleer"); //testbase oluşturduk
        searchBox.submit();
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
