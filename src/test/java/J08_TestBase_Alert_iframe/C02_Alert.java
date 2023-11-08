package J08_TestBase_Alert_iframe;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class C02_Alert extends TestBase {

    /*
        Eğer bir sayfada ki bir butona tıkladığınızda bir uyarı çıkıyorsa ve bu çıkan uyarıya sağ click
    yaparak locate alamıyorsak bu bir JS Alerttür.
        JS Alertü handle edebilmek için driverimizi o açılan penceereye geçirmemiz gerekir.
        Driver objemizi kullanarak switchTo methoduyla alert() methodunu kullanrak JS Alerte geçiş yapmış oluruz.

        1) accept()"kabul" yada dismiss() "iptal" methodlarıyla js alertü onaylar yada iptal ederek kapatırız.
        accept()--> onaylar , kabul eder..
        dismiss()-->iptal eder..

     */

    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.





Bir metod olusturun: sendKeysAlert
       3. butona tıklayın, uyarıdaki  metin kutusuna isminizi yazin, OK butonuna
       tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */


    // Bir metod olusturun: acceptAlert
    // 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  "You successfully clicked an alert" oldugunu test edin.
    @Test
    public void acceptAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[1]")).click();
        waitForSecond(2);

        driver.switchTo().alert().accept();           //driver.switchTo().alert() == driver geçiş yap alerte okeye bas
        //switchTo() -- drivere geçiş yaptırmak için kullanılır
        //alert() -- alerte geçiş yaptık
        //accept()-- alerti onayladık

        //ve result mesajının  "You successfully clicked an alert" oldugunu test edin.
      String actualResult =  driver.findElement(By.xpath("//p[@id='result']")).getText();
      String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(actualResult , expectedResult);

        
    }
    //Bir metod olusturun: dismissAlert
    //

    @Test
    public void dismissAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[2]")).click();
        waitForSecond(2);

       // 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss(); //dismiss ile cancel (iptal) tuşuna bastık.

      //  ve result mesajının
        //       "successfuly" icermedigini test edin.
        String actualResultMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String unexpectedResultMesaage = "successfuly";

        Assert.assertFalse(actualResultMessage.contains(unexpectedResultMesaage));



    }


}
