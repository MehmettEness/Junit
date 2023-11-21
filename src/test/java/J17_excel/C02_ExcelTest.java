package J17_excel;

import Utilities.TestBase;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelTest extends TestBase {
    @Test
    public void test01() throws IOException {
        //https://www.bluerentalcars.com/ sayfasına gidelim
        driver.get("https://www.bluerentalcars.com/");

        //Login butonuna basalım
        driver.findElement(By.xpath("//a[.=' Login']")).click();

        //Excel dosyasından aldığımız bir kullanıcı adı ve password ile login olalim
        String path ="src/test/java/resources/mysmoketestdata.xlsx";
        FileInputStream fileInputStream = new  FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        String userMail = workbook.getSheet("customer_info").getRow(1).getCell(0).toString();
        String userName = workbook.getSheet("customer_info").getRow(1).getCell(1).toString();

        WebElement emailBox = driver.findElement(By.id("formBasicEmail"));
        WebElement passwordBox = driver.findElement(By.id("formBasicPassword"));
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));

        emailBox.sendKeys(userMail);
        passwordBox.sendKeys(userName);

        login.click();

        //Login olduğumuzu doğrulayalım
        WebElement loginPass = driver.findElement(By.cssSelector("#dropdown-basic-button"));

        Assert.assertEquals(loginPass.getText() , "ayhan can");

    }
}
