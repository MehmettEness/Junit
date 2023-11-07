package J07_Assertion_Dropdown_TestBase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {
  //  https://www.youtube.com adresine gidin


    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://youtube.com");
    }

    @Test
    public void test01() {

        //TEST1=> Sayfa başlığının "YouTube" oldugunu test edin
        String actualTitle= driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertEquals(expectedTitle,actualTitle);

        // => YouTube logosunun görüntülendiğini (isDisplayed()) test edin
        WebElement logo = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void test02() {
        // TEST2=> Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searcBox=  driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searcBox.isEnabled());
    }

    @Test
    public void test03() {
        // TEST3=> wrongTitleTest  => Sayfa basliginin "youtube" olmadigini dogrulayin
        Assert.assertNotEquals("youtube",driver.getTitle());

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}