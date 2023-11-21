package J17_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {
        //1- Projemize resources package i altında bulunan excel dosyamızın yolunu belirtmeliyiz.
        String path = "src/test/java/resources/Capitals.xlsx";

        //2- FileInputStream clasını kullanarak bir stream oluşturduk ve akıs ile dosyamızdan gelen datayı java ortamına aktaracağız
        FileInputStream fis = new FileInputStream(path);

        //3-WorkbookFactory = workbook excel demek , workbookfactory ise dependencylerden çektiğimiz excel

         Workbook workbook = WorkbookFactory.create(fis);

        //4-Bir excel dosyasından birden fazla sayfa bulunabilir. Bu nedenle sayfa adını yazarız ve bu sayfadaki kodlarla çalışacağız
         Sheet sheet = workbook.getSheet("Sheet1");//excel dosyasında ki Sheet1 sayfasını aç dedik

        //5-Bir excel sayfasında birden fazla (row) satır bulunur. Bunu seçmemiz için bu Row classını kullanırız. 0 demek ilk sıradakini alır
         Row row = sheet.getRow(0);

        //6-Bir satır biden fazla cell (sütun) içerdiği için bu kodu yazarız.
         Cell cell = row.getCell(0);

        System.out.println("cell = " + cell);



    }

    @Test
    public void test02() throws IOException {
        String path = "src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0));

    }

    @Test
    public void test03() throws IOException {
        //Örnek 1: Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Cell cell =  workbook.getSheet("Sheet1").getRow(0).getCell(1);
        System.out.println("İndeksimiz = " + cell);

        //Örnek 2: 3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String actualCell = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        Assert.assertEquals(actualCell , "France");

        //Örnek 3: Kullanılan satır sayısın bulun
        int icindekiSatirSayisi = workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); //getPhysicalNumberOfRows = içi dolu olan satır sayısını verir.
        System.out.println("icindekiSatirSayisi = " + icindekiSatirSayisi); //11
        //Örnek 4: Sayfadaki son satırin index ini yazdırınız
        int sonSatir = workbook.getSheet("Sheet1").getLastRowNum(); //getLastRowNum = son satır indexini verir.
        System.out.println("sonSatir = " + sonSatir);//10
        //Örnek 5: Excel sayfasindaki datalari COUNTRY,CAPITALS (Ülke-Başkent) key-value şeklinde console a yazdiriniz
        // {{USA,D.C},{FRANCE,PARIS}....}

        Map<String , String> ulkeBaşkentleri = new HashMap<>();

        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {

            String country = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String capital = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();

            ulkeBaşkentleri.put(country , capital); //put ile eklemiş olduk

        }
        System.out.println("ulkeBaşkentleri = " + ulkeBaşkentleri);
    }





}
