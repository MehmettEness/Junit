package practice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Dropdown {
    /*
    Dropdown ==> Altbaşllıkların olduğu açılır menüyü listeler.
    
    Select önemli.
    selectByVisibleText -- Dropdowndaki menüde görünen metine ulaşmak için
    selectByIndex-- Index ile ulaşmak istediğimiz de kullanırız. Index 0 dan başlar.
    selectByValue -- value atribute ile kullanırız
    getOptions -- Locate ettiğimiz dropdown menüdeki tüm elementlere ulaşmak için kullanırız.
    getFirstSelectedOptions -- Dropdown menudeki seçili olan seceneği bize verir.
        
     */
    /*
     Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
   -3 farklı test methodu oluşturalım
       1.Method:
           a. Yil,ay,gün dropdown menu'leri locate ediniz
           b. Select objesi olustur
           c. Select object i kullaarak 3 farkli sekilde secim yapiniz
       2.Method:
           a. Tüm eyalet isimlerini yazdıralım
       3.Method:
           a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

    */

    WebDriver driver;
    
    @Before
    public void setUp() throws Exception {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        
    }




    @Test
    public void name() {
        //    a. Yil,ay,gün dropdown menu'leri locate ediniz

        WebElement year = driver.findElement(By.xpath("//*[@id='year']"));
        WebElement month =  driver.findElement(By.xpath("//*[@id='month']"));
        WebElement day =  driver.findElement(By.xpath("//*[@id='day']"));

        //    b. Select objesi olustur

        Select selectYear = new Select(year);
        Select selectMonth = new Select(month);
        Select selectDay = new Select(day);

        //    c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        selectYear.selectByIndex(0);
        selectMonth.selectByValue("5");
        selectDay.selectByVisibleText("14");

    }

    @Test
    public void sehirler() {

        //    2.Method:
//    a. Tüm eyalet isimlerini yazdıralım
        WebElement eyaletIsimleri = driver.findElement(By.xpath("//select[@id='state']"));

        Select select = new Select(eyaletIsimleri);

        List<WebElement> eyaletlerListesi = select.getOptions();

        for ( WebElement w  : eyaletlerListesi ) {
            System.out.println( "Eyaletler Listesi : " + w.getText());
        }

    }

    @Test
    public void state() {
        //    3.Method:
//    a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

        WebElement eyaletDropDown = driver.findElement(By.xpath("//select[@id='state']"));
        Select select = new Select(eyaletDropDown);

        String expected = "Select a State";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals( "Birbirlerine eşit değiller" , expected , actual);



    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
