package practice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assertion {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    @Test
    public void name() {
        //TEST1=> Sayfa başlığının "YouTube" oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle , actualTitle);

    }

    @Test
    public void Title() {
        // => YouTube logosunun görüntülendiğini (isDisplayed()) test edin
        WebElement logo = driver.findElement(By.xpath("(//*[@class='external-icon'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void Enabled() {
        // TEST2=> Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void not() {

        // TEST3=> wrongTitleTest  => Sayfa basliginin "youtube" olmadigini dogrulayin

        Assert.assertNotEquals("youtube" , driver.getTitle());

    }

    @After
    public void tearDown() throws Exception {
       // driver.close();
    }
}
