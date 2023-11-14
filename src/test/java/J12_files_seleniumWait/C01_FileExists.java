package J12_files_seleniumWait;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExists {

    @Test
    public void test01() {

        //Oncelikle bu testi yapmamızın amacı bir dosyanın varlığının olup olmadığını doğrulamaktır.

        /*
       Bilgisayarimizdaki herhangi bir dosyanin varligini test edebilmemiz icin;
        1-Oncelikle varligini test etmek istedigimiz dosyanin yolunu almaliyiz
        2-Aldigimiz dosya yolunu Files.exists(Paths.get(dynamicPath)); kodu ile dosyanin varligini test edebiliryz

        ==>Ortak calismalarda bir server uzerinden bir dosya yolu almak istersek her kullanicinin bilgisayarinin ana yolu farkli olabilir
        Ama projedeki dosyanin yeri belli oldugu icin buradaki yol herkeste ortaktir
        Dolayisiyla System.getProperty("user.home") methodu ile bilgisayarimizin ana yolunu alabilir ve projedeki ortak yol ile
        birlestirerek dynamic ve herkes icin calisan bir forma donusturebiliz
         */

        System.out.println(System.getProperty("user.dir")); //bu komut kodun çalıştığı directory (dosya yolu) ver dedik.

        
        //System.getProperty("user.home"); kullanici ana yolunu alır ve String olarak return eder
        //Bu yol her kullanıcı için farklıdır.
        //Orneğin eger kullanıcı adı mehmet ise bu yol ==> C:\Users\mehmet
       String userHome = System.getProperty("user.home");
        System.out.println("userHome = " + userHome); //C:\Users\ACER

        //Bilgisayarda masaüstünde oluşturduğumuz dosyanın varlığını doğrulayalım

        //C:\Users\ACER\Desktop\Batch189.txt
        //user     home + ortak       yol
        
        String ortakYol = "\\Desktop\\Batch189.txt";
        
        //Bu satırla biz tüm bilgisayarlarda çalışacak dosya yolu dynamic olarak oluşturduk
        String dynamicPath = userHome + ortakYol;

        System.out.println("dynamicPath = " + dynamicPath); //dynamicPath = C:\Users\ACER\Desktop\Batch189.txt

        boolean isExist = Files.exists(Paths.get(dynamicPath));

        Assert.assertTrue(isExist);
















    }
}
