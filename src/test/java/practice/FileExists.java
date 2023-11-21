package practice;

import org.apache.poi.sl.draw.geom.Path;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExists {
    @Test
    public void name() {
        System.out.println(System.getProperty("user.dir")); //Kodun çalıtığı dosya yolu C:\Users\ACER\IdeaProjects\Junit

        String userHome= System.getProperty("user.home");
        System.out.println(userHome); //Bize ait kişisel yol C:\Users\ACER

        String ortakYol = "\\Desktop\\enes.txt";

        String dynamicPath = userHome + ortakYol;
        System.out.println(dynamicPath);

        boolean yol = Files.exists(Paths.get(dynamicPath));

        Assert.assertTrue(yol);

    }

    @Test
    public void test01() {

        System.out.println(System.getProperty("user.dir"));

        String userHome = System.getProperty("user.home");
        System.out.println(userHome);

        String ortakYol = "\\Desktop\\mehmet.docx";

        String dynamic = userHome + ortakYol;

        System.out.println(dynamic);

        boolean yolVarligi = Files.exists(Paths.get(dynamic));
        Assert.assertTrue(yolVarligi);







    }
}
