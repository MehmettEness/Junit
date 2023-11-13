package J06_Junit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ClassWork4 {

    //BeforeClass methoduyla driveri oluşturun ve pencereyi maximize edin
    //      ve 15 saniye implicitli wait koyun

   static WebDriver driver ;
    @BeforeClass
    public static void beforeClass() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    //     Before methodu ile http://www.google.com adresine gidin
    @Before
    public void setUp() throws Exception {
        driver.get("http://www.google.com");
    }
    //     3 farklı test methoduyla:
    //      ->Arama kutusuna "Masaüstü" yazın ve sonuç sayısını yazdırın
    @Test
    public void testMasaustu() {
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Masaüstü" , Keys.ENTER);

     //   System.out.println("sonuc sayısı : " +  driver.findElement(By.xpath("//div[@id='result-stats']")).getText());

    }

    // ->Arama kutusuna "Akıllı Telefon" yazın ve sonuç sayısını yazdırın
    @Test
    public void akilliTelefon() {
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Akıllı Telefon" , Keys.ENTER);

     //   System.out.println("sonuc sayısı : " +  driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
    }

    //      ->Arama kutusuna "Dizüstü Bilgisayar" yazın ve sonuç sayısını yazdırın
    @Test
    public void dizustuBilgisayar() {
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Dizüstü Bilgisayar" , Keys.ENTER);

    //    System.out.println("sonuc sayısı : " +  driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
    }

    //     NOT: Sonuç sayilarini After method icinde yazdırın
    @After
    public void tearDown() throws Exception {
        String sonucYazim = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        System.out.println("Sonuç Sayısı : " + sonucYazim);

    }

    //     AfterClass methoduyla driver i kapatın
    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}





