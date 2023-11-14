package J06_Junit;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class C03_ClassWork8 extends TestBase {

    @Test
    public void fakerTest() {
        Locale locale = new Locale("tr");
        Faker faker2 = new Faker(locale);


        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //"create new account" butonuna basin
        driver.findElement(By.xpath("//a[.='Yeni hesap oluştur']")).click();

        //"firstName" giris kutusuna bir isim yazin
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys((faker2.name().firstName()) , Keys.TAB , (faker2.name().lastName()) , Keys.TAB ,
                faker2.internet().emailAddress());

        //"lastname" giris kutusuna bir soyisim yazin

        //"email" giris kutusuna bir email yazin
        //"email" onay kutusuna emaili tekrar yazin
        WebElement emailtekrar = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        waitForSecond(2);
        emailtekrar.sendKeys(Keys.CONTROL , "a");
        //waitForSecond(2);
        emailtekrar.sendKeys(Keys.CONTROL , "c");
        //waitForSecond(2);
        emailtekrar.sendKeys(Keys.TAB , Keys.CONTROL , "v");
        //waitForSecond(2);
        emailtekrar.sendKeys(Keys.TAB , Keys.TAB);
        //waitForSecond(2);

        //Bir sifre girin
        WebElement password = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
        password.sendKeys(faker2.internet().password());


        //Tarih icin gun secin
        WebElement gun = driver.findElement(By.xpath("//select[@title='Gün']"));
        selectIndex( gun , 18);
        //Tarih icin ay secin
        WebElement ay = driver.findElement(By.xpath("//select[@title='Ay']"));
        selectIndex(ay , 4);

        //Tarih icin yil secin
        WebElement yil = driver.findElement(By.xpath("//select[@title='Yıl']"));
        selectVisible(yil , "1905");

        //Cinsiyeti secin
        driver.findElement(By.xpath("(//input[@class='_8esa'])[2]")).click();

    }
}
