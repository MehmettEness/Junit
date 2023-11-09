package J09_iframe_windowHandle_basicAuthentication;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class C04_BasicAuthentication extends TestBase {

    @Test
    public void test01() {

        //Aşağıdaki bilgileri kullanarak authentication yapınız:
        //    Url: https://the-internet.herokuapp.com/basic_auth
        //    Username: admin
        //    Password: admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");


        //    Congratulations! You must have the proper credentials. yazının çıktığını doğrulayın
       String actualText = driver.findElement(By.xpath("//p")).getText();
       String expectedText ="Congratulations! You must have the proper credentials.";
        Assert.assertEquals(expectedText , actualText);

        //Elemental Selenium linkine tıklayınız
        driver.findElement(By.xpath("(//a)[2]")).click();

        //tıklayınca yeni sekme açıldı
        window(1); //1.sayfaya geçmiş olduk

        //Başlığın Elemental Selenium içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Elemental Selenium"));

    }
}



