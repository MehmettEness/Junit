package practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Prac16_11WindowHandle extends TestBase {
    @Test
    public void test01() {

        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String amazonHandle = driver.getWindowHandle();
        driver.navigate().refresh();
        driver.navigate().refresh();

        // 2- url'in 'amazon' icerdigini test edelim
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("amazon"));

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyHandle = driver.getWindowHandle();

        // 4- title'in 'Best Buy' icerdigini test edelim
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Best Buy"));

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(amazonHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java" , Keys.ENTER);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        WebElement actual = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(actual.getText().contains("java"));

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(bestBuyHandle);

        // 8- logonun gorundugunu test edelim
        WebElement logo= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        boolean gorunurluk = logo.isDisplayed();
        System.out.println(" Logo görünüyor mu " + gorunurluk);


    }

    @Test
    public void test02() throws InterruptedException {
        // https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");
        // 'Drag me' kutusunu tutup 'Drop here' kutusunun ustune birakiniz
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);
        action.dragAndDrop(drag , drop).perform();

        Thread.sleep(3000);

        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
        String dropped = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
        Assert.assertTrue(dropped.contains("Dropped!"));



    }

    @Test
    public void test03() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN , Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        WebElement play = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();
        // Videoyu calistirdiginizi test ediniz
        WebElement youtube = driver.findElement(By.xpath("(//a[@target='_blank'])[25]"));
        Assert.assertTrue(youtube.isDisplayed());

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
        String actualYazi = driver.findElement(By.xpath("//span[@id='Powerful_but_easy_to_misuse']")).getText();
        String expectedYazi = "Powerful, but easy to misuse";
        Assert.assertEquals(actualYazi , expectedYazi);
    }

    @Test
    public void test04() {
        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");
        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframeLocate = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0']"));
        driver.switchTo().frame(iframeLocate);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        waitForSecond(2);
        // videoyu durdurunuz
        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
        waitForSecond(2);
        // videoyu tam ekran yapınız
        driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).click();
        waitForSecond(2);
        // videoyu calıstırınız
        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
        waitForSecond(2);
        // videoyu kucultunuz
        driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).click();
        waitForSecond(2);
        // videoyu durdurunuz
        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
        waitForSecond(2);
        // Videoyu calistirdiginizi test ediniz
        WebElement youtubeYazi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        youtubeYazi.isDisplayed();
        waitForSecond(2);
        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
        waitForSecond(4);
        actions.sendKeys(Keys.PAGE_UP);
        waitForSecond(4);
        String actualYazi = driver.findElement(By.xpath("//h1")).getText();
        waitForSecond(2);
        String expectedYazi = "jQuery Flexy Plugin Demos";
        Assert.assertEquals(actualYazi , expectedYazi);
    }
}
