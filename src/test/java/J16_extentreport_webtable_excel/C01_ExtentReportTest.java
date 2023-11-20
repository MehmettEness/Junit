package J16_extentreport_webtable_excel;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C01_ExtentReportTest extends TestBase {

    @Test
    public void extentResuableFormatTest() {

        rapor("Chrome" , "Amazon Testi");
        extentTest = extentReports.createTest("Amazon SearchBox" , "Test Steps");

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        extentTest.info("Kullanıcı amazon sayfasına gider");

        //Arama kutusunda selenium aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium" , Keys.ENTER);
        extentTest.info("Arama kutusuna selenium yazılarak aratıldı");

        //Sayfa basliginin selenium icerdigini doğrulayalim
        Assert.assertTrue( driver.getTitle().contains("selenium"));
        extentTest.pass("Sayfa başlığının selenium içerdiği doğrulandı");

        extentReports.flush();





    }
}
