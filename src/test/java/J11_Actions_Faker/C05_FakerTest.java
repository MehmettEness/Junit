package J11_Actions_Faker;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Locale;

public class C05_FakerTest extends TestBase {

    @Test
    public void faker() {

        Faker faker = new Faker();

        //faker objesi ile fake bir isim yazdırınız
        String firstName =  faker.name().firstName();
        System.out.println(firstName);
        //faker objesi ile fake bir soyisim yazdırınız
        String lastName = faker.name().lastName();
        System.out.println(lastName);
        //faker objesi ile fake bir adress yazdırınız
        String adress = faker.address().fullAddress();
        System.out.println(adress);
        //faker objesi ile fake bir telefon No yazdırınız
        String phoneNumber = faker.phoneNumber().phoneNumber();
        System.out.println(phoneNumber);
        //faker objesi ile fake bir email yazdırınız
        String emailAdress = faker.internet().emailAddress();
        System.out.println(emailAdress);
        //faker objesi ile fake bir rastgele 15 haneli bir sayi yazdırınız
        String TcKimlikNo = faker.number().digits(11);
        System.out.println("TcNo : " + TcKimlikNo);
        //faker objesi ile fake bir isimsoyisim yazdırınız
        String fullName = faker.name().fullName();
        System.out.println(fullName);
    }

    /*
    Locale locale = new Locale("tr");
    Faker faker1 = new Faker(locale);
    System.out.println("faker1.name().firstName() = " + faker1.name().firstName());

    ==> Eğer belli bir bölgeye özel fake hesaplar oluşturmak istersek mesela türkiye için locate almak istersek
    Bunu constructor içinde belirtiriz.

     */

    @Test
    public void türkçeMethod() {
        Locale locale = new Locale("tr");
        Faker faker1 = new Faker(locale);
        System.out.println("faker1.name().firstName() = " + faker1.name().firstName());
    }



}
