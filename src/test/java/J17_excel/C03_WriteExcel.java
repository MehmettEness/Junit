package J17_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {

    @Test
    public void test01() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet("customer_info");
        Row row = sheet.getRow(0);

        Cell cell = row.createCell(2); //3.sütun başlığını oluşturduk

        //mysmoketestdata.xlsx dosyasina STATUS adinda ucuncu bir sutun olusturunuz,
        cell.setCellValue("STATUS"); //burada 3 sütuna STATUS adını verdik

        //Bu sutun altinda satirlara sirasiyla valid valid ve invalid degerlerini yaziniz

        //getRow(ikinci satırın). creatCell(3.sütununu oluştur ve değerine valid yaz
        sheet.getRow(1).createCell(2).setCellValue("valid");
        //getRow(ücüncü satırın). creatCell(3.sütununu oluştur ve değerine valid yaz
        sheet.getRow(2).createCell(2).setCellValue("valid");
        //getRow(dördüncü satırın). creatCell(3.sütununu oluştur ve değerine invalid yaz
        sheet.getRow(3).createCell(2).setCellValue("invalid");

        //Dosyaya yazmak icin sistemden çıkış yap
        FileOutputStream fileOutputStream = new FileOutputStream("src/test/java/resources/mysmoketestdata.xlsx");

        //Excel dosyasina yapilan değişiklikleri yazar.
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();


    }
}
