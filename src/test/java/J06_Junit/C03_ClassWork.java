package J06_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ClassWork {
    WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Testler çalışmaya başlar");

    }

    @Before
    public void setUp() throws Exception {
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void Test01() {
        driver.get("https://www.amazon.com");
    }
    @Test
    public void Test02() {
        driver.get("https://www.facebook.com");
    }
    @Test
    public void Test03() {
        driver.get("https://www.google.com");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();

    }





}
