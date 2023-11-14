package J08_TestBase_Alert_iframe;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class C01_TestBaseClassWork extends TestBase {
    @Test
    public void Test01() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // 1.Method:
        //           a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));



        //           b. Select objesi olustur
        Select selectYear = new Select(year);
        Select selectMonth = new Select(month);


        //           c. Select object i kullanarak 3 farkli sekilde secim yapiniz




       selectYear.selectByIndex(5);//index 0 dan başlayarak 6. element seçilir
       selectMonth.selectByValue("4");//value değeri seçilir.

       selectIndex(year , 3);
       waitForSecond(2);
       selectVisible(month , "May");
       selectVisible(day , "10");

    }
}
