package practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Prac16_01Actions extends TestBase {
    @Test
    public void test01() {
        // https://demo.automationtesting.in/Vimeo.html sayfasına gidiniz
        driver.get("https://demo.automationtesting.in/Vimeo.html");
        // ust bolumde bulunan Video menusunun acilmasi icin mouse'u bu menunun ustune getiriniz. Ve Vimeo kısmına tıklayınız.
       WebElement video = driver.findElement(By.xpath("//a[text()='Video']"));
        Actions actions= new Actions(driver);
        actions.moveToElement(video).perform();
         driver.findElement(By.xpath("//a[text()='Vimeo']")).click();
         waitForSecond(2);

        // play tusuna basınız.
        driver.switchTo().frame("foo");
        WebElement playTusu= driver.findElement(By.className("PlayButton_module_playIcon__fc6bec57"));
        playTusu.click();
        waitForSecond(2);

        // 'Automation Demo Site' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
        WebElement text = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(text.getText() , "Automation Demo Site");


    }

    @Test
    public void test02() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement language= driver.findElement(By.xpath("(//span[@class='nav-line-2'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(language).perform();


        // Change country/region butonuna basiniz
        waitForSecond(2);
        WebElement country = driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]"));
        country.click();
        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        waitForSecond(2);
        WebElement dropDownMenu = driver.findElement(By.xpath("//span[@class='a-dropdown-container']"));
        waitForSecond(2);
        dropDownMenu.click();
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("Turkey (Türkiye)");

        // Go to website butonuna tiklayiniz
        waitForSecond(2);
        driver.findElement(By.xpath("//span[@id='icp-save-button']")).click();
        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        waitForSecond(2);
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        String actualTitle = driver.getTitle();
        String expectedTitle = "Elektronik";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }


    
    
}
