package practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actions01 extends TestBase {


    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
        waitForSecond(2);
        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
        String expected = "You selected a context menu";
        String actual = driver.switchTo().alert().getText();
        Assert.assertEquals(expected , actual);
        waitForSecond(2);
        //Tamam diyerek alert'i kapatın
        driver.switchTo().alert().accept();
        waitForSecond(2);




    }
    @Test
    public void test02() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
        Actions actions=new Actions(driver);
        WebElement account = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        actions.moveToElement(account).perform();
        driver.findElement(By.xpath("//*[text()='Account']")).click();

        //Acilan sayfanin Title in "Your Account" icerdigini dogrula
        String expect = "Your Account";
        String actual = driver.getTitle();
        Assert.assertEquals(expect , actual);

    }

    @Test
    public void test03() {

        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");

        //Sayfayı istediğimiz bir miktar aşağıya doğru scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Sayfayı istediğimiz bir miktar yukarıya doğru scroll yapalım
        actions.sendKeys(Keys.PAGE_UP).perform();

    }

    @Test
    public void test04() {
        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");

        //Sayfanın en altına scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //Sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).perform();

    }

    @Test
    public void test05() {
        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");

        //Events yazısına kadar scroll yapalım
       WebElement events = driver.findElement(By.xpath("//h2[@class='react__tittle']"));
       Actions actions = new Actions(driver);
       actions.scrollToElement(events).perform();

    }




}
