package J13_SeleniumWaits_exception;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C05_NullPointerException {

    Faker faker;

    /*
    NullPointerException..
    1-Eger bir obje veya variable oluşturup bu oluşturdugumuz obje yada variable a assignment yapmadan kullanmak istersek
    bu exceptionı alırız. Yani henüz oluşturulmamıs bir obje üzerinde işlem yapmaya kalktıgımızda bu hatayı alırız.

    Hata almamak için faker=new faker(); yaparsak düzeltiriz.
     */

    @Test
    public void test01() {
       // faker=new Faker();
        System.out.println("faker.name().fullName() = " + faker.name().fullName()); //NullPointerException hatası alırız.
    }
}
