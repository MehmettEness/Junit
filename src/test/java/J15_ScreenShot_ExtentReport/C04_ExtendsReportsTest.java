package J15_ScreenShot_ExtentReport;

import Utilities.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_ExtendsReportsTest extends TestBase {

    ExtentReports extentReports;//raporlamayi baslatir

    ExtentHtmlReporter extentHtmlReporter;//html formatinda rapor olusuturur

    ExtentTest extentTest; // Test adimlarina bilgi ekler.


    @Test

    public void extentReportTemplate () {
         /*
        1- ExtentReport classindan raporlamayi baslatmasi icin bir object olusturmaliyiz
        2- ExtentHtmlReporter class indan raporlari html formatinda olusturmasi icin bir object olusturmaliyiz
        3- EXtentTest Classindan test adimlarina bilgi ekleyebilmek icin bir object olustururuz
         */

        //bu object i raporlari olusturmak ve yonetmek icin kullanacacğız
        extentReports=new ExtentReports();

        //Oncelikle olusturmak istedigimiz html reprotu projemizde nerede saklamak istiyorsak bir dosya yolu olusturmaliyiz
        //cunku bu pathi kullanarak bir tane html report olusturacağız
        //bunun icinde ExtentHtmlReporter classindan bir object olusturmaliyiz

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format( LocalDateTime.now());
        String path ="target/extentReport/"+date+"htmlReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //ExtentReports a Html raporlayiciyi ekler, bu raporun html formatinda olusturulmasini saglar
        extentReports.attachReporter(extentHtmlReporter);


        //Html raporunun belge basligini ayarlar, bu baslik sekme uzerinde görünür
        extentHtmlReporter.config().setDocumentTitle("Batch 189 Test Reports");

        //Raporun adini ayarladik, Bu raporda gorunecek olan genel baslik
        extentHtmlReporter.config().setReportName("Smoke Test");

        //Bu html raporunda görmek isteyebileceğimiz herhangi bir bilgiyi asagidaki formatta ekleyebilirz
        extentReports.setSystemInfo("Enviroment","QA");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Test Automation Engineer","Mehmet Enes Arslan");

        //"AmazonTest" adinda yeni bir test olusturur ve bu testin aciklamasi olarak "Test Report" ekler
        extentTest=extentReports.createTest("TechproEducationTest","Test Report");


        //==========Buraya kadar sablon ayarlamalari bitti==================================
        //Bundan sonra extentTest objecti ile log rapora detayli islemleri ekleme islemleri yapacağız


        //Techproya git
        driver.get("https://techproeducation.com");
        extentTest.info("Kullanıcı Techpro sayfasına gider.");

        //Techpro anasayfasında olduğunu doğrula
        String extendURL = "https://techproeducation.com/";
        Assert.assertEquals(extendURL , driver.getCurrentUrl());
        extentTest.info("Kullanıcı anasayfada olduğunu doğrular.");
        extentTest.pass("Ana sayfa URL başarılı");

        //Ana sayfada sosyal medya iconlarının göründüğünü doğrulayın
        WebElement icons = driver.findElement(By.xpath("//*[@class='social-links kuculunce-yok']"));
        Assert.assertTrue(icons.isDisplayed());
        extentTest.pass("Sosyal medya görünütlemeleri başarılı");

        extentReports.flush();



    }

}


