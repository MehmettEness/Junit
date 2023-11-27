package J19_JSExecutor_log4j;

import Utilities.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C02_Log4j extends TestBase {

    /*
    Junit classı seçiliyken sağ tıklayıp directory seçtik ve içine resources yazdık
    Resources seçiliyken sağ tık yapıp altta mark directory as seçip root seçtik
    Resources seçip içine new file seçtik ve log4j2.xml yazdık
    Dosyanın içine package içinde yazıları yazdık ve ctrl+s dedik
    sonra pom.xml e girip bunu ekledik;
    /*
    <!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
<dependency>
   <groupId>org.apache.logging.log4j</groupId>
   <artifactId>log4j-core</artifactId>
   <version>2.17.2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
<dependency>
   <groupId>org.apache.logging.log4j</groupId>
   <artifactId>log4j-api</artifactId>
   <version>2.17.2</version>
</dependency>
  */


    @Test
    public void test01() {


        //  LogManager.getLogger(C02_Log4j.class); kodu parantez icinde belirtilen class
        //  icin bir tane Logger(loglayici) objecti olusturur
       Logger logger = LogManager.getLogger(C02_Log4j.class); //LogManageri log4j den seçtik bu kısım önemli

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        logger.info("Amazon web sayfasına gidildi.");

        //arama kutusunu locate edin
        WebElement searcbox = driver.findElement(By.id("twotabsearchtextbox"));
        logger.info("arama kutusu locate edildi");

        //Arama kutusuna selenium yazın
        searcbox.sendKeys("selenium" , Keys.ENTER);
        logger.info("arama kutusunda selenium aratıldı");



        /*
        16:20:11.810 [main] INFO  J19_JSExecutor_log4j.C02_Log4j - Amazon web sayfasına gidildi.
        16:20:11.813 [main] INFO  J19_JSExecutor_log4j.C02_Log4j - arama kutusu locate edildi
        16:20:11.814 [main] INFO  J19_JSExecutor_log4j.C02_Log4j - arama kutusunda selenium aratıldı
         */
        // Bu loglar pom.xml altında "selenium.log" olarak oluşturuldu.

    }


}
