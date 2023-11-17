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
        Set<Cookie> cookiesSet = driver.manage().getCookies();

        int sayac =1;
        for ( Cookie w  : cookiesSet ) {
            System.out.println(sayac + " . cookie ---> " + w);
            sayac++;
        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        int actualSize = cookiesSet.size();
        Assert.assertTrue(actualSize>5);


        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String value = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertTrue(value.contains("USD"));

        //5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie" , "cikolatali");
        driver.manage().addCookie(cookie);
       cookiesSet= driver.manage().getCookies();

        //6-eklediginiz cookie'nin sayfaya eklendigini test edin.
        Assert.assertTrue(cookiesSet.contains(cookie));
        //7-ismi skin olan cookie'yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookiesSet=driver.manage().getCookies();

        int counter =1;
        for ( Cookie w  : cookiesSet ) {
            System.out.println(counter + " . cookie " + w);
        }

        //8-tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSet=driver.manage().getCookies();
        Assert.assertTrue(cookiesSet.isEmpty());

    }
}
