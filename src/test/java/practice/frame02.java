package practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.util.ArrayList;
import java.util.List;

public class frame02 extends TestBase {
    @Test
    public void test01() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın.
        String handleDeger = driver.getWindowHandle();
        System.out.println("Handle Degeri" + handleDeger);

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        WebElement actualText = driver.findElement(By.xpath("//h3"));
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText , actualText.getText());

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals("The Internet" , driver.getTitle());

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a[@target='_blank'])[1]")).click();

        ///////////////click yapınca yeni bir sekme açtı/////////////////////
        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.

      List<String> newWindowHandle = new ArrayList<>(driver.getWindowHandles());
      driver.switchTo().window(newWindowHandle.get(1));
      Assert.assertEquals("New Window" , driver.getTitle());
      waitForSecond(2);

       // driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString()) ;
       // Assert.assertEquals("New Window" , driver.getTitle());

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(handleDeger);
        Assert.assertEquals("The Internet" , driver.getTitle());
        waitForSecond(2);
        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(newWindowHandle.get(1));
        waitForSecond(2);
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(handleDeger);
        waitForSecond(2);
    }
}
