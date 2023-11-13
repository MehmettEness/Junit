package J11_Actions_Faker;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_ActionsTest extends TestBase {



    @Test
    public void test01() {

        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");

        //Sayfayı istediğimiz bir miktar aşağıya doğru scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();//klavye ile yapma şekli

        //   for (int i = 0; i < 5; i++) {
        //       actions.sendKeys(Keys.PAGE_DOWN).perform(); //java ile yapma şekli
        //       waitForSecond(1);
        //   }


        //Sayfayı istediğimiz bir miktar yukarıya doğru scroll yapalım
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitForSecond(1);
    }

    /*

    Bir sayfada otomasyon yaparken locate ettiğimiz halde noSuchElementException alıyorsak....
    1-Locate i tekrar kontrol ederiz buna rağmen ayni hatayi alıyorsak
    2-Wait / Synacranization problemi olabilir ,çö<üm olarak implicitly wwait de yeterli üre beklediğimizden emin oluruz, o süreyi arttırabiliriz
    3-Web elementin ifram eiçinde olup olmadığını kontrol ederiz. (alert... açılıyor mu ?)
    4-Driver webelementi göremiyor olabilir , dolayısıyla actions class kullanarak scroll yada başka yöntemlerle webelementin görünmesini sağlayabiliriz.

    */

        @Test
        public void test02() {
            //Techproeducation sayfasına gidelim
            driver.get("https://www.techproeducation.com");

            //Sayfanın en altına scroll yapalım
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.END).perform();//Sayfanın en altına gider.
            waitForSecond(2);

            //Sayfanın en üstüne scroll yapalım
            actions.sendKeys(Keys.HOME).perform();//sayfanın en üstüne çıkar
            waitForSecond(2);


        }

    @Test
    public void test03() {

        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");

        //Events yazısına kadar scroll yapalım

      WebElement event = driver.findElement(By.xpath("//h2[.='Events']"));
      Actions actions = new Actions(driver);
      actions.scrollToElement(event).perform(); //locatini aldığımız event kısmına kadar scroll yaparr


    }
}









