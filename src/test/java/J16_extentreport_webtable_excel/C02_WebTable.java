package J16_extentreport_webtable_excel;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C02_WebTable extends TestBase {
     /*
    1- <table> bu tag tum tabloyu kapsar, xpath kullanarak // table ifadesiyle sayfadaki tum tablolari bulabilirsiniz
    2- <thead> bu tag eger webtable da bir baslik bolumu varsa bu thead tagi icinde olur
        <thead> tagi icined <tr> table row baslik satirini <th> tag ise baslik satirindaki her bir hucreyi temsil eder
    3- <tbody> bu tag webtable daki datalarin yogun olarak bulundugu kısımdir
        <tr> satirlar ve <td> bu satirlardaki her bir hucreyi temsil eder

     */

    @Test
    public void test01() {


        //https://the-internet.herokuapp.com/tables sayfasına gidelim
        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 1 : Table1’i print edin
        WebElement table1 = driver.findElement(By.xpath("//table[1]"));

        System.out.println(table1.getText());
        System.out.println("====================================================================");
        //Task 2 : 3. Row'(satır) datalarını print edin
       WebElement tr = driver.findElement(By.xpath("//table[1]//tr[3]"));
        System.out.println(tr.getText());
        System.out.println("=====================================================================");

        //Task 3 : Son row daki dataları print edin
        WebElement td = driver.findElement(By.xpath("//table[1]//td[4]"));
      //  WebElement td = driver.findElement(By.xpath("//table[1]//tbody//tr[ last() ]")); //son satırı verir. lenght-1 gibi düşüneblirsin

        System.out.println(td.getText());
        System.out.println("=====================================================================");
        //Task 4 : 5. Column(sütun) datalarini print edin
        List<WebElement> sütunSayısı = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        //for ( WebElement w  : sütunSayısı ) {
        //    System.out.println(w.getText());
//
        //}
        sütunSayısı.forEach(t-> System.out.println(t.getText()));
        //Task 5 : Iki parametreli bir Java metot oluşturalım: printData  Parameter 1 = row numarasi
        printData(2,3); //printdata yazdığında //private void printData(int satir, int sutun) { otomatik oluştu
        printData(2,2);
        //Parameter 2 = column numarasi

        //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin




    }

    private void printData(int satir, int sutun) {
        WebElement satirSutun = driver.findElement(By.xpath("//table[1]//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println( satir + ". Satır " + " ve " + sutun + ". sütun bilgisi : " + satirSutun.getText());
    }
}