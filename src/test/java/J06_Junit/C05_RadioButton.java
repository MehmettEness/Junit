package J06_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButton {

    WebDriver driver ;

    //  https://www.facebook.com adresine gidin
    //  Cookies'i kabul edin
    @Before
    public void setUp() throws Exception {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com");

    }

    //          "Create an Account" button'una basin
    @Test
    public void radioButton() throws InterruptedException {
        driver.findElement(By.xpath("//a[@rel='async']")).click();
        Thread.sleep(3500);

        //          "radio buttons" elementlerini locate edin
        Thread.sleep(3500);
    //   WebElement kadın = driver.findElement(By.xpath("//input[@id='u_n_4_4Q']"));
       WebElement erkek = driver.findElement(By.xpath("//input[@id='uu_n_5_1J']"));

        //  Secili degilse cinsiyet butonundan size uygun olani secin

        if (!erkek.isSelected()){
            erkek.click();
        }

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3500);
        driver.close();
    }
}
