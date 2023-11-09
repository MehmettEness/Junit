package J09_iframe_windowHandle_basicAuthentication;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C03_WindowHandle extends TestBase {
    @Test
    public void test01() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
       String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window" , text);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals("The Internet" , driver.getTitle());

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a[@target='_blank'])[1]")).click();

        ////////////////click yapınca yeni bir sekme açtı/////////////////////
        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        Set<String> window = driver.getWindowHandles(); //burada 2 tane handle değeri var 1.URL 2.click yapınca açılan sekme

        for ( String w  : window ) {
            if (!w.equals(ilkSayfaHandle)){
                driver.switchTo().window(w);
            }
        }



        //yukarıda yazmış oldugumuz kod ile handle degeri ilk sayfaya eşit olmayana geçiş yap diyerek
        //kontrolümüz dışında açılan pencere geçirmiş olduk
        Assert.assertEquals("New Window" , driver.getTitle());
        String ikinciSayfaHandle = driver.getWindowHandle();

        waitForSecond(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(ilkSayfaHandle);
        Assert.assertEquals("The Internet" , driver.getTitle());

        //  ikinci sayfaya tekrar geçin.

        driver.switchTo().window(ikinciSayfaHandle);
        waitForSecond(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilkSayfaHandle);



    }
    //Yeni yöntem
    @Test
    public void test02() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",text);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals("The Internet",driver.getTitle());


        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.

        List<String> windows = new ArrayList<>(driver.getWindowHandles()); //burada 2 tane handle değeri var 1.URL 2.click yapınca açılan sekme
        driver.switchTo().window(windows.get(1));//1.sayfaya yani yeni sekmeye geçiş yaptık
        Assert.assertEquals("New Window",driver.getTitle());

        waitForSecond(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(windows.get(0)); //0.indexi aldık
        Assert.assertEquals("The Internet",driver.getTitle());

        waitForSecond(2);
        //  ikinci sayfaya tekrar geçin.

        driver.switchTo().window(windows.get(1));
        waitForSecond(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(windows.get(0));
    }
    //Yeni yöntem 2
    @Test
    public void test03() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",text);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals("The Internet",driver.getTitle());


        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.


        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());//1.sayfaya yani yeni sekmeye geçiş yaptık
        Assert.assertEquals("New Window",driver.getTitle());

        waitForSecond(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString()); //0.indexi aldık
        Assert.assertEquals("The Internet",driver.getTitle());

        waitForSecond(2);
        //  ikinci sayfaya tekrar geçin.

        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        waitForSecond(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
    }
 //TestBase ile yazdığımız şekilde window kullanacağız
    @Test
    public void test04() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window", text);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals("The Internet", driver.getTitle());


        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        window(1);//1.sayfaya yani yeni sekmeye geçiş yaptık
        Assert.assertEquals("New Window", driver.getTitle());
        waitForSecond(2);

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        window(0); //0.indexi aldık
        Assert.assertEquals("The Internet", driver.getTitle());
        waitForSecond(2);

        //  ikinci sayfaya tekrar geçin.
        window(1);
        waitForSecond(2);

        //  ilk sayfaya tekrar dönün.
        window(0);


    }
}
