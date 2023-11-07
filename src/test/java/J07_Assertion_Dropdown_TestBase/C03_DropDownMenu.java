package J07_Assertion_Dropdown_TestBase;

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

public class C03_DropDownMenu {

    /*
    Dropdown --> Altbaşlıkların olduğu açılır menü listesidir. Dropdownu automate etmek için ;

    1-- Dropdowen menuyu locate edeceğiz.
    2-- Select objesi oluştururuz
    3--Select objesini kullanarak bazı methodlar ile istediğimiz seçenege ulasırız

    SYNTAX
    Select select = new Select (Webelement adıonı yazacağız)
        a-- selectByVisibleText() --> Dropdown menudeki elemente görünen metin ile ulaşmak için kullanılır.
        b-- selectByIndex() --> Index ile ulaşmak için kullanılır.Burada index 0 dan başlar.
        c-- selectByValue() --> value attribute degeri ile ulaşmak için kullanılır (option tagi ile başlar)

     4-- getOtions() --> Locate ettiğimiz dropdown menüdeki tüm seçenekleri seçer.
     5-- getFirstSelectedOption() --> Dropdown menudeki secili olan seceneği bize verir.
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
    public void Test01() {

        // 1.Method:
        //           a. Yil,ay,gün dropdown menu'leri locate ediniz
                    WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
                    WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
                    WebElement day = driver.findElement(By.xpath("//select[@id='day']"));

        //           b. Select objesi olustur
                    Select selectYear = new Select(year);
                    Select selectMonth = new Select(month);
                    Select selectDay = new Select(day);

        //           c. Select object i kullanarak 3 farkli sekilde secim yapiniz

                    selectYear.selectByIndex(5);//index 0 dan başlayarak 6. element seçilir
                    selectMonth.selectByValue("4");//value değeri seçilir.
                    selectDay.selectByVisibleText("15");//ekranda görülen değeri seçilir

    }

    @Test
    public void Test02() {
        // 2.Method:
        //           a. Tüm eyalet isimlerini yazdıralım

      WebElement eyaletlerDropDown =  driver.findElement(By.xpath("//*[@id='state']"));
        Select select = new Select(eyaletlerDropDown);
        List<WebElement> eyaletlerListesi =  select.getOptions(); //get.Options hepsini verir.
   //  for (  WebElement w : eyaletlerListesi ) {
   //      System.out.println("Eyaletler Listesi :" + w.getText());
   //  }

        //ikinci yol
        eyaletlerListesi.forEach(t-> System.out.println(t.getText()));
    }


    @Test
    public void Test03() {



   //     3.Method:
   //     a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement eyaletlerDropDown =  driver.findElement(By.xpath("//*[@id='state']"));
        Select select = new Select(eyaletlerDropDown);

        String expectedOption = "Select a State";
        String actualOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption , expectedOption);

    }



    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
