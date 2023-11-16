package practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class frame01 extends TestBase {

    @Test
    public void name() {

        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız.
        String kalinYazi = driver.findElement(By.xpath("//h3")).getText();
        String expectedYazi = "Editor";
        Assert.assertTrue(kalinYazi.contains(expectedYazi));

        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBoxYazi = driver.findElement(By.xpath("(//*[.='Your content goes here.'])[3]"));
        textBoxYazi.clear();

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBoxYazi.sendKeys("Bu textbox iFrame içinde yer almaktadır");

        //Sayfadaki "Elemental Selenium" yazısının olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        WebElement eleSelYazi = driver.findElement(By.xpath("//*[.='Elemental Selenium']"));
        String expectedYazim = "Elemental Selenium";
        Assert.assertEquals(expectedYazim , eleSelYazi.getText());

    }

    @Test
    public void test02() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproHandle = driver.getWindowHandle();
        //Başlığın "TechPro Education IT Programs" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education IT Programs" , driver.getTitle());
        System.out.println(driver.getTitle());
        waitForSecond(2);
        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String youtubeHandle = driver.getWindowHandle();
        waitForSecond(2);
        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedHandle = driver.getWindowHandle();
        waitForSecond(2);
        //techproeducation sayfasına geçiniz:

        driver.switchTo().window(techproHandle);
        waitForSecond(2);
        //youtube sayfasına geçiniz:

        driver.switchTo().window(youtubeHandle);
        waitForSecond(2);
        //linkedIn sayfasına geçiniz:

        driver.switchTo().window(linkedHandle);
        waitForSecond(2);
    }

    @Test
    public void test03() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techHandle = driver.getWindowHandle();

        //Başlığın "TechPro Education IT Programs" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education IT Programs" , driver.getTitle());

        //Window 2'de (yeni bir sekmede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
        String youtubeHandle = driver.getWindowHandle();
        waitForSecond(2);
        //Window 3'te (yeni bir sekmede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linHandle = driver.getWindowHandle();
        waitForSecond(2);

        //techproeducation sayfasına geçiniz:

        driver.switchTo().window(techHandle);
        waitForSecond(2);

        //youtube sayfasına geçiniz:

        driver.switchTo().window(youtubeHandle);
        waitForSecond(2);

        //linkedIn sayfasına geçiniz:

        driver.switchTo().window(linHandle);
        waitForSecond(2);
    }

    @Test
    public void test04() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        //Başlığın "TechPro Education IT Programs" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education IT Programs" , driver.getTitle());
        //Window 2'de (yeni bir sekmede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        //Window 3'te (yeni bir sekmede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.kamrusepa.com");

        List<String> handless = new ArrayList<>(driver.getWindowHandles());

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(handless.get(0));
        waitForSecond(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(handless.get(1));
        waitForSecond(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(handless.get(2));
        waitForSecond(2);
        driver.switchTo().window(handless.get(3));
        waitForSecond(2);



    }

    @Test
    public void test05() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education IT Programs" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education IT Programs" , driver.getTitle());

        //Window 2'de (yeni bir sekmede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");

        //Window 3'te (yeni bir sekmede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");

        //techproeducation sayfasına geçiniz:
        window(0);
        waitForSecond(2);
        //youtube sayfasına geçiniz:
        window(1);
        waitForSecond(2);
        //linkedIn sayfasına geçiniz:
        window(2);
        waitForSecond(2);
    }



}
