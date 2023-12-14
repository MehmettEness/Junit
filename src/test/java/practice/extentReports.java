package practice;

import Utilities.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class extentReports extends TestBase {
    ExtentReports extentReports ;
    ExtentHtmlReporter extentHtmlReporter ;
    ExtentTest extentTest ;

    @Test
    public void name() {

        extentReports = new ExtentReports();

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "target/extentReport/" + date + "htmlreport.html";
        extentHtmlReporter=new ExtentHtmlReporter(path);
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setDocumentTitle("Aamzon Test Reports");
        extentHtmlReporter.config().setReportName("AMAZON");
        extentReports.setSystemInfo("BİRİM" , "QA");
        extentReports.setSystemInfo("BROWSER" , "CHROME");
        extentReports.setSystemInfo("TEST OTOMATION ENGINEER" , "MEHMET ENES ARSLAN");
        extentTest=extentReports.createTest("amazonTest" , "Test Report");

        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        String actual = driver.getCurrentUrl();
        String expected = "https://www.amazon.com/";
        Assert.assertEquals(expected , actual);
        extentTest.info("Kullanıcı anasayfada olduğunu doğrular");
        extentTest.pass("Anasayfa URL başarılı");
        extentReports.flush();







    }
}
