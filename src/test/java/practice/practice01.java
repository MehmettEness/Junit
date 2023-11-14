package practice;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class practice01 {
    WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("hepsinden önce çalışır");
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void google() {
        driver.get("https://google.com");
        
    }

    @Test
    public void kamrusepa() {
        driver.get("https://www.kamrusepa.com");
    }

    @Test
    public void facebook() {
        driver.get("https://www.facebook.com");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
