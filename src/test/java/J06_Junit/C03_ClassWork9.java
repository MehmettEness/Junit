package J06_Junit;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class C03_ClassWork9 extends TestBase {
    @Test
    public void test01() {

        // -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");

//-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız

        driver.findElement(By.xpath("/*[@class='btn btn-danger']"));
//-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
//-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
//-Çıkan alert'te iptal butonuna basınız
//-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
//-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
//-Çıkan mesajı konsola yazdırınız
//-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
    }






    /*


===========Homework 2==========================
- http://szimek.github.io/signature_pad/ sayfasına gidiniz
- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
- Çizimden sonra clear butonuna basınız
- Sayfayi kapatiniz
===========Homework 3==========================
https://the-internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown değerleri(value) yazdırın
    5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    False yazdırın.

===========Homework 4==========================
https://testpages.herokuapp.com/ adresine gidiniz
File Downloads a tiklayiniz
Acilan sayfada Server Download a tiklayiniz
Dosyanin basariyla indirildigini test ediniz
===========Homework 5==========================
https://testpages.herokuapp.com/styled/challenges/growing-clickable.html adresine gidiniz
click me buttonu na tiklayiniz
"Event Triggered" yazisinin görüntülendigini dogrulayiniz
===========Homework 6==========================
https://testpages.herokuapp.com/styled/basic-html-form-test.html adresine gidin.
Username adını, Password ve textArea bolumlerini faker ile doldurun
Bir dosya seçin ve yükleyin
Tüm checkbox lari secin
Radio button da radio 1 i secin
Dropdown menü den 2'yi seçin
submit'e tıklayın
Yüklenen dosyanin Form bilgilerinde yer aldığını doğrulayın
===========Homework 7==========================
    // https://www.saucedemo.com/ adresine gidin
    // Kullanici adini "standard_user" olarak girin
    // Şifreyi "secret_sauce" olarak girin
    // Login buttonuna tiklayin
    // Tum urunleri sepete ekleyin
    // Sepete tiklayarak gidin
    // Checkout a tiklayin
    // FirstName-LastName ve posta code unu doldurun
    // continue butonuna tiklayin
    // Toplam fiyatın 140,34$ olduğunu dogrulayin
    // finish e tiklayin
    // Checkout: Complete! yazisinin görüntülendigini doğrulayiniz
===========Homework 8==========================
     https://demo.guru99.com/test/drag_drop.html adresine gidin
     Sayfayi kesfederek turuncu webelementleri uygun kutulara sürükleyin
     Perfect! yazisinin görüntülendigini test edin
     */

}
