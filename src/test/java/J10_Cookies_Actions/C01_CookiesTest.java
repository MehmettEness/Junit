package J10_Cookies_Actions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C01_CookiesTest extends TestBase {

    /*
    Cookies denildiğinde aklımıza ilk gelen şey manage() methodu olmalı.
    manage(); methodu sayesin cookilerle ilgili tüm işlmeler yapılır.
     */
    @Test
    public void test01() throws InterruptedException {
        //1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
        driver.navigate().refresh();

        //2-tum cookie'leri consolda bir loop ile yazdirin
        Set<Cookie> cookieSet = driver.manage().getCookies();//Mevcut tüm cookieleri bir set olarak verir.

       // System.out.println(cookieSet);

        int counter=1;
        for ( Cookie w  : cookieSet ) {
            System.out.println(counter +" . cookie --> " + w);
            System.out.println(counter +" . cookie name --> " + w.getName()); //cookie adını verir.
            System.out.println(counter +" . cookie value --> " + w.getValue()); // value adını getirir.
            counter++;
        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int actualSize = cookieSet.size();
        Assert.assertTrue(actualSize>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String nameCookie = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals("USD" , nameCookie);

        //5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie olusturun ve sayfaya ekleyin

        Cookie newcookie = new Cookie("en sevdiğim cookie" , "çikolatalı");
        driver.manage().addCookie(newcookie);

        cookieSet = driver.manage().getCookies(); //eklediğimiz kontrol etmek için ve eklendiğini görmnek için yazdık

        int counter1=1;
        for ( Cookie w  : cookieSet ) {
            System.out.println(counter1 +" . cookie --> " + w);
            System.out.println(counter1 +" . cookie name --> " + w.getName()); //cookie adını verir.
            System.out.println(counter1 +" . cookie value --> " + w.getValue()); // value adını getirir.
            counter1++;
        }

        //6-eklediginiz cookie'nin sayfaya eklendigini test edin.
        Assert.assertTrue(cookieSet.contains(newcookie));


        //7-ismi skin olan cookie'yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookieSet = driver.manage().getCookies();

        int counter2=1;
        for ( Cookie w  : cookieSet ) {
            System.out.println(counter2 +" . cookie --> " + w);
            System.out.println(counter2 +" . cookie name --> " + w.getName()); //cookie adını verir.
            System.out.println(counter2 +" . cookie value --> " + w.getValue()); // value adını getirir.
            counter2++;


        }
       // Assert.assertFalse(driver.manage().getCookies().contains("skin")); //ornek yolu


        //8-tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet=driver.manage().getCookies(); // yukarıdaki kodda cookiesleri 0 ladık o yüzden burada güncelledikki aşağıda hata almayalım
        Assert.assertTrue(cookieSet.isEmpty());



    }





}
