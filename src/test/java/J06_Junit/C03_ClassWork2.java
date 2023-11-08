package J06_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_ClassWork2 {

WebDriver driver;


    @Before
    public void setUp() throws Exception {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }
    @Test
        public void eBay() throws InterruptedException {

            //- ebay sayfasına gidiniz
            driver.get("https://www.ebay.com");

            //- electronics bölümüne tıklayınız
            driver.findElement(By.xpath("(//a[@_sp='p2481888.m1379.l3250'])[1]")).click();
            Thread.sleep(3500);

            //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
           List<WebElement> resimlerrrrrr= driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            for ( WebElement w  : resimlerrrrrr ) {
                Thread.sleep(3500);
                w.click();
                Thread.sleep(3500);
                //- Her sayfanın sayfa başlığını yazdıralım
                System.err.println("Sayfa Başlıkları : " +  driver.getTitle());
                driver.navigate().back();

            }
        }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
