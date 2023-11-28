package practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends TestBase {
    @Test
    public void test01() {
        //Bu method da eğer indirilen dosya varsa sil yoksa indir diyeceğiz

        String dynamicPathh = System.getProperty("user.home") + "\\Downloads\\b10 all test cases, code.docx";

        try {
            Files.delete(Paths.get(dynamicPathh)); //sadece bu kısmı yaz delete kısmı uyarı veriyor otomatik try catch içine alırsın
        } catch (IOException e) {
            // throw new RuntimeException(e);
            System.out.println("Belirtilen dosya silinemedi !!!!");
        }

        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.partialLinkText("b10 all test cases, code")).click(); //başka b10 all test cases, code.docx olmadığı için direk yazı üzerinden bul dedik
        waitForSecond(5);

        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        //Dosya yolu = C:\Users\ACER\Downloads\b10 all test cases, code.docx

        //                      C:\Users\ACER   +               \Downloads\b10 all test cases, code.docx
        String dosyaYolu = System.getProperty("user.home") + "\\Downloads\\b10 all test cases, code.docx";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));




    }
}
