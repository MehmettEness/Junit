package practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDocuments extends TestBase {

    @Test
    public void test01() {

        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='b10 all test cases, code.docx']")).click();
        waitForSecond(5);

        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        String pcYol = System.getProperty("user.home");
        String ortakYol = "\\Downloads\\b10 all test cases, code.docx";

        String dinamikYol = pcYol + ortakYol;

        Assert.assertTrue(Files.exists(Paths.get(dinamikYol)));



    }

    @Test
    public void name() {

        //dosyayi varsa sil yoksa indir

        String pcYol = System.getProperty("user.home");
        String ortakYol = "\\Downloads\\b10 all test cases, code.docx";

        String dinamikYol = pcYol + ortakYol;

        try {
            Files.delete(Paths.get(dinamikYol));
        } catch (IOException e) {
            System.out.println("Belirtilen dosya silinemedi...");
        }

        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='b10 all test cases, code.docx']")).click();
        waitForSecond(5);

        String pcYol1 = System.getProperty("user.home");
        String ortakYol1 = "\\Downloads\\b10 all test cases, code.docx";

        String dinamikYol1 = pcYol1 + ortakYol1;

        Assert.assertTrue(Files.exists(Paths.get(dinamikYol1)));

    }









}
