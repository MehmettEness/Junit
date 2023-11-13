package J11_Actions_Faker;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class C02_ActionsTest extends TestBase {

    @Test
    public void test01() {

        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");

        //Sayfayı istediğimiz bir miktar aşağıya doğru scroll yapalım
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();//klavye ile yapma şekli

   //   for (int i = 0; i < 5; i++) {
   //       actions.sendKeys(Keys.PAGE_DOWN).perform(); //java ile yapma şekli
   //       waitForSecond(1);
   //   }


        //Sayfayı istediğimiz bir miktar yukarıya doğru scroll yapalım
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitForSecond(1);
    }
}

    /*

    Bir sayfada otomasyon yaparken locate ettiğimiz halde noSuchElementException alıyorsak....
    1-Locate i tekrar kontrol ederiz buna rağmen ayni hatayi alıyorsak
    2-Wait / Synacranization problemi olabilir ,çö<üm olarak implicitly wwait de yeterli üre beklediğimizden emin oluruz, o süreyi arttırabiliriz
    3-Web elementin ifram eiçinde olup olmadığını kontrol ederiz. (alert... açılıyor mu ?)
    4-Driver webelementi göremiyor olabilir , dolayısıyla actions class kullanarak scroll yada başka yöntemlerle webelementin görünmesini sağlayabiliriz.

    */













