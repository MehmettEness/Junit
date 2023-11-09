package J06_Junit;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class C03_ClassWork3 extends TestBase {
    @Test
    public void homeWork3() {
        ////https://html.com/tags/iframe/ sayfasina gidiniz
        driver.get("https://html.com/tags/iframe/");

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        waitForSecond(3);

    }



    //// sayfada bulunan youtube videosunu baslatiniz
}
