package J19_JSExecutor_log4j;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C01_JSExecutorStyle extends TestBase {
    @Test
    public void test01() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //aramakutusunun style özelliklerini degistirelim
        WebElement seacrhBox = driver.findElement(By.id("twotabsearchtextbox"));
        seacrhBox.sendKeys("selenium");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='5px solid red'",seacrhBox); //searchBox webelemneti etrafına 5 pixellik kırmızı çerçeve çizdik
        jse.executeScript("arguments[0].style.backgroundColor='green'",seacrhBox); //searchBox webelemneti içini yeşil yaptık
        jse.executeScript("arguments[0].style.color='yellow'",seacrhBox); //searchBox webelemneti içindeki yazıyı sari yaptık

        //sayfanin ekran görüntüsünü alalim
        screenShot("JSstyle");

    }


}
