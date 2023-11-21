package J17_excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C05_WriteExcel {
   @Test
   public void test01() throws IOException {/*
      Bir "Name" sütunu oluşturup isimlerini excel doyasına yazınız:
      ("ayhan","beyhan","ceyhan","ali","veli","ahmet","can","sam","kate","raj","pam")
  */
       FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
       Workbook workbook = WorkbookFactory.create(fileInputStream);
      Sheet sheet = workbook.getSheet("customer_info");
      sheet.getRow(0).createCell(3).setCellValue("Name");
      sheet.getRow(1).createCell(3).setCellValue("ayhan");
      sheet.getRow(2).createCell(3).setCellValue("beyhan");
      sheet.getRow(3).createCell(3).setCellValue("ceyhan");
      sheet.getRow(4).createCell(3).setCellValue("ali");
      sheet.getRow(5).createCell(3).setCellValue("veli");
      sheet.getRow(6).createCell(3).setCellValue("ahmet");
      sheet.getRow(7).createCell(3).setCellValue("can");
      sheet.getRow(8).createCell(3).setCellValue("sam");
      sheet.getRow(9).createCell(3).setCellValue("kate");
      sheet.getRow(10).createCell(3).setCellValue("raj");
      sheet.getRow(11).createCell(3).setCellValue("pam");
       FileOutputStream fileOutputStream =new FileOutputStream("src/test/java/resources/mysmoketestdata.xlsx");
       workbook.write(fileOutputStream);

       fileInputStream.close();
       fileOutputStream.close();
   }

   //ikinciYolllll
    @Test
    public void Test02() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        String [] isimlerSutunu = {"Name","ayhan","beyhan","ceyhan","ali","veli","ahmet","can","sam","kate","raj","pam"};
        for (int i = 0; i < 12; i++) {

            workbook.getSheet("customer_info").getRow(i).createCell(4).setCellValue(isimlerSutunu[i]);

        }


        FileOutputStream fileOutputStream =new FileOutputStream("src/test/java/resources/mysmoketestdata.xlsx");
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
    }
    }

