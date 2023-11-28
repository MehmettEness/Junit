package practice;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileUpload extends TestBase {

    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement dosyaSec = driver.findElement(By.xpath("//input[@name='file']"));
       // dosyaSec.click();

        //Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = System.getProperty("user.home") + "\\Downloads\\b10 all test cases, code.docx";
        dosyaSec.sendKeys(dosyaYolu);
        waitForSecond(3);

        //C:\Users\ACER\Downloads\b10 all test cases, code.docx
        //Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        //"File Uploaded!" textinin goruntulendigini test edelim.

    }
}
