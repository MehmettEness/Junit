package J14_Exception_ScreenShot;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_ScreenShot extends TestBase {
       /*
    1- Almak istedigimiz ekran gorunutusunu kaydetmek icin bir dosya yolu belirleriz
    2- TakeScreenShot interfacinden bir obje deklare ederek driver i bu objeye assign edeceğiz
    3- Files classindan write() methodunu kullanarak icine parametre olarak neyi nereyey kaydedelim bunu belirtiriz
        getScreenShotAs() methodu ile ekran gorunutusunu alarak bu gorunutuyu kaydetmek icin almis oldugumuz dosya yolunu beliritiriz
     */




    @Test
    public void test01() throws IOException {

        //amazon sayfasina gidiniz
        driver.get("https://amazon.com");


        //Sayfanin ekran gorunutusunu aliniz
        String dosyaYolu ="src\\test\\java\\screenShots\\amazon.png";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;



        Files.write(Paths.get(dosyaYolu) ,  takesScreenshot.getScreenshotAs(OutputType.BYTES));
//              Yaz (kayıt edilecek yer) ,              (bu görünütüyü al)

    }

    @Test
    public void test02() throws IOException {

        //techproya git
        driver.get("https://techproeducation.com");
        //sayfanın ekran görüntüsünü alınız
        String dosyaYolu ="src\\test\\java\\screenShots\\techpro.jpeg";

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;



        Files.write(Paths.get(dosyaYolu) ,  takesScreenshot.getScreenshotAs(OutputType.BYTES));

    }

    @Test
    public void test03() throws IOException {
        //faceboook sayfasına gidiniz
        driver.get("https://www.facebook.com");
        //ekran görüntüsü alınız
        String dosyaYolu = "src\\test\\java\\screenShots\\facebook.jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));

    }

    @Test
    public void test04() throws IOException {


        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());

        //faceboook sayfasına gidiniz
        driver.get("https://www.facebook.com");
        //ekran görüntüsü alınız
        String dosyaYolu = "src\\test\\java\\screenShots\\"+date+"facebook.jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));

    }
}











