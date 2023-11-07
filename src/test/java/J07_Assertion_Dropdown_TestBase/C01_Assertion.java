package J07_Assertion_Dropdown_TestBase;

import org.junit.Assert;
import org.junit.Test;

public class C01_Assertion {
    /*
    Assertion bir test sırasında beklenen (expected)  ve gerçek (actual) sonuclar arasındaki uyumu doğrulamak için kyllanılır.
    Eger beklenen sonuc , gerçekleşen sonuç ile uyuşmuyorsa assertion exception fırlatır ve test başarısız olur.
    JUnit de bir assertion başarısız olduğunda o anda çalışmakta olan test methodu durdurulur. ve bir assertionError fırlatılır
    Bu ilgili testin başarısız olduğu anlamına gelir.
    Ancak test sınıfı içindeki diger test methodları bu durumdan etkilenmez
    ve kendi içindeki assertionlar başarısız olmadıkça calışmaya devam eder.
     */

    //1- assertEquals(expected , equals) : İki sonucun birbirine eşit olup olmadığını kontrol eder.


    @Test
    public void test01() {
        String expectedData = "selenium";
        String actualData = "selenium";
        Assert.assertEquals(expectedData , actualData);

    }

    //2- assertTrue(); parantezi içinde belirtilen koşulun doğru olup olmadığını kontrol eder. Eğer parantez içindeki değer
    //true ise test başarılı olur ,değilse test başarısızı olur.


    @Test
    public void test02() {
        Assert.assertTrue("selenium".contains("e"));//passed
    }

    //3-assertFalse();parantezi içinde belirtilen koşulun yanlış olup olmadığını kontrol eder. Eğer parantez içindeki değer
    //false ise test başarılı olur ,değilse test başarısızı olur.


    @Test
    public void test03() {
        Assert.assertFalse("selenium".contains("E"));//passed
    }

    //4-assertNotEquals (); İçerisinde beliritlen parametler eşit değilse başarılı olur, değilse başarısızı olur

    @Test
    public void test04() {
        Assert.assertNotEquals("SELENIUM" , "JAVA"); //pass
        Assert.assertNotEquals("SELENIUM" , "SELENIUm"); //pass
        Assert.assertNotEquals("SELENIUM" , "SELENIUM"); //fail
    }
}
