package J10_Cookies_Actions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_ActionsTest extends TestBase {
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
        WebElement box = driver.findElement(By.cssSelector("#hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();

        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
        String expectedResult = "You selected a context menu";
        String actualResult = driver.switchTo().alert().getText();
        Assert.assertEquals( "Expected ve Actual birbirine uyumlu değil" , expectedResult , actualResult );

        //Tamam diyerek alert'i kapatın
        driver.switchTo().alert().accept();


    }
}
