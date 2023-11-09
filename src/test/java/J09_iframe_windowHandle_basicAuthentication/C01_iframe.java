package J09_iframe_windowHandle_basicAuthentication;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C01_iframe extends TestBase {



    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String kalinYazi = driver.findElement(By.tagName("h3")).getText();
        Assert.assertTrue(kalinYazi.contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        /////////biz şuan iframe alanındayız dışarıya çıkamadık///////////

        //Sayfadaki "Elemental Selenium" yazısının olduğunu doğrulayınız.
        driver.switchTo().defaultContent(); // bu şekilde dışarıya çıkmış olduk
        //driver.navigate().refresh(); -- sayfayı yeniler ana sayfaya döner ama iframe içindeki değişikliklerde gider ve sayfa eski haline döner.
        //driver.get(driver.getCurrentUrl()); -- bu da sayfayı yeniler. Class içindeki URL yi current et dedik
        WebElement elemantalSelenium = driver.findElement(By.xpath("//*[.='Elemental Selenium']"));
        Assert.assertEquals("Elemental Selenium" , elemantalSelenium.getText());






    }



}
