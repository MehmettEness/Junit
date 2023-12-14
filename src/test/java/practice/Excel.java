package practice;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Excel {
    @Test
    public void test01() throws IOException {

        String path = "src/test/java/resources/Capitals.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(2));
    }

    @Test
    public void test02() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("customer_info");
        Row row = sheet.getRow(0);
        Cell cell = row.createCell(3);
        cell.setCellValue("MEA");
        sheet.getRow(1).createCell(3).setCellValue("mehmet");
        sheet.getRow(2).createCell(3).setCellValue("enes");
        sheet.getRow(3).createCell(3).setCellValue("arslan");
        //Dosyaya yazmak icin sistemden çıkış yap
        FileOutputStream fileOutputStream = new FileOutputStream("src/test/java/resources/mysmoketestdata.xlsx");
        workbook.write(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();

    }

    @Test
    public void Test03() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        String[] isimlerSutunu = {"İSİMLERRRR", "ayhan", "beyhan", "ceyhan", "ali", "veli", "ahmet", "can", "sam", "kate", "raj", "pam"};
        for (int i = 0; i < 12; i++) {

            workbook.getSheet("customer_info").getRow(i).createCell(6).setCellValue(isimlerSutunu[i]);

        }
        FileOutputStream fileOutputStream =new FileOutputStream("src/test/java/resources/mysmoketestdata.xlsx");
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();

    }
}
