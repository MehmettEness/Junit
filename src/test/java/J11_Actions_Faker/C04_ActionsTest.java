package J11_Actions_Faker;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C04_ActionsTest extends TestBase {

    @Test
    public void test01() {


        //Google anasayfasına gidelim
        driver.get("https://www.google.com");

        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu , Keys.SHIFT).sendKeys("selenium")
                //keyDown tuşa basmak demek. Shift tusuna bas dedik
               .keyUp(Keys.SHIFT).sendKeys(" - java" , Keys.ENTER)
                //keyUp tuşu bırak demek.Shift tuşunu bırak dedik
                .perform();


    }

    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://www.google.com");

        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        aramaKutusu.sendKeys(Keys.SHIFT , "selenium" , Keys.SHIFT , " - java" , Keys.ENTER);
    }
}
