package practice;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class webTable extends TestBase {

    @Test
    public void test02() {
        driver.get("https://the-internet.herokuapp.com/tables");
        //Task 1 : Table1’i print edin
        WebElement table1 = driver.findElement(By.xpath("//table[1]"));
        System.out.println("table1 = " + table1.getText());

        System.out.println("///////////////////////////////////////////////////////////");

        //Task 2 : 3. Row'(satır) datalarını print edin
        WebElement row3 = driver.findElement(By.xpath("//table[1]//tr[3]"));
        System.out.println("row3 = " + row3.getText());

        System.out.println("///////////////////////////////////////////////////////////");

        //Task 3 : Son row daki dataları print edin
        WebElement rowSon = driver.findElement(By.xpath("//table[1]//td[6]"));
        System.out.println("rowSon = " + rowSon.getText());

        System.out.println("///////////////////////////////////////////////////////////");

        //Task 4 : 5. Column(sütun) datalarini print edin
        List<WebElement> column = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        column.forEach(t-> System.out.println(t.getText()));

       satirSutunDegerleri(3 , 3);

    }
    public void satirSutunDegerleri (int satir , int sutun){
        WebElement deger = driver.findElement(By.xpath("//table[1]//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(satir + " ve " + sutun + "degerleri = " + deger.getText());
    }

}
