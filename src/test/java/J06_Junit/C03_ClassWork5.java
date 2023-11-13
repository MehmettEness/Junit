package J06_Junit;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class C03_ClassWork5 extends TestBase {
    @Test
    public void work5() {

        //https://the-internet.herokuapp.com/dropdown adresine gidin
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.SelectByIndexTest methodunu oluşturun ve indeksi kullanarak Seçenek 1'i seçin
        WebElement selectByIndex = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select selectByIndexTest = new Select(selectByIndex);
        selectByIndexTest.selectByIndex(1);
        waitForSecond(2);
        //2.SelectByValueTest methodunu oluşturun ve  value ile Seçenek 2'yi seçin
        Select selectByValueTest = new Select(selectByIndex);
        selectByValueTest.selectByValue("2");
        waitForSecond(2);
        //3.SelectByVisibleTextTest methodunu olusturun ve görünür metinle Seçenek 1 değerini seç
        Select selectByVisibleTextTest = new Select(selectByIndex);
        selectByVisibleTextTest.selectByVisibleText("Option 1");
        waitForSecond(2);

        //4.printAllTest methodunu olusturun ve tüm seceneklerin metinlerini konsol a yazdirin, secenekler arasinda "Option 2" oldugunu test edin
        Select printAllTest = new Select(selectByIndex);
        printAllTest.getOptions().forEach(t-> System.out.println("Metinler  = " +(t.getText())));
        List<WebElement> seçimler = printAllTest.getOptions();
        Assert.assertTrue(seçimler.get(2).getText().contains("Option 2"));

    }




}
