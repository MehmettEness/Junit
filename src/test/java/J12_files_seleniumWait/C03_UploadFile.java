package J12_files_seleniumWait;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C03_UploadFile extends TestBase {

    @Test
    public void uploadTest() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));

        //Yuklemek istediginiz dosyayi secelim.
        //C:\Users\ACER\Downloads\b10 all test cases, code.docx

        String dosyaYolu =System.getProperty("user.home") + "\\Downloads\\b10 all test cases, code.docx";

        dosyaSec.sendKeys(dosyaYolu);
        waitForSecond(2);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //"File Uploaded!" textinin goruntulendigini test edelim.

        String expectedText = "File Uploaded!";
        String actualText =driver.findElement(By.xpath("//h3")).getText();

        Assert.assertEquals( "expectedText , ActualText'e eşit değil" , expectedText , actualText);


    }
}
