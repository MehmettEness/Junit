package practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Cookies extends TestBase {

    @Test
    public void test01() {
        //cookies == manage (9 manage() manage() manage() manage()
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //2-tum cookie'leri consolda bir loop ile yazdirin
        int sayac =1;
        Set<Cookie> cookiess= driver.manage().getCookies();
        for ( Cookie w  : cookiess  ) {
            System.out.println( sayac + " . Cookies" + w );
            System.out.println( sayac + " . cookie Name : " + w.getName());
            System.out.println( sayac + " . cookie Value : " + w.getValue());
            sayac++;
        }


        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int CookieSize = driver.manage().getCookies().size();
        Assert.assertTrue(CookieSize>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        Cookie deger = driver.manage().getCookieNamed("i18n-prefs");
        Assert.assertEquals(deger.getValue(), "USD");

        //5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie" , "cikolatali");
        driver.manage().addCookie(cookie);


        //6-eklediginiz cookie'nin sayfaya eklendigini test edin.
        cookiess = driver.manage().getCookies();

        int counter =1;

        for ( Cookie w  : cookiess ) {
            System.out.println ( counter + " . cookie " + w  );
            counter++;
        }
        Assert.assertTrue(cookiess.contains(cookie));
        //7-ismi skin olan cookie'yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookiess=driver.manage().getCookies();

        int counter2 =1 ;
        for ( Cookie w  : cookiess  ) {
            System.out.println( counter2 + " . cookie " + w);
            counter2++;
        }


        //8-tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiess=driver.manage().getCookies();
        Assert.assertTrue(cookiess.isEmpty());


    }
}
