package J06_Junit;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_ClassWork7 extends TestBase {
    @Test
    public void work7() {

      //       ÖDEV:
      //       //google sayfasına gidelim
      driver.get("https://google.com");

      //       //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
      WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@id='APjFqb']" ));
      aramaKutusu.sendKeys("Selenium" , Keys.ENTER);

      //       //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        WebElement aramakutusu1 = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));

      waitForSecond(2);
      aramakutusu1.sendKeys(Keys.CONTROL , "a");
      waitForSecond(2);
      aramakutusu1.sendKeys(Keys.CONTROL , "x");
      waitForSecond(2);

      //       //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
      aramakutusu1.click();
      aramakutusu1.sendKeys(Keys.CONTROL , "v" , Keys.ENTER);
    }

}
