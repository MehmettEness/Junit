package Utilities;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public abstract class TestBase {

   protected WebDriver driver ;
   //protected yerine public da yapabiliriz. Ama burada önemli olan kısım güvenlik açıklarını engellemek için  belli yerlerden ulaşabilmelidir. O yüzden protected daha kullanışlı
   @Before
   public void setUp() throws Exception {
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }
//  @After
//  public void tearDown() throws Exception {
//      Thread.sleep(2000);
//      driver.quit();
//  }


 //Select visible Text Dropdown
     public void selectVisible (WebElement ddm , String option){
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
     }

    //Select index DropDown
    public void selectIndex(WebElement ddm , int index){
       Select select = new Select(ddm);
           select.selectByIndex(index);

        }
    //Hard Wait
    public void waitForSecond (int second){
       //bekleme moduu try catch içine aldık çünkü extends classlarda kullandığımızda tekrar import etmemiz gerekirdi

        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //WİNDOW HANDLE
        public void window (int index){
       driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
        }

    //İFRAME HANDLE
        public void frameIndex (int index){
       driver.switchTo().frame(index);
        }

    }
