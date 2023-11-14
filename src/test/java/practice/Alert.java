package practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Alert extends TestBase {

    /*
    Bir butona tıkladığımız da bir uyarı çıkıyorsa ve biz locate alamıyorsak bu JS Alerttür.
    Bunu alabilmemiz için switcTo -- alert  kullanmamız gerekir.

    accept --kabul eder, onaylar, OK
    dismiss -- reddeder , iptal eder , Cancel
    gettext--uyarıdaki mesajı getirir.
    sendkeys--veri yazarız
     */
    @Test
    public void acceptAlert() {
        /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
      // Bir metod olusturun: acceptAlert
    // 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  "You successfully clicked an alert" oldugunu test edin.

*/
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        waitForSecond(2);
        driver.switchTo().alert().accept();

        String expectedMessage = "You successfully clicked an alert";
        String actualMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        waitForSecond(2);
        Assert.assertEquals( "birbirleriyle aynı değil" , expectedMessage ,actualMessage );


    }

    @Test
    public void dissmiss() {
        // 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının "successfuly" icermedigini test edin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        waitForSecond(2);
        driver.switchTo().alert().dismiss();

        String expectedCancel = "successfuly";
        String actualCancel = driver.findElement(By.xpath("//p[@id='result']")).getText();
        waitForSecond(2);
        Assert.assertFalse( actualCancel.contains(expectedCancel));

    }

    @Test
    public void sendKeysAlert() {
        //Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın, uyarıdaki  metin kutusuna isminizi yazin, OK butonuna
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Enes");
        waitForSecond(2);
        driver.switchTo().alert().accept();
        //       tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        String expectedName = "You entered: Enes";
        String actualName = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals( "Birbirlerine eşit değiller" ,expectedName , actualName);

    }

}

