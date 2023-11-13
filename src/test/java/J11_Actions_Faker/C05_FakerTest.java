package J11_Actions_Faker;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    @Test
    public void fakerTest() {
        Locale locale = new Locale("tr");
        Faker faker2 = new Faker(locale);


        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //"create new account"  butonuna basin
        driver.findElement(By.xpath("//a[.='Yeni hesap oluştur']")).click();

        //"firstName" giris kutusuna bir isim yazin
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker2.name().firstName());

        //"lastname" giris kutusuna bir soyisim yazin
        //"email" giris kutusuna bir email yazin
        //"email" onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
    }
}
