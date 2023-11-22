package J18_JSExecutor_log4j;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C01_JSExecutorClick extends TestBase {

    @Test
    public void test01() {
        //amazona gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //sell linkine tıklayalım
        waitForSecond(2);
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        sellLinki.click();
        //ElementClickInterceptedException hatası alırız. Çünkü tıklayacağımız linkin önüne locate ile alakalı başka bir kısım çıktı ve önünü kapattı


    }

    @Test
    public void test02() {

        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        waitForSecond(2);
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver; // jse methodu ile executeScript yapacağız

        jse.executeScript("arguments[0].click();" , sellLinki); //0 demek , den sonraki hemen ilk olanı alır.

    }

    @Test
    public void test03() {
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        waitForSecond(2);
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));

        JS_Click(sellLinki); // testBase oluşturduğumuz method ile kolayca çağırdık

    }
}
